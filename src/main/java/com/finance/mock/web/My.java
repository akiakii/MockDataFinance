package com.finance.mock.web;

import com.finance.mock.config.UserBean;
import com.finance.mock.entity.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: 快乐水 青柠可乐
 * @Description:
 * @Date: Created in 下午6:13 2018/9/23
 * @Modified By:
 */
@Api(tags = "前台--我的")
@RestController
@RequestMapping(value = "/user/my")
public class My {


    @Autowired
    UserBean userBean;

    @ApiOperation(value ="15：我的——点击——获得我的基本信息一第一个接口，基本信息" ,notes = "基本信息")
    @RequestMapping(value = "/info/{id}",method = RequestMethod.GET,produces =  "application/json;charset=UTF-8")
    public Result<User> myInfo(@PathVariable("id")long uerId){
        User user;
        if(uerId==1){
            user=userBean.getUser1();
        }else {
            user=userBean.getUser2();
        }
        return new Result<>(true,user);
    }

    @ApiOperation(value ="15.1我的——点击——获得我的基本信息一第二个接口，未读消息" ,notes = "未读消息")
    @RequestMapping(value = "/info/msg/{id}",method = RequestMethod.GET,produces =  "application/json;charset=UTF-8")
    public Result<Integer> getProducts(@PathVariable("id")long userId){
        List<Message> list;
        int j=0;
        if(userId==1){
            list=userBean.getUser1Message();
        }else {
            list=userBean.getUser2Messages();
        }
        for(int i=0;i<list.size();i++){
            Message message= list.get(i);
            if(!message.isRead()){
                j++;
            }
        }
        return new  Result<>(true,j);
    }

    @ApiOperation(value ="16:我的——个人信息--实名认证" ,notes = "实名认证")
    @RequestMapping(value = "/info/identification/{id}",method = RequestMethod.POST,produces =  "application/json;charset=UTF-8")
    public Result identification(String realName, @PathVariable("id")long id, @RequestParam(value ="idCard" ,required = true) long idCard, @RequestParam(value = "card",required = true) String card){
        return new Result(true);

    }

    @ApiOperation(value ="17:我的——个人信息——实名认证--卡号绑定（完成认证并绑定）" ,notes = "卡号绑定")
    @RequestMapping(value = "/info/identification/card/{id}",method = RequestMethod.POST,produces =  "application/json;charset=UTF-8")
    public Result identificationCard(@RequestParam(value ="cardType" ,required = true) String cardType,@RequestParam(value ="phoneNumber" ,required = true) String phoneNumber,@PathVariable("id")long id){
        return new Result(true);
    }

    @ApiOperation(value ="18：我的——个人信息——获取验证码" ,notes = "获取验证码")
    @RequestMapping(value = "/info/identification/card/msgcode/{id}",method = RequestMethod.GET,produces =  "application/json;charset=UTF-8")
    public Result cardMsgcode(@PathVariable("id")long id,@RequestParam(value = "phoneNumber" ,required = true) String phoneNumber){
        return new Result(true);
    }

    @ApiOperation(value ="19：我的——个人信息——获取验证码——下一步（验证验证码）" ,notes = "验证验证码")
    @RequestMapping(value = "/info/identification/card/verification/{id}",method = RequestMethod.POST,produces =  "application/json;charset=UTF-8")
    public Result cardVertification(@PathVariable("id")long id,@RequestParam(value = "phoneNumber",required = true) String phoneNumber,@RequestParam(value ="msgCode" ,required = true) String msgCode){
        return new Result(true);
    }

    @ApiOperation(value = "20我的——个人信息--更换手机——点击更换手机",notes = "显示用户的手机")
    @RequestMapping(value = "/info/phone/{id}",method = RequestMethod.GET,produces =  "application/json;charset=UTF-8")
    private Result<User> phoneChange (@PathVariable("id") long id){
        User user;
        if(id==1){
            user=userBean.getUser1();
        }else {
            user=userBean.getUser2();
        }

        return new Result<>(true,user);
    }

    @ApiOperation(value = "21我的——个人信息--更换手机——获取验证码",notes = "获取验证码")
    @RequestMapping(value = "/info/phone/msgcode/{id}",method = RequestMethod.GET)
    private Result phoneMsgcode (@PathVariable("id") long id){
        return new Result(true);
    }

    @ApiOperation(value = "22我的——个人信息--更换手机——获取验证码——下一步",notes = "验证验证码")
    @RequestMapping(value = "/info/phone/msgcode/verification/{id}",method = RequestMethod.POST)
    private Result phoneVerification(@PathVariable("id") long id){
        return new Result(true);

    }

    @ApiOperation(value = "22.1我的——个人信息--更换手机——获取验证码——下一步——绑定新手机——获取验证码",notes = "获取新手机验证码")
    @RequestMapping(value = "/info/phone/new/msgcode/{id}",method = RequestMethod.GET)
    private Result phoneNewMsgcode(@PathVariable("id") long id,@RequestParam(value = "newPhoneNumber",required = true) String newPhoneNumber){
        return new Result(true);

    }

    @ApiOperation(value = "23我的——个人信息--更换手机——获取验证码——下一步——绑定新手机——(下一步)校验验证码",notes = "校验验证码")
    @RequestMapping(value = "/info/phone/new/msgcode/verification/{id}",method =RequestMethod.POST)
    private Result phoneNewVerification(@PathVariable("id") long id ,@RequestParam(value = "msgCode",required = true) String msgCode){
        return new Result(true);
    }


