package sk.fei.stuba.oop.zadanie3.service;


import org.springframework.stereotype.Service;
import sk.fei.stuba.oop.zadanie3.model.contract.Contract;
import sk.fei.stuba.oop.zadanie3.model.user.User;
import sk.fei.stuba.oop.zadanie3.repository.ContractRepository;
import sk.fei.stuba.oop.zadanie3.repository.UserRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ContractService {
    private final ContractRepository contractRepository;
    private final UserRepository userRepository;

    public ContractService(ContractRepository contractRepository, UserRepository userRepository) {
        this.contractRepository = contractRepository;
        this.userRepository = userRepository;
    }

    public List<Contract> getAllContracts() {
        return contractRepository.getAllContracts();
    }

    public List<Contract> getContractsByUserId(String userId) {
        return contractRepository.getContractByUserId(userId);
    }

    public void addNewContract(Contract contract) {
        try {
            checkIfContractIsValid(contract);
            contractRepository.addContract(contract);
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public Contract editContract(Contract contract) {
        // edit contract by contract id
        User user = userRepository.getUserById(contract.getUserId());
        List<Contract> userContractList = user.getListOfContracts();
        List<Contract> editedUserContractList = userContractList.stream().filter(contract1 ->
                !contract1.getContractId().equals(contract.getContractId())).collect(Collectors.toList());

        Contract editedContract = contractRepository.editContract(contract);
        editedUserContractList.add(editedContract);
        user.setListOfContracts(editedUserContractList);
        userRepository.editUser(user);
        return editedContract;
    }

    public Contract getContractByContractId(String id){
        return contractRepository.getContractByContractId(id);
    }

    private void checkIfContractIsValid(Contract contract) {
        if (contract == null || contract.getUserId() == null) {
            System.out.println(contract);
            throw new IllegalArgumentException("Not valid contract, cant be added.");
        }
    }

}
