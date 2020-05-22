package sk.fei.stuba.oop.zadanie3.model.contract;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public abstract class Contract {
    private Long contractId;
    private LocalDate date;
    private UUID userId;
    private LocalDate beginDate;
    private LocalDate endDate;
    private BigDecimal contractPrice;
    private BigDecimal monthlyFee;
    private ContractType contractType;


    public Contract() {
    }

    public Contract(Long contractId, LocalDate date, UUID userId, LocalDate beginDate, LocalDate endDate, BigDecimal contractPrice, BigDecimal monthlyFee, ContractType contractType) {
        setContractId(contractId);
        setDate(date);
        this.userId = userId;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.contractPrice = contractPrice;
        this.monthlyFee = monthlyFee;
        this.contractType = contractType;
    }

    public Long getContractId() {
        return contractId;
    }

    private void setContractId(Long contractId) {
        if (contractId <= 0)
            throw new IllegalArgumentException("You have to specify contract ID.");
        this.contractId = contractId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        if (date == null)
            throw new IllegalArgumentException("You have to specify contracts date.");
        this.date = date;
    }

    public UUID getUserId() {
        return userId;
    }

    private void setUserId(UUID userId) {
        if (userId == null)
            throw new IllegalArgumentException("You have to specify contracts userID.");
        this.userId = userId;
    }

    public LocalDate getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(LocalDate beginDate) {
        this.beginDate = beginDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
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
