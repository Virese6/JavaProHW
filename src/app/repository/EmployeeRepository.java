package app.repository;

import app.domain.Employee;


public interface EmployeeRepository {
    Employee getById(Long id);

}
