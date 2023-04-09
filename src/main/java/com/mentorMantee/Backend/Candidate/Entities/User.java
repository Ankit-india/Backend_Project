package com.mentorMantee.Backend.Candidate.Entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "student_user")
@NoArgsConstructor
@Getter
@Setter
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	
	@Column(name = "password", nullable = false, length = 20)
	private String password;
	
	@Column(name = "name", nullable = false, length = 60)
    private String name;
	
	@Column(name = "email", nullable = true)
    private String email;
	
	@Column(name = "phone_number", nullable = false)
	private String phoneNumber;
	
	@Column(name = "profile_image", nullable = true)
    private String dpImage;
	
	@Column(name = "year_of_passing", nullable = true)
	private int yearOfPassing;
	
	@Column(name = "latest_resume")
	private String latestResume;
	
	@Column(name = "domain")
	private String domain;
	
	@Column(name = "tech_stack")
	private String techStack;
	
}
