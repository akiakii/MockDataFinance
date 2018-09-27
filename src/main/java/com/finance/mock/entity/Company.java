package com.finance.mock.entity;

import java.math.BigDecimal;

/**
 * @Author: 快乐水 青柠可乐
 * @Description:
 * @Date: Created in 下午9:42 2018/9/21
 * @Modified By:
 */
public class Company {
    private long id;
    private String serialId;
    private String companyName;
    private String debtPerson;
    private String phoneNumber;
    private String idCardNum;
    private BigDecimal borrowMoney;
    private int borrowingCycle;
    private long repaymentDate;
    private BigDecimal unmatchMoney;
    private int status;
    private long createdAt;
    private long updatedAt;

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", serialId='" + serialId + '\'' +
                ", companyName='" + companyName + '\'' +
                ", debtPerson='" + debtPerson + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", idCardNum='" + idCardNum + '\'' +
                ", borrowMoney=" + borrowMoney +
                ", borrowingCycle=" + borrowingCycle +
                ", repaymentDate=" + repaymentDate +
                ", unmatchMoney=" + unmatchMoney +
                ", status=" + status +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSerialId() {
        return serialId;
    }

    public void setSerialId(String serialId) {
        this.serialId = serialId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDebtPerson() {
        return debtPerson;
    }

    public void setDebtPerson(String debtPerson) {
        this.debtPerson = debtPerson;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getIdCardNum() {
        return idCardNum;
    }

    public void setIdCardNum(String idCardNum) {
        this.idCardNum = idCardNum;
    }

    public BigDecimal getBorrowMoney() {
        return borrowMoney;
    }

    public void setBorrowMoney(BigDecimal borrowMoney) {
        this.borrowMoney = borrowMoney;
    }

    public int getBorrowingCycle() {
        return borrowingCycle;
    }

    public void setBorrowingCycle(int borrowingCycle) {
        this.borrowingCycle = borrowingCycle;
    }

    public long getRepaymentDate() {
        return repaymentDate;
    }

    public void setRepaymentDate(long repaymentDate) {
        this.repaymentDate = repaymentDate;
    }

    public BigDecimal getUnmatchMoney() {
        return unmatchMoney;
    }

    public void setUnmatchMoney(BigDecimal unmatchMoney) {
        this.unmatchMoney = unmatchMoney;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }
}
