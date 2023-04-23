package com.mentorMantee.Backend.Mentor.Services.Impl;

import java.util.List;
import java.util.stream.Collectors;

import com.mentorMantee.Backend.Candidate.Exceptions.ResourceNotFoundException;
import com.mentorMantee.Backend.Mentor.Payloads.ApiResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mentorMantee.Backend.Mentor.Entities.Mentor;
import com.mentorMantee.Backend.Mentor.Payloads.MentorDto;
import com.mentorMantee.Backend.Mentor.Repositories.MentorRepo;
import com.mentorMantee.Backend.Mentor.Services.MentorService;

@Service
public class MentorServiceImpl implements MentorService{

	@Autowired
	private MentorRepo mentorRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public Mentor MentorDtoToMentor(MentorDto mentorDto) {
		Mentor mentor = this.modelMapper.map(mentorDto, Mentor.class);
		return mentor;
	}
	
	public MentorDto MentorToMentorDto(Mentor mentor) {
		MentorDto mentorDto = this.modelMapper.map(mentor, MentorDto.class);
		return mentorDto;
	}

	@Override
	public MentorDto createMentor(MentorDto mentorDto) {
		Mentor mentor = this.MentorDtoToMentor(mentorDto);
		Mentor savedMentor = this.mentorRepo.save(mentor);
		return this.MentorToMentorDto(savedMentor);
	}

	@Override
	public MentorDto updateMentor(MentorDto mentorDto, Integer mentorId) {
		Mentor mentor = this.mentorRepo.findById(mentorId).orElseThrow(() -> new ResourceNotFoundException("mentorId", " mentorId", mentorId));
		mentor.setName(mentorDto.getName());
		mentor.setDesignation(mentorDto.getDesignation());
		mentor.setDomain(mentorDto.getDomain());
		mentor.setEmail(mentorDto.getEmail());
		mentor.setExperience(mentorDto.getExperience());
		mentor.setPassword(mentorDto.getPassword());
		mentor.setCurrentCompanyName(mentorDto.getCurrentCompanyName());
		Mentor savedMentor = this.mentorRepo.save(mentor);
		return this.MentorToMentorDto(savedMentor);
	}

	@Override
	public MentorDto getMentorById(Integer mentorId) {
		Mentor mentor = this.mentorRepo.findById(mentorId).orElseThrow(() -> new ResourceNotFoundException("mentorId", " mentorId ", mentorId));
		return this.MentorToMentorDto(mentor);
	}

	@Override
	public List<MentorDto> getAllMentor() {
		List<Mentor> listOfAllMentor = this.mentorRepo.findAll();
		List<MentorDto> listOfMentorDto = listOfAllMentor.stream().map(mentor -> this.MentorToMentorDto(mentor)).collect(Collectors.toList());
		return listOfMentorDto;
	}

	@Override
	public ApiResponse deleteMentor(Integer mentorId) {
		Mentor mentor = this.mentorRepo.findById(mentorId).orElseThrow(() -> new ResourceNotFoundException("mentorId", " mentorId ", mentorId));
		this.mentorRepo.delete(mentor);
		return new ApiResponse("Mentor Deleted Successfully", true);
	}

}
