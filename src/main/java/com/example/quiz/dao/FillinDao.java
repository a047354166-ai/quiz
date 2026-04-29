package com.example.quiz.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.quiz.entity.Fillin;
import com.example.quiz.entity.FillinId;

import jakarta.transaction.Transactional;

public interface FillinDao extends JpaRepository<Fillin, FillinId> {

	// 新增填答資料
	@Modifying
	@Transactional
	@Query(value = "insert into fillin(quiz_id, question_id, email, phone, answers, fillin_date) "
			+ "values(?1, ?2, ?3, ?4, ?5, curdate())", nativeQuery = true)
	public int insertFillin(Integer quizId, Integer questionId, String email, String phone, String answers);

	// 檢查是否已經填過這份問卷
	@Query(value = "select count(*) from fillin where quiz_id = ?1 and email = ?2", nativeQuery = true)
	public int countByQuizIdAndEmail(Integer quizId, String email);

	// 查詢某位使用者某份問卷的填寫紀錄
	@Query(value = "select * from fillin where quiz_id = ?1 and email = ?2 order by question_id asc", nativeQuery = true)
	public List<Fillin> getRecord(Integer quizId, String email);

	// 查詢某位使用者已經填過哪些問卷
	@Query(value = "select distinct quiz_id from fillin where email = ?1", nativeQuery = true)
	public List<Integer> getFilledQuizIds(String email);

	// 查詢某份問卷所有填答
	@Query(value = "select * from fillin where quiz_id = ?1 order by question_id asc", nativeQuery = true)
	public List<Fillin> getFillinByQuizId(Integer quizId);

	// 查詢某份問卷總填寫人數
	@Query(value = "select count(distinct email) from fillin where quiz_id = ?1", nativeQuery = true)
	public int countFillinUser(Integer quizId);
}