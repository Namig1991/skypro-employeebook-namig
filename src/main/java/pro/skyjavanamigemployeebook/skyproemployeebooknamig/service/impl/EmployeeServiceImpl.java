package pro.skyjavanamigemployeebook.skyproemployeebooknamig.service.impl;

import org.springframework.stereotype.Service;
import pro.skyjavanamigemployeebook.skyproemployeebooknamig.data.Employee;
import pro.skyjavanamigemployeebook.skyproemployeebooknamig.exception.EmployeeExistsException;
import pro.skyjavanamigemployeebook.skyproemployeebooknamig.exception.NotFound;
import pro.skyjavanamigemployeebook.skyproemployeebooknamig.service.EmployeeService;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    public Map<String, Employee> employees;

    public EmployeeServiceImpl() {
        employees = new HashMap<>();
    }

    private String getKey(String firstName, String lastName) {
        return firstName + lastName;
    }

    @Override
    public Employee addEmployee(String firstName, String lastName, Integer salary, Integer department) {
        Employee employeeNew = new Employee(firstName, lastName, salary, department);
        if (employees.containsKey(getKey(firstName, lastName))) {
            throw new EmployeeExistsException("Ошибка! Не удалось создать сотрудника");
        }
        employees.put(getKey(firstName, lastName), employeeNew);
        return employeeNew;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        if (!employees.containsKey(getKey(firstName, lastName))) {
            throw new NotFound("Сотрудник не найден");
        }
        return employees.remove(getKey(firstName, lastName));
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        if (!employees.containsKey(getKey(firstName, lastName))) {
            throw new NotFound("Ошибка! Сотрудник не найден!");
        }
        return employees.get(getKey(firstName, lastName));
    }

    @Override
    public Collection<Employee> findAll() {
        return employees.values();
    }
}