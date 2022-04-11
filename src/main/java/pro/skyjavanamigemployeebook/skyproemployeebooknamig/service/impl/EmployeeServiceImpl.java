package pro.skyjavanamigemployeebook.skyproemployeebooknamig.service.impl;

import org.springframework.stereotype.Service;
import pro.skyjavanamigemployeebook.skyproemployeebooknamig.data.Employee;
import pro.skyjavanamigemployeebook.skyproemployeebooknamig.exception.EmployeeExistsException;
import pro.skyjavanamigemployeebook.skyproemployeebooknamig.exception.NotFound;
import pro.skyjavanamigemployeebook.skyproemployeebooknamig.service.EmployeeService;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> employees;

    public EmployeeServiceImpl() {
        employees = new HashMap<>();
    }

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee employeeNew = new Employee(firstName, lastName);

        if (employees.containsKey(firstName + lastName)) {
            throw new EmployeeExistsException("Ошибка! Не удалось создать сотрудника");
        }
        employees.put(firstName + lastName, employeeNew);
        return employeeNew;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        if (!employees.containsKey(firstName + lastName)) {

            throw new NotFound("Сотрудник не найден");
        }
        return employees.remove(firstName + lastName);
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        if (!employees.containsKey(firstName + lastName)) {
            throw new NotFound("Ошибка! Сотрудник не найден!");
        }
        return employees.get(firstName + lastName);
    }

    @Override
    public Collection<Employee> findAll() {
        return employees.values();
    }
}