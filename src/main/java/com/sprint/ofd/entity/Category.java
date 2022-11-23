package com.sprint.ofd.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Category {
	
	@Id
	@GeneratedValue
	private int catId;
	@NotNull(message="name cannot be null")
	@NotEmpty(message="name cannot be empty")
	private String categoryName;
	
	

}
