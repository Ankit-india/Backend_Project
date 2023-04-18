package com.mentorMantee.Backend.Candidate.Payloads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter

public class UserDto {
	
	private int id;
	
	@NotEmpty
	@Size(min = 6, message = "User password must be greater than 6")
	private String Password;
	
	private String name;
	
	private String email;
	
	@NotEmpty
	@Size(min=10, message = "User mobile number should be valid")
	private String phoneNumber;
		
	private String dpImage;
		
	private int yearOfPassing;
		
	private String latestResume;
		
	private String domain;
	
	private String techStack;

}
