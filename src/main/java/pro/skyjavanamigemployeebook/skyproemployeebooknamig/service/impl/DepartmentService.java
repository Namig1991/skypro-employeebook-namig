package pro.skyjavanamigemployeebook.skyproemployeebooknamig.service.impl;


import pro.skyjavanamigemployeebook.skyproemployeebooknamig.data.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface DepartmentService {

//    Optional<Employee> maxSalaryEmployeeInDepartment(Integer department);

    Employee maxSalaryEmployeeInDepartment(int departmentId);

//    Optional<Employee> minSalaryEmployeeInDepartment(Integer department);

    Employee minSalaryEmployeeInDepartment(int departmentId);

    Collection<Employee> printDepartmentEmployee(Integer department);

    String salaryInMonth(Integer department);

    Map<Integer, List<Employee>> findEmployeesByDepartment();
}
