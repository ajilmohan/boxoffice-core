package com.href.biz.tiz.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.href.biz.tiz.domain.SeatMasterOfScreen;

public interface SeatMasterOfScreenRepo extends JpaRepository<SeatMasterOfScreen, Serializable>{

	@Query("select sc from SeatMasterOfScreen sc where sc.screen.id = :id")
    public List<SeatMasterOfScreen> getSeatMasterByScreenId(@Param("id") Long id);
}
