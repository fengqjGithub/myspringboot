package com.joy;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * @Project: myspringboot
 * @Package: com.joy
 * @Author: 冯前进
 * @Date: 2018-05-04 15:24
 * @Description: TODO
 **/
public class TomcatRun extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MyspringbootApplication.class);
    }
}
