package com.sprint.ofd.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data                      //creating automatic functions using lambok
public class Address {
	
	@Id
	@GeneratedValue
	private int addressId;   //generating unique address Id
	@NotNull
	@NotEmpty
	private String buildingName;    //validating name of the building
	@NotNull
	@NotBlank  
	private String area;         //validating area of the restaurant
	@NotNull
	private String streetNo;     
	@NotEmpty
	private String city;        //validating city of the restaurant
	@NotEmpty
	private String state;
	@NotEmpty
	private String country;
	@NotNull
	@NotEmpty
	private String pincode;

}
