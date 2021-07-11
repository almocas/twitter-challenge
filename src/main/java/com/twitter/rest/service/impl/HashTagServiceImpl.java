/**
 * 
 */
package com.twitter.rest.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twitter.rest.dto.HashTagDTO;
import com.twitter.rest.model.HashTagEntity;
import com.twitter.rest.model.HashTagTweetEntity;
import com.twitter.rest.repo.HashTagRepository;
import com.twitter.rest.repo.HashTagTweetRepository;
import com.twitter.rest.service.HashTagService;

/**
 * @author almocas
 *
 */
@Service
public class HashTagServiceImpl implements HashTagService {

	@Autowired
	private HashTagRepository hashTagRepository;

	@Autowired
	private HashTagTweetRepository hashTagTweetRepository;
	
	/**
	 * Servicio para buscar hashatag por el texto
	 */
	@Override
	public Optional<HashTagEntity> findByTexto(String texto){
		return hashTagRepository.findByTexto(texto);
	}
	
	/**
	 * Servicio para guardar hashatag
	 */
	@Override
	public void saveHashTag(HashTagEntity hashTag) {
		hashTagRepository.save(hashTag);
	}
	
	/**
	 * Servicio para guardar la relación del hashtag con el tweet
	 */
	@Override
	public void saveHashTagRel(HashTagTweetEntity hashTagTweet) {
		hashTagTweetRepository.save(hashTagTweet);
	}
	
	/**
	 * Servicio para obtener el ranking de los N hashtags más usados
	 */
	@Override
	public List<HashTagDTO> getRanking(Integer cantidad) {
		return hashTagRepository.getRanking(cantidad).stream()
				.map(hashTagTweet -> HashTagDTO.builder()
								.id(hashTagTweet.getId())
								.texto(hashTagTweet.getTexto())
							.build()
				).collect(Collectors.toList());
		
	}
	
}
