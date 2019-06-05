package com.miBank.profileservice.controller;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.miBank.profileservice.model.Profile;
import com.miBank.profileservice.service.ProfileService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class ProfileController {

	@Autowired
	private ProfileService service;

	/*
	 * Save Profile
	 */
	@PostMapping(path = "/v1/profiles", consumes = "application/json", produces = "application/json")
	@ApiOperation(value = "Save profile", response = ResponseEntity.class,
			consumes = "application/json", produces = "application/json")
	@ApiResponses(value = { 
			@ApiResponse(code = 201, message = "Profile saved successfully.")
	})
	public ResponseEntity<Profile> saveProfile(@RequestBody Profile profile) {	
		// save Profile
		Profile savedProfile = this.service.save(profile);
		return new ResponseEntity<Profile>(savedProfile, HttpStatus.CREATED);
		
	}
	
	/*
	 * Get Profile
	 *
	 * */
	@GetMapping(path="/v1/profiles/{id}", consumes = "application/json", produces = "application/json")
	@ApiOperation(value = "Get profiles", response = ResponseEntity.class,
	consumes = "application/json", produces = "application/json")
	@ApiResponses(value = { 
		@ApiResponse(code = 200, message = "Profile found"),
		@ApiResponse(code = 404, message = "Profile not found") 
	})
	public ResponseEntity<Profile> getProfileById(@PathVariable int id) {
		try {
			Profile response = service.findById(id);
			return new ResponseEntity<Profile>(response, HttpStatus.OK);	
		}catch(EntityNotFoundException e) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	/*
	 * Update Profile
	 */
	@PatchMapping(path = "/v1/profiles/{id}", consumes = "application/json", produces = "application/json")
	@ApiOperation(value = "Update profile", response = ResponseEntity.class, 
					consumes = "application/json", produces = "application/json")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Profile updated"),
			@ApiResponse(code = 404, message = "Profile not found") 
	})
	public ResponseEntity<Profile> updateEmployee(@PathVariable int id,
			@RequestBody Profile profile) {
		try {
			Profile response = this.service.update(id, profile);
			return new ResponseEntity<Profile>(response, HttpStatus.OK);	
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/v1/profiles/{id}")
	@ApiOperation(value = "Delete profile", response = ResponseEntity.class, 
		consumes = "application/json", produces = "application/json")
	@ApiResponses(value = { 
			@ApiResponse(code = 204, message = "Profile deleted"),
			@ApiResponse(code = 404, message = "Profile not found") 
	})
	public ResponseEntity<Profile> deleteProfile(@PathVariable int id) {	
		
		try {
			service.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);	
		}catch(EntityNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}  		
	}
	
	
}
