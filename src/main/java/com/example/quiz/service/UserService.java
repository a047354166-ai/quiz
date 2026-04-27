package com.example.quiz.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.quiz.constants.ReplyMessage;
import com.example.quiz.dao.UserDao;
import com.example.quiz.entity.User;
import com.example.quiz.respomse.BasicInfoRes;
import com.example.quiz.respomse.LoginRes;


@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public BasicInfoRes addInfo (String email, String password) {
		if (!StringUtils.hasText(email)) {
			return new  BasicInfoRes(ReplyMessage.PARAM_EMAIL_ERROW.getCode(),
					ReplyMessage.PARAM_EMAIL_ERROW.getMessage());
		}
		if (!StringUtils.hasText(password)) {
			return new  BasicInfoRes(ReplyMessage.PARAM_PASSWORD_ERROW.getCode(),
					ReplyMessage.PARAM_PASSWORD_ERROW.getMessage());
		}
		
		
		// 🌟 2. 【絕對關鍵的防護網】在 Insert 之前，先檢查信箱是否已存在！
				if (userDao.existsById(email)) {
					// 如果已經存在，冷靜地回傳 400 給前端，不要讓系統崩潰
					return new BasicInfoRes(400, "這個 Email 已經被註冊過囉！");
				}
				
				userDao.insert(email, password);
				return new BasicInfoRes(ReplyMessage.SUCCESS.getCode(), ReplyMessage.SUCCESS.getMessage());
	}
	
	public LoginRes login(String email, String password) {
		if (!StringUtils.hasText(email)) {
			return new LoginRes(
				ReplyMessage.PARAM_EMAIL_ERROW.getCode(),
				ReplyMessage.PARAM_EMAIL_ERROW.getMessage(),
				null
			);
		}

		if (!StringUtils.hasText(password)) {
			return new LoginRes(
				ReplyMessage.PARAM_PASSWORD_ERROW.getCode(),
				ReplyMessage.PARAM_PASSWORD_ERROW.getMessage(),
				null
			);
		}

		User user = userDao.findByEmailAndPassword(email, password);

		if (user != null) {
			return new LoginRes(
				ReplyMessage.LOGIN_SUCCESS.getCode(),
				ReplyMessage.LOGIN_SUCCESS.getMessage(),
				user.getUserId()
			);
		}

		return new LoginRes(400, "帳號密碼錯誤", null);
	}
}
