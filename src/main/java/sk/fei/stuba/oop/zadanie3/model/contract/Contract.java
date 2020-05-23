package sk.fei.stuba.oop.zadanie3.model.contract;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public abstract class Contract {
    private String contractId;
    private LocalDateTime date; // needed LocalDateTime ??
    private String userId;// INSURER - employee ID

    private LocalDateTime beginDate;
    private LocalDateTime endDate;
    private BigDecimal contractPrice;
    private BigDecimal monthlyFee;
    private ContractType contractType;


    public Contract() {
    }

    public Contract(String contractId, LocalDateTime date, String userId, LocalDateTime beginDate, LocalDateTime endDate, BigDecimal contractPrice, BigDecimal monthlyFee, ContractType contractType) {
        this.contractId = contractId;
        setDate(date);
        this.userId = userId;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.contractPrice = contractPrice;
        this.monthlyFee = monthlyFee;
        this.contractType = contractType;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        if (date == null)
            throw new IllegalArgumentException("You have to specify contracts date.");
        this.date = date;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public LocalDateTime getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(LocalDateTime beginDate) {
        this.beginDate = beginDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getContractPrice() {
        return contractPrice;
    }

    public void setContractPrice(BigDecimal contractPrice) {
        this.contractPrice = contractPrice;
    }

    public BigDecimal getMonthlyFee() {
        return monthlyFee;
    }

    public void setMonthlyFee(BigDecimal monthlyFee) {
        this.monthlyFee = monthlyFee;
    }

    public ContractType getContractType() {
        return contractType;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "contractId=" + contractId +
                ", date=" + date +
                ", userId=" + userId +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", contractPrice=" + contractPrice +
                ", monthlyFee=" + monthlyFee +
                '}';
    }
}
