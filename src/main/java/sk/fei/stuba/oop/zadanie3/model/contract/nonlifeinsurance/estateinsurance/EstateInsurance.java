package sk.fei.stuba.oop.zadanie3.model.contract.nonlifeinsurance.estateinsurance;


import sk.fei.stuba.oop.zadanie3.model.contract.Contract;
import sk.fei.stuba.oop.zadanie3.model.contract.ContractType;
import sk.fei.stuba.oop.zadanie3.model.contract.nonlifeinsurance.EstateType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class EstateInsurance extends Contract {

    @NotNull
    private EstateType estateType;
    @NotBlank
    private String estateAddrZipCode;
    @NotBlank
    private String estateAddrTown;
    @NotBlank
    private String estateAddrStreet;
    @NotBlank
    private String estateAddrHouseNumber;
    @NotNull// not string ..... its a fucking Address class
    @Positive
    private BigDecimal estatePrice; // nehnutelnosti
    @NotNull
    private boolean garage;  // pripoistenie garaze

    public EstateInsurance() {
        super();
    }

    public EstateInsurance(String contractId, LocalDateTime date, String userId, LocalDateTime beginDate, LocalDateTime endDate, BigDecimal contractPrice, BigDecimal monthlyFee, ContractType contractType, EstateType estateType, String estateAddrZipCode, String estateAddrTown, String estateAddrStreet, String estateAddrHouseNumber, BigDecimal estatePrice, boolean garage) {
        super(contractId, date, userId, beginDate, endDate, contractPrice, monthlyFee, contractType);
        this.estateType = estateType;
        this.estateAddrZipCode = estateAddrZipCode;
        this.estateAddrTown = estateAddrTown;
        this.estateAddrStreet = estateAddrStreet;
        this.estateAddrHouseNumber = estateAddrHouseNumber;
        this.estatePrice = estatePrice;
        this.garage = garage;
    }



    public EstateType getEstateType() {
        return estateType;
    }

    public void setEstateType(EstateType estateType) {
        this.estateType = estateType;
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

    public BigDecimal getEstatePrice() {
        return estatePrice;
    }

    public void setEstatePrice(BigDecimal estatePrice) {
        this.estatePrice = estatePrice;
    }

    public boolean isGarage() {
        return garage;
    }

    public void setGarage(boolean garage) {
        this.garage = garage;
    }

    @Override
    public String toString() {
        return super.toString() + "EstateInsurance{" +
                "estateType=" + estateType +
                ", estateAddrZipCode='" + estateAddrZipCode + '\'' +
                ", estateAddrTown='" + estateAddrTown + '\'' +
                ", estateAddrStreet='" + estateAddrStreet + '\'' +
                ", estateAddrHouseNumber='" + estateAddrHouseNumber + '\'' +
                ", estatePrice=" + estatePrice +
                ", garage=" + garage +
                '}';
    }
}
