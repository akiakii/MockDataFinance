package com.finance.mock.web;

import com.finance.mock.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @author admin
 */
@Api(tags = "测试模块接口")
@RestController
@RequestMapping(value = "/test")
public class TestController {
    /**
      * @Description:
      * @auther: 快乐水 零度可乐
      * @date: 16:47 2018/9/20 
      * @param: [id]
      * @return: int
     */
    @ApiOperation(value="【PC端】提交订单", notes="提交一组识别的标签id，返回生成的订单详情")
    @RequestMapping(value = "/{id}", method = RequestMethod.POST, produces  = "application/json;charset=UTF-8")
    public int test(@PathVariable Integer id){
        System.out.println(id);
        return id;
    }

    /**
      *
      * @Description:
      * @auther: 快乐水 零度可乐
      * @date: 16:47 2018/9/20 
      * @param: [user]
      * @return: com.finance.mock.entity.User
     */
    @ApiOperation(value = "测试User",notes = "返回User类型Json")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @PostMapping(value = "/user")
    public User User(@RequestBody User user){
        return user;
    }
}
