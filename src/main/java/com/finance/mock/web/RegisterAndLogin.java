package com.finance.mock.web;

import com.finance.mock.config.UserBean;
import com.finance.mock.entity.Result;
import com.finance.mock.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: 快乐水 青柠可乐
 * @Description:
 * @Date: Created in 下午3:34 2018/9/22
 * @Modified By:
 */
@Api(tags = "前台--注册和登录")
@RestController
@RequestMapping(value = "/user")
public class RegisterAndLogin {
    @Autowired
    UserBean userBean;


    @ApiOperation(value ="1:注册页面——点击获取验证码" ,notes = "获取验证码")
    @RequestMapping(value = "/register/msgcode",method = RequestMethod.GET,produces =  "application/json;charset=UTF-8")
    public Result registerGetMsgcode(@RequestParam(value = "phoneNumber",required = true) String phoneNumber){
        return new Result(true);
    }

    @ApiOperation(value ="2:注册页面——验证验证码——下一步" ,notes = "下一步(校验验证码)")
    @RequestMapping(value = "/register/msgcode",method = RequestMethod.POST,produces =  "application/json;charset=UTF-8")
    public Result registerPostNext(@RequestParam(value ="msgCode")String msgCode,@RequestParam(value = "phoneNumber")String phoneNumber,@RequestParam(value = "picCode",required = false)String picCode ){
        return new Result(true);
    }

    @ApiOperation(value ="3：注册页面——验证验证码——下一步——注册" ,notes = "注册")
    @RequestMapping(value = "/register/password",method = RequestMethod.POST,produces =  "application/json;charset=UTF-8")
    public Result registerPostPassword(@RequestParam(value = "firstPassword",required = true) String firstPassword, @RequestParam(value = "secondPassword",required = true) String secondPassword){
        return new Result(true);
    }

    @ApiOperation(value ="4：登录页面——登录" ,notes = "登录")
    @RequestMapping(value = "login/account",method = RequestMethod.POST,produces =  "application/json;charset=UTF-8")
    public Result<User> loginAccount(@RequestParam(value = "phoneNumber",required = true) String phoneNumber, @RequestParam(value = "password",required = true) String password){
        User user1=userBean.getUser1();
        User user2=userBean.getUser2();
        if(phoneNumber.equals(user1.getPhoneNumber())){
            return new Result<>(true,user1);
        }else {
            if (phoneNumber.equals(user2.getPhoneNumber())){
                return new Result<>(true,user2);
            }else {
                return new Result<>((true));
            }
        }

    }

    @ApiOperation(value ="5：忘记密码——找回密码——获取验证码" ,notes = "获取验证码")
    @RequestMapping(value = "reset/msgcode",method = RequestMethod.GET,produces =  "application/json;charset=UTF-8")
    public Result resetGetMsgcode(@RequestParam(value = "phoneNumber",required = true) String phoneNumber){
        return new Result(true);
    }


    @ApiOperation(value ="6：忘记密码——找回密码——获取验证码——下一步（校验验证码）" ,notes = "下一步，校验验证码")
    @RequestMapping(value = "reset/msgcode",method = RequestMethod.POST,produces =  "application/json;charset=UTF-8")
    public Result resetPostMsgcode(@RequestParam(value = "phoneNumber" ,required = true) String phoneNumber){
        return new Result(true);
    }

    @ApiOperation(value ="7：忘记密码——找回密码——获取验证码——下一步——确认（提交新密码）" ,notes = "确认新的密码，并且提交")
    @RequestMapping(value = "reset/password",method = RequestMethod.POST,produces =  "application/json;charset=UTF-8")
    public Result resetPostPassword(@RequestParam(value ="phoneNumber") String phoneNumber, @RequestParam(value = "firstPassword") String firstPassword, @RequestParam(value ="secondPassword") String secondPassword){
        return new Result(true);
    }


}
