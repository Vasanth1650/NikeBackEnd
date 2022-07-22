package com.example.demo.mapper;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;


import com.example.demo.dto.ProductDto;

import com.example.demo.model.Product;




@Component
public class ProductMapper {

	
	public ProductDto toProductDto(Product product) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return mapper.map(product, ProductDto.class);
	}
	
	public Product toProduct(ProductDto productDto) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return mapper.map(productDto,Product.class);
	}
	
	public List<ProductDto> toProductsDtos(List<Product> product){
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return Arrays.asList(mapper.map(product, ProductDto[].class));
	}
}
