package com.example.quiz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.quiz.entity.User;



@Repository
public interface UserDao extends JpaRepository<User, String> {
    
    @Modifying
    @Transactional
    @Query(value = "insert into user(email, password) values (?1, ?2)", nativeQuery = true)
    public void insert(String email, String password);
    
    @Query(value = "select * from user where email = ?1 and password = ?2",nativeQuery = true)
    public User findByEmailAndPassword(String email, String password);
}
