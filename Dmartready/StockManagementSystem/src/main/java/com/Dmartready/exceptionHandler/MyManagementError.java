package com.Dmartready.exceptionHandler;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class MyManagementError {
	private LocalDateTime timestamp;
	private String message;
	private String description;
	private String path;

}
