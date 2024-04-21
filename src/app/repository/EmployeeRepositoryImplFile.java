package app.repository;

import app.domain.Employee;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Primary
@Repository
public class EmployeeRepositoryImplFile implements EmployeeRepository {
    @Override
    public Employee getById(Long id) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("database.txt"))) {
            return bufferedReader.lines()
                    .filter(x -> x.split(";")[0].equals(id.toString()))
                    .limit(1)
                    .map(x -> {
                        String[] values = x.split(";");
                        return new Employee(id,values[1],values[2]);
                    })
                    .findFirst()
                    .orElse(null);
        } catch (IOException e){
            throw new RuntimeException();
        }
    }
}
