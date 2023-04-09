package com.mentorMantee.Backend.Candidate.Services;

import java.util.List;

import com.mentorMantee.Backend.Candidate.Payloads.UserDto;

public interface UserService {
	
	UserDto createUser(UserDto user);
	
	UserDto updateUser(UserDto user, Integer userId);
	
	UserDto getUserById(Integer userId);
	
	void deleteUser(Integer userId);
	
	List<UserDto> getAllUser();

}
