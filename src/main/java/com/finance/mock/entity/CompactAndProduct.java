package com.finance.mock.entity;

/**
 * @Author: 快乐水 青柠可乐
 * @Description:
 * @Date: Created in 上午10:42 2018/9/28
 * @Modified By:
 */
public class CompactAndProduct {
    private Compacting compacting;
    private Product product;

    @Override
    public String toString() {
        return "CompactAndProduct{" +
                "compacting=" + compacting +
                ", product=" + product +
                '}';
    }

    public Compacting getCompacting() {
        return compacting;
    }

    public void setCompacting(Compacting compacting) {
        this.compacting = compacting;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
