/**
 * Charge Service Acts As The Business Layer Where Implementation Of Rest Happens
 * @author Vasanth
 * */

package com.example.demo.service;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ChargeRepository;
import com.example.demo.dto.ChargeDto;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.mapper.ChargeMapper;
import com.example.demo.model.Charge;



@Service
public class ChargeService {
	
	@Autowired
	private ChargeRepository repository;
	
	@Autowired
	private ChargeMapper mapper;
	
	//Logger
	Logger logger = LogManager.getLogger(ChargeService.class);
	
	
	//Adding Cart Items
	public ChargeDto addCharge(ChargeDto charge){
		//logger Get's The Info Of Every New Object Added 
		try {
			if(charge==null) {
				//Throws Exception And Logger Error Unable To Add Data.
				logger.error("No Object Present");
				throw new ResourceNotFoundException("Problem Ocuured In Adding Data In Cart");
			}
			else {
				//On Succesful Receiving Object Log The Data
				logger.info("Data Addedd Successfull ");
			}
		}catch(Exception e) {
			//Catch The Exception In Try Catch
			throw new ResourceNotFoundException("Something Went While Adding Data....");
		}
		Charge charging = mapper.toCharge(charge);
		charging = repository.save(charging);
		return mapper.toChargeDto(charging);
	}
	
	
	//Getting Particular Item Of User Cart Items
	public List<ChargeDto> getById(int userid){
		//logger Get's The Info Of The Particular Record Picking
		logger.info("The Particular Data Picking For The Particular User ");
		List<Charge>charge = repository.findByUserid(userid);
		return mapper.toChargeDtos(charge);
	}
	
	
	//@Transactional Will Only Work On The Public Method Which Creates A Proxy Between Database It Will RollBack When Exception Occurred 
	@Transactional
	public List<ChargeDto> deleteById(int userid) {
		//Logger Warns The Data From The Database Getting Deleted For The Particular UserId
		logger.warn("After Checking Out The Object From The Checkout Is Deleted According To UserID ");
		return repository.deleteByUserid(userid);
	}
	
	
	
	//Delete If User Don’t Wanna Add Item In Checkout
	public void deleteByIdTo(int id){
			//Stores Log Warn Info For Deleting Presented Item 
		logger.warn("User Removing Particular Object While CheckOut");
		repository.deleteById(id);
	}

}
