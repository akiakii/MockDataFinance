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
    private long debtId;
    private String companyName;
    private String debtPerson;
    private String phoneNumber;
    private String idCardNum;
    private BigDecimal borrowMoney;
    private int borrowingCycle;
    private long repaymentDate;
    private long unmatchMoney;
    private boolean status;
    private long createdAt;
    private long updatedAt;

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", debtId=" + debtId +
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
                '}'+"\n";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getDebtId() {
        return debtId;
    }

    public void setDebtId(long debtId) {
        this.debtId = debtId;
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

    public long getUnmatchMoney() {
        return unmatchMoney;
    }

    public void setUnmatchMoney(long unmatchMoney) {
        this.unmatchMoney = unmatchMoney;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
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
