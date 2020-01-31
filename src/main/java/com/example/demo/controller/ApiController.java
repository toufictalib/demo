package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.GeneralRepositoryImp;

@RestController
@RequestMapping("/")
public class ApiController {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	GeneralRepositoryImp generalRepositoryImp;

	@GetMapping(value = "/home/{name}")
	public String helloWorld(@PathVariable(value = "name") String name) {
		Optional<Customer> findME = customerRepository.findME(name);
		return findME.isPresent() ? findME.get().getName() : "NONE";
	}

	@GetMapping(value = "/home")
	public String helloWorld1(@RequestParam(value = "name") String name) {
		Optional<Customer> findME = customerRepository.findME(name);
		return findME.isPresent() ? findME.get().getName() : "NONE";
	}
}
