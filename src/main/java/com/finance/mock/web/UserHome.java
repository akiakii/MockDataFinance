package com.finance.mock.web;

import com.finance.mock.config.UserBean;
import com.finance.mock.entity.Banner;
import com.finance.mock.entity.Product;
import com.finance.mock.entity.Result;
import com.finance.mock.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 快乐水 青柠可乐
 * @Description:
 * @Date: Created in 下午5:35 2018/9/22
 * @Modified By:
 */
@Api(tags = "前台-首页")
@RestController
@RequestMapping(value = "/user")
public class UserHome {

    @Autowired
    UserBean userBean;

    @ApiOperation(value ="8：首页-点击首页-调用第一个接口——banner图" ,notes = "首页第一个接口：获取banner图")
    @RequestMapping(value = "/home/banner/{id}",method = RequestMethod.GET,produces =  "application/json;charset=UTF-8")
    public Result<List<Banner>> homeGetBanner(@PathVariable("id") long id){
       Banner banner1=userBean.getBanner1();
       Banner banner2=userBean.getBanner2();
       List<Banner> banners=new ArrayList<>();
       banners.add(banner1);
       banners.add(banner2);
       return new Result<>(true,banners);
    }

    @ApiOperation(value ="9：首页-点击首页-调用第二个接口——鼎力推荐" ,notes = "首页第二个接口：鼎力推荐")
    @RequestMapping(value = "/home/recommandation/{id}",method = RequestMethod.GET,produces =  "application/json;charset=UTF-8")
    public Result<Product> homeGetRecommandation(@PathVariable("id") long id){
        User user;
        int i=1;
        int j=2;
        Product noobProduct=userBean.getProduct1();
        Product recommendation=userBean.getProduct2();
        if (id==i||id==j){
            if (id==1){
                user=userBean.getUser1();
            }else {
                user=userBean.getUser2();
            }
            if (user.isNoob()){
                return new Result<>(true,noobProduct);
            }
            return new Result<>(true,recommendation);

        }else {
            return new Result<>(true,noobProduct);
        }
    }
}
