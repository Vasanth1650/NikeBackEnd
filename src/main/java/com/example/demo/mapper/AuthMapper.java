package com.example.demo.mapper;


import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import com.example.demo.dto.AuthDto;
import com.example.demo.model.Auth;



@Component
public class AuthMapper {
	public AuthDto toAuthDto(Auth auth) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return mapper.map(auth, AuthDto.class);
	}

	public Auth toAuthLive(AuthDto authDto) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return mapper.map(authDto, Auth.class);
	}

	public List<AuthDto> toAuthDtos(List<Auth> auth) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return Arrays.asList(mapper.map(auth, AuthDto[].class));
	}
}
