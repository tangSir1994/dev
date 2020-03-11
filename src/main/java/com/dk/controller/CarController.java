package com.dk.controller;

import com.alibaba.fastjson.JSONObject;
import com.dk.pojo.Car;
import com.dk.pojo.CarType;
import com.dk.pojo.CarVo;
import com.dk.service.CarService;
import com.dk.service.CarTypeService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.github.pagehelper.PageInfo;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("carController")
public class CarController {
    //日志
    Logger logger = LoggerFactory.getLogger(CarController.class);

    @Resource
    private CarService carService;

    //分类表
    @Resource
    private CarTypeService carTypeService;

    //查询页面，并且查询类型表
    @RequestMapping("list")
    public String list(Model model){
        try {
            List<CarType> list = carTypeService.findList();
            model.addAttribute("list",list);
            logger.info("跳转list页面查询分类表,参数为" + JSONObject.toJSONString(list));
        }catch (Exception e){
            logger.error("跳转list页面查询分类表失败",e);
        }
        return "car/list";
    }
    //查询
    @RequestMapping("getCar")
    @ResponseBody
    public Map<String,Object> getCar(Car car, @RequestParam(required = false,defaultValue = "1") Integer pageNum, @RequestParam(required = false,defaultValue = "3")Integer pageSize){
        Map<String,Object> map = null;
        try {
            PageInfo<CarVo> page = carService.findList(car,pageNum,pageSize);
            map = new HashMap<>();
            map.put("total",page.getTotal());
            map.put("rows",page.getList());
            logger.info("查询汽车表成功,参数为" + JSONObject.toJSONString(page));
        }catch (Exception e){
            logger.error("查询汽车表失败",e);
        }
        return map;
    }
    //上下架
    @RequestMapping("getFrames")
    @ResponseBody
    public boolean getFrames(Integer carId,Integer isLower){
        try {
            carService.getFrames(carId,isLower);
            logger.info("修改上下架成功");
        }catch (Exception e){
            logger.error("修改上下架失败",e);
        }
        return true;
    }
    //增加页面
    @RequestMapping("toAdd")
    public String toAdd(Model model){
        try {
            List<CarType> list = carTypeService.findList();
            model.addAttribute("list",list);
            logger.info("跳转增加页面时查询分类表成功,参数为" + JSONObject.toJSONString(list));
        }catch (Exception e){
            logger.error("跳转增加页面时查询分类表失败",e);
        }
        return "car/add";
    }
    //增加
    @RequestMapping("addInfo")
    @ResponseBody
    public boolean addInfo(Car car){
        try {
            carService.addInfo(car);
            logger.info("增加成功");
        }catch (Exception e){
            logger.error("增加失败",e);
        }
        return true;
    }
    //修改页面
    @RequestMapping("toUpdate/{carId}")
    public String toUpdate(Model model, @PathVariable("carId") Integer carId){
        try {
            Car car = carService.selectById(carId);
            List<CarType> list = carTypeService.findList();

            model.addAttribute("list",list);
            model.addAttribute("car",car);
            logger.info("跳转修改页面时回显成功");
        }catch (Exception e){
            logger.error("跳转修改页面时回显失败",e);
        }
        return "car/update";
    }
    //修改
    @RequestMapping("updateInfo")
    @ResponseBody
    public boolean updateInfo(Car car){
        try {
            carService.updateInfo(car);
            logger.info("修改成功");
        }catch (Exception e){
            logger.error("修改失败",e);
        }
        return true;
    }
    //批量删除
    @RequestMapping("getDeleteAll")
    @ResponseBody
    public boolean getDeleteAll(@RequestParam("ids") Integer[] ids ){
        try {
            carService.deleteAll(ids);
            logger.info("批量删除成功");
        }catch (Exception e){
            logger.error("批量删除失败",e);
        }
        return true;
    }

}