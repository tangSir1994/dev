package com.dk.convertor;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * <pre>项目名称：springmvc-hibernate    
 * 类名称：DateConvertor    
 * 类描述：    自定义 ： 日期转换器
 * 创建人：彭斌  
 * 创建时间：2019年5月23日 上午11:19:03    
 * 修改人：彭斌     
 * 修改时间：2019年5月23日 上午11:19:03    
 * 修改备注：       
 * Converter : 两个参数 ： 第一个 ：  当前类型  第二个 ： 目标类型，将要转换成的类型 
 * @version </pre>
 */
public class DateConvertor implements Converter<String, Date> {

	//转换器。
	@Override
	public Date convert(String arg0) {
		SimpleDateFormat sdf10  =  new  SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf16  =  new  SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date date = null;
		try {
			if(arg0!=null && !"".equals(arg0)){
				if(arg0.length()==10){
					date = sdf10.parse(arg0);	
				}else if(arg0.length()==16){
					date = sdf16.parse(arg0);	
				}
				
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

}
