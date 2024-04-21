package app.service;

import app.domain.Employee;
import app.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
@PropertySource("classpath:application.properties")
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepository employeeRepository;
    private String salaryCurrency;

    public EmployeeServiceImpl(@Qualifier("employeeRepositoryImplMap") EmployeeRepository employeeRepository,
                               @Value("${salary.currency}") String salaryCurrency) {
        this.employeeRepository = employeeRepository;
        this.salaryCurrency = salaryCurrency;
    }

    @Override
    public Employee getById(Long id) {
        Employee employee = employeeRepository.getById(id);
        setSalary(employee);
        return employee;
    }

    @Override
    public void setSalary(Employee employee) {
        System.out.println("Enter the salary");
        Scanner scanner = new Scanner(System.in);
        String salary = String.format("%s %s",scanner.nextInt(), salaryCurrency);
        employee.setSalary(salary);
        scanner.close();
    }
}
