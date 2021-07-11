package com.twitter.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TweetDTO
 * @author almocas
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TweetDTO {

	/** id */
	private Long id;

	/** alias */
	private String alias;

	/** ubicacion */
	private String ubicacion;

	/** texto */
	private String texto;

	/** validado */
	private boolean validado;

}
