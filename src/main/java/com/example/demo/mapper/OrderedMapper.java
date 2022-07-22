package com.example.demo.mapper;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import com.example.demo.dto.OrderedDto;
import com.example.demo.model.Ordered;




@Component
public class OrderedMapper {
	
	public OrderedDto toOrderedDto(Ordered order) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return mapper.map(order, OrderedDto.class);
	}
	
	public Ordered toOrdered(OrderedDto orderedDto) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return mapper.map(orderedDto,Ordered.class);
	}
	
	public List<OrderedDto> toOrderedDtos(List<Ordered> ordered){
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return Arrays.asList(mapper.map(ordered, OrderedDto[].class));
	}
}
