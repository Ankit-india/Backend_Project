package com.mentorMantee.Backend.Mentor.Services.Impl;

import java.util.List;

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
		// TODO Auto-generated method stub
		Mentor mentor = this.MentorDtoToMentor(mentorDto);
		Mentor savedMentor = this.mentorRepo.save(mentor);
		return this.MentorToMentorDto(savedMentor);
	}

	@Override
	public MentorDto updateMentor(MentorDto mentorDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MentorDto getMetorById(Integer mentorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MentorDto> getAllMentor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void deleteMentor(Integer mentorId) {
		// TODO Auto-generated method stub
		return null;
	}

}
