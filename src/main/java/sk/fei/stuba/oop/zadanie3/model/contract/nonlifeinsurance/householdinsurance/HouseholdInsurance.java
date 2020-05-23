package sk.fei.stuba.oop.zadanie3.model.contract.nonlifeinsurance.householdinsurance;


import sk.fei.stuba.oop.zadanie3.model.contract.Contract;
import sk.fei.stuba.oop.zadanie3.model.contract.ContractType;
import sk.fei.stuba.oop.zadanie3.model.contract.nonlifeinsurance.EstateType;


import java.math.BigDecimal;
import java.time.LocalDate;

public class HouseholdInsurance extends Contract {
    private EstateType estateType;
    private String estateAddrZipCode;
    private String estateAddrTown;
    private String estateAddrStreet;
    private String estateAddrHouseNumber;
    private BigDecimal estatePrice; // nehnutelnosti
    private BigDecimal equipmentPrice; //zariadenia

    public HouseholdInsurance() { super(); }

    public HouseholdInsurance(String contractId, LocalDate date, String userId,
                              LocalDate beginDate, LocalDate endDate,
                              BigDecimal contractPrice, BigDecimal monthlyFee,
                              ContractType contractType, EstateType estateType,
                              String estateAddrZipCode, String estateAddrTown,
                              String estateAddrStreet, String estateAddrHouseNumber,
                              BigDecimal estatePrice, BigDecimal equipmentPrice) {
        super(contractId, date, userId, beginDate, endDate, contractPrice, monthlyFee, contractType);
        this.estateType = estateType;
        this.estateAddrZipCode = estateAddrZipCode;
        this.estateAddrTown = estateAddrTown;
        this.estateAddrStreet = estateAddrStreet;
        this.estateAddrHouseNumber = estateAddrHouseNumber;
        this.estatePrice = estatePrice;
        this.equipmentPrice = equipmentPrice;
    }



    public EstateType getEstateType() {
        return estateType;
    }

    public void setEstateType(EstateType estateType) {
        this.estateType = estateType;
    }


    public BigDecimal getEstatePrice() {
        return estatePrice;
    }

    public void setEstatePrice(BigDecimal estatePrice) {
        this.estatePrice = estatePrice;
    }

    public BigDecimal getEquipmentPrice() {
        return equipmentPrice;
    }

    public void setEquipmentPrice(BigDecimal equipmentPrice) {
        this.equipmentPrice = equipmentPrice;
    }


    public String getEstateAddrZipCode() {
        return estateAddrZipCode;
    }

    public void setEstateAddrZipCode(String estateAddrZipCode) {
        this.estateAddrZipCode = estateAddrZipCode;
    }

    public String getEstateAddrTown() {
        return estateAddrTown;
    }

    public void setEstateAddrTown(String estateAddrTown) {
        this.estateAddrTown = estateAddrTown;
    }

    public String getEstateAddrStreet() {
        return estateAddrStreet;
    }

    public void setEstateAddrStreet(String estateAddrStreet) {
        this.estateAddrStreet = estateAddrStreet;
    }

    public String getEstateAddrHouseNumber() {
        return estateAddrHouseNumber;
    }

    public void setEstateAddrHouseNumber(String estateAddrHouseNumber) {
        this.estateAddrHouseNumber = estateAddrHouseNumber;
    }

    @Override
    public String toString() {
        return "HouseholdInsurance{" +
                "estateType=" + estateType +
                ", estateAddrZipCode='" + estateAddrZipCode + '\'' +
                ", estateAddrTown='" + estateAddrTown + '\'' +
                ", estateAddrStreet='" + estateAddrStreet + '\'' +
                ", estateAddrHouseNumber='" + estateAddrHouseNumber + '\'' +
                ", estatePrice=" + estatePrice +
                ", equipmentPrice=" + equipmentPrice +
                '}';
    }
}
