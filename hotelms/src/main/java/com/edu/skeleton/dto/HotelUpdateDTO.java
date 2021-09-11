package com.edu.skeleton.dto;

public class HotelUpdateDTO {

	public Long Hotelid;
	private String name;
	
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public void setId(Long Hotelid) {
		this.Hotelid=Hotelid;
	}
	public Long getId() {
		return Hotelid;
	}

    @Override
    public String toString() {
        return "HotelUpdateDTO{" +
                "id='" + Hotelid + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
