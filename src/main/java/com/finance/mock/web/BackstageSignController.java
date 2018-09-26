package com.finance.mock.web;

import com.finance.mock.entity.Module;
import com.finance.mock.entity.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 快乐水 樱桃可乐
 * @Description:
 * @Date: Created in 8:38 2018/9/22
 * @Modified By:
 */
@Api(tags = "后台登录注销控制器")
@RestController
@RequestMapping(value = "/manager",produces  = "application/json;charset=UTF-8")
public class BackstageSignController {

    /**
     *
     * @Description: 后台登陆接口
     * @auther: 快乐水 樱桃可乐
     * @date: 19:32 2018/9/25
     * @param: [account, password, response]
     * @return: com.finance.mock.entity.Result
     *
     */
    @ApiOperation(value = "后台登陆",notes = "从响应头中返回JWT")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "account",value = "账号",dataType = "String",required = true),
            @ApiImplicitParam(name = "password",value = "密码",dataType = "String",required = true)
    })
    @PostMapping(value ="/login")
    public Result postLogin(@RequestParam String account, @RequestParam String password,
                            HttpServletResponse response) {
        response.setHeader("JWT","Test-JWT");
        return new Result(true,"登录成功");
    }

    /**
     *
     * @Description:    后台注销
     * @auther: 快乐水 樱桃可乐
     * @date: 19:33 2018/9/25
     * @param: [managerId]
     * @return: com.finance.mock.entity.Result
     *
     */
    @ApiOperation(value = "后台注销",notes = "注销当前用户的登录状态")
    @ApiImplicitParam(name = "managerId",value = "后台用户ID",dataType = "long",required = true,paramType = "path")
    @GetMapping(value = "/logout/{id}")
    public Result getLogout(@PathVariable long id){
        return new Result(true,"注销成功");
    }

    @ApiOperation(value = "后台获取模块列表",notes = "获取模块列表")
    @ApiImplicitParam(name = "id",value = "当前用户",dataType = "long",required = true,paramType = "path")
    @GetMapping(value = "/modules/{id}")
    public Result getModules(@PathVariable long id){

        Module module1=new Module();
        module1.setId(1);
        module1.setModuleUrl("/login");
        module1.setModuleType("父");
        module1.setModuleName("登录注销");
        module1.setFatherModuleId(0);

        Module module2=new Module();
        module2.setId(2);
        module2.setModuleUrl("");
        module2.setModuleType("父");
        module2.setModuleName("业务管理");
        module2.setFatherModuleId(0);

        Module module3=new Module();
        module3.setId(3);
        module3.setModuleUrl("");
        module3.setModuleType("父");
        module3.setModuleName("运营管理");
        module3.setFatherModuleId(0);

        Module module4=new Module();
        module4.setId(4);
        module4.setModuleUrl("");
        module4.setModuleType("父");
        module4.setModuleName("后台管理");
        module4.setFatherModuleId(0);

        Module module5=new Module();
        module5.setId(5);
        module5.setModuleUrl("/business/user");
        module5.setModuleType("子");
        module5.setModuleName("用户管理");
        module5.setFatherModuleId(2);


        Module module6=new Module();
        module6.setId(6);
        module6.setModuleUrl("/business/debt");
        module6.setModuleType("子");
        module6.setModuleName("债务管理");
        module6.setFatherModuleId(2);

        Module module7=new Module();
        module7.setId(7);
        module7.setModuleUrl("/business/product");
        module7.setModuleType("子");
        module7.setModuleName("产品管理");
        module7.setFatherModuleId(2);

        Module module8=new Module();
        module8.setId(8);
        module8.setModuleUrl("/Operation/Banner");
        module8.setModuleType("子");
        module8.setModuleName("Banner图");
        module8.setFatherModuleId(3);

        Module module9=new Module();
        module9.setId(9);
        module9.setModuleUrl("/Operation/recommend");
        module9.setModuleType("子");
        module9.setModuleName("鼎力推荐");
        module9.setFatherModuleId(3);

        Module module10=new Module();
        module10.setId(10);
        module10.setModuleUrl("/Operation/news");
        module10.setModuleType("子");
        module10.setModuleName("消息管理");
        module10.setFatherModuleId(3);

        Module module11=new Module();
        module11.setId(11);
        module11.setModuleUrl("/Operation/opinion");
        module11.setModuleType("子");
        module11.setModuleName("意见回复");
        module11.setFatherModuleId(3);

        Module module12=new Module();
        module12.setId(12);
        module12.setModuleUrl("/Backstage/password");
        module12.setModuleType("子");
        module12.setModuleName("密码管理");
        module12.setFatherModuleId(4);

        Module module13=new Module();
        module13.setId(13);
        module13.setModuleUrl("/Backstage/Account");
        module13.setModuleType("子");
        module13.setModuleName("账户管理");
        module13.setFatherModuleId(4);

        Module module14=new Module();
        module14.setId(14);
        module14.setModuleUrl("/Backstage/Module");
        module14.setModuleType("子");
        module14.setModuleName("模块管理");
        module14.setFatherModuleId(4);

        Module module15=new Module();
        module15.setId(15);
        module15.setModuleUrl("/Backstage/role");
        module15.setModuleType("子");
        module15.setModuleName("角色管理");
        module15.setFatherModuleId(4);

        List<Module> list1=new ArrayList<>();
        list1.add(module5);
        list1.add(module6);
        list1.add(module7);
        module2.setModules(list1);

        List<Module> list2=new ArrayList<>();
        list2.add(module8);
        list2.add(module9);
        list2.add(module10);
        list2.add(module11);
        module3.setModules(list2);

        List<Module> list3=new ArrayList<>();
        list3.add(module12);
        list3.add(module13);
        list3.add(module14);
        list3.add(module15);
        module4.setModules(list3);

        List<Module> list=new ArrayList<>();
        list.add(module1);
        list.add(module2);
        list.add(module3);
        list.add(module4);

        return new Result<List<Module>>(true,list);
    }

}


