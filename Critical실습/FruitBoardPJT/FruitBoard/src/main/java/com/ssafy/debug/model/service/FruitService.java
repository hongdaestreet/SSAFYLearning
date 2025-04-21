package com.ssafy.debug.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.debug.model.dto.FruitDto;

@Service
public interface FruitService {
	int registFruit(FruitDto fruitDto);  // 성공/실패를 반환하기 위해서 int 사용
	List<FruitDto> getFruitList();
	FruitDto getFruitDetail(int fruitId);
	int deleteFruit(int fruitId);
	int updateFruit(FruitDto fruitDto);
}
