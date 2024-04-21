package app.controller;

import app.domain.Employee;
import app.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeController {

    @Autowired
    public EmployeeServiceImpl employeeService;

    public Employee getById(Long id){
       return employeeService.getById(id);
    }
}
