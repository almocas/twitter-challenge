package com.twitter.rest.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.twitter.rest.model.TweetEntity;

/**
 * @author almocas
 *
 */
@Repository
public interface TweetRepository extends JpaRepository<TweetEntity, Long>{
	
	List<TweetEntity> findByValidadoTrue();
	
}
