package com.example.demo;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.dao.ChatLiveRepository;
import com.example.demo.dto.ChatLiveDto;
import com.example.demo.model.ChatLive;
import com.example.demo.service.ChatLiveService;

@SpringBootTest
@AutoConfigureMockMvc
 class ChatLiveTest {
	
	
	@Autowired
	private MockMvc mockMvc;
	
	
	
	@MockBean
	private ChatLiveService service;

	@Test
	 void shouldReturnDefaultMessage() throws Exception {
		
			List<ChatLiveDto> list = new ArrayList<>();
			ChatLiveDto live = new ChatLiveDto(1,"vasanth",2);
			list.add(live);
			when(service.getAllLives()).thenReturn(list);
		
		this.mockMvc.perform(get("/livechat/getAllId")).andDo(print()).andExpect(status().isOk());
				
	}
	
	

}
