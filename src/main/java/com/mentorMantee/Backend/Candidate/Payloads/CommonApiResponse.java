package com.mentorMantee.Backend.Candidate.Payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CommonApiResponse {

	private String message;
	private boolean success;

}
