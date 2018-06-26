package com.joy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package: com.joy
 * @Class: Swagger2Configure
 * @Author: Joy
 * @date: 2018/6/11 12:39
 * @Description: TODO
 * @Param: param
 * @ReturnType: 
 * @Exception   
 **/
@Configuration
@EnableSwagger2
public class Swagger2Configure {
    @Bean
    public Docket createRestApi() {

        ParameterBuilder tokenPar = new ParameterBuilder();
        //设置请求头部信息
        List<Parameter> pars = new ArrayList<Parameter>();//bf1201e1-ae78-461c-b827-3a7934135d0b
//        tokenPar.name("tokenid").description("令牌").modelRef(new ModelRef("string")).defaultValue("123456")
//                .parameterType("header").required(true).build();
//        pars.add(tokenPar.build());
        return new Docket(DocumentationType.SWAGGER_2)
                .globalOperationParameters(pars)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.joy"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Joy's springboot")
                .description("Joy springboot框架")
                .contact("fengqj")
                .version("1.0")
                .build();
    }

}
