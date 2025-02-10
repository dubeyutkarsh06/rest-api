package com.utkarsh.springboot.restapi.employee;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    public EmployeeDAO employeeDAO;
    public EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeDAO employeeDAO){
        this.employeeRepository = employeeRepository;
        this.employeeDAO = employeeDAO;
    }


    @Override
    public List<Employee> findAll() {
        return this.employeeRepository.findAll();
    }

    @Override
    public Employee findById(Integer id) {

        Optional<Employee> optionalEmployee = this.employeeRepository.findById(id);
        Employee result = null;
        if(optionalEmployee.isPresent()){
            result = optionalEmployee.get();
        }
        else{
            throw new RuntimeException("Employee with id " + id + " doesn't exist!");
        }

        return result;
    }

    // No need for Transactional as JPA repository provides it by default

    @Override
    public Employee save(Employee employee) {
        Employee empl = this.employeeRepository.save(employee);
        return empl;
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        this.employeeDAO.delete(id);
    }

    @Override
    public void deleteById(Integer id) {
        this.employeeRepository.deleteById(id);
    }
}
