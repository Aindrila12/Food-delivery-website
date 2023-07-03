package com.example.fooddeliverywebsite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.fooddeliverywebsite.dao.RegisterRepo;
import com.example.fooddeliverywebsite.model.Register;


@Controller
public class HomeController {
	@Autowired
	RegisterRepo registerRepo;
	
	@RequestMapping("/")
	public String homePage() {
		return "home.jsp";
	}
	
	@RequestMapping("/register")
	public String addDetail(Register register) {
		registerRepo.save(register);
		return "login.jsp";
	}
	
	@RequestMapping("/login")
    public String login(@RequestParam("emailId") String emailId, @RequestParam("password") String password) {
        Register register = registerRepo.findByEmailId(emailId);
        if (register != null && register.getPassword().equals(password)) {
            return "home.jsp";
        } else {
            return "login.jsp";
        }
    }

}
