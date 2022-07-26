package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Authority;

public interface AuthRepository extends JpaRepository<Authority,Integer>{

}
