package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Refund;
import com.example.demo.service.RefundService;

@RestController
@CrossOrigin
@RequestMapping("/refund")
public class RefundController {
	
	@Autowired
	private RefundService service;
	
	
	@PostMapping("/refundcollector")
	public Refund addDetails(@RequestBody Refund refund) {
		return service.addRefundDetails(refund);
	}
	
	@GetMapping("/refunding/{userid}")
	public List<Refund> getDetails(@PathVariable int userid){
		return service.getByUserid(userid);
	}
	
	@GetMapping("/viewerequest")
	public List<Refund> getAllRefund(){
		return service.getAllRefund();
	}
	
	@GetMapping("/{id}")
	public Refund getByIds(@PathVariable int id){
		return service.getById(id);
	}
	
	@PutMapping("/updaterefund/{id}")
	public ResponseEntity<Refund> updateStatus(@PathVariable int id,@RequestBody Refund refund){
		Refund refunds = service.getById(id);
		refunds.setUserid(refund.getUserid());
		refunds.setUsername(refund.getUsername());
		refunds.setOrderid(refund.getOrderid());
		refunds.setPaymentid(refund.getPaymentid());
		refunds.setPrice(refund.getPrice());
		refunds.setProductname(refund.getProductname());
		refunds.setRefundstatus(refund.getRefundstatus());
		Refund update = service.addRefundDetails(refunds);
		return ResponseEntity.ok(update);
	}

}
