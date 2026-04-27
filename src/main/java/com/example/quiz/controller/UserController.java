package com.example.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.quiz.request.AddInfoReq;
import com.example.quiz.respomse.BasicInfoRes;
import com.example.quiz.respomse.LoginRes;
import com.example.quiz.service.UserService;


@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping(value = "register")
	public BasicInfoRes addInfo (@RequestBody AddInfoReq req) {
		return userService.addInfo(req.getEmail(), req.getPassword());
	}
	
	@PostMapping(value = "login")
	public LoginRes login(@RequestBody AddInfoReq req) {
		return userService.login(req.getEmail(), req.getPassword());
	}
}
