package com.finance.mock.web;

import com.finance.mock.entity.*;
import com.finance.mock.entity.Banner;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: huangdongjiang
 * @Description: 快乐水 原味可乐
 * @Date: Created in 2018/9/24 21:49
 * @Modified By:
 */
@Api(tags = "后台运营管理模块")
@RestController
@RequestMapping("/manager/operation")
public class OperationController {
	/**
	 *
	 * @Description:
	 * @auther: 快乐水 原味可乐
	 * @date: 22:40 2018/9/24
	 * @param: [pageNumber]
	 * @return: com.finance.mock.entity.Result
	 *
	 */
	@ApiOperation(value = "Banner图-首页", notes = "查询出所有的Banner图")
	@ApiImplicitParam(name = "pageNumber", value = "当前页码", dataType = "Integer")
	@GetMapping(value = "/banners", produces = "application/json;charset=UTF-8")
	public Result managerBanners(int pageNumber) {
		Banner banner = new Banner();
		banner.setId(1);
		banner.setSerialId("xxxxqqqq");
		banner.setTitle("聚金融三周年");
		banner.setKey("a.jpg");
        banner.setIntervalTime(6);
        banner.setCreatedBy("威斯克");
        banner.setCreateAt(new Date().getTime());
        banner.setUpdatedBy("爱德华");
        banner.setUpdateAt(new Date().getTime());
        banner.setStatus(false);

		Banner banner1 = new Banner();
		banner1.setId(2);
		banner1.setSerialId("eewwqq");
		banner1.setTitle("聚金融三周年");
		banner1.setKey("b.jpg");
		banner1.setIntervalTime(6);
		banner1.setCreatedBy("威斯克");
		banner1.setCreateAt(new Date().getTime());
		banner1.setUpdatedBy("爱德华");
		banner1.setUpdateAt(new Date().getTime());
		banner1.setStatus(false);

		List<Banner> bannerList = new ArrayList<>();
		bannerList.add(banner);
		bannerList.add(banner1);

		return new Result<>(true, bannerList);
	}

	/**
	 *
	 * @Description:
	 * @auther: 快乐水 原味可乐
	 * @date: 22:40 2018/9/24
	 * @param: [serialId, bannerTitle, creator, status]
	 * @return: com.finance.mock.entity.Result
	 *
	 */
	@ApiOperation(value = "banner图-查询", notes = "根据管理员输入关键字查询出相应的banner图")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "bannerId", value = "banner图的ID", dataType = "int"),
			@ApiImplicitParam(name = "bannerTitle", value = "banner图标题", dataType = "String"),
			@ApiImplicitParam(name = "creator", value = "创建人", dataType = "String"),
			@ApiImplicitParam(name = "status", value = "上架/下架", dataType = "Boolean")
	})
	@GetMapping(value = "/banner/search", produces = "application/json;charset=UTF-8")
	public Result findBanners(String serialId, String bannerTitle,
							   String creator, boolean status) {
		Banner banner = new Banner();
		banner.setId(1);
		banner.setSerialId("xxxxqqqq");
		banner.setTitle("聚金融三周年");
		banner.setKey("a.jpg");
		banner.setIntervalTime(6);
		banner.setCreatedBy("威斯克");
		banner.setCreateAt(new Date().getTime());
		banner.setUpdatedBy("爱德华");
		banner.setUpdateAt(new Date().getTime());
		banner.setStatus(false);

		List<Banner> bannerList = new ArrayList<>();
		bannerList.add(banner);
		return new Result<>(true, bannerList);
	}

	/**
	 *
	 * @Description:
	 * @auther: 快乐水 原味可乐
	 * @date: 22:39 2018/9/24
	 * @param: [bannerTitle, intervalTime, bannerURL]
	 * @return: com.finance.mock.entity.Result
	 *
	 */
	@ApiOperation(value = "banner图-新增", notes = "没有数据返回")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "bannerTitle", value = "banner图标题", required = true, dataType = "String"),
			@ApiImplicitParam(name = "intervalTime", value = "轮播时间(s)", required = true, dataType = "Integer"),
			@ApiImplicitParam(name = "bannerURL", value = "URL地址(可为空", dataType = "String")})
	@PostMapping(value = "/banners", produces = "application/json;charset=UTF-8")
	public Result addBanner( String bannerTitle,int intervalTime, String bannerURL) {
		return new Result<>(true, "banner图新增成功");
	}

	/**
	 *
	 * @Description:
	 * @auther: 快乐水 原味可乐
	 * @date: 22:39 2018/9/24
	 * @param: [serialId]
	 * @return: com.finance.mock.entity.Result
	 *
	 */
	@ApiOperation(value = "Banner图-删除", notes = "没有数据返回")
