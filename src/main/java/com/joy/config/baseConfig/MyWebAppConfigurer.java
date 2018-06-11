package com.joy.config.baseConfig;

import com.joy.config.interceptor.MyInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyWebAppConfigurer   extends WebMvcConfigurerAdapter {

    @Bean
    public MyInterceptor myinterceptor() {
        return new MyInterceptor();
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myinterceptor())
                .excludePathPatterns ("/swagger-ui.html")
                .excludePathPatterns ("*.css")
                .excludePathPatterns ("*.js")
                .excludePathPatterns ("/swagger-resources")
                .excludePathPatterns ("/v2/api-docs")
                .excludePathPatterns ("/configuration/security")
                .excludePathPatterns ("/configuration/ui")
                .excludePathPatterns("/aries-web/Hessian/AriesBpsClientService")
                .excludePathPatterns("/resource")
                .excludePathPatterns ("/login/loginMenu");
        super.addInterceptors(registry);
    }

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/excelDownload/**").addResourceLocations(sysConstant.getMappedPath());
//        super.addResourceHandlers(registry);
//    }

}