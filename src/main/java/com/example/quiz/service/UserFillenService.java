package com.example.quiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.example.quiz.dao.UserFillenDao;
import com.example.quiz.entity.UserFillen;
import com.example.quiz.request.UserFillenReq;
import com.example.quiz.respomse.BasicInfoRes;
import com.example.quiz.respomse.UserFillenLoginRes;

@Service
public class UserFillenService {

	@Autowired
	private UserFillenDao userFillenDao;
	
	//填問卷註冊
	public BasicInfoRes register(UserFillenReq req) {
		//email不可空白
		if (!StringUtils.hasText(req.getEmail())) {
			return new BasicInfoRes(400, "Email 不可為空");
		}
		
		//密碼不可為空
		if (!StringUtils.hasText(req.getPassword())) {
			return new BasicInfoRes(400, "密碼不可為空");
		}
		
		//姓名不可為空
		if (!StringUtils.hasText(req.getName())) {
			return new BasicInfoRes(400, "姓名不可為空");
		}
		
		// 年齡不可小於 1
		if(req.getAge() <= 0) {
			return new BasicInfoRes(400, "年齡不可小於0");
		}
		
		//檢查 email 是否存在
		if(userFillenDao.countByEmail(req.getEmail()) > 0) {
			return new BasicInfoRes(400, "此 email 已被註冊過");
			
		}
		
		//寫進資料庫
		userFillenDao.insertUserFillen(req.getEmail(), req.getPassword(), req.getName(), req.getAge());
		
		return new BasicInfoRes (200, "登入成功");
	}
	
	public UserFillenLoginRes login (UserFillenReq req) {
		
		//email不可空白
		if (!StringUtils.hasText(req.getEmail())) {
			return new UserFillenLoginRes(400, "Email 不可為空", null, null, null);
		}
				
		//密碼不可為空
		if (!StringUtils.hasText(req.getPassword())) {
			return new UserFillenLoginRes(400, "密碼不可為空", null, null, null);
			}
		
		//查詢帳號及密碼是否存在
		UserFillen user = userFillenDao.findByEmailAnfPassword(req.getEmail(), req.getPassword());
		if(user == null) {
			return new UserFillenLoginRes(400, "帳號密碼錯誤", null, null, null);
			
		}
		
		//登入成功
		return new UserFillenLoginRes(200, "登入成功", user.getUserId(), user.getEmail(), user.getPassward());
		
	}
	
}
