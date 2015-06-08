package com.href.biz.tiz.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.href.biz.tiz.domain.Screen;

public interface ScreenRepo extends JpaRepository<Screen, Serializable>{
	
    @Query("select sc from Screen sc where sc.cinema.name = :name")
    public List<Screen> getScreensByCinema(@Param("name") String name);
    
    @Query("select sc from Screen sc where sc.cinema.id = :id")
    public List<Screen> getScreensByCinemaId(@Param("id") Long id);

}
