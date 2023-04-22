package com.mentorMantee.Backend.Mentor.Services;

import java.util.List;

import com.mentorMantee.Backend.Mentor.Payloads.MentorDto;

public interface MentorService {
	
	MentorDto createMentor(MentorDto mentorDto);
	
	MentorDto updateMentor(MentorDto mentorDto, Integer mentorId);
	
	MentorDto getMentorById(Integer mentorId);
	
	List<MentorDto> getAllMentor();
	
	Void deleteMentor(Integer mentorId);
}
