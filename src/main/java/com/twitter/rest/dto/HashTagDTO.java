package com.twitter.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * HashTagDTO
 * @author almocas
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HashTagDTO {

	/** id */
	private Long id;

	/** texto */
	private String texto;

}
