package sk.fei.stuba.oop.zadanie3.model.contract.lifeinsurance.accidentinsurance;

import sk.fei.stuba.oop.zadanie3.model.contract.Contract;
import sk.fei.stuba.oop.zadanie3.model.contract.ContractType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AccidentInsurance extends Contract {
    @NotNull
    @Positive
    private int accidentConseq;
    @NotNull
    @Positive
    private int death;
    @NotNull
    @Positive
    private int dailyCompens;
    @NotNull
    private TerritorialValidity territorialValidity;
    @NotBlank
    private String insured; // INSURED - customer ID

    public AccidentInsurance() {
        super();
    }

    public AccidentInsurance(String contractId, LocalDateTime date, String userId, LocalDateTime beginDate, LocalDateTime endDate, BigDecimal contractPrice, BigDecimal monthlyFee, ContractType contractType,
                             int accidentConseq, int death, int dailyCompens, TerritorialValidity territorialValidity) {
        super(contractId, date, userId, beginDate, endDate, contractPrice, monthlyFee, contractType);
        this.accidentConseq = accidentConseq;
        this.death = death;
        this.dailyCompens = dailyCompens;
        this.territorialValidity = territorialValidity;
    }


    public int getAccidentConseq() {
        return accidentConseq;
    }

    public void setAccidentConseq(int accidentConseq) {
        this.accidentConseq = accidentConseq;
    }

    public int getDeath() {
        return death;
    }

    public void setDeath(int death) {
        this.death = death;
    }

    public int getDailyCompens() {
        return dailyCompens;
    }

    public void setDailyCompens(int dailyCompens) {
        this.dailyCompens = dailyCompens;
    }

    public TerritorialValidity getTerritorialValidity() {
        return territorialValidity;
    }

    public void setTerritorialValidity(TerritorialValidity territorialValidity) {
        this.territorialValidity = territorialValidity;
    }
    public String getInsured() {
        return insured;
    }

    public void setInsured(String insured) {
        this.insured = insured;
    }

    @Override
    public String toString() {
        return super.toString() +
                "AccidentInsurance{" +
                "accidentConseq=" + accidentConseq +
                ", death=" + death +
                ", dailycompens=" + dailyCompens +
                ", territorialValidity=" + territorialValidity +
                '}';
    }
}

