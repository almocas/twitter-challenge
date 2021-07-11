package com.twitter.rest.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * HashTagEntityKey
 * @author almocas
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class HashTagTweetEntityKey implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -3057522455857931904L;

	/** Columna id */
	@Column(name = "HASHTAG_ID")
	private Long hashTagId;
	
	/** Columna  TWEET_ID */
	@Column(name = "TWEET_ID")
	private Long tweetId;

}
