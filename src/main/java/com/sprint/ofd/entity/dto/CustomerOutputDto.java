package com.sprint.ofd.entity.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class CustomerOutputDto {
	
		private int customerId;
	@NotNull
	@NotEmpty
	@NotBlank
		private String firstName;
	@NotNull
	@NotEmpty
	@NotBlank
		private String lastName;
	
	@Email
		private String email;
		
		

}
