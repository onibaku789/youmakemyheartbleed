package sk.fei.stuba.oop.zadanie3.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import sk.fei.stuba.oop.zadanie3.model.contract.Contract;
import sk.fei.stuba.oop.zadanie3.model.contract.ContractType;
import sk.fei.stuba.oop.zadanie3.model.contract.lifeinsurance.accidentinsurance.AccidentInsurance;
import sk.fei.stuba.oop.zadanie3.model.contract.lifeinsurance.travelinsurance.TravelInsurance;
import sk.fei.stuba.oop.zadanie3.model.contract.nonlifeinsurance.estateinsurance.EstateInsurance;
import sk.fei.stuba.oop.zadanie3.model.contract.nonlifeinsurance.householdinsurance.HouseholdInsurance;
import sk.fei.stuba.oop.zadanie3.service.ContractService;

import java.util.UUID;

@Controller
public class ContractController {
    private final Logger LOGGER = LoggerFactory.getLogger(ContractController.class);
    private final ContractService contractService;

    public ContractController(ContractService contractService) {
        this.contractService = contractService;
    }

    @GetMapping("/contracts/edit/{id}")
    public String editContract(@PathVariable UUID contractId, Model model) {
        //TODO
        return "";
    }

    @PostMapping("/contracts/edit")
    public String updateContract(Model model) {
        //TODO
        return "";
    }

    @GetMapping("/contracts/add/{contractType}")
    public String addContract(Model model, @PathVariable String contractType) {
        switch (ContractType.valueOf(contractType)) {
            case ESTATE:
                model.addAttribute("item", new EstateInsurance());
                return "contract/add/addestateins";
            case TRAVEL:
                model.addAttribute("item", new TravelInsurance());
                return "contract/add/addtravelins";
            case ACCIDENT:
                model.addAttribute("item", new AccidentInsurance());
                return "contract/add/addaccidentins";
            case HOUSEHOLD:
                model.addAttribute("item", new HouseholdInsurance());
                return "contract/add/addhouseholdins";
            default:
                throw new IllegalArgumentException("Invalid ContractType chosen.");

        }
    }

    @PostMapping("/contracts/addEST")
    public String submitEstContract(@ModelAttribute("item") EstateInsurance item, Model model) {
        LOGGER.warn("submitContract " + item.toString());
        try {
            //TODO UPDATE USER CONTRACT LIST
            item.setContractId(UUID.randomUUID().toString());
            contractService.addNewContract(item);
            return "redirect:/contracts/details/" + item.getContractId();
        } catch (IllegalArgumentException ex) {
            System.err.println("SUBMIT CONTRACT ERROR");
            return "error";
        }
    }

    @GetMapping("/contracts/details/{id}")
    public String detailedContract(@PathVariable UUID contractId, Model model) {
        //TODO
        return "";
    }


}
