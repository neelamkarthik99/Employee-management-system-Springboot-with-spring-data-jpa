package com.employees.crudspringboot.service;

import java.util.List;
import java.util.Optional;

import com.employees.crudspringboot.entity.Employee;

public interface EmployeeService 
{
	public List<Employee> getEmployees();
	
	public void deleteEmployee(int id);
	
	public void saveEmployee(Employee employee);

	public Optional<Employee> getEmployee(int id);

	public void updateEmployee(Employee employee);
}
