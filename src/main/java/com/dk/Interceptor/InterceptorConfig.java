package com.dk.Interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/*
* 需要实现WebMvcConfigurer接口
* 1.5 实现拦截器的方式和2.0不一样
* 2.0有两种方式：第一种继承extends WebMvcConfigurationSupport 类，但是有一个问题；
*   如果使用继承此类的方式，我们的静态资源就必须手动放过
*   我们的自定义的转换器比如日期转换器等，也不能使用了，其实是因为使用继承此类之后，
*   springboot就不会接管MVC的自动配置了，就需要我们自己放过我们自己需要的方法了
* */
@Configuration
public class InterceptorConfig  implements WebMvcConfigurer {
    /*
    * 重写拦截器注册方法
    * */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加自己定义的拦截器
       /* registry.addInterceptor(new LoginInterceptor())
                //添加拦截的路径 /**代表拦截所有(多层拦截)  /* 代表只拦截一层
                .addPathPatterns("/**")
                //设置放过的请求
                .excludePathPatterns("/carController/list");*/
    }
}
