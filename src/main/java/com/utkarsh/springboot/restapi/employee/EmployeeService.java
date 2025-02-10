package com.utkarsh.springboot.restapi.employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> findAll();

    public Employee findById(Integer id);

    public Employee save(Employee employee);

    public void delete(Integer id);

    public void deleteById(Integer id);
}
