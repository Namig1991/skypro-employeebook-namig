package pro.skyjavanamigemployeebook.skyproemployeebooknamig.service.impl;


import pro.skyjavanamigemployeebook.skyproemployeebooknamig.data.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface EmployeeServiceDepartment {

    Optional<Employee> maxSalaryEmployeeInDepartment(Integer department);

    Optional<Employee> minSalaryEmployeeInDepartment(Integer department);

    Collection<Employee> printDepartmentEmployee(Integer department);

    String salaryInMonth(Integer department);

    List<Employee> allStuff();
}
