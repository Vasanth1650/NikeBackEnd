package com.example.demo.mapper;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import com.example.demo.dto.RefundDto;
import com.example.demo.model.Refund;




@Component
public class RefundMapper {

	
	public RefundDto toRefundDto(Refund refund) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return mapper.map(refund, RefundDto.class);
	}
	
	public Refund toRefund(RefundDto refund) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return mapper.map(refund,Refund.class);
	}
	
	public List<RefundDto> toRefundDtos(List<Refund> refund){
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return Arrays.asList(mapper.map(refund, RefundDto[].class));
	}
}
