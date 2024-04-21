package app.service;

import app.domain.Employee;

public interface EmployeeService {
    Employee getById(Long id);
    void setSalary(Employee employee);
}
