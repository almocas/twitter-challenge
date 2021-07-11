package com.twitter.rest.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twitter.rest.dto.TweetDTO;
import com.twitter.rest.exception.NotFoundException;
import com.twitter.rest.model.TweetEntity;
import com.twitter.rest.repo.TweetRepository;
import com.twitter.rest.service.TweetService;

/**
 * @author almocas
 *
 */
@Service
public class TweetServiceImpl implements TweetService{

	@Autowired
	private TweetRepository tweetRepository;
	
	@Override
	public void saveTweet(TweetEntity tweet) {
		tweetRepository.save(tweet);
	}

	/**
	 * Servicio que devuelve los tweets alamacenados
	 */
	@Override
	public List<TweetDTO> getTweets(){
		return tweetRepository.findAll().stream()
			.map(tweet -> TweetDTO.builder()
							.alias(tweet.getAlias())
							.id(tweet.getId())
							.texto(tweet.getTexto())
							.ubicacion(tweet.getUbicacion())
							.validado(tweet.isValidado())
						.build()
			).collect(Collectors.toList());
	}

	/** 
	 * Servicio que valida el tweet informado
	 */
	@Override
	public void validateTweet(Long tweetId) {
		Optional<TweetEntity> tweet = tweetRepository.findById(tweetId);
		
		if (!tweet.isPresent()) {
			throw new NotFoundException("El identificador del tweet informado no existe.");
		}else {
			var tw = tweet.get();
			tw.setValidado(true);
			tweetRepository.save(tw);
		}
	}

	/**
	 * Servicio que obtiene los tweets validados
	 */
	@Override
	public List<TweetDTO> getValidated() {
		return tweetRepository.findByValidadoTrue().stream()
				.map(tweet -> TweetDTO.builder()
								.alias(tweet.getAlias())
								.id(tweet.getId())
								.texto(tweet.getTexto())
								.ubicacion(tweet.getUbicacion())
								.validado(tweet.isValidado())
							.build()
				).collect(Collectors.toList());
	}
	
}
