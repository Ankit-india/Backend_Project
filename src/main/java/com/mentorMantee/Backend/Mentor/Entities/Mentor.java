package com.mentorMantee.Backend.Mentor.Entities;

import java.util.List;

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
@Getter
@Setter
@NoArgsConstructor
@Table(name = "mentor_user")
public class Mentor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "password", nullable = false, length = 20)
	private String password;
	
	@Column(name = "name", nullable = false, length = 60)
	private String name;
	
	@Column(name = "designation")
	private String designation; 
	
	@Column(name = "current_company_name")
	private String currentCompanyName;
	
	@Column(name = "previous_company_name_list")
	List<String> previousCompanyNameList;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "email_id")
	private String email;
	
	@Column(name = "profile_image")
	private String profileImage;
	
	@Column(name = "domain")
	private String domain;
	
	@Column(name = "experience")
	private int experience;
	
	@Column(name = "tech_stack")
	private String techStack;
}
