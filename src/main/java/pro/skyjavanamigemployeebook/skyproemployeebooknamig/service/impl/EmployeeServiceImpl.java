package pro.skyjavanamigemployeebook.skyproemployeebooknamig.service.impl;

import org.springframework.stereotype.Service;
import pro.skyjavanamigemployeebook.skyproemployeebooknamig.service.EmployeeService;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    List<String> employeeList;

    public EmployeeServiceImpl() {
        employeeList = new ArrayList<>();
    }

    @Override
    public List<String> findAll() {
        return employeeList;
    }

    @Override
    public boolean addEmployee(String firstName, String lastName) {
        return employeeList.add(firstName);
    }

    @Override
    public boolean removeEmployee(String firstName, String lastName) {
        String deletedEmployee = String.valueOf(employeeList.remove(firstName));
        return deletedEmployee != null;
    }

    @Override
    public boolean findEmployee(String firstName, String lastName) {
        return false;
    }

}

