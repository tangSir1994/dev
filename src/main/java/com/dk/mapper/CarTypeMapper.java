package com.dk.mapper;

import com.dk.pojo.CarType;
import com.dk.pojo.CarTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CarTypeMapper {
    int countByExample(CarTypeExample example);

    int deleteByExample(CarTypeExample example);

    int deleteByPrimaryKey(Integer tid);

    int insert(CarType record);

    int insertSelective(CarType record);

    List<CarType> selectByExample(CarTypeExample example);

    CarType selectByPrimaryKey(Integer tid);

    int updateByExampleSelective(@Param("record") CarType record, @Param("example") CarTypeExample example);

    int updateByExample(@Param("record") CarType record, @Param("example") CarTypeExample example);

    int updateByPrimaryKeySelective(CarType record);

    int updateByPrimaryKey(CarType record);
}