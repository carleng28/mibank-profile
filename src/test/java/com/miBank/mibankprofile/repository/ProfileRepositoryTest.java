package com.miBank.mibankprofile.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.miBank.profileservice.model.Profile;
import com.miBank.profileservice.repository.ProfileRepository;



@RunWith(SpringRunner.class)
@DataJpaTest
public class ProfileRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private ProfileRepository repository;
	
	/*
	 * Test - add new profile
	 */
	@Test
	public void addNewProfileTest() {
		
		Profile profile = createNewProfile();
		repository.save(profile);
		Profile newProfile = entityManager.find(Profile.class, profile.getProfileId());
		assertEquals(profile,newProfile);
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
