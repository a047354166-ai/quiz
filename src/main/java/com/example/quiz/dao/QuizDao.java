package com.example.quiz.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.quiz.entity.Quiz;

public interface QuizDao extends JpaRepository<Quiz, Integer> {

	
	@Modifying
	@Transactional
	@Query(value = "insert into quiz(title, description, start_date, end_date, published, user_Id )"//
					+ "values(?1, ?2, ?3, ?4, ?5, ?6)",nativeQuery = true)
	public void insertQuiz(String title,String description, LocalDate startDate, LocalDate endDate, Boolean published, Integer user_Id);
	
	@Query(value = "select last_insert_id()", nativeQuery = true)
	public Integer getLastInsertId();
	
	@Modifying
	@Transactional
	@Query(value = "delete from quiz where id = ?1" , nativeQuery = true)
	public int deleteQuizById(Integer quizId);
	
	@Modifying
	@Transactional
	@Query(value = "update quiz set title = ?1, description = ?2, start_date = ?3, end_date = ?4, published = ?5 where id = ?6",  nativeQuery = true)
	public int updateQuiz(String title, String description, LocalDate startDate,  LocalDate endDate, Boolean published, Integer quizId );
	
	//查全部問卷
	@Query(value = "select * from quiz where user_id = ?1 order by id desc", nativeQuery = true)
	public List<Quiz> getAllQuizByUserId(Integer userId);
	
	//查單筆詳細資料
	@Query(value = "select * from quiz where id = ?1" , nativeQuery = true)
	public Quiz getQuizById(Integer quizId);
}
