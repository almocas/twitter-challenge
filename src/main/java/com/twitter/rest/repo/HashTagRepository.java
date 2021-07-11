package com.twitter.rest.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.twitter.rest.model.HashTagEntity;

/**
 * @author almocas
 *
 */
@Repository
public interface HashTagRepository extends JpaRepository<HashTagEntity, Long>{
	
	public Optional<HashTagEntity> findByTexto(String texto);
	
	@Query(value="SELECT H.ID , H.TEXTO,count(1) FROM HASHTAG_TWEET HT INNER JOIN HASHTAG H ON H.ID = HT.HASHTAG_ID group by HASHTAG_ID order by count(HASHTAG_ID) desc, h.texto asc  FETCH FIRST :cantidad ROWS ONLY",nativeQuery=true)
	List<HashTagEntity> getRanking(Integer cantidad);

}
