package com.finance.mock.config;

import com.finance.mock.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 快乐水 青柠可乐
 * @Description:
 * @Date: Created in 下午4:09 2018/9/27
 * @Modified By:
 */
@Configuration
public class UserBean {

    @Autowired
    UserBean userBean;

    @Bean
    public User getUser1(){
        User user1=new User();
        user1.setId(1);
        user1.setSerialId("U0000001");
        user1.setPhoneNumber("111111");
        user1.setIdCard("440110110110");
        user1.setRealName("青柠");
        user1.setLocked(false);
        user1.setNoob(false);
        user1.setPassword("000000");
        user1.setSalt("");
        user1.setBalance(BigDecimal.valueOf(200000));
        user1.setProfit(BigDecimal.valueOf(0));
        user1.setCreatedAt(0);
        user1.setUpdatedAt(0);
        return user1;
    }

    @Bean
    public User getUser2(){
        User user2=new User();
        user2.setId(2);
        user2.setSerialId("U0000002");
        user2.setPhoneNumber("222222");
        user2.setIdCard("440220220220");
        user2.setRealName("白");
        user2.setLocked(false);
        user2.setNoob(true);
        user2.setPassword("000000");
        user2.setSalt("");
        user2.setBalance(BigDecimal.valueOf(100000));
        user2.setProfit(BigDecimal.valueOf(100));
        user2.setCreatedAt(1);
        user2.setUpdatedAt(1);
        return user2;
    }

    @Bean
    public Product getProduct1(){
        Product product1=new Product();
        product1.setId(1);
        product1.setCreatedBy("青柠");
        product1.setSerialId("P000001");
        product1.setStatus(true);
        product1.setAdvantage("注册即可购买新手里——新手里专享13%预期年华——更多福利");
        product1.setProductIntro("只能购买一次，高回报，赶紧买");
        product1.setProductName("新手礼");
        product1.setInvestmentCycle((short) 90);
        product1.setMinIncrement(BigDecimal.valueOf(1000));
        product1.setSlogan("新手理财，3步攻略");
        product1.setMinAmount(BigDecimal.valueOf(5000));
        product1.setMaxAmount(BigDecimal.valueOf(50000));
        product1.setProProfit((short) 13);
        return product1;
    }

    @Bean
    public Product getProduct2(){
        Product product2=new Product();
        product2.setId(2);
        product2.setCreatedBy("青柠");
        product2.setSerialId("P000002");
        product2.setStatus(true);
        product2.setAdvantage("青柠推荐——买买不倦——更多福利");
        product2.setProductIntro("赶紧买");
        product2.setProductName("聚划算投资");
        product2.setInvestmentCycle((short) 90);
        product2.setMinIncrement(BigDecimal.valueOf(1000));
        product2.setSlogan("聚划算投资，3步攻略");
        product2.setMinAmount(BigDecimal.valueOf(5000));
        product2.setMaxAmount(BigDecimal.valueOf(5000000));
        product2.setProProfit((short) 10);
        return product2;
    }

    @Bean
    public Banner getBanner1(){
        Banner banner1=new Banner();
        banner1.setId(1);
        banner1.setSerialId("B0000001");
        banner1.setTitle("聚金融三周年");
        banner1.setKey("1");
        banner1.setIntervalTime((short) 6);
        banner1.setStatus(true);
        banner1.setCreatedBy("青柠");
        banner1.setUpdatedBy("青柠");
        banner1.setCreateAt(0);
        banner1.setUpdateAt(0);
        return banner1;
    }

    @Bean
    public Banner getBanner2(){
        Banner banner2=new Banner();
        banner2.setId(2);
        banner2.setSerialId("B0000002");
        banner2.setTitle("邀请注册");
        banner2.setKey("2");
        banner2.setIntervalTime((short) 6);
        banner2.setStatus(true);
        banner2.setCreatedBy("青柠");
        banner2.setUpdatedBy("青柠");
        banner2.setCreateAt(0);
        banner2.setUpdateAt(0);
        return banner2;
    }

    @Bean
    public Compacting getCompacting1(){
        Compacting compacting1=new Compacting();
        compacting1.setId(1);
        compacting1.setSerialId("C0000001");
        compacting1.setUserId(1);
        compacting1.setProductId(1);
        compacting1.setExpiredTime(1000*60*60*24+30);
        compacting1.setStatus(0);
        compacting1.setAmount(BigDecimal.valueOf(5000));
        compacting1.setProfit(BigDecimal.valueOf(10));
        compacting1.setFinancialTime(30);
        compacting1.setCreatedAt(0);
        compacting1.setUpdatedAt(0);
        return compacting1;
    }

    @Bean
    public Compacting getCompacting2(){
        Compacting compacting2=new Compacting();
        compacting2.setId(2);
        compacting2.setSerialId("C0000002");
        compacting2.setUserId(1);
        compacting2.setProductId(2);
        compacting2.setExpiredTime(1000*60*60*24+30);
        compacting2.setStatus(0);
        compacting2.setAmount(BigDecimal.valueOf(10000));
        compacting2.setProfit(BigDecimal.valueOf(20));
        compacting2.setFinancialTime(30);
        compacting2.setCreatedAt(0);
        compacting2.setUpdatedAt(0);
        return compacting2;
    }




