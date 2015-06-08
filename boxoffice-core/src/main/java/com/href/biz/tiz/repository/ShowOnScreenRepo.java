package com.href.biz.tiz.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.href.biz.tiz.domain.ShowOnScreen;

public interface ShowOnScreenRepo extends JpaRepository<ShowOnScreen, Serializable>{
	
	@Query("select sc from ShowOnScreen sc where sc.status = :status")
    public List<ShowOnScreen> getShowOnScreenByStatus(@Param("status") String status);

}
