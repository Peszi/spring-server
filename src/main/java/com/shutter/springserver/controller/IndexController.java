package com.shutter.springserver.controller;

import com.shutter.springserver.dto.UserDTO;
import com.shutter.springserver.service.user.ManageUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Controller
public class IndexController {

    private ManageUserService manageUserService;

    public IndexController(ManageUserService manageUserService) {
        this.manageUserService = manageUserService;
    }

    @GetMapping("/index")
    public String getIndex(@ModelAttribute UserDTO userDTO) {
        return "index";
    }

    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute UserDTO userDTO, BindingResult binding, Model model) {
        model.addAttribute(userDTO);
        if (binding.hasErrors())
            model.addAttribute("messages", this.getFieldErrorMessage(binding.getFieldErrors()));
        else {
            this.manageUserService.registerUser(userDTO);
            model.addAttribute("messages", new String[]{"Success!"});
        }
        return "index";
    }

    private String[] getFieldErrorMessage(List<FieldError> fieldErrorsList) {
        final String[] errorMessages = new String[fieldErrorsList.size()];
        for (int i = 0; i < errorMessages.length; i++)
            errorMessages[i] = "'" + fieldErrorsList.get(i).getField() + "' " + fieldErrorsList.get(i).getDefaultMessage();
        return errorMessages;
    }
}
