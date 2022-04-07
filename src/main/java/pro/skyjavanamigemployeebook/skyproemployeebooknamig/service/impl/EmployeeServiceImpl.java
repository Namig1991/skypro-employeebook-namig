package pro.skyjavanamigemployeebook.skyproemployeebooknamig.service.impl;

import org.springframework.stereotype.Service;
import pro.skyjavanamigemployeebook.skyproemployeebooknamig.data.Employee;
import pro.skyjavanamigemployeebook.skyproemployeebooknamig.exception.NotFound;
import pro.skyjavanamigemployeebook.skyproemployeebooknamig.service.EmployeeService;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
   private final List<Employee> employeeList = new ArrayList<>();

    @Override
    public boolean addEmployee(String firstName, String lastName) {
        return employeeList.add(new Employee(firstName, lastName));
    }

    @Override
    public Employee findEmployee(String firstName, String lastName){
        Employee employee = new Employee(firstName, lastName);
        if(employeeList.contains(employee)){
            return employee;
        }
        throw new NotFound("Ошибка! Сотруник не найден.");
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName,lastName);
        if(employeeList.contains(employee)){
            employeeList.remove(employee);
            return employee;
        }
        throw new NotFound("Ошибка! Сотруник не найден!");
    }

    @Override
    public List<Employee> findAll() {
        return employeeList;
    }
}