//	@ApiImplicitParam(name = "serialId", value = "债务公司的序列id", dataType = "String")
	@DeleteMapping(value = "/banner/{bannerId}", produces = "application/json;charset=UTF-8")
	public Result deleteBanner(@PathVariable("bannerId") long bannerId) {
		return new Result<>(true, "删除成功");
	}

	/**
	 *
	 * @Description:
	 * @auther: 快乐水 原味可乐
	 * @date: 22:39 2018/9/24
	 * @param: [serialId]
	 * @return: com.finance.mock.entity.Result
	 *
	 */
	@ApiOperation(value = "Banner图-编辑", notes = "没有数据返回")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "bannerTitle", value = "banner图标题", required = true, dataType = "String"),
			@ApiImplicitParam(name = "intervalTime", value = "轮播时间(s)", required = true, dataType = "Integer"),
			@ApiImplicitParam(name = "bannerURL", value = "URL地址(可为空", dataType = "String")
	})
	@PutMapping(value = "/banner/{bannerId}", produces = "application/json;charset=UTF-8")
	public Result editBanner(@PathVariable("bannerId") String serialId) {
		return new Result<>(true, "Banner编辑成功");
		//留个疑问，这里修改后的值要不要返回给前端？还是前端直接取用户修改后的值
	}

	/**
	 *
	 * @Description:
	 * @auther: 快乐水 原味可乐
	 * @date: 22:39 2018/9/24
	 * @param: [serialId]
	 * @return: com.finance.mock.entity.Result
	 *
	 */
	@ApiOperation(value = "banner图上下架", notes = "没有数据返回")
	@PutMapping(value = "/banner/status/{bannerId}", produces = "application/json;charset=UTF-8")
	public Result offBanner(@PathVariable("bannerId") long bannerId, boolean status) {
		return new Result<>(true, "下架/上架成功");
	}

