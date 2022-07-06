package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ChatLiveRepository;
import com.example.demo.model.ChatLive;

@Service
public class ChatLiveService {
	
	@Autowired
	private ChatLiveRepository repository;
	
	
	public ChatLive addChat(ChatLive chat) {
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
