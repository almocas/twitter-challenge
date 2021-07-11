package com.twitter.rest.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "HASHTAG_TWEET")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HashTagTweetEntity  implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 928398357104251838L;

	/** The key. */
	@EmbeddedId
	private HashTagTweetEntityKey pk;
	
	/** The hashTag. */
	@MapsId("hashTagId")
    @ManyToOne
	@JoinColumn(name = "HASHTAG_ID", insertable = false, updatable = false, nullable = false)
	private HashTagEntity hashTag;

	/** The tweet. */
	@MapsId("tweetId")
    @ManyToOne
	@JoinColumn(name = "TWEET_ID", insertable = false, updatable = false, nullable = false)
	private TweetEntity tweet;

}
