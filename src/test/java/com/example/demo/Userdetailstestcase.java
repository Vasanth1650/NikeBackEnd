package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.dao.ChatLiveRepository;
import com.example.demo.model.ChatLive;
import com.example.demo.service.ChatLiveService;

@SpringBootTest
@RunWith(SpringRunner.class)
class Userdetailstestcase {
	
	
	@MockBean
	private ChatLiveService service;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ChatLiveRepository repository;
	
	
	ChatLive live = new ChatLive(1,"Vasanth",4);
	
	
	
	
	
	

}
