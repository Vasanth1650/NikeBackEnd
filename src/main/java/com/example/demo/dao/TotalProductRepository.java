package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.TotalProducts;

@Repository
public interface TotalProductRepository extends JpaRepository<TotalProducts,Integer>{
	
	List<TotalProducts> findByProductname(String productname);

	List<TotalProducts> findByCategory(String category);

	List<TotalProducts> findByGender(String gender);

}
