package com.edu.skeleton;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.skeleton.dto.HotelQueryDTO;
import com.edu.skeleton.model.Hotel;
import com.edu.skeleton.repository.HotelRepository;
import com.edu.skeleton.dto.HotelUpdateDTO;

@Service
public class HotelsServiceImpl implements HotelService{
	
	 @Autowired
	    private HotelRepository hotelRepository;

	@Override
	public HotelQueryDTO updateHotel(Long Hotelid, HotelUpdateDTO hotelUpdateDTO) {
		// TODO Auto-generated method stub
		if (hotelRepository.findById(Hotelid).isPresent()){
			Hotel existinghotel = hotelRepository.findById(Hotelid).get();
			existinghotel.setId(hotelUpdateDTO.getId());
			existinghotel.setName(hotelUpdateDTO.getName());
			Hotel updateHotel = hotelRepository.save(existinghotel);
            return new HotelQueryDTO(updateHotel.getId(), updateHotel.getName());
		}else {
		
		return null;
		}
	}

}
