package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ChatLiveDto;

import com.example.demo.service.ChatLiveService;

@RestController
@CrossOrigin
@RequestMapping("/livechat")
public class ChatLiveController {
	
	@Autowired
	private ChatLiveService service;
	
	@PostMapping("/addnewrequest")
	public ChatLiveDto addNewChat(@RequestBody ChatLiveDto chat) {
		return service.addChat(chat);
	}
	
	@DeleteMapping("/deletetunnel/{tunnelid}")
	public void deleteByTunneling(@PathVariable int tunnelid) {
		service.deleteBytunnel(tunnelid);
	}
	
	@GetMapping("/getAllId")
	public List<ChatLiveDto> allLives(){
		return service.getAllLives();
	}
	
	@GetMapping("/getByTunnelId/{tunnelid}")
	public List<ChatLiveDto> tunnelcheck(@PathVariable int tunnelid){
		return service.getBytunnelId(tunnelid);
	}
	
	

}
