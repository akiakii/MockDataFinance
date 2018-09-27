package com.finance.mock.web;

import com.finance.mock.entity.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: huangdongjiang
 * @Description: 快乐水 原味可乐
 * @Date: Created in 2018/9/22 9:26
 * @Modified By:
 */
@Api(tags = "后台业务管理模块")
@RestController
@RequestMapping(value = "/manager/business")
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
	@ApiOperation(value = "用户管理-首页", notes = "点击用户管理页面，查询出所有用户信息")
	@ApiImplicitParam(name = "pageNumber", value = "页码", dataType = "int", required = true,paramType="query")
	@GetMapping(value = "/users", produces = "application/json;charset=UTF-8")
	public Result<List<User>> userManage(@RequestParam int pageNumber) {
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
		user2.setId(2);
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
		System.out.println(pageNumber);
		return new Result<>(true, userList);
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
	@GetMapping(value = "/users/search", produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "用户管理-查询", notes = "根据用户输入查询关键字模糊搜索用户")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "serialId", value = "用户序列id", dataType = "String"),
			@ApiImplicitParam(name = "realName", value = "用户真实姓名", dataType = "String"),
			@ApiImplicitParam(name = "phoneNumber", value = "用户电话号码", dataType = "String"),
			@ApiImplicitParam(name = "status", value = "用户状态", dataType = "Boolean"),
			@ApiImplicitParam(name = "pageNumber", value = "页码", dataType = "long", required = true)})
	public Result<List<User>> searchUser(String serialId, String realName, String phoneNumber, boolean status, int pageNumber) {
		User user2 = new User();
		user2.setId(2);
		user2.setSerialId("JJR0000002");
		user2.setPhoneNumber("13800138001");
		user2.setRealName("王尼玛1");
		user2.setIdCard("440923201809120292");
		user2.setBalance(new BigDecimal(0.00));
		user2.setProfit(new BigDecimal(24.00));
		user2.setCreatedAt(1537582046000L);
		List<User> userList = new ArrayList<>();
		userList.add(user2);
		return new Result<>(true,userList);
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
	@ApiOperation(value = "用户管理-冻结/解冻", notes = "前端传回一个当前用户的状态(冻结状态或者正常状态),返回操作成功前台更改用户状态")
	@ApiImplicitParam(name = "Lock", value = "用户状态", required = true,dataType = "Boolean")
	@PutMapping(value = "/user/status/{userId}", produces = "application/json;charset=UTF-8")
	public Result lockUser(@PathVariable("userId") long userId, boolean Lock) {
		return new Result(true, "操作成功");
	}

	/**
	 *
	 * @Description:
	 * @auther: 快乐水 原味可乐
	 * @date: 16:39 2018/9/22
	 * @param: [userId]
	 * @return: com.finance.mock.entity.Result
	 *
	 */
	@ApiOperation(value = "用户管理-查看", notes = "查看显示单个用户的信息")
	@ApiImplicitParam(name = "userId", value = "用户Id", dataType = "long")
	@GetMapping(value = "/user/information",  produces = "application/json;charset=UTF-8")
	public Result<User> findUser(long userId) {
		User user = new User();
		user.setSerialId("JJR0000001");
		user.setPhoneNumber("13800138000");
		user.setRealName("王尼玛");
		user.setIdCard("440923201809120293");
		user.setBalance(new BigDecimal(20000.00));
		user.setProfit(new BigDecimal(24.93));
		user.setCreatedAt(1537582046000L);

		Bank bank1 = new Bank();
		Bank bank2 = new Bank();

		bank1.setCard("123412341234666");
		bank1.setType("招商银卡");

		bank2.setCard("4321432143217777");
		bank2.setType("工商银行");

		List<Bank> bankList = new ArrayList<>();
		bankList.add(bank1);
		bankList.add(bank2);

        user.setBankList(bankList);
		return new Result<>(true, user);
	}

	/**
	 *
	 * @Description: 发送验证码
	 * @auther: 快乐水 原味可乐
	 * @date: 16:44 2018/9/22
	 * @param: [phoneNumber]
	 * @return: com.finance.mock.entity.Result
	 *
	 */
	@ApiOperation(value = "用户管理-更换手机-获取验证码", notes = "获取验证码")
	@ApiImplicitParam(name = "phoneNumber", value = "手机号码", dataType = "String")
	@GetMapping(value = "/user/phone/msg",  produces = "application/json;charset=UTF-8")
	public Result getMsg(String phoneNumber) {
		return new Result(true,"验证码发送成功");
	}

	/**
	 *
	 * @Description: 更换手机
	 * @auther: 快乐水 原味可乐
	 * @date: 16:48 2018/9/22
	 * @param: [userId, phoneNumber, msgCode]
	 * @return: com.finance.mock.entity.Result
	 *
	 */
	@ApiOperation(value = "用户管理-更换手机-确认更换", notes = "验证输入的验证码是否正确")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "userId", value = "用户id", dataType = "long"),
			@ApiImplicitParam(name = "phoneNumber", value = "电话号码", dataType = "String"),
			@ApiImplicitParam(name = "msgCode", value = "验证码", dataType = "String")})
	@PutMapping(value = "/user/phone", produces = "application/json;charset=UTF-8")
	public Result changePhone(long userId, String phoneNumber, String msgCode) {
		return new Result(true,"更换成功");
	}

	/**
	 *
	 * @Description:
	 * @auther: 快乐水 原味可乐
	 * @date: 0:50 2018/9/26 
	 * @param: [userId]
	 * @return: com.finance.mock.entity.Result
	 *
	 */
	@ApiOperation(value = "用户管理-交易记录", notes = "点击查看用户的所有的交易记录")
	@ApiImplicitParam(name = "userId", value = "用户id", dataType = "long")
	@GetMapping(value = "/information/deals", produces = "application/json;charset=UTF-8")
	public Result findDealRecord(long userId) {
        String serialId = "JYJL000001";
        String realName = "王尼玛";
        String phoneNumber = "13800138000";
        String productName = "新手礼";
        String investment = String.valueOf(new BigDecimal(10000.00));
        String createAt = String.valueOf(1537582046000L);
        String dealingType = "付款";
        String Status = "成功";
        String dealingWay = "账户余额";

		String dealJson = "{\"serialId\":\"" + serialId + "\"\",\"realName\":\""+ realName + "\",\"phoneNumber\":\""+phoneNumber+
				"\",\"productWay\":\""+productName+"\",\"investment\":\""+investment+"\",\"createAt\":\""+createAt+"\",\"dealingType\":\""+dealingType +
				"\",\"Status\":\""+Status+"\",\"dealingWay\":\""+dealingWay+"\"}";
		return new Result<>(true, dealJson);
	}

	/**
	 *
	 * @Description:
	 * @auther: 快乐水 原味可乐
	 * @date: 21:47 2018/9/24
	 * @param: [userId]
	 * @return: com.finance.mock.entity.Result
	 *
	 */
	@ApiOperation(value = "用户管理-投资合同", notes = "查看用户所有的投资合同")
	@ApiImplicitParam(name = "pageNumber", value = "页码", dataType = "String")
	@GetMapping(value = "/information/compacts", produces = "application/json;charset=UTF-8")
	public Result findCompacts(String userId) {
		long compactId = 1;
		String serialId = "TZHT000001";
		String realName = "王尼玛";
		String phoneNumber = "13800138000";
		String productName = "新手礼";
		String investment = String.valueOf(new BigDecimal(10000.00));
		String createAt = String.valueOf(1537582046000L);
		String expireTime = "1537582046000";
		String Status = "生效中";

		String dealJson = "{\"compactId\":\""+compactId+"\",\"serialId\":\"" + serialId + "\"\",\"realName\":\""+ realName + "\",\"phoneNumber\":\"" + phoneNumber +
				"\",\"productWay\":\"" + productName+"\",\"investment\":\"" + investment+"\",\"createAt\":\"" + createAt + "\",\"expireTime\":\""
				+ expireTime + "\",\"Status\":\"" + Status+"\"}";
		return new Result<>(true, dealJson);
	}

	/**
	 *
	 * @Description:
	 * @auther: 快乐水 原味可乐
	 * @date: 21:47 2018/9/24
	 * @param: [serialId]
	 * @return: com.finance.mock.entity.Result
	 *
	 */
	@ApiOperation(value = "用户管理-投资合同-查看", notes = "点击查看用户某一个投资合同")
	@GetMapping(value = "/information/compact/search/{compactId}", produces = "application/json;charset=UTF-8")
	public Result findCompact(@PathVariable("compactId") long compactId) {
		String realName = "王尼玛";
		String idCard = "440923200811111";
		String createAt = String.valueOf(1537582046000L);
		String investment = String.valueOf(new BigDecimal(10000.00));

		String dealJson = "{\"realName\":\""+ realName + "\",\"idCard\":\"" + idCard + "\",\"createAt\":\""
				+ createAt + "\",\"investment\":\"" + investment +"\"}";
		return new Result<>(true, dealJson);
	}

