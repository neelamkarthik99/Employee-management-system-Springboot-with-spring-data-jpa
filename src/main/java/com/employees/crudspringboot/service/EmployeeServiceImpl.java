package com.employees.crudspringboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.employees.crudspringboot.dao.EmployeeRepository;
import com.employees.crudspringboot.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService
{
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getEmployees() 
	{
		return employeeRepository.findAll();
	}

	@Override
	public void deleteEmployee(int id) 
	{
		employeeRepository.deleteById(id);
	}

	@Override
	public void saveEmployee(Employee employee) 
	{
		employeeRepository.save(employee);
	}

	@Override
	public Optional<Employee> getEmployee(int id) 
	{
		return employeeRepository.findById(id);
	}

	@Override
	public void updateEmployee(Employee employee) 
	{
		employeeRepository.save(employee);
	}

}
