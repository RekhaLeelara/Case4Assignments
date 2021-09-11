package com.edu.skeleton.dto;

	public class HotelQueryDTO {


	    private Long id;

	    private String name;

	    public HotelQueryDTO(Long id, String name) {
	        this.id = id;
	        this.name = name;
	    }

	    public Long getId() {
	        return id;
	    }

	    public String getName() {
	        return name;
	    }


	    @Override
	    public String toString() {
	        return "HotelQueryDTO{" +
	                "id=" + id +
	                ", name='" + name + '\'' + +
	                '}';
	    }
	}

