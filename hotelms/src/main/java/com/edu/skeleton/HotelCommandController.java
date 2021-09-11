package com.edu.skeleton;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.skeleton.dto.HotelQueryDTO;
import com.edu.skeleton.dto.HotelUpdateDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
	@RequestMapping(value = "/api/Hotels")
	public class HotelCommandController {

	    @Autowired
	    private HotelService hotelService;

	    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	    @ResponseStatus(HttpStatus.OK)
	    public ResponseEntity<HotelQueryDTO> updateHotel(@PathVariable(value = "id")Long id,
	    		@RequestBody HotelUpdateDTO hotelUpdateDTO){
	        return new ResponseEntity<>(hotelService.updateHotel(id, hotelUpdateDTO), HttpStatus.OK);
	    }
	}
