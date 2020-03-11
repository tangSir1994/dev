package com.dk.service.impl;

import com.dk.mapper.CarTypeMapper;
import com.dk.pojo.CarType;
import com.dk.pojo.CarTypeExample;
import com.dk.service.CarTypeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CarTypeServiceImpl implements CarTypeService {

    @Resource
    private CarTypeMapper carTypeMapper;

    @Override
    @Transactional(readOnly = true,rollbackFor = Exception.class,propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
    public List<CarType> findList() {
        return carTypeMapper.selectByExample(new CarTypeExample());
    }
}
