package com.example.demo.controller;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exceptions.EmployeeNotFound;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

import lombok.AllArgsConstructor;

@RestController //@Controller + @ResponseBody
@RequestMapping("/employees")
@AllArgsConstructor
public class EmployeeController { // http://localhost:1234/employees(class level url)

	
	EmployeeService service;

	@GetMapping("/message")
	public String getMessage() {
		return "we are getting sleep!!";
	}

	@PostMapping("/save") // http://localhost:1234/employees/save(method level url)
	public String createEmployee(@RequestBody @Validated Employee employee) {
		return service.saveEmployee(employee);
	}
	@PutMapping("/update")
	public String updateEmp(@RequestBody Employee employee) {
		return service.updateEmployee(employee);
	}
	@DeleteMapping("/delete/{id}")
	public String removeEmployee(@PathVariable("id")  int empId) {
		return service.deleteEmployee(empId);
	}
	@GetMapping("/fetch/{id}")
	public Employee getEmployee(@PathVariable("id") int empId) throws EmployeeNotFound {
		return service.getEmployee(empId);
	}
	@GetMapping("/fetchAll")
	public List<Employee> fetchAllEmployees() {
		return service.getAllEmployees();
	}
	@GetMapping("/fetchAllDesg/{empDesg}")
	public List<Employee> getAllEmployeeDesg(@PathVariable("empDesg")  String empDesg) {
		return service.getEmployeesByDesg(empDesg);
	}
	@GetMapping("/fetchAllBetween")
	public List<Employee> getAllEmployeeBtwn(@RequestParam("sal1") int initialSal, @RequestParam("sal2") int finalSal) {
		return service.getEmployeesBetweenSal(initialSal, finalSal);
	}
	
	
}