/*-------------------------------------------------鼎力推荐--------------------------------*/
	/**
	 *
	 * @Description:
	 * @auther: 快乐水 原味可乐
	 * @date: 23:18 2018/9/24
	 * @param: [pageNumber]
	 * @return: com.finance.mock.entity.Result
	 *
	 */
	@ApiOperation(value = "鼎力推荐", notes = "查询出所有的鼎力推荐产品")
	@ApiImplicitParam(name = "pageNumber", value = "当前页码", dataType = "Integer")
	@GetMapping(value = "/recommendations", produces = "application/json;charset=UTF-8")
	public Result manageRecommendations(int pageNumber) {

		Product product = new Product();
		product.setId(1);
		product.setSerialId("wwwqfafa");
		product.setProductName("新手礼");
		product.setKey("b.jpg");
		product.setCreatedBy("威斯克");
		product.setCreatedAt(new Date().getTime());
		product.setUpdatedBy("乔治");
		product.setUpdatedAt(new Date().getTime());
		product.setStatus(true);

		Product product1 = new Product();
		product1.setId(2);
		product.setSerialId("ssssfafa");
		product1.setProductName("新手礼");
		product1.setKey("b.jpg");
		product1.setCreatedBy("威斯克");
		product1.setCreatedAt(new Date().getTime());
		product1.setUpdatedBy("乔治");
		product1.setUpdatedAt(new Date().getTime());
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
	 * @date: 23:18 2018/9/24
	 * @param: [serialId, bannerTitle, createdBy, updatedBy]
	 * @return: com.finance.mock.entity.Result
	 *
	 */
	@ApiOperation(value = "鼎力推荐-查询", notes = "根据管理员输入关键字查询出相应的定理推荐产品")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "bannerId", value = "鼎力推荐的产品的序列ID", dataType = "long"),
			@ApiImplicitParam(name = "productTitle", value = "鼎力推荐图片标题", dataType = "String"),
			@ApiImplicitParam(name = "createdBy", value = "创建人", dataType = "String"),
			@ApiImplicitParam(name = "updatedBy", value = "更新人", dataType = "String")
	})
	@GetMapping(value = "/recommendation/search", produces = "application/json;charset=UTF-8")
	public Result findRecommendations(long bannerId, String bannerTitle,String createdBy, String updatedBy) {
		Product product = new Product();
		product.setId(1);
		product.setSerialId("xxxxssss");
		product.setProductName("新手礼");
		product.setKey("b.jpg");
		product.setCreatedBy("威斯克");
		product.setCreatedAt(new Date().getTime());
		product.setUpdatedBy("乔治");
		product.setUpdatedAt(new Date().getTime());
		product.setStatus(true);
		List<Product> productList = new ArrayList<>();
		productList.add(product);
		return new Result<>(true, productList);
	}

	/**
	 *
	 * @Description:
	 * @auther: 快乐水 原味可乐
	 * @date: 23:18 2018/9/24
	 * @param: [recommendationTitle, recommendationURL]
	 * @return: com.finance.mock.entity.Result
	 *
	 */
	@ApiOperation(value = "鼎力推荐-新增", notes = "没有数据返回")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "recommendationTitle", value = "鼎力推荐图片标题", required = true, dataType = "String"),
			@ApiImplicitParam(name = "recommendationURL", value = "URL地址(可为空", dataType = "String")})
	@PostMapping(value = "/recommendation", produces = "application/json;charset=UTF-8")
	public Result addRecommendation( String recommendationTitle,String recommendationURL) {
		return new Result<>(true, "鼎力推荐产品新增成功");
	}

	/**
	 *
	 * @Description:
	 * @auther: 快乐水 原味可乐
	 * @date: 23:18 2018/9/24
	 * @param: [serialId]
	 * @return: com.finance.mock.entity.Result
	 *
	 */
	@ApiOperation(value = "鼎力推荐-删除", notes = "没有数据返回")
//	@ApiImplicitParam(name = "serialId", value = "债务公司的序列id", dataType = "String")
	@DeleteMapping(value = "/recommendation/{recommendationId}", produces = "application/json;charset=UTF-8")
	public Result deleteRecommendationId(@PathVariable("recommendationId") long bannerId) {
		return new Result<>(true, "删除成功");
	}

	/**
	 *
	 * @Description:
	 * @auther: 快乐水 原味可乐
	 * @date: 23:18 2018/9/24
	 * @param: [serialId]
	 * @return: com.finance.mock.entity.Result
	 *
	 */
	@ApiOperation(value = "鼎力推荐-编辑", notes = "没有数据返回")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "recommendationTitle", value = "recommendation图标题", required = true, dataType = "String"),

			@ApiImplicitParam(name = "recommendationURL", value = "URL地址(可为空", dataType = "String")
	})
	@PutMapping(value = "/recommendation/{recommendationId}", produces = "application/json;charset=UTF-8")
	public Result editRecommendation(@PathVariable("recommendationId") long recommendtationId) {
		return new Result<>(true, "鼎力推荐产品编辑成功");
		//留个疑问，这里修改后的值要不要返回给前端？还是前端直接取用户修改后的值
	}

	/**
	 *
	 * @Description:
	 * @auther: 快乐水 原味可乐
	 * @date: 23:17 2018/9/24
	 * @param: [serialId]
	 * @return: com.finance.mock.entity.Result
	 *
	 */
	@ApiOperation(value = "banner图上下架", notes = "没有数据返回")
	@PutMapping(value = "/banner/status/{recommendationId}", produces = "application/json;charset=UTF-8")
	public Result offRecommendation(@PathVariable("recommendationId") long recommendationId, boolean status) {
		return new Result<>(true, "下架/上架成功");
	}

