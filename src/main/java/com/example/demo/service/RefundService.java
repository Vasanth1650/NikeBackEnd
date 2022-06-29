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
		logger.info("New Details Added For The Refund");
		return repository.save(refund);
	}
	
	//Get Refund Order By Id
	public Refund getById(int id) {
		Optional<Refund> refund = repository.findById(id);
		return (refund.get());
	}
	
	//Getting Refund For The Particular User
	public List<Refund> getByUserid(int userid){
		return repository.findByUserid(userid);
	}
	
	//Getting All Refund Details
	public List<Refund> getAllRefund(){
		return repository.findAll();
	}
	
	//Updating Refund Details
	public Refund updateStatusRefund(int id,Refund refund) {
		if(getById(refund.getId())==null) {
			return null;
		}
		return repository.save(refund);
	}

}
