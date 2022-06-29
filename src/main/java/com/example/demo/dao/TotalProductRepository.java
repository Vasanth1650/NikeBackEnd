/**
 * TotalProductRepository Data Access Object Which Used To Manipulate Certain Methods Defined In Jpa Which Is Rest Operation
 * 
 */


package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.TotalProducts;

@Repository
public interface TotalProductRepository extends JpaRepository<TotalProducts,Integer>{
	
	//There Will Be List Of Products This Will Helps To Find ProductByName
	List<TotalProducts> findByProductname(String productname);

	//There Will Be List Of Product In Each Category It Will Return According To Category
	List<TotalProducts> findByCategory1(String category1);

	//There Will Be Multiple Gender Which Will Sort According To The Particular Gender
	List<TotalProducts> findByGender(String gender);

	//There Will Be A Particular Products Under A Certain Collection 
	List<TotalProducts> findByCollection(String collection);

}
