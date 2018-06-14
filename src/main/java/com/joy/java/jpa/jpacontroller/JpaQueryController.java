package com.joy.java.jpa.jpacontroller;

import com.joy.java.jpa.jpaservice.JpaQueryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Project: myspringboot
 * @Package: com.joy.java.jpa.jpaController
 * @Author: Joy
 * @Date: 2018-05-04 11:55
 * @Description: TODO
 **/

/**
 * 五种查询方式涵盖了spring-data-jpa的大部分基础查询，
 * 可扩展性强，能满足大部分项目查询需求
 * byJoy
 */
@RestController
@Api(description = "JPA查询接口")
public class JpaQueryController {

//    @PersistenceContext(unitName = "sqlserverDataSourceUnit")
    @Autowired
    JpaQueryService jpaQueryService;

//    @ApiOperation(value = "登录验证", response = SessionBean.class, notes = "备注")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "userName", value = "用户名", paramType = "query", dataType = "String", required = true),
//            @ApiImplicitParam(name = "password", value = "密码", paramType = "query", dataType = "String", required = true)
//    })
//    @RequestMapping(value = "/loginMenu", method = RequestMethod.POST)

    /**
     * jpa原生查询
     *
     * @return
     */
    @RequestMapping(value ="/test0",method = RequestMethod.POST)
    public String test0() {
        return jpaQueryService.test0();
    }

    @RequestMapping(value ="/test22",method = RequestMethod.POST)
    public String test22() {
        return jpaQueryService.test0();
    }

    /**
     * 虚拟实体映射查询，使用jpa
     *
     * @return
     */
//    @ApiModelProperty
//    @ApiOperation(value = "123", notes = "12312312")
    @RequestMapping(value = "/test1",method = RequestMethod.POST)
    public String test1() {
        return jpaQueryService.test1();
    }

    /**
     * 使用jpa多条件单表查询
     *
     * @return
     */
//    @ApiModelProperty
//    @ApiOperation(value = "2121", notes = "12312312")
    @RequestMapping(value = "/test2",method = RequestMethod.POST)
    public String test2() {
        return jpaQueryService.test2();
    }

    /**
     * 使用jpa单表多条件分页查询
     *
     * @return
     */
//    @ApiModelProperty
//    @ApiOperation(value = "2121", notes = "12312312")
    @RequestMapping(value = "/test3",method = RequestMethod.POST)
    public String test3() {
        return jpaQueryService.test3();
    }

    /**
     * 使用jpa多表半映射查询
     *
     * @return
     */
//    @ApiModelProperty
//    @ApiOperation(value = "2121", notes = "12312312")
    @RequestMapping(value = "/test4",method = RequestMethod.POST)
    public String test4() {
        return jpaQueryService.test4();
    }
}
