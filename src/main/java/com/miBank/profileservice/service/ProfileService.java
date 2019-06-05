package com.miBank.profileservice.service;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import com.miBank.profileservice.model.Profile;
import com.miBank.profileservice.repository.ProfileRepository;


/**
 * 
 * @author Carlos Gomez
 * 
 */
@Service
public class ProfileService {

	@Autowired
	private ProfileRepository repository;

	/**
	 * <p>
	 * It saves {@link Profile} object into database or return Exception if
	 * {@link Profile} is not valid.
	 * </p>
	 * 
	 * @param profile {@link Profile} must be valid and not {@literal null}
	 * @return {@link Profile}
	 * @throws NullPointerException if {@link Profile} is {@literal null}
	 */
	public Profile save(Profile profile) throws NullPointerException {		
		return this.repository.save(profile);
	}

	/**
	 * <p>
	 * It finds {@link Profile} object from database by id or return
	 * EntityNotFoundException if no {@link Profile} exists with given id.
	 * </p>
	 * 
	 * @param id {@literal int} primary key of {@link Profile}
	 * @return {@link Profile}
	 * @throws EntityNotFoundException if {@link Profile} does not exist with
	 *                                 {@literal id}
	 */
	public Profile findById(int id) throws EntityNotFoundException {		
		Optional<Profile> optionalProfile = this.repository.findById(id);
		if (optionalProfile.isPresent()) {
			return optionalProfile.get();
		} else {
			throw new EntityNotFoundException("Profile with id = "+id+" not found");
		}

	}


	/**
	 * <p>
	 * It updates {@link Profile} in database with {@literal id}.
	 * <p>
	 * 
	 * @param id must not be {@literal null}
	 * @param profile updated {@link Profile}
	 * @return {@link Profile}
	 * @throws EntityNotFoundException in case there is no {@link Profile} with
	 *                                 {@literal id}
	 */
	public Profile update(int id, Profile profile) throws EntityNotFoundException {
		try {
			Profile foundProfile = this.repository.getOne(id);
			if (profile.getEmail() != null && !profile.getEmail().isEmpty()) {
				foundProfile.setEmail(profile.getEmail());
			}
			if (profile.getFirstName() != null && !profile.getFirstName().isEmpty()) {
				foundProfile.setFirstName(profile.getFirstName());
			}
			if (profile.getLastName() != null && !profile.getLastName().isEmpty()) {
				foundProfile.setLastName(profile.getLastName());
			}
			if (profile.getAddress() != null && !profile.getAddress().isEmpty()) {
				foundProfile.setAddress(profile.getAddress());
			}
			if (profile.getCity() != null && !profile.getCity().isEmpty()) {
				foundProfile.setCity(profile.getCity());
			}
			if (profile.getProvince() != null && !profile.getProvince().isEmpty()) {
				foundProfile.setProvince(profile.getProvince());
			}
			if (profile.getPostalCode() != null && !profile.getPostalCode().isEmpty()) {
				foundProfile.setPostalCode(profile.getPostalCode());
			}
			if (profile.getCountry() != null && !profile.getCountry().isEmpty()) {
				foundProfile.setCountry(profile.getCountry());
			}
			if (profile.getPhoneNumber() != null && !profile.getPhoneNumber().isEmpty()) {
				foundProfile.setPhoneNumber(profile.getPhoneNumber());
			}
			if (profile.getPictureUrl() != null && !profile.getPictureUrl().isEmpty()) {
				foundProfile.setPictureUrl(profile.getPictureUrl());
			}
			return this.repository.save(foundProfile);
		} catch (EntityNotFoundException e) {
			throw new EntityNotFoundException("Profile with id = "+id+" not found");
		}

	}
	
	/**
	 * <p>
	 * Deletes the given {@link Profile} from database
	 * </p>
	 * 
	 * @param {@literal id}
	 * @return {@literal boolean}
	 * @throws EntityNotFoundException if {@link Profile} is not found in database
	 */
	public boolean delete(int id) throws EntityNotFoundException {
		Optional<Profile> optionalProfile = this.repository.findById(id);
		if (optionalProfile.isPresent()) {
			repository.delete(optionalProfile.get());
			return true;
		} else {
			throw new EntityNotFoundException("Profile with id = "+id+" not found");
		}
		
	}
}