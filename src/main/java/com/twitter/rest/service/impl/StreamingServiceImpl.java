package com.twitter.rest.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twitter.rest.commons.Constants;
import com.twitter.rest.model.HashTagEntity;
import com.twitter.rest.model.HashTagTweetEntity;
import com.twitter.rest.model.HashTagTweetEntityKey;
import com.twitter.rest.model.TweetEntity;
import com.twitter.rest.service.HashTagService;
import com.twitter.rest.service.StreamingService;
import com.twitter.rest.service.TweetService;

import twitter4j.FilterQuery;
import twitter4j.HashtagEntity;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterStreamFactory;

@Service
public class StreamingServiceImpl implements StreamingService{
	
	@Autowired
	private TweetService tweetService;
	
	@Autowired
	private HashTagService hashTagService;
	
	Logger logger = LoggerFactory.getLogger(StreamingServiceImpl.class);
	
	/**
	 * Método que realiza el streaming de los tweets
	 */
	public void streamFeed() {
		StatusListener listener = new StatusListener(){
	
			@Override
			public void onException(Exception e) {
				e.printStackTrace();
			}

			@Override
			public void onStatus(Status status) {        
		        if (status.getUser().getFollowersCount() > Constants.MINIMO_NUMERO_SEGUIDORES) {
		        	
		        	//Obtenemos usuario
		        	var user = status.getUser();
		            
		            //Creamos el objeto de la entidad a persistir
		            TweetEntity tweetObject = TweetEntity.builder()
		            				.alias(user.getScreenName())
		            				.ubicacion(user.getLocation())
		            				.texto(status.getText())
		            				.build();

		            logger.debug("Tweet: {}", tweetObject);
		            
		            //Guardamos la entidad
		            tweetService.saveTweet(tweetObject);

		            //Recuperamos y guardamos los hashtags del tweet
		            HashtagEntity[] hashTags = status.getHashtagEntities();
		            for(HashtagEntity hashTag: hashTags) {    
			            logger.debug("Hashtag: {}", hashTag);
			            
			            Optional<HashTagEntity> hashTagOpt = hashTagService.findByTexto(hashTag.getText());
			            
			            HashTagEntity hashTagObject;
			            if(hashTagOpt.isEmpty()) {
			            	hashTagObject = HashTagEntity.builder()
		            				.texto(hashTag.getText())
		            				.build();
			            	hashTagService.saveHashTag(hashTagObject);
			            } else {
			            	hashTagObject = hashTagOpt.get();
			            }
			            
			            hashTagService.saveHashTagRel(
			            		HashTagTweetEntity.builder()
			            				.pk(HashTagTweetEntityKey.builder()
			            						.hashTagId(hashTagObject.getId())
			            						.tweetId(tweetObject.getId())
			            						.build()
			            				 )
			            				.hashTag(hashTagObject)
			            				.tweet(tweetObject)
			            				.build()
			            );
		            }
		        }
			}
	
			@Override
			public void onDeletionNotice(StatusDeletionNotice arg) {
				//No lo tenemos que utilizar		
			}
	
			@Override
			public void onScrubGeo(long userId, long upToStatusId) {
				//No lo tenemos que utilizar		
			}
	
			@Override
			public void onStallWarning(StallWarning warning) {
				//No lo tenemos que utilizar		
			}
	
			@Override
			public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
				//No lo tenemos que utilizar
			}
		};
	
		var twitterStream = new TwitterStreamFactory().getInstance();
	    twitterStream.addListener(listener);	    

		var query = new FilterQuery();
		query.language(Constants.IDIOMAS_PERMITIDOS.toArray(new String[0]));
		query.track("web");
		twitterStream.filter(query);
	}
	
}
