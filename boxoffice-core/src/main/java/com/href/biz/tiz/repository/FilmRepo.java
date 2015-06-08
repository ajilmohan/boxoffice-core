package com.href.biz.tiz.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.href.biz.tiz.domain.Film;

public interface FilmRepo extends JpaRepository<Film, Serializable>{
	
	@Query("select fl from Film fl where fl.status = :status")
    public List<Film> getFilmByStatus(@Param("status") String status);

}
