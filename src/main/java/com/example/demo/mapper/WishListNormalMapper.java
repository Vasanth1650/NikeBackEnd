package com.example.demo.mapper;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import com.example.demo.dto.WishListNormalDto;
import com.example.demo.model.WishListNormal;




@Component
public class WishListNormalMapper {

	public WishListNormalDto toWishListNormalDto(WishListNormal wish) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return mapper.map(wish, WishListNormalDto.class);
	}
	
	public WishListNormal toWishList(WishListNormalDto wish) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return mapper.map(wish,WishListNormal.class);
	}
	
	public List<WishListNormalDto> toUserDtos(List<WishListNormal> wish){
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return Arrays.asList(mapper.map(wish, WishListNormalDto[].class));
	}
}
