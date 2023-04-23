package com.mentorMantee.Backend.Mentor.Controllers;

import com.mentorMantee.Backend.Mentor.Entities.Mentor;
import com.mentorMantee.Backend.Mentor.Payloads.ApiResponse;
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
	
	@PostMapping("/creatementor")
	public ResponseEntity<MentorDto> createMentor(@Valid @RequestBody MentorDto mentorDto) {
		MentorDto createdMentorDto = this.mentorService.createMentor(mentorDto);
		return new ResponseEntity<>(createdMentorDto, HttpStatus.CREATED);
	}

	@PutMapping("/updatementor/{mentorId}")
	public ResponseEntity<MentorDto> updateMentor(@Valid @RequestBody MentorDto mentorDto, @PathVariable Integer mentorId) {
		MentorDto updatedMentorDto = this.mentorService.updateMentor(mentorDto, mentorId);
		return new ResponseEntity<>(updatedMentorDto, HttpStatus.OK);
	}

	@GetMapping("/getmentorbyid/{mentorId}")
	public ResponseEntity<MentorDto> getMentorById(@PathVariable Integer mentorId) {
		MentorDto mentorDto = this.mentorService.getMentorById(mentorId);
		return new ResponseEntity<>(mentorDto, HttpStatus.OK);
	}

	@GetMapping("/getallmentor")
	public ResponseEntity<List<MentorDto>> getAllMentor() {
		List<MentorDto> listOfAllMentor = this.mentorService.getAllMentor();
		return new ResponseEntity<>(listOfAllMentor, HttpStatus.OK);
	}

	@DeleteMapping("/deletementor/{mentorId}")
	public ResponseEntity<ApiResponse> deleteMentor(@PathVariable Integer mentorId) {
		ApiResponse apiResponse = this.mentorService.deleteMentor(mentorId);
		return new ResponseEntity<>(apiResponse, HttpStatus.OK);
	}

}
