package com.href.biz.tiz.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.href.biz.tiz.domain.User;

public interface UserRepo extends JpaRepository<User, Serializable>{
	
	@Query("select user from User user where user.name = :name and user.password = :pass ")
    public List<User> getUserByCredentials(@Param("name") String name , @Param("pass") String pass);

}
