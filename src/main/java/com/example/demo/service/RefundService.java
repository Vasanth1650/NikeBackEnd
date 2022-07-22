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
import com.example.demo.dto.RefundDto;
import com.example.demo.mapper.RefundMapper;
import com.example.demo.model.Refund;



@Service
public class RefundService {
	
	//Logger
	Logger logger = LogManager.getLogger(RefundService.class);
	
	
	//RefundRepository
	@Autowired
	private RefundRepository repository;
	
	
	@Autowired
	private RefundMapper mapper;
	
	
	
	//Add New Refund Details
	public RefundDto addRefundDetails(RefundDto refund) {
		//Adding New Refund Status
		logger.info("New Details Added For The Refund");
		Refund refunds = mapper.toRefund(refund);
		refunds = repository.save(refunds);
		return mapper.toRefundDto(refunds);
	}
	
	//Get Refund Order By Id
	public RefundDto getById(int id) {
		//Getting Refund Details By Particular Id
		logger.info("Refund Id Is Getting :");
		Optional<Refund> refund = repository.findById(id);
		Refund list = null;
		if(refund.isPresent()) {
			list = (refund.get());
		}
		return mapper.toRefundDto(list);
	}
	
	//Getting Refund For The Particular User
	public List<RefundDto> getByUserid(int userid){
		//Getting Particular Refund Status For Userid
		logger.warn("Refund UserID Is Getting");
		List<Refund>refund = repository.findByUserid(userid);
		return mapper.toRefundDtos(refund);
	}
	
	//Getting All Refund Details
	public List<RefundDto> getAllRefund(){
		//Getting All Refund Details
		logger.warn("Getting All refund Details");
		List<Refund>refund = repository.findAll();
		return mapper.toRefundDtos(refund);
	}
	
	//Updating Refund Details
	public RefundDto updateStatusRefund(RefundDto refund) {
		//Checking Whether The Particular Id Exist To Update
		if(getById(refund.getId())==null) {
			logger.error("Not Found Refund Details Of Id");
			return null;
		}
		//Returns The Update
		Refund refunds = repository.save(refund);
		return mapper.toRefundDto(refunds);
	}

}
