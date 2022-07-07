package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Ordered;
import com.example.demo.service.OrderedService;

@RestController
@RequestMapping("/ordered")
@CrossOrigin
public class OrderedController {
	
	@Autowired
	private OrderedService service;
	
	@PostMapping("/generateorder")
	public Ordered adder(@RequestBody Ordered order) {
		return service.addDetails(order);
	}
	
	@GetMapping("/viewallproducts")
	public List<Ordered> getAllOrders(){
		return service.viewer();
	}
	
	@GetMapping("/getbyuserid/{userid}")
	public List<Ordered> getting(@PathVariable int userid) throws Exception{
		return service.getByUserid(userid);
	}
	
	@GetMapping("/{id}")
	public Ordered finderById(@PathVariable int id) {
		return service.getByIds(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleting(@PathVariable int id) {
		service.deleteById(id);
	}
	
	@PutMapping("/updateOrder/{id}")
	public ResponseEntity<Ordered> updatingStatus(@PathVariable int id,@RequestBody Ordered order){
		Ordered orders = service.getByIds(id);
		orders.setUserid(order.getUserid());
		orders.setUsername(order.getUsername());
		orders.setPayment(order.getPayment());
		orders.setPaymentid(orders.getPaymentid());
		orders.setProductname(order.getProductname());
		orders.setAddress(order.getAddress());
		orders.setCity(order.getCity());
		orders.setState(order.getState());
		orders.setStatus(order.getStatus());
		orders.setStatus1(order.getStatus1());
		orders.setStatus2(order.getStatus2());
		orders.setStatus3(order.getStatus3());
		orders.setStatus4(order.getStatus4());
		orders.setStatus5(order.getStatus5());
		Ordered update = service.addDetails(orders);
		return ResponseEntity.ok(update);
	}

}
