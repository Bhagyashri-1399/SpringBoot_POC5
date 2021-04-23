package com.neosoft.springboot.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.neosoft.springboot.Exception.RecordNotFoundException;

import com.neosoft.springboot.model.User;
import com.neosoft.springboot.repository.UserRepository;
import com.neosoft.springboot.service.UserService;



@Controller
@RequestMapping("/")
public class UserController 
{
	@Autowired
	UserService service;
	
	@Autowired
	UserRepository repository;

	@RequestMapping
	public String getAllUsers(@PageableDefault(size = 5)Pageable pageable, Model model) 
	{
		List<User> list = service.getAllUsers();

		model.addAttribute("Users", list);
		
		  Page<User> page = repository.findAll(pageable); 
		  model.addAttribute("page",page);
		 
		return "list-Users";
	}

	@RequestMapping(path = {"/edit", "/edit/{id}"})
	public String editUserById(Model model, @PathVariable("id") Optional<Long> id) 
							throws RecordNotFoundException 
	{
		if (id.isPresent()) {
			User entity = service.getUserById(id.get());
			model.addAttribute("User", entity);
		} else {
			model.addAttribute("User", new User());
		}
		return "add-edit-User";
	}
	
	@RequestMapping(path = "/delete/{id}")
	public String deleteUserById(Model model, @PathVariable("id") Long id) 
							throws RecordNotFoundException 
	{
		service.deleteUserById(id);
		return "redirect:/";
	}

	@RequestMapping(path = "/createUser", method = RequestMethod.POST)
	public String createOrUpdateUser(User User) 
	{
		service.createOrUpdateUser(User);
		return "redirect:/";
	}
	
	
	/*
	 * @GetMapping("/") public String getAllUsers(@PageableDefault(size = 10)
	 * Pageable pageable, Model model) { Page<User> page
	 * =repository.findAll(pageable); model.addAttribute("page", page); return
	 * "list-Users"; }
	 */
	 
	
}