package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ChatLiveRepository;
import com.example.demo.model.ChatLive;

@Service
public class ChatLiveService {
	
	@Autowired
	private ChatLiveRepository repository;
	
	Logger logger = LogManager.getLogger(ChatLiveService.class);
	
	public ChatLive addChat(ChatLive chat) {
		try {
			if(chat!=null) {
				logger.info("A New Chat Tunnel Has Been Created");
			}else {
				logger.error("Error Creating Tunnel");
				throw new Exception("Catch Me");
			}
		}catch(Exception e) {
			throw new RuntimeException("Something Went Wrong While Creating Tunnel");
		}
		return repository.save(chat);
	}
	
	
	@Transactional
	public void deleteBytunnel(int tunnelid) {
		repository.deleteByTunnelid(tunnelid);
	}
	
	public List<ChatLive> getAllLives(){
		return repository.findAll();
	}
	
	public List<ChatLive> getBytunnelId(int tunnelid){
		return repository.findByTunnelid(tunnelid);
	}
	
	
	

}
