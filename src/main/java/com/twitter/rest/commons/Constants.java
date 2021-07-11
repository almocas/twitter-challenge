package com.twitter.rest.commons;

import java.util.Collections;
import java.util.List;

public class Constants {

	private Constants() {
		throw new IllegalStateException("Utility class");
	}

	public static final int MINIMO_NUMERO_SEGUIDORES = 1500;
	public static final List<String> IDIOMAS_PERMITIDOS = Collections.unmodifiableList(List.of("es", "it", "fr"));
	
}