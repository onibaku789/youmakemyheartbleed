package sk.fei.stuba.oop.zadanie3.model.contract;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public abstract class Contract {
    private String contractId;
    @NotNull
    private LocalDateTime date; // creation date
    @NotBlank
    private String userId;// INSURER - employee ID
    @NotNull
    private LocalDateTime beginDate;
    @NotNull
    private LocalDateTime endDate;
    @NotNull
    @Positive
    private BigDecimal contractPrice;
    @NotNull
    @Positive
    private BigDecimal monthlyFee;

    private ContractType contractType;


    public Contract() {
        this.date = LocalDateTime.now();
    }

    public Contract(String contractId, LocalDateTime date, String userId, LocalDateTime beginDate, LocalDateTime endDate, BigDecimal contractPrice, BigDecimal monthlyFee, ContractType contractType) {
        this.contractId = contractId;
        this.date = LocalDateTime.now();
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

    public void setContractType(ContractType contractType) {
        this.contractType = contractType;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "contractId='" + contractId + '\'' +
                ", date=" + date +
                ", userId='" + userId + '\'' +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", contractPrice=" + contractPrice +
                ", monthlyFee=" + monthlyFee +
                ", contractType=" + contractType +
                '}';
    }
}
