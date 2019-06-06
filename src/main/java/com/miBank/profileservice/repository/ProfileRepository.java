package com.miBank.profileservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miBank.profileservice.model.Profile;


@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {
	
	
}