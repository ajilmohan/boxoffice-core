package com.href.biz.tiz.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.href.biz.tiz.domain.Role;

public interface RoleRepo extends JpaRepository<Role, Serializable>{

}
