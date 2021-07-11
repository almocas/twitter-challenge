package com.twitter.rest.controller.v0;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.twitter.rest.dto.HashTagDTO;
import com.twitter.rest.service.HashTagService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author almocas
 *
 */
@RestController
@RequestMapping("hashtags/v0")
@Api(value = "HashTagV0", description = "Servicios relacionados con HashTags(versión 0)")
public class HashTagControllerV0 {

	Logger logger = LoggerFactory.getLogger(HashTagControllerV0.class);
	
	@Autowired
	HashTagService hashTagService;

	/**
	 * Servicio que devuelve los N hashtags más usados; por defecto 10.
	 * @param tweetId
	 * @return
	 */
	@ApiOperation(value = "Servicio que devuelve los N hashtags más usados; por defecto 10.")
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved"),
            @ApiResponse(code = 500, message = "Generic error")
    }
    )
	@PutMapping("/ranking")
	public List<HashTagDTO> ranking(
			@ApiParam(value="Cantidad", required = false, defaultValue="10")
			@RequestParam(name="numero", required = false, defaultValue="10") 
			Integer cantidad)
	{
		return hashTagService.getRanking(cantidad);
	}
	
}