/*-------------------------------------------------消息管理---------------------------------*/
	/**
	 *
	 * @Description:
	 * @auther: 快乐水 原味可乐
	 * @date: 9:50 2018/9/25
	 * @param: [pageNumber]
	 * @return: com.finance.mock.entity.Result
	 *
	 */
	@ApiOperation(value = "消息管理", notes = "查询出所有的消息")
	@ApiImplicitParam(name = "pageNumber", value = "当前页码", dataType = "Integer")
	@GetMapping(value = "/messages", produces = "application/json;charset=UTF-8")
	public Result manageMessages(int pageNumber) {

		Message message = new Message();
		message.setId(1);
		message.setTittle("六一欢聚，孩童快乐！");
        message.setCreated_by("admin");
		message.setCreatedAt(new Date().getTime());
        message.setUpdated_by("admin");
        message.setUpdatedAt(new Date().getTime());
        message.setStatus(10);//10推送，20已推送，30已取消
		message.setSendAt(new Date().getTime());

		Message message1 = new Message();
		message1.setId(2);
		message1.setTittle("版本更新通知");
		message1.setCreated_by("admin");
		message1.setCreatedAt(new Date().getTime());
		message1.setUpdated_by("admin");
		message1.setUpdatedAt(new Date().getTime());
		message1.setStatus(20);//10推送，20已推送，30已取消
		message1.setSendAt(new Date().getTime());

		List<Message> messagesList = new ArrayList<>();

		messagesList.add(message);
		messagesList.add(message1);
		return new Result<>(true, messagesList);
	}

	/**
	 *
	 * @Description:
	 * @auther: 快乐水 原味可乐
	 * @date: 9:50 2018/9/25
	 * @param: [createdBy, messageTitle, status, sendAt]
	 * @return: com.finance.mock.entity.Result
	 *
	 */
	@ApiOperation(value = "消息管理-查询", notes = "根据管理员输入关键字查询出相应的消息")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "createdBy", value = "创建人", dataType = "String"),
			@ApiImplicitParam(name = "messageTitle", value = "消息标题", dataType = "String"),
			@ApiImplicitParam(name = "status", value = "消息状态", dataType = "Integer"),
			@ApiImplicitParam(name = "sendAt", value = "发送时间", dataType = "Long")
	})
	@GetMapping(value = "/message/search", produces = "application/json;charset=UTF-8")
	public Result findMessages(String createdBy, String messageTitle,
									  int status, Long sendAt) {
		Message message = new Message();
		message.setId(1);
		message.setTittle("六一欢聚，孩童快乐！");
		message.setCreated_by("admin");
		message.setCreatedAt(new Date().getTime());
		message.setUpdated_by("admin");
		message.setUpdatedAt(new Date().getTime());
		message.setStatus(10);//10推送，20已推送，30已取消
		message.setSendAt(new Date().getTime());

		List<Message> messagesList = new ArrayList<>();
		messagesList.add(message);
		return new Result<>(true, messagesList);
	}

	/**
	 *
	 * @Description:
	 * @auther: 快乐水 原味可乐
	 * @date: 9:50 2018/9/25
	 * @param: [messageTitle, content, sendAt]
	 * @return: com.finance.mock.entity.Result
	 *
	 */
	@ApiOperation(value = "消息管理-新增", notes = "没有数据返回")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "messageTitle", value = "消息标题", required = true, dataType = "String"),
			@ApiImplicitParam(name = "content", value = "消息内容", required = true, dataType = "String"),
			@ApiImplicitParam(name = "sendAt", value = "发送时间", dataType = "Long")
	})
	@PostMapping(value = "/message", produces = "application/json;charset=UTF-8")
	public Result addMessage( String messageTitle,String content,long sendAt) {
		return new Result<>(true, "消息新增成功");
	}

	/**
	 *
	 * @Description:
	 * @auther: 快乐水 原味可乐
	 * @date: 9:50 2018/9/25
	 * @param: [id]
	 * @return: com.finance.mock.entity.Result
	 *
	 */
	@ApiOperation(value = "消息管理-删除", notes = "没有数据返回")
