package com.miBank.profileservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "Health Management")
public class HomeController {

	@GetMapping("/_health")
	@ApiOperation(value = "Health Check", response = String.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "UP") })
	public String health() {
		return "PROFILE_SERVICE_IS_UP";
	}
}