//-----------------------------------------------债权管理---------------------------------------
	/**
	 *
	 * @Description:
	 * @auther: 快乐水 原味可乐
	 * @date: 21:47 2018/9/24
	 * @param: [pageNumber]
	 * @return: com.finance.mock.entity.Result
	 *
	 */
	@ApiOperation(value = "债权管理-首页", notes = "点击进入债权管理页面")
	@ApiImplicitParam(name = "pageNumber", value = "当前页码", dataType = "Integer")
	@GetMapping(value = "/companies", produces = "application/json;charset=UTF-8")
	public Result managerCompanies(int pageNumber) {
		Company company1 = new Company();
		company1.setId(1);
		company1.setSerialId("C00000001");
		company1.setCompanyName("涌动公司");
		company1.setDebtPerson("赵菊");
		company1.setPhoneNumber("13800138000");
		company1.setIdCardNum("36242212345678900x");
		company1.setBorrowMoney(new BigDecimal(20000.00));
		company1.setBorrowingCycle(3);
		company1.setCreatedAt(1537582046000L);
		company1.setRepaymentDate(1538791646000L);
		company1.setUnmatchMoney(new BigDecimal(0.00));
		company1.setStatus(20);

		Company company2 = new Company();
		company2.setId(2);
		company2.setSerialId("C00000002");
		company2.setCompanyName("潮奚公司");
		company2.setDebtPerson("黄明");
		company2.setPhoneNumber("13800138001");
		company2.setIdCardNum("36242212345678901x");
		company2.setBorrowMoney(new BigDecimal(20000.00));
		company2.setBorrowingCycle(3);
		company2.setCreatedAt(1537582046000L);
		company2.setRepaymentDate(1538791646000L);
		company2.setUnmatchMoney(new BigDecimal(10000.00));
		company2.setStatus(10);

		List<Company> companyList = new ArrayList<>();
		companyList.add(company1);
		companyList.add(company2);

		return new Result<>(true, companyList);
	}

	/**
	 *
	 * @Description:
	 * @auther: 快乐水 原味可乐
	 * @date: 21:47 2018/9/24
	 * @param: [serialId]
	 * @return: com.finance.mock.entity.Result
	 *
	 */
	@ApiOperation(value = "债权管理-查看", notes = "把相应债权的所有投资合同id查找出来")
	@ApiImplicitParam(name = "companyId", value = "债务公司的id", dataType = "long")
	@GetMapping(value = "/companies/compacts/{companyId}", produces = "application/json;charset=UTF-8")
	public Result findCompanyCompacts(@PathVariable("companyId") String companyId) {
		Compacting compacting = new Compacting();
		compacting.setSerialId("I00000001");
		compacting.setAmount(new BigDecimal(1000.00));
		compacting.setFinancialTime(7);

		Compacting compacting2 = new Compacting();
		compacting2.setSerialId("I00000002");
		compacting2.setAmount(new BigDecimal(2000.00));
		compacting2.setFinancialTime(10);

		List<Compacting> compactList = new ArrayList<>();
		compactList.add(compacting);
		compactList.add(compacting2);
		return new Result<>(true, compactList);
	}

	/**
	 *
	 * @Description:
	 * @auther: 快乐水 原味可乐
	 * @date: 21:47 2018/9/24
	 * @param: [serialId, companyName, DebtPerson, status]
	 * @return: com.finance.mock.entity.Result
	 *
	 */
	@ApiOperation(value = "债权管理-查询", notes = "根据用户输入关键字查询出相应的债务")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "serialId", value = "债权的序列ID", dataType = "String"),
			@ApiImplicitParam(name = "companyName", value = "公司名称", dataType = "String"),
			@ApiImplicitParam(name = "DebtPerson", value = "债务人", dataType = "String"),
			@ApiImplicitParam(name = "status", value = "匹配状态", dataType = "Integer")
	})
	@GetMapping(value = "/companies/compacts/search", produces = "application/json;charset=UTF-8")
	public Result findCompanies(String serialId, String companyName, String DebtPerson, int status) {
		Company company1 = new Company();
		company1.setId(1);
		company1.setSerialId("C00000001");
		company1.setCompanyName("涌动公司");
		company1.setDebtPerson("赵菊");
		company1.setPhoneNumber("13800138000");
		company1.setIdCardNum("36242212345678900x");
		company1.setBorrowMoney(new BigDecimal(20000.00));
		company1.setBorrowingCycle(3);
		company1.setCreatedAt(1537582046000L);
		company1.setRepaymentDate(1538791646000L);
		company1.setUnmatchMoney(new BigDecimal(0.00));
		company1.setStatus(20);

		List<Company> companyList = new ArrayList<>();
		companyList.add(company1);
		return new Result<>(true, companyList);
	}

	@ApiOperation(value = "债权管理-匹配", notes = "返回推荐投资")
	@ApiImplicitParam(name = "companyId", value = "债务公司的id", dataType = "long")
	@GetMapping(value = "/companies/compacts/matching/{companyId}", produces = "application/json;charset=UTF-8")
	public Result toMatchDebt(@PathVariable("companyId") long companyId) {

		String recommendationCompactId1 = "I00000001";
		String recommendationCompactId2 = "I00000001";
		String recommendationCompactId3 = "I00000001";

		List<String> recommendationCompactList = new ArrayList<>();
		recommendationCompactList.add(recommendationCompactId1);
		recommendationCompactList.add(recommendationCompactId2);
		recommendationCompactList.add(recommendationCompactId3);

		return new Result<>(true, recommendationCompactList);
	}


	/**
	 *
	 * @Description:
	 * @auther: 快乐水 原味可乐
	 * @date: 21:47 2018/9/24
	 * @param: [serialId]
	 * @return: com.finance.mock.entity.Result
	 *
	 */
	@ApiOperation(value = "债权管理-匹配债权", notes = "没有数据返回")
	@ApiImplicitParam(name = "serialId", value = "债务公司的序列id", dataType = "String")
	@PostMapping(value = "/companies/compacts/matching/{companyId}", produces = "application/json;charset=UTF-8")
	public Result matchDebt(@PathVariable("companyId") String serialId,@RequestBody List<String> recommendationCompactList) {
		return new Result<>(true, "匹配成功");
	}

	/**
	 *
	 * @Description:
	 * @auther: 快乐水 原味可乐
	 * @date: 11:58 2018/9/27
	 * @param: [companyName, debtPerson, phoneNumber, idCard, borrowMoneyDate, borrowMoney, borrowCycle]
	 * @return: com.finance.mock.entity.Result
	 *
	 */
	@ApiOperation(value = "债权管理-保存新增", notes = "没有数据返回")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "companyName", value = "公司名称", required = true, dataType = "String"),
			@ApiImplicitParam(name = "debtPerson", value = "债务人", required = true, dataType = "String"),
			@ApiImplicitParam(name = "phoneNumber", value = "手机号码", required = true, dataType = "String"),
			@ApiImplicitParam(name = "idCard", value = "身份证号", required = true, dataType = "String"),
			@ApiImplicitParam(name = "borrowMoneyDate", value = "借款日期", required = true, dataType = "long"),
			@ApiImplicitParam(name = "borrowMoney", value = "借款金额", required = true, dataType = "String"),
			@ApiImplicitParam(name = "borrowCycle", value = "借款期限(月)", required = true, dataType = "Integer")
	})
	@PostMapping(value = "/companies/compact/", produces = "application/json;charset=UTF-8")
	public Result addCompany(String companyName, String debtPerson, String phoneNumber,String idCard, long borrowMoneyDate,
							 String borrowMoney, int borrowCycle ) {
		return new Result<>(true, "债权新增成功");
	}

	/**
	 *
	 * @Description:
	 * @auther: 快乐水 原味可乐
	 * @date: 21:47 2018/9/24
	 * @param: [serialId, companyName, debtPerson, phoneNumber, idCard, borrowMoneyDate, borrowMoney, borrowCycle]
	 * @return: com.finance.mock.entity.Result
	 *
	 */
	@ApiOperation(value = "债权管理删除", notes = "没有数据返回")
	@ApiImplicitParam(name = "debtId", value = "债务公司的id", dataType = "long")
	@DeleteMapping(value = "/companies/compact/{debtId}", produces = "application/json;charset=UTF-8")
	public Result deleteDebt(@PathVariable("debtId") long debtId) {
		return new Result<>(true, "删除成功");
	}

	/**
	 *
	 * @Description:
	 * @auther: 快乐水 原味可乐
	 * @date: 21:47 2018/9/24
	 * @param: [serialId]
	 * @return: com.finance.mock.entity.Result
	 *
	 */
	@ApiOperation(value = "债权管理-编辑", notes = "没有数据返回")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "companyName", value = "公司名称", required = true, dataType = "String"),
			@ApiImplicitParam(name = "debtPerson", value = "债务人", required = true, dataType = "String"),
			@ApiImplicitParam(name = "phoneNumber", value = "手机号码", required = true, dataType = "String"),
			@ApiImplicitParam(name = "idCard", value = "身份证号", required = true, dataType = "String"),
			@ApiImplicitParam(name = "borrowMoneyDate", value = "借款日期", required = true, dataType = "long"),
			@ApiImplicitParam(name = "borrowMoney", value = "借款金额", required = true, dataType = "String"),
			@ApiImplicitParam(name = "borrowCycle", value = "借款期限(月)", required = true, dataType = "String")
	})
	@PutMapping(value = "/companies/compact/{debtId}", produces = "application/json;charset=UTF-8")
	public Result editCompany(@PathVariable("debtId") long debtId) {
		return new Result<>(true, "债权修改成功");
		//留个疑问，这里修改后的值要不要返回给前端？还是前端直接取用户修改后的值
	}

