package com.example.demo.mapper;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import com.example.demo.dto.ChargeDto;
import com.example.demo.model.Charge;




@Component
public class ChargeMapper {
	
	
	public ChargeDto toChargeDto(Charge charge) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return mapper.map(charge, ChargeDto.class);
	}

	public Charge toCharge(ChargeDto charge) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return mapper.map(charge, Charge.class);
	}

	public List<ChargeDto> toChargeDtos(List<Charge> charge) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return Arrays.asList(mapper.map(charge, ChargeDto[].class));
	}
	
	
}
