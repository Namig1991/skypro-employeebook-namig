package pro.skyjavanamigemployeebook.skyproemployeebooknamig.service.impl;

import org.springframework.stereotype.Service;
import pro.skyjavanamigemployeebook.skyproemployeebooknamig.data.Employee;
import pro.skyjavanamigemployeebook.skyproemployeebooknamig.exception.EmployeeExistsException;
import pro.skyjavanamigemployeebook.skyproemployeebooknamig.exception.EmployeeIsFullException;
import pro.skyjavanamigemployeebook.skyproemployeebooknamig.exception.NotFound;
import pro.skyjavanamigemployeebook.skyproemployeebooknamig.service.EmployeeService;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    List<Employee> employees = List.of();
    static int counter = 0;

    @Override
    public List<Employee> findAll() {
        return employees;
    }

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        if (counter <= employees.size()) {
            for (int i = 0; i < employees.size(); i++) {
                if ((employees.get(i) != null) && employmentVerification(firstName, lastName, employees.get(i))) {
                    throw new EmployeeExistsException();
                }
            }
        } else {
            throw new EmployeeIsFullException();
        }
        int i = 0;
        while (employees.get(i) != null) {
            i++;
        }
        employees.set(i, new Employee(firstName, lastName));
        counter++;
        return employees.get(i);
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        for (int i = 0; i < employees.size(); i++) {
            if ((employees.get(i) != null) && employmentVerification(firstName, lastName, employees.get(i))) {
                employees.set(i, null);
                counter--;
                return new Employee(firstName, lastName);
            }
        }
        throw new NotFound();
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        boolean isFound = false;
        for (int i = 0; i < employees.size(); i++) {
            if ((employees.get(i) != null) && employmentVerification(firstName, lastName, employees.get(i))) {
                isFound = true;
            }
        }
        if (isFound == true) {
            return new Employee(firstName, lastName);
        } else throw new NotFound();
    }

    public boolean employmentVerification(String firstName, String lastName, Employee employee) {
        boolean answer = false;
        if (employee.getFirstName().equals(firstName) &&
                employee.getLastName().equals(lastName)) {
            answer = true;
        }
        return answer;
    }
}

