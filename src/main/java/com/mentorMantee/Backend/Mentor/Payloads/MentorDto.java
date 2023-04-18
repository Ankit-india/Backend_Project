package com.mentorMantee.Backend.Mentor.Payloads;

import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class MentorDto {
	
	private int id;
	
	@NotEmpty
	@Size(min = 6, message = "password must by greater than 6")
	private String password;
	
	@NotEmpty
	private String name;
	
	private String designation; 
	
	private String currentCompanyName;
	
	List<String> previousCompanyNameList;
	
	@NotEmpty
	private String phoneNumber;
	
	@NotEmpty
	private String email;
	
	private String profileImage;
	
	private String domain;
	
	private int experience;
	
	private String techStack;
}
