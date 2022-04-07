package pro.skyjavanamigemployeebook.skyproemployeebooknamig.service;

import pro.skyjavanamigemployeebook.skyproemployeebooknamig.data.Employee;


import java.util.List;

public interface EmployeeService {

    boolean addEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    Employee removeEmployee(String firstName, String lastName);

    List<Employee> findAll();
}

