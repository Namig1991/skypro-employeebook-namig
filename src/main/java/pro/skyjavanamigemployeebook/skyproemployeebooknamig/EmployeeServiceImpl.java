package pro.skyjavanamigemployeebook.skyproemployeebooknamig;

import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    Employee[] employees = new Employee[6];
    static int counter = 0;

    @Override
    public Employee[] findAll() {
        return employees;
    }

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        if (counter <= employees.length) {
            for (int i = 0; i < employees.length; i++) {
                if ((employees[i] != null) && employmentVerification(firstName, lastName, employees[i])) {
                    throw new EmployeeExistsException();
                }
            }
        } else {
            throw new EmployeeIsFullException();
        }
        int i = 0;
        while (employees[i] != null) {
            i++;
        }
        employees[i] = new Employee(firstName, lastName);
        counter++;
        return employees[i];
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        for (int i = 0; i < employees.length; i++) {
            if ((employees[i] != null) && employmentVerification(firstName, lastName, employees[i])) {
                employees[i] = null;
                counter--;
                return new Employee(firstName, lastName);
            }
        }
        throw new NotFound();
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        boolean isFound = false;
        for (int i = 0; i < employees.length; i++) {
            if ((employees[i] != null) && employmentVerification(firstName, lastName, employees[i])) {
                isFound = true;
            }
        }
        if (isFound == true) {
            return new Employee(firstName, lastName);
        } else throw new NotFound();
    }

    public boolean employmentVerification(String firstName, String lastName, Employee employee) {
        boolean answer = false;
        if (employee.getFirstName().equals(firstName) &&
                employee.getLastName().equals(lastName)) {
            answer = true;
        }
        return answer;
    }
}

