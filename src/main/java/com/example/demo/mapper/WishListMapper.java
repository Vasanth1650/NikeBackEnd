package com.example.demo.mapper;

import java.util.Arrays;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import com.example.demo.dto.WishListDto;
import com.example.demo.model.WishList;



@Component
public class WishListMapper {

	
	public WishListDto toWishListDto(WishList wish) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return mapper.map(wish, WishListDto.class);
	}
	
	public WishList toWishList(WishListDto wish) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return mapper.map(wish,WishList.class);
	}
	
	public List<WishListDto> toUserDtos(List<WishList> wish){
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return Arrays.asList(mapper.map(wish, WishListDto[].class));
	}
}
