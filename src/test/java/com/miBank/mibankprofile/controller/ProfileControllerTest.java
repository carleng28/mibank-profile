package com.miBank.mibankprofile.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.miBank.profileservice.controller.ProfileController;
import com.miBank.profileservice.model.Profile;
import com.miBank.profileservice.service.ProfileService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ProfileController.class)
public class ProfileControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ProfileService service;
	
	Profile profile;
	
	
	
	@Before
	public void setup() {
		
		profile = createNewProfile();
		Mockito.when(service.save(profile)).thenReturn(profile);
		
	}
	
	@Test
	public void createProfileControllerTest() throws Exception{
		
		ObjectMapper mapper = new ObjectMapper();
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(
				"/v1/profiles")
				.accept(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsBytes(profile))
				.contentType(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(requestBuilder)
		        .andExpect(status().isCreated());
		
		//Verify that the save() method of the PositionService interface is called only once
		verify(service, times(1)).save(profile);
		//Ensure that no other methods of our mock object are called during the test
        verifyNoMoreInteractions(service);
		
	}
	
	
	
	/*
	 * Return new instance of Profile for testing purposes
	 */
	private Profile createNewProfile() {

		Profile profile = new Profile();
		profile.setAddress("75 Charolais Boulevard");
		profile.setCity("Brampton");
		profile.setCountry("Canada");
		profile.setEmail("test@test.ca");
		profile.setFirstName("John");
		profile.setLastName("Snow");
		profile.setPhoneNumber("647-674-3798");
		profile.setPostalCode("L6Y-2R8");
		profile.setProvince("Ontario");
		
		return profile;
	}
}