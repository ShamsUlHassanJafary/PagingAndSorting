package com.example.PagginationExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.PageRequest;

import com.example.PagginationExample.repo.UserRepo;
import java.util.*;
import com.example.PagginationExample.entities.*;

@SpringBootApplication
@RestController
public class PagginationExampleApplication {

	@Autowired
	private UserRepo repo;

	@GetMapping("/listOfUser/{pageNo}/{pageSize}") // localhost:8080/listOfUser/0/3
	public List<User> listOfUsers(@PathVariable int pageNo, @PathVariable int pageSize) {

		Pageable paging = PageRequest.of(
				pageNo, pageSize, Sort.by("id").ascending());

		Page<User> page = repo.findAll(paging);

		// Retrieve the items
		return page.getContent();

	}

	public static void main(String[] args) {
		SpringApplication.run(PagginationExampleApplication.class, args);
	}

}
