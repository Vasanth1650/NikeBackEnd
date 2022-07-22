package com.example.demo.mapper;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import com.example.demo.dto.ChatLiveDto;
import com.example.demo.model.ChatLive;

@Component
public class ChatLiveMapper {
	
	public ChatLiveDto toChatLiveDto(ChatLive chating) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return mapper.map(chating, ChatLiveDto.class);
	}
	
	public ChatLive toChatLive(ChatLiveDto companyDto) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return mapper.map(companyDto,ChatLive.class);
	}
	
	public List<ChatLiveDto> toChatLiveDtos(List<ChatLive> companies){
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return Arrays.asList(mapper.map(companies, ChatLiveDto[].class));
	}
}
