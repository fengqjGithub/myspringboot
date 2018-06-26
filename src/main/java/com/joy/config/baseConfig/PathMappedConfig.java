package com.joy.config.baseConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.io.File;

/**
 * @Project: sfrzapi
 * @Package: com.hnzr.config
 * @Author: Joy
 * @Date: 2018-02-02 17:16
 * @Description: TODO
 **/
@Configuration
public class PathMappedConfig extends WebMvcConfigurerAdapter {
    /**
     * 本地磁盘映射，静态资源
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String path="E:/atest/";
        if(!new File(path).exists()){
            new File(path).mkdirs();
        }
        path="file:E:/atest/";
//        CreateFolderUtill.makedirByPath(path.replaceAll("file:","")+"DBF/");
        registry.addResourceHandler("/resource/**").addResourceLocations(path);
        super.addResourceHandlers(registry);
    }
}