    @Bean
    public Bank getBank1(){
        Bank bank1=new Bank();
        bank1.setUserId(1);
        bank1.setId(1);
        bank1.setCard("88886666");
        bank1.setType("招商银行");
        return bank1;
    }

    @Bean
    public  Bank getBank2(){
        Bank bank2=new Bank();
        bank2.setId(2);
        bank2.setUserId(1);
        bank2.setType("建设银行");
        bank2.setCard("99990000");
        return bank2;
    }


    @Bean
    public Deal getDeal1(){
        Compacting compacting=userBean.getCompacting1();
        Deal  deal=new Deal();
        deal.setId(1);
        deal.setCompactId(1);
        deal.setUserID(1);
        deal.setInvestment(compacting.getAmount());
        deal.setProfit(compacting.getProfit());
        deal.setDealingType("账户");
        deal.setCreatedAt(compacting.getCreatedAt());
        deal.setUpdatedAt(compacting.getUpdatedAt());
        return  deal;

    }

    @Bean
    public Deal getDeal2(){
        Compacting compacting=userBean.getCompacting2();
        Deal  deal=new Deal();
        deal.setId(2);
        deal.setCompactId(2);
        deal.setUserID(1);
        deal.setInvestment(compacting.getAmount());
        deal.setProfit(compacting.getProfit());
        deal.setDealingType("账户");
        deal.setCreatedAt(compacting.getCreatedAt());
        deal.setUpdatedAt(compacting.getUpdatedAt());
        return  deal;

    }


    @Bean
    public List<Message> getUser1Message(){
        Message message1=new Message();
        Message message2=new Message();

        message1.setId(1);
        message1.setUserId(1);
        message1.setManagerId(1);
        message1.setTitle("欢迎");
        message1.setContent("感谢你");
        message1.setType("20");
        message1.setRead(false);
        message1.setSendAt(0);

        message2.setId(2);
        message2.setUserId(1);
        message2.setManagerId(1);
        message2.setTitle("建议");
        message2.setContent("买新手礼");
        message2.setType("20");
        message2.setRead(false);
        message2.setSendAt(0);


        List<Message> messages=new ArrayList<>();
        messages.add(message1);
        messages.add(message2);

        return  messages;
    }

    public List<Message> getUser2Messages(){
        Message message1=new Message();
        Message message2=new Message();
        Message message3=new Message();

        message1.setId(3);
        message1.setUserId(2);
        message1.setManagerId(1);
        message1.setTitle("欢迎");
        message1.setContent("感谢你");
        message1.setType("20");
        message1.setRead(false);
        message1.setSendAt(0);

        message2.setId(4);
        message2.setUserId(2);
        message2.setManagerId(1);
        message2.setTitle("建议");
        message2.setContent("买新手礼");
        message2.setType("20");
        message2.setRead(false);
        message2.setSendAt(0);

        message3.setId(5);
        message3.setUserId(2);
        message3.setManagerId(1);
        message3.setTitle("咨询");
        message3.setContent("您为什么还不买");
        message3.setType("20");
        message3.setRead(false);
        message3.setSendAt(0);

        List<Message> messages=new ArrayList<>();
        messages.add(message1);
        messages.add(message2);
        messages.add(message3);
        return  messages;
    }

    @Bean
    public List<Compacting> getUser1Compacting(){
        List<Compacting> list=new ArrayList<>();
        Compacting compacting1=userBean.getCompacting1();
        Compacting compacting2=userBean.getCompacting2();
        list.add(compacting1);
        list.add(compacting2);
        return list;
    }


    @Bean
    public List<Bank> getUser1Bank(){
        Bank bank1=userBean.getBank1();
        Bank bank2=userBean.getBank2();
        List<Bank> banks=new ArrayList<>();
        banks.add(bank1);
        banks.add(bank2);
        return banks;
    }

    @Bean
    public List<DealAndProduct> getUser1Deals(){
        DealAndProduct dealAndProduct1=new DealAndProduct();
        dealAndProduct1.setDeal(userBean.getDeal1());
        dealAndProduct1.setProduct(userBean.getProduct1());

        DealAndProduct dealAndProduct2=new DealAndProduct();
        dealAndProduct2.setDeal(userBean.getDeal2());
        dealAndProduct2.setProduct(userBean.getProduct2());

        List<DealAndProduct> dealAndProducts=new ArrayList<>();
        dealAndProducts.add(dealAndProduct1);
        dealAndProducts.add(dealAndProduct2);

        return dealAndProducts;
    }

    @Bean
    public List<CompactAndProduct> getProduct1Compact(){
        CompactAndProduct cap1=new CompactAndProduct();
        cap1.setProduct(userBean.getProduct1());
        cap1.setCompacting(userBean.getCompacting1());

        List<CompactAndProduct> compactAndProductList=new ArrayList<>();
        compactAndProductList.add(cap1);
        return compactAndProductList;
    }

    @Bean
    public List<CompactAndProduct> getProduct2Compact(){
        CompactAndProduct cap2=new CompactAndProduct();
        cap2.setProduct(userBean.getProduct2());
        cap2.setCompacting(userBean.getCompacting2());

        List<CompactAndProduct> compactAndProductList=new ArrayList<>();
        compactAndProductList.add(cap2);
        return compactAndProductList;
    }



}
