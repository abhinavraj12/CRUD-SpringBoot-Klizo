package com.klizo.crud.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klizo.crud.assignment.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}
