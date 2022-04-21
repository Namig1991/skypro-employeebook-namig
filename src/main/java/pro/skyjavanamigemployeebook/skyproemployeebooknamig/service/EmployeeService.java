package pro.skyjavanamigemployeebook.skyproemployeebooknamig.service;

import pro.skyjavanamigemployeebook.skyproemployeebooknamig.data.Employee;

import java.util.Collection;


public interface EmployeeService {

    Employee addEmployee(String firstName, String lastName, Integer salary, Integer department);

    Employee removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    Collection<Employee> findAll();

}



