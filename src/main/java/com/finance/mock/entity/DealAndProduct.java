package com.finance.mock.entity;

/**
 * @Author: 快乐水 青柠可乐
 * @Description:
 * @Date: Created in 下午8:10 2018/9/27
 * @Modified By:
 */
public class DealAndProduct extends Deal {

    private Deal deal;
    private Product product;


    @Override
    public String toString() {
        return "DealAndProduct{" +
                "deal=" + deal +
                ", product=" + product +
                '}'+"\n";
    }

    public Deal getDeal() {
        return deal;
    }

    public void setDeal(Deal deal) {
        this.deal = deal;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
