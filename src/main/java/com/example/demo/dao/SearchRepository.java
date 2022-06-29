/**
 * SearchRepository Data Access Object Which Used To Manipulate Certain Methods Defined In Jpa Which Is Rest Operation
 * 
 */


package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.SearchResult;

@Repository
public interface SearchRepository extends JpaRepository<SearchResult,Integer>{
	

}
