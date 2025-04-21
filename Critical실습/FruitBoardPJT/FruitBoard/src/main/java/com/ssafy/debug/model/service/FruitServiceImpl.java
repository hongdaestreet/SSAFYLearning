package com.ssafy.debug.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.debug.model.dao.FruitDao;
import com.ssafy.debug.model.dto.FruitDto;

@Service
public class FruitServiceImpl implements FruitService {
	
    private FruitDao fruitDao;
    
    public FruitServiceImpl(FruitDao fruitDao) {
		this.fruitDao = fruitDao;
	}

	@Override
    public int registFruit(FruitDto fruitDto) {
        return fruitDao.insertFruit(fruitDto);
    }

    @Override
    public List<FruitDto> getFruitList() {
        return fruitDao.selectFruitList();
    }

    @Override
    public FruitDto getFruitDetail(int fruitId) {
        return fruitDao.selectFruitDetail(fruitId);
    }

    @Override
    public int deleteFruit(int fruitId) {
        return fruitDao.deleteFruit(fruitId);
    }

    @Override
    public int updateFruit(FruitDto fruitDto) {
        return fruitDao.updateFruit(fruitDto);
    }
}
