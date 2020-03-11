package com.dk.service;

import com.dk.pojo.Car;
import com.dk.pojo.CarVo;
import com.github.pagehelper.PageInfo;

public interface CarService {
    PageInfo<CarVo> findList(Car car, Integer pageNum, Integer pageSize);

    void getFrames(Integer carId, Integer isLower);

    void addInfo(Car car);

    Car selectById(Integer carId);

    void updateInfo(Car car);

    void deleteAll(Integer[] ids);
}
