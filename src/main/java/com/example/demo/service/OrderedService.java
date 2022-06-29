/**
 * OrderedService Class Used To Act As The Business Layer To Add Order Viewing Order And Getting Particular Order Of The User
 * @author Vasanth
 * */


package com.example.demo.service;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dao.OrderedRepository;
import com.example.demo.model.Ordered;

@Service
public class OrderedService {
	
	@Autowired
	private OrderedRepository repository;
	
	Logger logger = LogManager.getLogger(OrderedService.class);
	
	
	//Add Ordered Details
	public Ordered addDetails(Ordered order) {
		logger.info("New Order Has Been Placed");
		return repository.save(order);
	}
	
	//View All The Orders
	public List<Ordered> viewer(){
		logger.warn("Viewing All Details");
		return repository.findAll();
	}
	
	//May Particular User Have Many Order So Viewing In List Of A Particular User
	public List<Ordered> getByUserid(int userid) throws Exception{
		List<Ordered>list = repository.findByUserid(userid);
		try {
			if(list.isEmpty()) {
				logger.error("The User Has No Particular Orders");
				throw new RuntimeException("Check Me");
			}
			else {
				logger.info("The User Order Is Here");
			}
		}catch(Exception e){
			throw new RuntimeException("No Order Yet Placed ");
		}
		return list;
	}
	
	//This Used To Delete Order In Case Of Refund
	public void deleteById(int id) {
		logger.warn("Some Ids Has Been Deleted");
		repository.deleteById(id);
	}
	
	//Getting Order By Particular Order Id
	public Ordered getByIds(int id){
		logger.info("Picking up Ordered By ID");
		Optional<Ordered>order = repository.findById(id);
		return (order.get());
	}
	
	//Update The Particular Information Of The Order
	public Ordered updateStatus(int id,Ordered order) {
		if(getByIds(order.getId())==null) {
			return null;
		}
		return repository.save(order);
	}

}
