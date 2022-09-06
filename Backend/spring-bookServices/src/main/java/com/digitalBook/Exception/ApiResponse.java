package com.digitalBook.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor

public class ApiResponse {

	public ApiResponse(String message2, boolean b) {
		// TODO Auto-generated constructor stub
	}
	private String message;
	private String success;
	}


