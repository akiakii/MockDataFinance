package com.finance.mock.web;

import com.finance.mock.entity.Result;
import com.finance.mock.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: huangdongjiang
 * @Description: 快乐水 原味可乐
 * @Date: Created in 2018/9/22 9:26
 * @Modified By:
 */
@Api(tags = "后台业务管理模块")
@RestController
@RequestMapping("/manager/business")
public class BusinessController {
	/**
	 *
	 * @Description:
	 * @auther: 快乐水 原味可乐
	 * @date: 10:21 2018/9/22
	 * @param: [pageNumber]
	 * @return: com.finance.mock.entity.Result
	 *
	 */
	@ApiOperation(value = "点击用户管理页面", notes = "点击用户管理页面，查询出所有用户信息")
	@RequestMapping(value = "/user", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public Result userManage(int pageNumber) {
		User user = new User();
		user.setId(1);
		user.setSerialId("JJR0000001");
		user.setPhoneNumber("13800138000");
		user.setRealName("王尼玛");
		user.setIdCard("440923201809120293");
		user.setBalance(new BigDecimal(20000.00));
        user.setProfit(new BigDecimal(24.93));
        user.setCreatedAt(1537582046000L);
        user.setLock(true);

		User user2 = new User();
		user2.setId(1);
		user2.setSerialId("JJR0000002");
		user2.setPhoneNumber("13800138001");
		user2.setRealName("王尼玛1");
		user2.setIdCard("440923201809120292");
		user2.setBalance(new BigDecimal(0.00));
		user2.setProfit(new BigDecimal(24.00));
		user2.setCreatedAt(1537582046000L);
		user2.setLock(false);
		List<User> userList = new ArrayList<>();
		userList.add(user);
		userList.add(user2);
		return new Result(true,userList);
	}

	/**
	 *
	 * @Description:
	 * @auther: 快乐水 原味可乐
	 * @date: 12:06 2018/9/22
	 * @param: [userId, realName, phoneNumber, status, pageNumber]
	 * @return: com.finance.mock.entity.Result
	 *
	 */
	@ApiOperation(value = "查询", notes = "根据用户输入查询关键字模糊搜索用户")
	@RequestMapping(value = "/user/search", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public Result searchUser(long userId, String realName, String phoneNumber,
							 boolean status, int pageNumber) {
		User user2 = new User();
		user2.setId(userId);
		user2.setSerialId("JJR0000002");
		user2.setPhoneNumber("13800138001");
		user2.setRealName("王尼玛1");
		user2.setIdCard("440923201809120292");
		user2.setBalance(new BigDecimal(0.00));
		user2.setProfit(new BigDecimal(24.00));
		user2.setCreatedAt(1537582046000L);
		List<User> userList = new ArrayList<>();
		userList.add(user2);
		return new Result(true,userList);
	}
	/**
	 *
	 * @Description: 冻结/解冻用户
	 * @auther: 快乐水 原味可乐
	 * @date: 15:05 2018/9/22
	 * @param: [isLock]
	 * @return: com.finance.mock.entity.Result
	 *
	 */
	@ApiOperation(value = "冻结/解冻", notes = "前端传回一个当前用户的状态(冻结状态或者正常状态),返回操作成功前台更改用户状态")
	@RequestMapping(value = "/user/status", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
	public Result lockUser(boolean isLock) {
		return new Result(true, "操作成功");
	}
	@ApiOperation(value = "冻结/解冻", notes = "前端传回一个当前用户的状态(冻结状态或者正常状态),返回操作成功前台更改用户状态")
	@RequestMapping(value = "/user/information", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
	public Result checkUser(long userId) {
		User user = new User();
		user.setId(userId);
		user.setSerialId("JJR0000001");
		user.setPhoneNumber("13800138000");
		user.setRealName("王尼玛");
		user.setIdCard("440923201809120293");
		user.setBalance(new BigDecimal(20000.00));
		user.setProfit(new BigDecimal(24.93));
		user.setCreatedAt(1537582046000L);
		user.setLock(true);

//		return new Result(true, );
	}
}
