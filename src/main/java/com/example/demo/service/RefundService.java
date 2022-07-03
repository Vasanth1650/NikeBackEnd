/**
 * Refund Service To Provide Refund From The Ordered Service 
 * @author Vasanth
 * **/




package com.example.demo.service;
import java.util.List;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dao.RefundRepository;
import com.example.demo.model.Refund;



@Service
public class RefundService {
	
	//Logger
	Logger logger = LogManager.getLogger(RefundService.class);
	
	
	//RefundRepository
	@Autowired
	private RefundRepository repository;
	
	
	
	//Add New Refund Details
	public Refund addRefundDetails(Refund refund) {
		//Adding New Refund Status
		logger.info("New Details Added For The Refund");
		return repository.save(refund);
	}
	
	//Get Refund Order By Id
	public Refund getById(int id) {
		//Getting Refund Details By Particular Id
		logger.info("Refund Id Is Getting :"+id);
		Optional<Refund> refund = repository.findById(id);
		return (refund.get());
	}
	
	//Getting Refund For The Particular User
	public List<Refund> getByUserid(int userid){
		//Getting Particular Refund Status For Userid
		logger.warn("Refund UserID Is Getting"+userid);
		return repository.findByUserid(userid);
	}
	
	//Getting All Refund Details
	public List<Refund> getAllRefund(){
		//Getting All Refund Details
		logger.warn("Getting All refund Details");
		return repository.findAll();
	}
	
	//Updating Refund Details
	public Refund updateStatusRefund(int id,Refund refund) {
		//Checking Whether The Particular Id Exist To Update
		if(getById(refund.getId())==null) {
			logger.error("Not Found Refund Details Of Id"+id);
			return null;
		}
		//Returns The Update
		return repository.save(refund);
	}

}
