package com.twitter.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.twitter.rest.service.StreamingService;

@SpringBootApplication
public class TwitterChallengeApplication implements CommandLineRunner {
	
	@Autowired
	private StreamingService streamingService;
	
	public static void main(String[] args) {
		SpringApplication.run(TwitterChallengeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if(null != args && args.length > 0 && args[0].equals("stream")) {
			streamingService.streamFeed();
		}
	}
	
}
