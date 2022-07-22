package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ChatLiveRepository;
import com.example.demo.dto.ChatLiveDto;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.mapper.ChatLiveMapper;
import com.example.demo.model.ChatLive;

@Service
public class ChatLiveService {
	
	@Autowired
	private ChatLiveRepository repository;
	
	@Autowired
	private ChatLiveMapper mapper;
	
	Logger logger = LogManager.getLogger(ChatLiveService.class);
	
	public ChatLiveDto addChat(ChatLiveDto chat) {
		try {
			if(chat!=null) {
				logger.info("A New Chat Tunnel Has Been Created");
			}else {
				logger.error("Error Creating Tunnel");
				throw new ResourceNotFoundException("Catch Me");
			}
		}catch(Exception e) {
			throw new ResourceNotFoundException("Something Went Wrong While Creating Tunnel");
		}
		ChatLive chating = mapper.toChatLive(chat);
		chating = repository.save(chating);
		
		return mapper.toChatLiveDto(chating);
	}
	
	
	@Transactional
	public void deleteBytunnel(int tunnelid) {
		repository.deleteByTunnelid(tunnelid);
	}
	
	public List<ChatLiveDto> getAllLives(){
		List<ChatLive> live = repository.findAll();
		return mapper.toChatLiveDtos(live);
	}
	
	public List<ChatLiveDto> getBytunnelId(int tunnelid){
		List<ChatLive> live = repository.findByTunnelid(tunnelid);
		return mapper.toChatLiveDtos(live);
	}


	
	
	
	

}
