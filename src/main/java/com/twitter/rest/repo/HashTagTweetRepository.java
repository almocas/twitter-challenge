package com.twitter.rest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.twitter.rest.model.HashTagTweetEntity;
import com.twitter.rest.model.HashTagTweetEntityKey;

/**
 * @author almocas
 *
 */
@Repository
public interface HashTagTweetRepository extends JpaRepository<HashTagTweetEntity, HashTagTweetEntityKey>{

}
