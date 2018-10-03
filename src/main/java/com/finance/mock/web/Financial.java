package com.finance.mock.web;

import com.finance.mock.config.UserBean;
import com.finance.mock.entity.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 快乐水 青柠可乐
 * @Description:
 * @Date: Created in 下午8:59 2018/9/22
 * @Modified By:
 * 注意事项，投资合同还没写
 */
@Api(tags = "前台--理财")
@RestController
@RequestMapping(value = "/user")
public class Financial {

    @Autowired
    UserBean userBean;

    @ApiOperation(value ="10：理财页面——点击——获得所有产品的列表" ,notes = "点击理财，弹出所有理财产品")
    @RequestMapping(value = "/products",method = RequestMethod.GET,produces =  "application/json;charset=UTF-8")
    public Result<List<Product>> getProducts(@RequestParam(value = "id",required = false) Integer id) {
        Product product1;
        Product product2 = userBean.getProduct2();
        List<Product> products = new ArrayList<>();
        products.add(product2);
        if (id == null) {
            product1 = userBean.getProduct1();
            products.add(product1);
            return new Result<>(true, products);
        } else {
            if (id == 1) {
                return new Result<>(true, products);
            } else {
                product1 = userBean.getProduct1();
                products.add(product1);
                return new Result<>(true, products);
            }
        }
    }
    /**
     *
     * @Description:
     * @auther: 快乐水 青柠可乐
     * @date: 下午5:51 2018/9/23
     * @param: [productId]
     * @return: com.finance.mock.entity.Result
     *
     */
    @ApiOperation(value ="11：理财页面——点击——获得所有产品的列表——点击单个产品——点击投资记录" ,notes = "某个产品的交易记录")
    @RequestMapping(value = "/products/records/{id}",method = RequestMethod.GET,produces =  "application/json;charset=UTF-8")
    public Result productsRecords
    (@PathVariable(value = "id") long id, @RequestParam(value = "productId") long productId){
        int i=1,j=2;
        if(productId==i||productId==j){
            if(productId==i){
                return new Result<>(true,userBean.getProduct1Compact());
            }else {
                return new Result<>(true,userBean.getProduct2Compact());
            }

        }
            return new  Result<>(true);
    }

    @ApiOperation(value ="12理财页面——点击——获得所有产品的列表——立即购买(获得用户信息——银行卡列表）" ,notes = "获得用户信息")
    @RequestMapping(value = "/products/investment/{id}",method = RequestMethod.GET,produces =  "application/json;charset=UTF-8")
    public Result<List<Bank>> productsInvestment(@PathVariable("id") long id){
        if (id==1){
            return new Result<>(true,userBean.getUser1Bank());
        }
        return new Result<>(true);

    }

    //
    @ApiOperation(value ="13:理财页面——点击——获得所有产品的列表——立即购买——确认购买" ,notes = "确认购买（提交金额和选择支付方式）校验金额")
    @RequestMapping(value = "/products/determination/{id}",method = RequestMethod.POST,produces =  "application/json;charset=UTF-8")
    public Result productsDetermination
    (@PathVariable("id") long userId, @RequestParam(value ="productId" ) long productId, @RequestParam(value ="moneyAmount" ) BigDecimal moneyAmount,@RequestParam(value = "paymentWay") String paymentWay){
        return new Result(true);
    }

    @ApiOperation(value = "14:理财页面——点击——获得某产品——确认购买——确认支付(获取验证码）)",notes = "确认支付，获取验证码")
    @RequestMapping(value = "/products/payment/msgcode/{id}",method = RequestMethod.GET)
    public Result productPaymentMsgcode(@PathVariable("id")long userId,@RequestParam(value = "phoneNumber",required = true) String phoneNumber){
        return new Result(true);

    }

    @ApiOperation(value = "14.1:理财页面——点击——获得某产品——确认购买——确认支付（校验验证码）)",notes = "确认支付，校验验证码")
    @RequestMapping(value = "/products/payment/{id}",method = RequestMethod.POST)
    public Result productPayment(@PathVariable("id")long id, @RequestParam(value ="phoneNumber") String phoneNumber, @RequestParam(value ="msgcode") String msgcode){
        return new Result(true);
    }

}
