package sk.fei.stuba.oop.zadanie3.repository;


import org.springframework.stereotype.Service;
import sk.fei.stuba.oop.zadanie3.model.contract.Contract;
import sk.fei.stuba.oop.zadanie3.model.contract.lifeinsurance.accidentinsurance.AccidentInsurance;
import sk.fei.stuba.oop.zadanie3.model.contract.lifeinsurance.travelinsurance.TravelInsurance;
import sk.fei.stuba.oop.zadanie3.model.contract.nonlifeinsurance.estateinsurance.EstateInsurance;
import sk.fei.stuba.oop.zadanie3.model.contract.nonlifeinsurance.householdinsurance.HouseholdInsurance;

import java.util.*;

@Service
public class ContractRepository {
    private Map<String, Contract> allContracts;

    public ContractRepository() {
        this.allContracts = new HashMap<>();
    }

    public List<Contract> getContractByUserId(String id) {
        List<Contract> userContractList = new ArrayList<>();
        for (Contract contract : allContracts.values()) {
            if (contract.getUserId().equals(id)) {
                userContractList.add(contract);
            }
        }
        return userContractList;
    }

    public Contract getContractByContractId(String id){
        return allContracts.getOrDefault(id,null);
    }


    public void addContract(Contract newContract) {
        allContracts.put(newContract.getContractId(),newContract);
    }

    public Contract editContract(Contract editedContract) {
        Contract tempContract = allContracts.get(editedContract.getContractId());
        editContract(editedContract, tempContract);
        switch (tempContract.getContractType()) {
            case ACCIDENT:
                editAccidentInsurance(editedContract, tempContract);
                break;
            case ESTATE:
                editEstateInsurance(editedContract, tempContract);
                break;
            case TRAVEL:
                editTravelInsurance(editedContract, tempContract);
                break;
            case HOUSEHOLD:
                editHouseholdInsurance(editedContract, tempContract);
                break;
        }
        allContracts.replace(tempContract.getContractId(),tempContract);
        return tempContract;
    }

    public List<Contract> getAllContracts() {
        return new ArrayList<>(allContracts.values());
    }

    private void editEstateInsurance(Contract editedContract, Contract tempContract) {
        EstateInsurance editedEstateInsurance = (EstateInsurance) editedContract;
        EstateInsurance tempEstateInsurance = (EstateInsurance) tempContract;
        tempEstateInsurance.setEstateAddrHouseNumber(editedEstateInsurance.getEstateAddrHouseNumber());
        tempEstateInsurance.setEstateAddrStreet(editedEstateInsurance.getEstateAddrStreet());
        tempEstateInsurance.setEstateAddrTown(editedEstateInsurance.getEstateAddrTown());
        tempEstateInsurance.setEstateAddrZipCode(editedEstateInsurance.getEstateAddrZipCode());
        tempEstateInsurance.setEstatePrice(editedEstateInsurance.getEstatePrice());
        tempEstateInsurance.setEstateType(editedEstateInsurance.getEstateType());
        tempEstateInsurance.setGarage(editedEstateInsurance.isGarage());
    }

    private void editAccidentInsurance(Contract editedContract, Contract tempContract) {
        AccidentInsurance editedAccidentInsurance = (AccidentInsurance) editedContract;
        AccidentInsurance tempAccidentInsurance = (AccidentInsurance) tempContract;
        tempAccidentInsurance.setAccidentConseq(editedAccidentInsurance.getAccidentConseq());
        tempAccidentInsurance.setDailyCompens(editedAccidentInsurance.getDailyCompens());
        tempAccidentInsurance.setDeath(editedAccidentInsurance.getDeath());
        tempAccidentInsurance.setTerritorialValidity(editedAccidentInsurance.getTerritorialValidity());
    }

    private void editTravelInsurance(Contract editedContract, Contract tempContract) {
        TravelInsurance editedTravelInsurance = (TravelInsurance) editedContract;
        TravelInsurance tempTravelInsurance = (TravelInsurance) tempContract;
        tempTravelInsurance.setInEU(editedTravelInsurance.isInEU());
        tempTravelInsurance.setPurpose(editedTravelInsurance.getPurpose());
    }

    private void editHouseholdInsurance(Contract editedContract, Contract tempContract) {
        HouseholdInsurance editedHouseholdInsurance = (HouseholdInsurance) editedContract;
        HouseholdInsurance tempHouseholdInsurance = (HouseholdInsurance) tempContract;
        tempHouseholdInsurance.setEstateType(editedHouseholdInsurance.getEstateType());
        tempHouseholdInsurance.setEstateAddrHouseNumber(editedHouseholdInsurance.getEstateAddrHouseNumber());
        tempHouseholdInsurance.setEstateAddrStreet(editedHouseholdInsurance.getEstateAddrStreet());
        tempHouseholdInsurance.setEstateAddrTown(editedHouseholdInsurance.getEstateAddrTown());
        tempHouseholdInsurance.setEstateAddrZipCode(editedHouseholdInsurance.getEstateAddrZipCode());
        tempHouseholdInsurance.setEstatePrice(editedHouseholdInsurance.getEstatePrice());
        tempHouseholdInsurance.setEquipmentPrice(editedHouseholdInsurance.getEquipmentPrice());
    }

    private void editContract(Contract editedContract, Contract tempContract) {
        tempContract.setBeginDate(editedContract.getBeginDate());
        tempContract.setEndDate(editedContract.getEndDate());
        tempContract.setContractPrice(editedContract.getContractPrice());
        tempContract.setMonthlyFee(editedContract.getMonthlyFee());
    }
}

