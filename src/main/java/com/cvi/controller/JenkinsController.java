package com.cvi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JenkinsController {
	
	@GetMapping("message")
	public String getMessage() {
		
		return "Merry Christmas Simeon, Sichan and Sian!!";
	}

}