//	@ApiImplicitParam(name = "serialId", value = "债务公司的序列id", dataType = "String")
	@DeleteMapping(value = "/message/{messageId}", produces = "application/json;charset=UTF-8")
	public Result deleteMessage(@PathVariable("messageId") int id) {
		return new Result<>(true, "删除成功");
	}

	/**
	 *
	 * @Description:
	 * @auther: 快乐水 原味可乐
	 * @date: 9:50 2018/9/25
	 * @param: [id, messageTitle, content, sendAt]
	 * @return: com.finance.mock.entity.Result
	 *
	 */
	@ApiOperation(value = "消息管理-编辑", notes = "没有数据返回")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "messageTitle", value = "消息标题", required = true, dataType = "String"),
			@ApiImplicitParam(name = "content", value = "消息内容", required = true, dataType = "String"),
			@ApiImplicitParam(name = "sendAt", value = "发送时间", dataType = "Long")
	})
	@PutMapping(value = "/message/{messageId}", produces = "application/json;charset=UTF-8")
	public Result editMessage(@PathVariable("messageId") int id,String messageTitle,String content,long sendAt) {
		return new Result<>(true, "消息编辑成功");
		//留个疑问，这里修改后的值要不要返回给前端？还是前端直接取用户修改后的值
	}

	/**
	 *
	 * @Description:
	 * @auther: 快乐水 原味可乐
	 * @date: 9:50 2018/9/25
	 * @param: [id]
	 * @return: com.finance.mock.entity.Result
	 *
	 */
	@ApiOperation(value = "取消发送", notes = "没有数据返回")
	@PutMapping(value = "/message/cancel/{messageId}", produces = "application/json;charset=UTF-8")
	public Result cancelSendMessage(@PathVariable("messageId") int id) {
		return new Result<>(true, "消息发送取消成功");
	}

