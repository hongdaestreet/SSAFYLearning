package com.ssafy.debug.model.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ssafy.debug.model.dto.FruitDto;

@Component
public interface FruitDao {
	int insertFruit(FruitDto fruitDto);
	List<FruitDto> selectFruitList();
	FruitDto selectFruitDetail(int fruitId);
	int deleteFruit(int fruitId);
	int updateFruit(FruitDto fruitDto);
}
