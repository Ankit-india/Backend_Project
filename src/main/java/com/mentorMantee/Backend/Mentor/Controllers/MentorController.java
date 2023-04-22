package com.mentorMantee.Backend.Mentor.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mentorMantee.Backend.Mentor.Payloads.MentorDto;
import com.mentorMantee.Backend.Mentor.Services.MentorService;

import jakarta.validation.Valid;

import java.util.List;

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

	@PutMapping("/{mentorId}")
	public ResponseEntity<MentorDto> updateMentor(@Valid @RequestBody MentorDto mentorDto, @PathVariable Integer mentorId) {
		MentorDto updatedMentorDto = this.mentorService.updateMentor(mentorDto, mentorId);
		return new ResponseEntity<>(updatedMentorDto, HttpStatus.OK);
	}

	@GetMapping("/{mentorId}")
	public ResponseEntity<MentorDto> getMentorById(@PathVariable Integer mentorId) {
		MentorDto mentorDto = this.mentorService.getMentorById(mentorId);
		return new ResponseEntity<>(mentorDto, HttpStatus.OK);
	}

	@GetMapping("/")
	public ResponseEntity<List<MentorDto>> getAllMentor() {
		List<MentorDto> listOfAllMentor = this.mentorService.getAllMentor();
		return new ResponseEntity<>(listOfAllMentor, HttpStatus.OK);
	}



}
