package com.href.biz.tiz.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.href.biz.tiz.domain.BoxOffice;

public interface BoxOfficeRepo extends JpaRepository<BoxOffice, Serializable>{

}
