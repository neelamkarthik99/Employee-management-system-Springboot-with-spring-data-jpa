package com.employees.crudspringboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.employees.crudspringboot.entity.Employee;
import com.employees.crudspringboot.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController 
{
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Employee> getEmployees()
	{
		return employeeService.getEmployees();
	}
	
	@GetMapping("/employees/{id}")
	public Optional<Employee> getEmployee(@PathVariable int id)
	{
		Optional<Employee> employee = employeeService.getEmployee(id);
		if(employee==null)
		{
			throw new EmployeeNotFoundException("id - "+ id +" not found");
		}
		return employeeService.getEmployee(id);
	}
	
	@PostMapping("/employees")
	public Employee saveEmployee(@RequestBody Employee employee)
	{
		employee.setId(0);
		employeeService.saveEmployee(employee);
		return employee;
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee)
	{
		employeeService.updateEmployee(employee);
		return employee;
	}
	
	@DeleteMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable int id)
	{
		employeeService.deleteEmployee(id);
		return "id: "+id+" deleted";
	}
	
}
