package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.ServicesImpl.LoginServiceImpl;
import com.example.demo.entities.Categorie;
import com.example.demo.services.CategorieService;
import com.example.demo.services.ClientService;
import com.example.demo.services.LoginService;
import com.example.demo.userDTO.UserDTO;

@Controller
@RequestMapping("/inscription")
public class InscriptionController {


	public InscriptionController(LoginService loginser) {
		super();
		this.loginser = loginser;
	}

	@Autowired
	private ClientService clientService;

	  @Autowired
	 private LoginService loginser;
	public InscriptionController(ClientService clientService) {
		super();
		this.clientService = clientService;
	}
	
	
	
	public InscriptionController() {
		super();
	}




	public InscriptionController(ClientService clientService, LoginService loginser) {
		super();
		this.clientService = clientService;
		this.loginser = loginser;
	}



	@ModelAttribute("user")
	public UserDTO UserDTOinscription()
	{
		return new UserDTO();
	}
	
	@GetMapping
	public String ShowinscriptionForm()
	{
		return "inscription";
	}

	@PostMapping
	public String inscriptionClientAccount (@ModelAttribute("user") UserDTO userdto)
	{
		
		loginser.saveLogin(userdto);
		clientService.saveClient(userdto);
		
		return "redirect:/inscription?succes";
	}
}
