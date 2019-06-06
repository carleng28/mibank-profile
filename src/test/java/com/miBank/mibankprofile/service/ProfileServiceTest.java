package com.miBank.mibankprofile.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.miBank.profileservice.model.Profile;
import com.miBank.profileservice.repository.ProfileRepository;
import com.miBank.profileservice.service.ProfileService;

@RunWith(SpringRunner.class)
public class ProfileServiceTest {

	@TestConfiguration
	static class ProfileServiceContextConfiguration {
		@Bean
		public ProfileService profileService() {
			return new ProfileService();
		}
	}

	@Autowired
	private ProfileService service;

	@MockBean
	private ProfileRepository repository;
	
	
	@Before
	public void setup() {
		Profile profile = createNewProfile();
		Mockito.when(repository.save(profile)).thenReturn(profile);
		
	}

	// save profile
	@Test
	public void saveDealershipServiceTest() {
		Profile profile = createNewProfile();
		Profile savedProfile = this.service.save(profile);

		assertEquals(profile, savedProfile);
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
