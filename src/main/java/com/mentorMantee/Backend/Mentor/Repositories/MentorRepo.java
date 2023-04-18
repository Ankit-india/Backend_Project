package com.mentorMantee.Backend.Mentor.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mentorMantee.Backend.Mentor.Entities.Mentor;

public interface MentorRepo extends JpaRepository<Mentor, Integer>{

}
