package pro.skyjavanamigemployeebook.skyproemployeebooknamig.service;

import java.util.List;

public interface EmployeeService {
    boolean addEmployee(String firstName, String lastName);

    boolean removeEmployee(String firstName, String lastName);

    boolean findEmployee(String firstName, String lastName);

    List<String> findAll();
}
