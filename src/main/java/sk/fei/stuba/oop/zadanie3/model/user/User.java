package sk.fei.stuba.oop.zadanie3.model.user;


import sk.fei.stuba.oop.zadanie3.model.contract.Contract;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User  {

    private String userId;
    private String firstName;
    private String lastName;
    private int birthId;
    private String email;

    private String addrZipCode;
    private String addrTown;
    private String addrStreet;
    private String addrHouseNumber;

    private String correspaddrZipCode;
    private String correspaddrTown;
    private String correspaddrStreet;
    private String correspaddrHouseNumber;

    private List<Contract> listOfContracts;

    public User() {
        listOfContracts = new ArrayList<>();
    }

    public User(String userId, String firstName, String lastName, int birthId, String email, String addrZipCode, String addrTown, String addrStreet, String addrHouseNumber, String correspaddrZipCode,
                String correspaddrTown, String correspaddrStreet, String correspaddrHouseNumber) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthId = birthId;
        this.email = email;
        this.addrZipCode = addrZipCode;
        this.addrTown = addrTown;
        this.addrStreet = addrStreet;
        this.addrHouseNumber = addrHouseNumber;
        this.correspaddrZipCode = correspaddrZipCode;
        this.correspaddrTown = correspaddrTown;
        this.correspaddrStreet = correspaddrStreet;
        this.correspaddrHouseNumber = correspaddrHouseNumber;
    }

    public User(User user1) {
        this.userId = user1.userId;
        this.firstName = user1.firstName;
        this.lastName = user1.lastName;
        this.birthId = user1.birthId;
        this.email = user1.email;
        this.addrZipCode = user1.addrZipCode;
        this.addrTown = user1.addrTown;
        this.addrStreet = user1.addrStreet;
        this.addrHouseNumber = user1.addrHouseNumber;
        this.correspaddrZipCode = user1.correspaddrZipCode;
        this.correspaddrTown = user1.correspaddrTown;
        this.correspaddrStreet = user1.correspaddrStreet;
        this.correspaddrHouseNumber = user1.correspaddrHouseNumber;
        this.listOfContracts = user1.listOfContracts;
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName.trim().isEmpty())
            throw new IllegalArgumentException("You have to specify users first name.");
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName.trim().isEmpty())
            throw new IllegalArgumentException("You have to specify users last name.");
        this.lastName = lastName;
    }

    public int getBirthId() {
        return birthId;
    }

    public void setBirthId(int birthId) {
        if (birthId <= 0)
            throw new IllegalArgumentException("You have to specify users birth ID.");
        this.birthId = birthId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email.trim().isEmpty())
            throw new IllegalArgumentException("You have to specify users email.");
        this.email = email;
    }
    public void addContracts(Contract contract){
        listOfContracts.add(contract);
    }

    public List<Contract> getListOfContracts() {
        return new ArrayList<>(listOfContracts);
    }

    public void setListOfContracts(List<Contract> listOfContracts) {
        this.listOfContracts = listOfContracts;
    }

    public String getAddrZipCode() {
        return addrZipCode;
    }

    public void setAddrZipCode(String addrZipCode) {
        this.addrZipCode = addrZipCode;
    }

    public String getAddrTown() {
        return addrTown;
    }

    public void setAddrTown(String addrTown) {
        this.addrTown = addrTown;
    }

    public String getAddrStreet() {
        return addrStreet;
    }

    public void setAddrStreet(String addrStreet) {
        this.addrStreet = addrStreet;
    }

    public String getAddrHouseNumber() {
        return addrHouseNumber;
    }

    public void setAddrHouseNumber(String addrHouseNumber) {
        this.addrHouseNumber = addrHouseNumber;
    }

    public String getCorrespaddrZipCode() {
        return correspaddrZipCode;
    }

    public void setCorrespaddrZipCode(String correspaddrZipCode) {
        this.correspaddrZipCode = correspaddrZipCode;
    }

    public String getCorrespaddrTown() {
        return correspaddrTown;
    }

    public void setCorrespaddrTown(String correspaddrTown) {
        this.correspaddrTown = correspaddrTown;
    }

    public String getCorrespaddrStreet() {
        return correspaddrStreet;
    }

    public void setCorrespaddrStreet(String correspaddrStreet) {
        this.correspaddrStreet = correspaddrStreet;
    }

    public String getCorrespaddrHouseNumber() {
        return correspaddrHouseNumber;
    }

    public void setCorrespaddrHouseNumber(String correspaddrHouseNumber) {
        this.correspaddrHouseNumber = correspaddrHouseNumber;
    }
    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthId=" + birthId +
                ", email='" + email + '\'' +
                ", addrZipCode='" + addrZipCode + '\'' +
                ", addrTown='" + addrTown + '\'' +
                ", addrStreet='" + addrStreet + '\'' +
                ", addrHouseNumber='" + addrHouseNumber + '\'' +
                ", correspaddrZipCode='" + correspaddrZipCode + '\'' +
                ", correspaddrTown='" + correspaddrTown + '\'' +
                ", correspaddrStreet='" + correspaddrStreet + '\'' +
                ", correspaddrHouseNumber='" + correspaddrHouseNumber + '\'' +
                ", listOfContracts=" + listOfContracts +
                '}';
    }
}