/*---------------------------------------------意见回复------------------------------------*/
	/**
	 *
	 * @Description:
	 * @auther: 快乐水 原味可乐
	 * @date: 11:16 2018/9/25
	 * @param: [pageNumber]
	 * @return: com.finance.mock.entity.Result
	 *
	 */
	@ApiOperation(value = "意见回复", notes = "查询出所有的意见")
	@ApiImplicitParam(name = "pageNumber", value = "当前页码", dataType = "Integer")
	@GetMapping(value = "/suggestions", produces = "application/json;charset=UTF-8")
	public Result manageSuggestion(int pageNumber) {

		String content = "工资卡是招商的，我可以更换之前绑定的银行卡吗？";
		String commitBy = "王尼玛";
		String phoneNumber = "13800138000";
		String commitAt = String.valueOf(new Date().getTime());
		String replyBy = "爱丽丝";
		String replyAt = String.valueOf(new Date().getTime());

        String messageJson = "{\"content\":\"" + content + "\", \"commitBy\":\""+commitBy+"\"," +
				"\"phoneNumber\":\""+phoneNumber+"\",\"commitAt\":\""+commitAt+"\"," +
				"\"replyBy\":\""+replyBy+"\",\"replyAt\":\""+replyAt+"\",}";

		List<String> messageList = new ArrayList<>();

		messageList.add(messageJson);
		return new Result<>(true, messageList);
	}

	/**
	 *
	 * @Description:
	 * @auther: 快乐水 原味可乐
	 * @date: 11:16 2018/9/25
	 * @param: [serialId, keyWord, commitBy, phoneNumber]
	 * @return: com.finance.mock.entity.Result
	 *
	 */
	@ApiOperation(value = "意见回复-查询", notes = "根据管理员输入关键字查询出相应的意见")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "serialId", value = "意见的序列ID", dataType = "String"),
			@ApiImplicitParam(name = "keyWord", value = "关键字", dataType = "String"),
			@ApiImplicitParam(name = "commitBy", value = "提交人", dataType = "String"),
			@ApiImplicitParam(name = "phoneNumber", value = "手机号码", dataType = "String")
	})
	@GetMapping(value = "/suggestions/search", produces = "application/json;charset=UTF-8")
	public Result findSuggestions(String serialId, String keyWord,
									  String commitBy, String phoneNumber) {

		String content = "工资卡是招商的，我可以更换之前绑定的银行卡吗？";
		String commitBy1 = "王尼玛";
		String phoneNumber1 = "13800138001";
		String commitAt = String.valueOf(new Date().getTime());
		String replyBy = "爱丽丝";
		String replyAt = String.valueOf(new Date().getTime());

		String messageJson = "{\"content\":\"" + content + "\", \"commitBy\":\""+commitBy1+"\"," +
				"\"phoneNumber\":\""+phoneNumber1+"\",\"commitAt\":\""+commitAt+"\"," +
				"\"replyBy\":\""+replyBy+"\",\"replyAt\":\""+replyAt+"\",}";

		List<String> messageList = new ArrayList<>();

		messageList.add(messageJson);
		return new Result<>(true, messageList);
	}

	/**
	 *
	 * @Description:
	 * @auther: 快乐水 原味可乐
	 * @date: 11:16 2018/9/25
	 * @param: [serialId]
	 * @return: com.finance.mock.entity.Result
	 *
	 */
	@ApiOperation(value = "意见回复-查看", notes = "根据管理员输入关键字查询出相应的意见")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "serialId", value = "意见的序列ID", dataType = "String"),
			@ApiImplicitParam(name = "keyWord", value = "关键字", dataType = "String"),
			@ApiImplicitParam(name = "commitBy", value = "提交人", dataType = "String"),
			@ApiImplicitParam(name = "phoneNumber", value = "手机号码", dataType = "String")
	})
	@GetMapping(value = "/suggestions/search/{suggestionId}", produces = "application/json;charset=UTF-8")
	public Result findMessages(@PathVariable("suggestionId") long suggestionId) {

		String content = "工资卡是招商的，我可以更换之前绑定的银行卡吗？";
		String commitBy = "王尼玛";
		String commitAt = String.valueOf(new Date().getTime());
		String replyBy = "爱丽丝";
		String replyAt = String.valueOf(new Date().getTime());
        String replyContent = "可以更换之前绑定的银行卡。感谢对聚金融的鼎力支持，祝你生活愉快。";
		String messageJson = "{\"content\":\"" + content + "\", \"commitBy\":\""+commitBy+"\"," +
				"\"replyContent\":\""+replyContent+"\",\"commitAt\":\""+commitAt+"\"," +
				"\"replyBy\":\""+replyBy+"\",\"replyAt\":\""+replyAt+"\",}";

		List<String> messageList = new ArrayList<>();

		messageList.add(messageJson);
		return new Result<>(true, messageList);
	}


	/**
	 *
	 * @Description:
	 * @auther: 快乐水 原味可乐
	 * @date: 11:15 2018/9/25
	 * @param: [serialId]
	 * @return: com.finance.mock.entity.Result
	 *
	 */
	@ApiOperation(value = "消息回复-删除", notes = "没有数据返回")
	@DeleteMapping(value = "/suggestion/{suggestionId}", produces = "application/json;charset=UTF-8")
	public Result deleteSuggestion(@PathVariable("suggestionId") long suggestionId) {
		return new Result<>(true, "删除成功");
	}

	/**
	 *
	 * @Description:
	 * @auther: 快乐水 原味可乐
	 * @date: 11:15 2018/9/25
	 * @param: [serialId, replyContent]
	 * @return: com.finance.mock.entity.Result
	 *
	 */
	@ApiOperation(value = "意见管理-回复", notes = "没有数据返回")
	@ApiImplicitParam(name = "replyContent", value = "回复内容", dataType = "String")
	@PostMapping(value = "/suggestion/{suggestionId}", produces = "application/json;charset=UTF-8")
	public Result replySuggestion(@PathVariable("suggestionId") String serialId,String replyContent) {
		return new Result<>(true, "回复成功");
	}
}
