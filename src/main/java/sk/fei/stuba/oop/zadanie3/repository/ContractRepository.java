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

    public boolean checkIfContractIdExists(UUID contractId) {
        return allContracts.containsKey(contractId);
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
        allContracts.replace(editedContract.getContractId(),tempContract);
        return tempContract;
    }

    public List<Contract> getAllContracts() {
        return new ArrayList<>(allContracts.values());
    }

    private void editEstateInsurance(Contract editedContract, Contract tempContract) {
        EstateInsurance editedEstateInsurance = (EstateInsurance) editedContract;
        EstateInsurance tempEstateInsurance = (EstateInsurance) tempContract;
        editedEstateInsurance.setEstateAddrHouseNumber(tempEstateInsurance.getEstateAddrHouseNumber());
        editedEstateInsurance.setEstateAddrStreet(tempEstateInsurance.getEstateAddrStreet());
        editedEstateInsurance.setEstateAddrTown(tempEstateInsurance.getEstateAddrTown());
        editedEstateInsurance.setEstateAddrZipCode(tempEstateInsurance.getEstateAddrZipCode());
        editedEstateInsurance.setEstatePrice(tempEstateInsurance.getEstatePrice());
        editedEstateInsurance.setEstateType(tempEstateInsurance.getEstateType());
        editedEstateInsurance.setGarage(tempEstateInsurance.isGarage());
    }

    private void editAccidentInsurance(Contract editedContract, Contract tempContract) {
        AccidentInsurance editedAccidentInsurance = (AccidentInsurance) editedContract;
        AccidentInsurance tempAccidentInsurance = (AccidentInsurance) tempContract;
        editedAccidentInsurance.setAccidentConseq(tempAccidentInsurance.getAccidentConseq());
        editedAccidentInsurance.setDailyCompens(tempAccidentInsurance.getDailyCompens());
        editedAccidentInsurance.setDeath(tempAccidentInsurance.getDeath());
        editedAccidentInsurance.setTerritorialValidity(tempAccidentInsurance.getTerritorialValidity());
    }

    private void editTravelInsurance(Contract editedContract, Contract tempContract) {
        TravelInsurance editedTravelInsurance = (TravelInsurance) editedContract;
        TravelInsurance tempTravelInsurance = (TravelInsurance) tempContract;
        editedTravelInsurance.setInEU(tempTravelInsurance.isInEU());
        editedTravelInsurance.setPurpose(tempTravelInsurance.getPurpose());
    }

    private void editHouseholdInsurance(Contract editedContract, Contract tempContract) {
        HouseholdInsurance editedHouseholdInsurance = (HouseholdInsurance) editedContract;
        HouseholdInsurance tempHouseholdInsurance = (HouseholdInsurance) tempContract;
        editedHouseholdInsurance.setEstateType(tempHouseholdInsurance.getEstateType());
        editedHouseholdInsurance.setEstateAddrHouseNumber(tempHouseholdInsurance.getEstateAddrHouseNumber());
        editedHouseholdInsurance.setEstateAddrStreet(tempHouseholdInsurance.getEstateAddrStreet());
        editedHouseholdInsurance.setEstateAddrTown(tempHouseholdInsurance.getEstateAddrTown());
        editedHouseholdInsurance.setEstateAddrZipCode(tempHouseholdInsurance.getEstateAddrZipCode());
        editedHouseholdInsurance.setEstatePrice(tempHouseholdInsurance.getEstatePrice());
        editedHouseholdInsurance.setEquipmentPrice(tempHouseholdInsurance.getEquipmentPrice());
    }


    private void editContract(Contract editedContract, Contract tempContract) {
        tempContract.setBeginDate(editedContract.getBeginDate());
        tempContract.setEndDate(editedContract.getEndDate());
        tempContract.setContractPrice(editedContract.getContractPrice());
        tempContract.setMonthlyFee(editedContract.getMonthlyFee());
    }
}

