package com.twitter.rest.service;

import java.util.List;
import java.util.Optional;

import com.twitter.rest.dto.HashTagDTO;
import com.twitter.rest.model.HashTagEntity;
import com.twitter.rest.model.HashTagTweetEntity;

public interface HashTagService {

	public Optional<HashTagEntity> findByTexto(String texto);

	public void saveHashTag(HashTagEntity hashTag);

	public void saveHashTagRel(HashTagTweetEntity build);

	public List<HashTagDTO> getRanking(Integer cantidad);
	
}
