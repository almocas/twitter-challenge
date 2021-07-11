package com.twitter.rest.controller.v0;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twitter.rest.dto.TweetDTO;
import com.twitter.rest.service.TweetService;

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
@RequestMapping("tweets/v0")
@Api(value = "TweetV0", description = "Servicios relacionados con Tweets(versión 0)")
public class TweetControllerV0 {

	Logger logger = LoggerFactory.getLogger(TweetControllerV0.class);
	
	@Autowired
	TweetService tweetService;

	/**Servicio que permite consultar los tweets almacenados
	 * @param 
	 * @return List<TweetDTO>
	 */
	@ApiOperation(value = "Servicio que permite consultar los tweets almacenados", response = TweetDTO.class)
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Generic error")
    }
    )
	@GetMapping(value="/")
	public ResponseEntity<List<TweetDTO>> getTweets(){
		return ResponseEntity.ok(tweetService.getTweets());
	}

	/**Servicio que valida un tweet
	 * @param tweetId
	 * @return
	 */
	@ApiOperation(value = "Servicio que valida un tweet")
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved"),
            @ApiResponse(code = 204, message = "Request has succeeded"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Generic error")
    }
    )
	@PutMapping("/{tweetId}/validate")
	public ResponseEntity<Object> validateTweet(
			@ApiParam(value="Identificador del tweet", required = true)
			@PathVariable(name="tweetId", required=true)	Long tweetId) 
	{
		tweetService.validateTweet(tweetId);
		return ResponseEntity.noContent().build();
	}

	/**
	 * Servicio que consulta los tweets validados
	 * @param 
	 * @return List<TweetDTO>
	 */
	@ApiOperation(value = "Servicio que consulta los tweets validados", response = TweetDTO.class)
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved"),
            @ApiResponse(code = 204, message = "Request has succeeded"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Generic error")
    }
    )
	@PutMapping("/validated")
	public ResponseEntity<List<TweetDTO>> getValidatedTweets() 
	{
		return ResponseEntity.ok(tweetService.getValidated());
	}

}
