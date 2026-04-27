package com.example.quiz.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.quiz.entity.Question;
import com.example.quiz.entity.QuestionId;
import com.example.quiz.entity.Quiz;

import jakarta.transaction.Transactional;

public interface QuestionDao extends JpaRepository<Question, QuestionId>{

	
	@Modifying
	@Transactional
	@Query(value = "insert into question(quiz_id, question_id, question, type, required, options) " +
			       "values(?1, ?2, ?3, ?4, ?5, ?6)", nativeQuery = true)
	public void insertQuestion(Integer quizId, Integer questionId, String question, String type, Boolean required, String options);

	@Modifying
	@Transactional
	@Query(value = "delete from question where quiz_id = ?1", nativeQuery = true)
	public int deleteQuestionsByQuizId(Integer quizId);
	
	@Query(value = "select * from question where quiz_id = ?1 order by question_id asc", nativeQuery = true)
	public List<Question> getQuestionsByQuizId(Integer quizId);
	
}
