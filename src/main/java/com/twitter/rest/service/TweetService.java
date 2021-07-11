package com.twitter.rest.service;

import java.util.List;

import com.twitter.rest.dto.TweetDTO;
import com.twitter.rest.model.TweetEntity;

public interface TweetService {

	public void saveTweet(TweetEntity tweet);
	
	public List<TweetDTO> getTweets();
	
	public void validateTweet(Long tweetId);

	public List<TweetDTO> getValidated();
	
}
