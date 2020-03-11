package com.dk.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.dk.mapper.CarMapper;
import com.dk.pojo.Car;
import com.dk.pojo.CarVo;
import com.dk.service.CarService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class CarServiceImpl implements CarService {

    @Resource
    private CarMapper carMapper;

    @Resource
    private RedisTemplate redisTemplate;

    //查询
    @Override
    @Transactional(readOnly = true,rollbackFor = Exception.class,propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
    public PageInfo<CarVo> findList(Car car, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<CarVo> list = carMapper.findList(car);
        PageInfo<CarVo> page = new PageInfo<>(list);
        return page;
    }
    //上下架
    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
    public void getFrames(Integer carId, Integer isLower) {
        carMapper.getFrames(carId,isLower);
    }
    //增加
    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
    public void addInfo(Car car) {
        carMapper.insertSelective(car);
    }
    //修改回显的时候，放在缓存中
    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
    public Car selectById(Integer carId) {
        Car car = null;
            car = carMapper.selectByPrimaryKey(carId);
        return car;
    }
    //修改
    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
    public void updateInfo(Car car) {
        carMapper.updateByPrimaryKeySelective(car);
    }
    //批量删除
    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
    public void deleteAll(Integer[] ids) {
        carMapper.deleteAll(ids);
    }
}
