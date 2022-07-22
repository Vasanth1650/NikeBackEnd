/**
 * ChargeRepository Data Access Object Which Used To Manipulate Certain Methods Defined In Jpa Which Is Rest Operation
 * 
 */

package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.ChargeDto;
import com.example.demo.model.Charge;

@Repository
public interface ChargeRepository extends JpaRepository<Charge,Integer>{
	
	//List Denotes One User Can Have Multiple Items In Cart Which Retrives While Billing The Multiple Item Of The User
	List<Charge> findByUserid(int userid);

	//After The Cart Purchase The Item Must Be Removed From The Cart 
	List<Charge> deleteAllById(int userid);

	List<ChargeDto> deleteByUserid(int userid);

	Charge save(ChargeDto charge);

}
