package com.twitter.rest.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TWEET")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TweetEntity implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4236135150416991095L;

	/** Columna id */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** Columna alias */
	@NotNull
	private String alias;

	/** Columna ubicacion */
	private String ubicacion;

	/** Columna texto */
	@NotEmpty
	@Column(length = 400)
	private String texto;

	/** Columna validado */
	private boolean validado;
	
}
