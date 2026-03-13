package com.example.demo.service;

import java.util.List;

import com.example.demo.exceptions.EmployeeNotFound;
import com.example.demo.model.Employee;

public interface EmployeeService {
	public abstract String saveEmployee(Employee employee);

	public abstract String updateEmployee(Employee employee);

	public abstract String deleteEmployee(int empId);

	public abstract Employee getEmployee(int empId) throws EmployeeNotFound;

	public abstract List<Employee> getAllEmployees();

	public abstract List<Employee> getEmployeesByDesg(String empDesg);

	public abstract List<Employee> getEmployeesBetweenSal(int initialSal, int finalSal);
}
