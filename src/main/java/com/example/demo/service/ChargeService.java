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
import com.example.demo.model.Charge;



@Service
public class ChargeService {
	
	@Autowired
	private ChargeRepository repository;
	
	Logger logger = LogManager.getLogger(ChargeService.class);
	
	
	//Adding Cart Items
	public Charge addCharge(Charge charge){
		//logger Get's The Info Of Every New Object Added 
		try {
			if(charge==null) {
				//Throws Exception And Logger Error Unable To Add Data.
				logger.error("No Object Present");
				throw new Exception("Problem Ocuured In Adding Data In Cart");
			}
			else {
				//On Succesful Receiving Object Log The Data
				logger.info("Data Addedd Successfull "+charge);
			}
		}catch(Exception e) {
			//Catch The Exception In Try Catch
			System.out.println("Something Went While Adding Data....");
		}
		return repository.save(charge);
	}
	
	
	//Getting Particular Item Of User Cart Items
	public List<Charge> getById(int userid){
		//logger Get's The Info Of The Particular Record Picking
		logger.info("The Particular Data Picking For The Particular User "+userid);
		return repository.findByUserid(userid);
	}
	
	
	//@Transactional Will Only Work On The Public Method Which Creates A Proxy Between Database It Will RollBack When Exception Occurred 
	@Transactional
	public List<Charge> deleteById(int userid) {
		//Logger Warns The Data From The Database Getting Deleted For The Particular UserId
		logger.warn("After Checking Out The Object From The Checkout Is Deleted According To UserID "+userid);
		return repository.deleteByUserid(userid);
	}
	
	
	
	//Delete If User Don’t Wanna Add Item In Checkout
	public void deleteByIdTo(int id) {
		Charge m = repository.findById(id).get();
		try {
			if(m==null) {
				logger.error("Unable To Find The Object To Delete");
				throw new Exception("Unable To Find Catch Me");
			}else {
				//Stores Log Warn Info For Deleting Presented Item 
				logger.warn("User Removing Particular Object While CheckOut");
				repository.deleteById(id);
			}
		}catch(Exception e){
			//Gives The Log For Accessing UnKnown Object
			logger.error("Unable To Delete The Unpresent Object");
			System.out.println("User Trying To Delete The Unknown Element");
		}
		
	}

}
