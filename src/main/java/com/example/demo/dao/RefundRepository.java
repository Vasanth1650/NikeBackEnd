/**
 * RefundRepository Data Access Object Which Used To Manipulate Certain Methods Defined In Jpa Which Is Rest Operation
 * 
 */
package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.RefundDto;
import com.example.demo.model.Refund;

@Repository
public interface RefundRepository extends JpaRepository<Refund,Integer>{

	//A Single User Can Have Multiple Order On Cancellation Which Will Return As A List
	List<Refund> findByUserid(int userid);

	Refund save(RefundDto refund);
	
	

}
