package com.utkarsh.springboot.restapi.employee;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class EmployeeRESTController {

    private EmployeeService employeeService;

    public EmployeeRESTController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAllEmployees(){
        return this.employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee findEmployeedById(@PathVariable int employeeId){
        Employee employee =  this.employeeService.findById(employeeId);

        if(employee == null){
            throw new RuntimeException("Employee not found!!");
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee){
        // Set id to 0 to add new record
        //employee.setId(0);
        return this.employeeService.save(employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployeeById(@PathVariable Integer employeeId){

        Employee employee = this.employeeService.findById(employeeId);

        if(employee == null){
            throw new RuntimeException("Employeed with id " + employeeId + " doesn't exist!");
        }

        this.employeeService.delete(employeeId);

        return "Successfully deleted Employeed with id " + employeeId;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        return this.employeeService.save(employee);
    }
}
