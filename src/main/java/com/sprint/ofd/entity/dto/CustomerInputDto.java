package com.sprint.ofd.entity.dto;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.sprint.ofd.entity.Address;

import lombok.Data;


@Data
public class CustomerInputDto {

	
	@NotNull
	@NotEmpty
	@NotBlank
		private String firstName;
	@NotNull
	@NotEmpty
	@NotBlank
		private String lastName;
	@NotNull
	@NotEmpty
	@NotBlank
		private String gender;
		@NotNull
		@NotEmpty
		@NotBlank
		private int age;
		@Size(min=10,max=10,message="mobile number should be 10 digits")
		private long mobileNumber;
		@OneToOne(cascade=CascadeType.MERGE)
		@JoinColumn(name="cust_add_fk")
		private Address address;
		@Email
		private String email;
		
		
}
