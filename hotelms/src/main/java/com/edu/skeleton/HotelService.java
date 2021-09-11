package com.edu.skeleton;

import java.util.UUID;
import com.edu.skeleton.HotelsServiceImpl;
import com.edu.skeleton.dto.HotelQueryDTO;
import com.edu.skeleton.dto.HotelUpdateDTO;
import com.edu.skeleton.model.Hotel;

public interface HotelService {

	   // public UUID createVehicle(VehicleCreateDTO vehicleCreateDTO);
	    public HotelQueryDTO updateHotel(Long Hotelid, HotelUpdateDTO hotelUpdateDTO);
	    //public VehicleQueryDTO updateVehicle(UUID id, VehicleUpdateDTO vehicleUpdateDTO);

}
                      