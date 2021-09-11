package com.edu.skeleton.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.skeleton.model.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long>{
	
}
