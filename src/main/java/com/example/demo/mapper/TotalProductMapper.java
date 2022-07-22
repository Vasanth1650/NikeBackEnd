package com.example.demo.mapper;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import com.example.demo.dto.TotalProductsDto;
import com.example.demo.model.TotalProducts;



@Component
public class TotalProductMapper {

	
	public TotalProductsDto toTotalProductsDto(TotalProducts product) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return mapper.map(product, TotalProductsDto.class);
	}
	
	public TotalProducts toTotalProducts(TotalProductsDto product) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return mapper.map(product,TotalProducts.class);
	}
	
	public List<TotalProductsDto> toTotalProductsDtos(List<TotalProducts> product){
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return Arrays.asList(mapper.map(product, TotalProductsDto[].class));
	}
	
	
}
