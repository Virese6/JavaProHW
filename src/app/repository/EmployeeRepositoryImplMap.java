package app.repository;

import app.domain.Employee;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeRepositoryImplMap implements EmployeeRepository {

    Map<Long, Employee> database = new HashMap<>();

    public EmployeeRepositoryImplMap() {
        database.put(1L, new Employee(1L, "Master Chief", "BackEnd"));
        database.put(2L, new Employee(2L, "Lara Croft", "FrontEnd"));
        database.put(3L, new Employee(3L, "John Marston", "Sales"));
    }

    @Override
    public Employee getById(Long id) {
        return database.get(id);
    }
}