/*--------------------------------------------产品管理---------------------------------*/

	/**
	 *
	 * @Description:
	 * @auther: 快乐水 原味可乐
	 * @date: 21:48 2018/9/24
	 * @param: [pageNumber]
	 * @return: com.finance.mock.entity.Result
	 *
	 */
	@ApiOperation(value = "产品管理-首页", notes = "点击进入产品管理页面")
	@ApiImplicitParam(name = "pageNumber", value = "当前页码", dataType = "Integer")
	@GetMapping(value = "/products", produces = "application/json;charset=UTF-8")
	public Result managerProducts(int pageNumber) {
		Product product = new Product();
		product.setSerialId("L00000001");
		product.setProductName("新手礼");
		product.setProProfit(13);
		product.setInvestmentCycle(7);
		product.setMinAmount(new BigDecimal(5000.00));
		product.setMinIncrement(new BigDecimal(1000));
		product.setRepaymentWay("本息返还");
		product.setCreatedBy("翁涵");
		product.setCreatedAt(new Date().getTime());
		product.setStatus(false);

		Product product1 = new Product();
		product1.setSerialId("L00000002");
		product1.setProductName("聚月赚");
		product1.setProProfit(7);
		product1.setInvestmentCycle(90);
		product1.setMinAmount(new BigDecimal(5000.00));
		product1.setMinIncrement(new BigDecimal(1000));
		product1.setRepaymentWay("本息返还");
		product1.setCreatedBy("郑志航");
		product1.setCreatedAt(new Date().getTime());
		product1.setStatus(true);

		List<Product> productList = new ArrayList<>();
		productList.add(product);
		productList.add(product1);

		return new Result<>(true, productList);
	}

	/**
	 *
	 * @Description:
	 * @auther: 快乐水 原味可乐
	 * @date: 21:48 2018/9/24
	 * @param: [serialId, productName, creator, status]
	 * @return: com.finance.mock.entity.Result
	 *
	 */
	@ApiOperation(value = "产品管理-查询", notes = "根据管理员输入关键字查询出相应的产品")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "serialId", value = "产品的序列ID", dataType = "String"),
			@ApiImplicitParam(name = "productName", value = "产品名称", dataType = "String"),
			@ApiImplicitParam(name = "creator", value = "创建人", dataType = "String"),
			@ApiImplicitParam(name = "status", value = "上架/下架", dataType = "Boolean")
	})
	@GetMapping(value = "/companies/products/search", produces = "application/json;charset=UTF-8")
	public Result findProducts(String serialId, String productName,
								String creator, boolean status) {
		Product product = new Product();
		product.setSerialId("L00000001");
		product.setProductName("新手礼");
		product.setProProfit(13);
		product.setInvestmentCycle(7);
		product.setMinAmount(new BigDecimal(5000.00));
		product.setMinIncrement(new BigDecimal(1000));
		product.setRepaymentWay("本息返还");
		product.setCreatedBy("翁涵");
		product.setCreatedAt(new Date().getTime());
		product.setStatus(false);

		List<Product> productList = new ArrayList<>();
		productList.add(product);
		return new Result<>(true, productList);
	}

	/**
	 *
	 * @Description:
	 * @auther: 快乐水 原味可乐
	 * @date: 21:48 2018/9/24
	 * @param: [productName, proProfit, investmentCycle, minAmount, minIncrement, repaymentWay, productIntro, moreInformation]
	 * @return: com.finance.mock.entity.Result
	 *
	 */
	@ApiOperation(value = "产品管理-新增", notes = "没有数据返回")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "productName", value = "产品名称", required = true, dataType = "String"),
			@ApiImplicitParam(name = "proProfit", value = "预期年利率", required = true, dataType = "Integer"),
			@ApiImplicitParam(name = "investmentCycle", value = "投资周期(天)", required = true, dataType = "Integer"),
			@ApiImplicitParam(name = "minAmount", value = "起投金额", required = true, dataType = "String"),
			@ApiImplicitParam(name = "minIncrement", value = "最小增减金额", required = true, dataType = "String"),
			@ApiImplicitParam(name = "repaymentWay", value = "还款方式", required = true, dataType = "String"),
			@ApiImplicitParam(name = "productIntro", value = "产品简介", required = true, dataType = "String"),
			@ApiImplicitParam(name = "moreInformation", value = "更多信息", required = true, dataType = "String"),
	})
	@PostMapping(value = "/companies/product/", produces = "application/json;charset=UTF-8")
	public Result addProduct( String productName,int proProfit, int investmentCycle,String minAmount, String minIncrement,String repaymentWay, String productIntro,String moreInformation) {
		return new Result<>(true, "产品新增成功");
	}

	/**
	 *
	 * @Description:
	 * @auther: 快乐水 原味可乐
	 * @date: 21:48 2018/9/24
	 * @param: [serialId]
	 * @return: com.finance.mock.entity.Result
	 *
	 */
	@ApiOperation(value = "产品管理-删除", notes = "没有数据返回")
	@ApiImplicitParam(name = "serialId", value = "债务公司的序列id", dataType = "String")
	@DeleteMapping(value = "/companies/product/{productId}", produces = "application/json;charset=UTF-8")
	public Result deleteProduct(@PathVariable("productId") long productId) {
		return new Result<>(true, "删除成功");
	}

	/**
	 *
	 * @Description:
	 * @auther: 快乐水 原味可乐
	 * @date: 21:48 2018/9/24
	 * @param: [serialId]
	 * @return: com.finance.mock.entity.Result
	 *
	 */
	@ApiOperation(value = "债权管理-编辑", notes = "没有数据返回")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "companyName", value = "公司名称", required = true, dataType = "String"),
			@ApiImplicitParam(name = "debtPerson", value = "债务人", required = true, dataType = "String"),
			@ApiImplicitParam(name = "phoneNumber", value = "手机号码", required = true, dataType = "String"),
			@ApiImplicitParam(name = "idCard", value = "身份证号", required = true, dataType = "String"),
			@ApiImplicitParam(name = "borrowMoneyDate", value = "借款日期", required = true, dataType = "long"),
			@ApiImplicitParam(name = "borrowMoney", value = "借款金额", required = true, dataType = "String"),
			@ApiImplicitParam(name = "borrowCycle", value = "借款期限(月)", required = true, dataType = "String")
	})
	@PutMapping(value = "/companies/product/{productId}", produces = "application/json;charset=UTF-8")
	public Result editProduct(@PathVariable("productId") long productId) {
		return new Result<>(true, "产品编辑成功");
		//留个疑问，这里修改后的值要不要返回给前端？还是前端直接取用户修改后的值
	}

	/**
	 *
	 * @Description:
	 * @auther: 快乐水 原味可乐
	 * @date: 21:48 2018/9/24
	 * @param: [serialId]
	 * @return: com.finance.mock.entity.Result
	 *
	 */
	@ApiOperation(value = "产品上下架", notes = "没有数据返回")
	@PutMapping(value = "/companies/product/status/{productId}", produces = "application/json;charset=UTF-8")
	public Result offProduct(@PathVariable("productId") long productId) {
		return new Result<>(true, "下架/上架成功");
	}
}
