package com.mentorMantee.Backend.Candidate.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mentorMantee.Backend.Candidate.Entities.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}