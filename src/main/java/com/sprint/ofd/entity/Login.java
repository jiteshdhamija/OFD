package com.sprint.ofd.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
public class Login {

	@Id
	@NotNull
	@NotEmpty
	@NotBlank
	private String userid;
	
	@NotNull
	@NotEmpty
	@NotBlank
	private String userName;
	@NotNull
	@NotBlank
	@Size(min=6,max=18)
	private String password;
	
	private boolean login_flag;
	
}
