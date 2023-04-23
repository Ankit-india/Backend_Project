package com.mentorMantee.Backend.Candidate.Services.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mentorMantee.Backend.Candidate.Entities.User;
import com.mentorMantee.Backend.Candidate.Exceptions.ResourceNotFoundException;
import com.mentorMantee.Backend.Candidate.Payloads.UserDto;
import com.mentorMantee.Backend.Candidate.Repositories.UserRepo;
import com.mentorMantee.Backend.Candidate.Services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public User dtoToUser(UserDto userDto) {
		User user = this.modelMapper.map(userDto, User.class);
		return user;
	}
	
	public UserDto userToDto(User user) {
		UserDto userDto = this.modelMapper.map(user, UserDto.class);
		return userDto;
	}
	
	@Override
	public UserDto createUser(UserDto userDto) {
		User user = this.dtoToUser(userDto);
		User savedUser = this.userRepo.save(user);
		return this.userToDto(savedUser);
	}
	
	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", " id ", userId));
		user.setName(userDto.getName());
		user.setPassword(userDto.getPassword());
		user.setEmail(userDto.getEmail());
		user.setPhoneNumber(userDto.getPhoneNumber());
		user.setDpImage(userDto.getDpImage());
		user.setYearOfPassing(userDto.getYearOfPassing());
		user.setDomain(userDto.getDomain());
		user.setTechStack(userDto.getTechStack());

		User updatedUser = this.userRepo.save(user);
		UserDto updatedUserDto = this.userToDto(updatedUser);

		return updatedUserDto;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", " id ", userId));
		return this.userToDto(user);
	}

	@Override
	public void deleteUser(Integer userId) {
		User user =this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", " id ", userId));
		this.userRepo.delete(user);
		
	}

	@Override
	public List<UserDto> getAllUser() {
		List<User> users = this.userRepo.findAll();
		List<UserDto> listOfUsersDto = users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
		return listOfUsersDto;
	}
}
