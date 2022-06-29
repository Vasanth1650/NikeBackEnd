/**
 * OrderedRepository Data Access Object Which Used To Manipulate Certain Methods Defined In Jpa Which Is Rest Operation
 * 
 */

package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Ordered;


@Repository
public interface OrderedRepository extends JpaRepository<Ordered,Integer>{

	//To Find List Of Particular Users Order Here List Denotes The Particular User Can Have Multiple Orders
	List<Ordered> findByUserid(int userid);

}
