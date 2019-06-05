package com.miBank.profileservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.miBank.profileservice.model.Profile;


/**
 * 
 * @author Carlos Gomez
 * 
 */
@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {
	
	
}