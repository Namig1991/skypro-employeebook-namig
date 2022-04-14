package pro.skyjavanamigemployeebook.skyproemployeebooknamig.service.impl;


import org.springframework.stereotype.Service;
import pro.skyjavanamigemployeebook.skyproemployeebooknamig.data.Employee;
import pro.skyjavanamigemployeebook.skyproemployeebooknamig.service.EmployeeService;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class EmployeeServiceDepartmentImpl implements EmployeeServiceDepartment {

    private final EmployeeService employeeService;

    public EmployeeServiceDepartmentImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Optional<Employee> maxSalaryEmployeeInDepartment(Integer department) {
        return printDepartmentEmployee(department).stream()
                .max(Comparator.comparingInt(employee -> employee.getSalary()));
    }

    @Override
    public Optional<Employee> minSalaryEmployeeInDepartment(Integer department) {
        return printDepartmentEmployee(department).stream()
                .min(Comparator.comparingInt(employee -> employee.getSalary()));
    }

    @Override
    public Collection<Employee> printDepartmentEmployee(Integer department) {
        final Collection<Employee> allStuffDepartment = employeeService.findAll().stream()
                .filter(employee -> employee.getDepartmentId() == department)
                .collect(Collectors.toList());
        return allStuffDepartment;
    }

    @Override
    public String salaryInMonth(Integer department) {
        int costAmount = 0;
        double averageSalary = 0;
        final int sum = employeeService.findAll().stream()
                .filter(e -> e.getDepartmentId() == department).mapToInt(e -> e.getSalary()).sum();
        final int count = Math.toIntExact(employeeService.findAll().stream()
                .filter(e -> e.getDepartmentId() == department).count());
        costAmount = sum * 30;
        averageSalary = sum / count;
        return "Затраты в месяц на зарплату = " + costAmount +
                "рублей" + " Среднее значение зарплат = " + averageSalary + "рублей" + " В департаменте : " + department;
    }

    @Override
    public List<Employee> allStuff() {
        return employeeService.getEmployeeList();
    }
}