package com.example.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.quiz.request.UserFillenReq;
import com.example.quiz.respomse.BasicInfoRes;
import com.example.quiz.respomse.UserFillenLoginRes;
import com.example.quiz.service.UserFillenService;

@RestController
@RequestMapping("/fillen")
@CrossOrigin(origins = "http://localhost:4200")
public class UserFillenController {
	
	@Autowired
	private UserFillenService userFillenService;
	
	//填問卷者註冊
	@PostMapping("/register")
	public BasicInfoRes regester(@RequestBody UserFillenReq req) {
		return userFillenService.register(req);
	}
		
	// 填問卷者登入
	@PostMapping("/login")
	public UserFillenLoginRes login(@RequestBody UserFillenReq req) {
		return userFillenService.login(req);
		}
}
