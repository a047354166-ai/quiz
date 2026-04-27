package com.example.quiz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.quiz.entity.UserFillen;

public interface UserFillenDao extends JpaRepository<UserFillen, Integer>{
	
	//檢查email是否註冊
	@Query(value = "select count(*) from user_fillen where email = ?1", nativeQuery = true)
	public int countByEmail(String email);
	
	// 新增填問卷者帳號
	@Modifying
	@Transactional
	@Query(value = "insert into user_fillen(email, password, name, age) values(?1, ?2, ?3, ?4)", nativeQuery = true)
	public int insertUserFillen(String email, String password, String name, int age);
	
	//登入時用 email 和 password 查使用者 
	@Query(value = "select * from user_fillen where email = ?1 and password = ?2", nativeQuery = true)
	public UserFillen findByEmailAnfPassword(String email, String password);
}