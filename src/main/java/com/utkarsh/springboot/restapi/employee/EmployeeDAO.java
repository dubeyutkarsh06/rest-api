package com.utkarsh.springboot.restapi.employee;

import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface EmployeeDAO {

    public List<Employee> findAll();

    public Employee findById(Integer id);

    public Employee save(Employee employee);

    public void delete(Integer id);
}
