package com.sprint.ofd.entity.dto;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginOutputDto {

	
	@NotNull
	@NotEmpty
	@NotBlank
	private String userid;
	
	@NotNull
	@NotEmpty
	@NotBlank
	private String userName;
	
}
