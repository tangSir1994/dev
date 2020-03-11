package com.dk.mapper;

import com.dk.pojo.Car;
import com.dk.pojo.CarExample;
import com.dk.pojo.CarVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
//想要在service层调mapper有两种方式：1.在此类上加上@mapper 2.在启动类上加上@MapperScan("com.dk.mapper")扫描mapper所在的包
//@Mapper
public interface CarMapper {
    int countByExample(CarExample example);

    int deleteByExample(CarExample example);

    int deleteByPrimaryKey(Integer carId);

    int insert(Car record);

    int insertSelective(Car record);

    List<Car> selectByExample(CarExample example);

    Car selectByPrimaryKey(Integer carId);

    int updateByExampleSelective(@Param("record") Car record, @Param("example") CarExample example);

    int updateByExample(@Param("record") Car record, @Param("example") CarExample example);

    int updateByPrimaryKeySelective(Car record);

    int updateByPrimaryKey(Car record);

    List<CarVo> findList(Car car);
    //上下架
    void getFrames(@Param("carId")Integer carId, @Param("isLower")Integer isLower);
    //批量删除
    void deleteAll(@Param("ids")Integer[] ids);
}