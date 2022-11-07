package spring.redis.crud.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import spring.redis.crud.app.model.Employee;
import spring.redis.crud.app.repository.EmployeeRepository;

@RestController
public class Controller {
	@Autowired
	public EmployeeRepository employeeRepository;
	@PostMapping("/employee")
	public Employee save(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}
	@GetMapping("/employee/{id}")
	public Employee get(@PathVariable String id) {
		return employeeRepository.findById(id).get();
	}
}