    @ApiOperation(value = "24我的———设置——--修改密码",notes = "修改密码")
    @RequestMapping(value = "/setting/password/{id}",method =RequestMethod.POST)
    private Result passwordSetting(@PathVariable("id") long id,@RequestParam(value ="oldPassword" ,required = true) String oldPassword,@RequestParam(value ="newPassword" ,required = true) String newPassword,@RequestParam(value = "comfirmPassword",required = true) String comfirmPassword){
        return new Result(true,"修改密码成功");
    }

    @ApiOperation(value = "25我的———设置——--退出登录 ",notes = "退出登录")
    @RequestMapping(value = "/setting/logout/{id}",method =RequestMethod.GET)
    private Result logout(@PathVariable("id") long id){
        return new Result(true,"退出登录成功");
    }




    @ApiOperation(value = "补-我的———消息中心——点击消息中心 ",notes = "获得消息中心的List")
    @RequestMapping(value = "/messages/{id}",method =RequestMethod.GET)
    private Result<List<Message>> messages(@PathVariable("id")long id){
        List<Message> messages;
        if (id==1||id==2){
            if(id==1){
                messages=userBean.getUser1Message();
            }else {
                messages=userBean.getUser2Messages();
            }
        }else {
            messages=null;
        }
        return new Result<>(true,messages);
    }




    @ApiOperation(value = "26我的———我的理财——-点击获得全部的交易记录的理财产品 ",notes = "获得交易记录的理财产品")
    @RequestMapping(value = "/investment/{id}",method =RequestMethod.GET)
    private Result<List<DealAndProduct>> myInvestment(@PathVariable("id") long id){
        List<DealAndProduct> dps;
        if(id==1){
            dps=userBean.getUser1Deals();
            return new Result<>(true,dps);
        }
        return new Result<List<DealAndProduct>>(true);

    }

    @ApiOperation(value = "27我的———我的理财——-预约续投",notes = "预约续投")
    @RequestMapping(value = "/investment/book/{id},compactingId={compactingId}",method =RequestMethod.GET)
    private Result investmentBook( @PathVariable("id") long id, @RequestParam(value = "compactingId",required = true) long compactingId){
        return new Result(true,"预约续投成功");
    }


    @ApiOperation(value = "28我的———我的理财——-取消续投",notes = "取消续投")
    @RequestMapping(value = "/investment/debook/{id},compactingId={compactingId}",method =RequestMethod.GET)
    private Result investmentDebook(@PathVariable("id") long id, @RequestParam(value ="compactingId" ,required = true) long compactingId){
        return new Result(true,"取消续投成功");
    }

    //
    @ApiOperation(value = "29我的———交易记录 ",notes = "点击获得我的交易记录")
    @RequestMapping(value = "/transaction/record/{id}",method =RequestMethod.GET)
    private Result<List<DealAndProduct>> transactionRecord(@PathVariable("id") long id){
        List<DealAndProduct> dps;
        if(id==1){
            dps=userBean.getUser1Deals();
        }else {
            dps=null;
        }
        return new Result<>(true,dps);
    }

    //
    @ApiOperation(value = "30我的———银行卡——-点击获得我的银行卡列表 ",notes = "点击获得我的银行卡列表")
    @RequestMapping(value = "/bank/{id}",method =RequestMethod.GET)
    private Result<List<Bank>> myBank(@PathVariable("id") long id){
        List<Bank> banks;
        if(id==1){
            banks=userBean.getUser1Bank();
        }else {
            banks=null;
        }
        return new Result<>(true,banks);
    }



    @ApiOperation(value = "31我的———银行卡——-点击+，添加银行卡 ",notes = "添加银行卡，获取用户基本信息")
    @RequestMapping(value = "/bank/info/{id}",method =RequestMethod.GET)
    private Result<User> bankMyInfo(@PathVariable("id") long userId){
        User user;
        if(userId==1){
            user=userBean.getUser1();
        }else {
            user=userBean.getUser2();
        }
        return new Result<>(true,user);
    }

    //
    @ApiOperation(value = "32我的———银行卡——-添加银行卡——下一步(提交卡号) ",notes = "提交添加的银行卡的卡号")
    @RequestMapping(value = "/bank/card/{id}",method =RequestMethod.POST)
    private Result bankCard(@PathVariable("id")long id, @RequestParam(value = "card",required = true)  String card){
        return new Result(true);
    }

    //这里不需要
//    @ApiOperation(value = "33我的———银行卡——-解除绑定——确认解除绑定",notes = "解除绑定")
//    @RequestMapping(value = "/bank/card",method =RequestMethod.GET)
//    private Result bankCardCancel(String card){
//        return new Result(true);
//    }

    //
    @ApiOperation(value = "35我的———银行卡——-解除绑定——确认解除绑定——获取验证码",notes = "获取验证码")
    @RequestMapping(value = "/bank/card/msgcode/{id}",method =RequestMethod.GET)
    private Result bankMsgcode(@PathVariable("id") long id,@RequestParam(value = "phoneNumber",required = true) String phoneNumber){
        return new Result(true);
    }


    @ApiOperation(value = "36我的———银行卡——-解除绑定——确认解除绑定——获取验证码——校验",notes = "校验验证码")
    @RequestMapping(value = "/bank/card/msgcode/{id}",method =RequestMethod.DELETE)
    private Result bankMsgcodeVertify( @PathVariable("id") long id,@RequestParam(value = "msgCode",required = true) String msgCode,@RequestParam(value = "card",required = true) String card){
        return new Result(true);
    }


    @ApiOperation(value = "37我的———意见反馈——提交",notes = "提交意见")
    @RequestMapping(value = "/idea/{id}",method =RequestMethod.POST)
    private Result myIdea(@PathVariable("id") long id,@RequestParam(value = "content",required = true) String content){
        return new Result(true);
    }

}
