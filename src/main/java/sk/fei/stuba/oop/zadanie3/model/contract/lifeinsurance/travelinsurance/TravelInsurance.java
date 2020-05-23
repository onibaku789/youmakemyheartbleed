package sk.fei.stuba.oop.zadanie3.model.contract.lifeinsurance.travelinsurance;


import sk.fei.stuba.oop.zadanie3.model.contract.Contract;
import sk.fei.stuba.oop.zadanie3.model.contract.ContractType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class TravelInsurance extends Contract {

    private boolean inEU;
    private PurposeOfTrip purpose;

    public TravelInsurance(String contractId, LocalDateTime date, String userId, LocalDateTime beginDate, LocalDateTime endDate, BigDecimal contractPrice, BigDecimal monthlyFee, ContractType contractType,
                           boolean inEU, PurposeOfTrip purpose) {
        super(contractId, date, userId, beginDate, endDate, contractPrice, monthlyFee, contractType);
        this.inEU = inEU;
        this.purpose = purpose;
    }

    public TravelInsurance() { super(); }

    public boolean isInEU() {
        return inEU;
    }

    public void setInEU(boolean inEU) {
        this.inEU = inEU;
    }

    public PurposeOfTrip getPurpose() {
        return purpose;
    }

    public void setPurpose(PurposeOfTrip purpose) {
        this.purpose = purpose;
    }

    @Override
    public String toString() {
        return super.toString() +
                "TravelInsurance{" +
                "inEU=" + inEU +
                ", purpose=" + purpose +
                '}';
    }
}
