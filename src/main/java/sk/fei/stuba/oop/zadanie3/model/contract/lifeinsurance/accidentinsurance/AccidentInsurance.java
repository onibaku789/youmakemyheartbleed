package sk.fei.stuba.oop.zadanie3.model.contract.lifeinsurance.accidentinsurance;

import sk.fei.stuba.oop.zadanie3.model.contract.Contract;
import sk.fei.stuba.oop.zadanie3.model.contract.ContractType;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AccidentInsurance extends Contract {
    private int accidentConseq;
    private int death;
    private int dailycompens;
    private TerritorialValidity territorialValidity;

    public AccidentInsurance() { super(); }

    public AccidentInsurance(String contractId, LocalDate date, String userId, LocalDate beginDate, LocalDate endDate, BigDecimal contractPrice, BigDecimal monthlyFee, ContractType contractType,
                             int accidentConseq, int death, int dailycompens, TerritorialValidity territorialValidity) {
        super(contractId, date, userId, beginDate, endDate, contractPrice, monthlyFee, contractType);
        this.accidentConseq = accidentConseq;
        this.death = death;
        this.dailycompens = dailycompens;
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

    public int getDailycompens() {
        return dailycompens;
    }

    public void setDailycompens(int dailycompens) {
        this.dailycompens = dailycompens;
    }

    public TerritorialValidity getTerritorialValidity() {
        return territorialValidity;
    }

    public void setTerritorialValidity(TerritorialValidity territorialValidity) {
        this.territorialValidity = territorialValidity;
    }

    @Override
    public String toString() {
        return super.toString() +
                "AccidentInsurance{" +
                "accidentConseq=" + accidentConseq +
                ", death=" + death +
                ", dailycompens=" + dailycompens +
                ", territorialValidity=" + territorialValidity +
                '}';
    }
}

