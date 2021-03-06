package pro.skyjavanamigemployeebook.skyproemployeebooknamig.service.impl;


import org.springframework.stereotype.Service;
import pro.skyjavanamigemployeebook.skyproemployeebooknamig.data.Employee;
import pro.skyjavanamigemployeebook.skyproemployeebooknamig.service.EmployeeService;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.groupingBy;


@Service
public class DepartmentServiceImpl implements DepartmentService {


    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Optional<Employee> maxSalaryEmployeeInDepartment(Integer department) {
        return printDepartmentEmployee(department).stream()
                .max(Comparator.comparingInt(Employee::getSalary));
    }

    @Override
    public Optional<Employee> minSalaryEmployeeInDepartment(Integer department) {
        return printDepartmentEmployee(department).stream()
                .min(Comparator.comparingInt(Employee::getSalary));
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
                .filter(e -> e.getDepartmentId() == department).mapToInt(Employee::getSalary).sum();
        final int count = Math.toIntExact(employeeService.findAll().stream()
                .filter(e -> e.getDepartmentId() == department).count());
        costAmount = sum * 30;
        averageSalary = sum / count;
        return "Затраты в месяц на зарплату = " + costAmount +
                "рублей" + " Среднее значение зарплат = " + averageSalary + "рублей" + " В департаменте : " + department;
    }

    @Override
    public Map<Integer, List<Employee>> findEmployeesByDepartment() {
        return employeeService.findAll().stream()
                .sorted(comparing(Employee::getLastName).thenComparing(Employee::getFirstName))
                .collect(groupingBy(Employee::getDepartmentId));
    }
}