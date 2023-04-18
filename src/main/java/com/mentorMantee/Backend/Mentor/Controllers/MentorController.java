package com.mentorMantee.Backend.Mentor.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mentorMantee.Backend.Mentor.Payloads.MentorDto;
import com.mentorMantee.Backend.Mentor.Services.MentorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/mentor")
public class MentorController {
	
	@Autowired
	private MentorService mentorService;
	
	@PostMapping("/")
	public ResponseEntity<MentorDto> createMentor(@Valid @RequestBody MentorDto mentorDto) {
		MentorDto createdMentorDto = this.mentorService.createMentor(mentorDto);
		return new ResponseEntity<>(createdMentorDto, HttpStatus.CREATED);
	}
}
