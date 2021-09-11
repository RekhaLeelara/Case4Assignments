package com.edu.skeleton.model;

import javax.persistence.Entity;
import java.util.Objects;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table

public class Hotel {
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	
	public Long Hotelid;
	private String name;
	
/*	public void setId(Long productId)
	{
		this.productId = productId;
	}
	public Long getId(Long productId)
	{
		return productId;
	}*/
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
	  public boolean equals(Object o) {

	    if (this == o)
	      return true;
	    if (!(o instanceof Hotel))
	      return false;
	    Hotel employee = (Hotel) o;
	    return Objects.equals(this.Hotelid, employee.Hotelid) && Objects.equals(this.name, employee.name);
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(this.Hotelid, this.name);
	  }

	  @Override
	  public String toString() {
	    return "Employee{" + "id=" + this.Hotelid + ", name='" + this.name+'}';
	  }


}
