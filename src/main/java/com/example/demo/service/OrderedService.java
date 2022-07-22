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
import com.example.demo.dto.OrderedDto;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.mapper.OrderedMapper;
import com.example.demo.model.Ordered;

@Service
public class OrderedService {
	
	//Repository
	@Autowired
	private OrderedRepository repository;
	
	@Autowired
	private OrderedMapper mapper;
	
	//Logger
	Logger logger = LogManager.getLogger(OrderedService.class);
	
	
	//Add Ordered Details
	public OrderedDto addDetails(OrderedDto order) {
		//Creating New Order
		logger.info("New Order Has Been Placed");
		Ordered orders = mapper.toOrdered(order);
		orders = repository.save(orders);
		return mapper.toOrderedDto(orders);
	}
	
	//View All The Orders
	public List<OrderedDto> viewer(){
		//Viewing All The Ordered Details
		logger.warn("Viewing All Details");
		List<Ordered>list = repository.findAll();
		return mapper.toOrderedDtos(list);
	}
	
	//May Particular User Have Many Order So Viewing In List Of A Particular User
	public List<OrderedDto> getByUserid(int userid){
		//One User Can Have Multiple Order Details So We Are Using List
		List<Ordered>list = repository.findByUserid(userid);
		try {
			if(list.isEmpty()) {
				//Checks Whether The List Of The Particular User Is Empty
				logger.error("The User Has No Particular Orders");
				//Throws Run Time Error
				throw new ResourceNotFoundException("Check Me");
			}
			else {
				//If User List Not Empty
				logger.info("The User Order Is Here");
			}
		}catch(Exception e){
			//Catch The Exception
			throw new ResourceNotFoundException("No Order Yet Placed ");
		}
		//return The List
		return mapper.toOrderedDtos(list);
	}
	
	//This Used To Delete Order In Case Of Refund
	public void deleteById(int id) {
		//Gives A Waring Of Id Getting Deleted
		logger.warn("Some Ids Has Been Deleted");
		repository.deleteById(id);
	}
	
	//Getting Order By Particular Order Id
	public OrderedDto getByIds(int id){
		//Getting Particular Order By ID
		logger.info("Picking up Ordered By ID");
		Optional<Ordered>order = repository.findById(id);
		Ordered orders = null;
		if(order.isPresent()) {
			orders = order.get();
		}
		return mapper.toOrderedDto(orders);
	}
	
	//Update The Particular Information Of The Order
	public OrderedDto updateStatus(OrderedDto order) {
		//Checking Whether The Id Exists TO Update
		if(getByIds(order.getId())==null) {
			return null;
		}
		Ordered orders = repository.save(order);
		//Returns Saved Details
		
		return mapper.toOrderedDto(orders);
	}

}
