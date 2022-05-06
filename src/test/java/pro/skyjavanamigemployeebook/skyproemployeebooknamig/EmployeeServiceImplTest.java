package pro.skyjavanamigemployeebook.skyproemployeebooknamig;

import org.junit.jupiter.api.Test;
import pro.skyjavanamigemployeebook.skyproemployeebooknamig.data.Employee;
import pro.skyjavanamigemployeebook.skyproemployeebooknamig.service.impl.EmployeeServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class EmployeeServiceImplTest {
    private final EmployeeServiceImpl out = new EmployeeServiceImpl();


    @Test
    public void addEmployeeTest(){
        Employee employee = new Employee("Ivan", "Ivanov", 90000, 1);
        assertEquals(employee, out.addEmployee("Ivan", "Ivanov", 90000, 1));
    }

    @Test
    public void removeEmployeeTest(){
        Employee employee = new Employee("Petr", "Petrov", 80000, 2);
        out.addEmployee("Petr", "Petrov", 80000, 2);
        assertEquals(employee, out.removeEmployee("Petr", "Petrov"));
    }

    @Test
    public void findEmployeeTest(){
        Employee employee = new Employee("Oleg", "Ivanov", 90000, 1);
        out.addEmployee("Oleg", "Ivanov", 90000, 1);
        assertEquals(employee, out.findEmployee("Oleg", "Ivanov"));
    }
}
