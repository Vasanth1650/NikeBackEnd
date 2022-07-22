package com.example.demo.mapper;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import com.example.demo.dto.AuthorityDto;
import com.example.demo.model.Authority;




@Component
public class AuthorityMapper {
	public AuthorityDto toAuthorityDto(Authority authority) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return mapper.map(authority, AuthorityDto.class);
	}

	public Authority toAuthority(AuthorityDto authorityDto) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return mapper.map(authorityDto, Authority.class);
	}

	public List<AuthorityDto> toAuthorityDtos(List<Authority> auth) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return Arrays.asList(mapper.map(auth, AuthorityDto[].class));
	}
}
