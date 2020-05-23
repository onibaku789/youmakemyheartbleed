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
import sk.fei.stuba.oop.zadanie3.model.user.User;
import sk.fei.stuba.oop.zadanie3.service.ContractService;
import sk.fei.stuba.oop.zadanie3.service.UserService;

import java.util.Objects;
import java.util.UUID;

@Controller
public class ContractController {
    private final Logger LOGGER = LoggerFactory.getLogger(ContractController.class);
    private final ContractService contractService;
    private final UserService userService;
    public ContractController(ContractService contractService, UserService userService) {
        this.contractService = contractService;
        this.userService = userService;
    }

    //TODO
    @GetMapping("/contracts/edit/{contractId}")
    public String editContract(@PathVariable String contractId, Model model) {
        Contract contract = contractService.getContractByContractId(contractId);
        LOGGER.warn("edit "+ contract.toString());
        model.addAttribute("item",contract);
        return "";
    }

    //TODO
    @PostMapping("/contracts/edit")
    public String updateContract(Contract item, Model model) {
        LOGGER.warn("Update " + item.toString());
        try{
            contractService.editContract(item);
            model.addAttribute("item", item);
            return "user/viewoneuser";
        }
        catch(IllegalArgumentException ex)
        {
            System.err.println("Contract Update ERROR");
            return "error";
        }
    }

    @GetMapping("/contracts/{userId}/add/{contractType}")
    public String addContract(Model model, @PathVariable String contractType,@PathVariable String userId) {
        LOGGER.warn("ADD CONTRACT userID:  " + userId);
        switch (ContractType.valueOf(contractType)) {
            case ESTATE:
                model.addAttribute("item", new EstateInsurance());
                model.addAttribute("userId", userId);
                return "redirect:/contracts/addEST/" + userId;
            case TRAVEL:
                model.addAttribute("item", new TravelInsurance());
                model.addAttribute("userId", userId);
                return "contract/add/addtravelins";
            case ACCIDENT:
                model.addAttribute("item", new AccidentInsurance());
                model.addAttribute("userId", userId);
                return "contract/add/addaccidentins";
            case HOUSEHOLD:
                model.addAttribute("item", new HouseholdInsurance());
                model.addAttribute("userId", userId);
                return "contract/add/addhouseholdins";
            default:
                throw new IllegalArgumentException("Invalid ContractType chosen.");
        }
    }

    //TODO
    @GetMapping("/contracts/addEST/{userId}")
    public String submitEstContract(@ModelAttribute("item") EstateInsurance item,
                                    @PathVariable("userId") String userId,
                                    Model model) {
        LOGGER.warn("submitContract " + item.toString());
        LOGGER.warn(model.toString());
        LOGGER.warn(userId);
        try {
            //TODO UPDATE USER CONTRACT LIST
            item.setUserId(userId);
            item.setContractId(UUID.randomUUID().toString());
            contractService.addNewContract(item);
            model.addAttribute("users",userService.getAllUser());
            LOGGER.warn(item.toString());
            return "redirect:/contracts/details/" + item.getContractId();
            //return "user/viewoneuser/";
        } catch (IllegalArgumentException ex) {
            System.err.println("SUBMIT CONTRACT ERROR");
            return "error";
        }
    }

    @PostMapping("/contracts/addACC")
    public String submitAccContract(@ModelAttribute("item") AccidentInsurance item, Model model) {
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

    @PostMapping("/contracts/addTRA")
    public String submitTraContract(@ModelAttribute("item") TravelInsurance item, Model model) {
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

    @PostMapping("/contracts/addHOU")
    public String submitHouContract(@ModelAttribute("item") HouseholdInsurance item, Model model) {
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

    @GetMapping("/contracts/details/{contractId}")
    public String detailedContract(@PathVariable String contractId, Model model) {
        //TODO
        model.addAttribute("contract",contractService.getContractByContractId(contractId));
        return "contract/view/viewestateins";
    }


}
