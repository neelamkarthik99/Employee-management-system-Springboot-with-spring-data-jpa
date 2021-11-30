package com.employees.crudspringboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employees.crudspringboot.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>
{

}
