package pro.skyjavanamigemployeebook.skyproemployeebooknamig;

import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.skyjavanamigemployeebook.skyproemployeebooknamig.data.Employee;
import pro.skyjavanamigemployeebook.skyproemployeebooknamig.exception.NotFound;
import pro.skyjavanamigemployeebook.skyproemployeebooknamig.service.impl.DepartmentServiceImpl;
import pro.skyjavanamigemployeebook.skyproemployeebooknamig.service.impl.EmployeeServiceImpl;
import org.junit.jupiter.params.provider.Arguments;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class DepartmentServiceImplTest {

    private Employee employee;

    @Mock
    private EmployeeServiceImpl employeeService;

    @InjectMocks
    private DepartmentServiceImpl out;

    private static List<Employee> employees = List.of(
            new Employee("Ivan", "Ivanov", 90000, 1),
            new Employee("Petr", "Petrov", 80000, 1),
            new Employee("Victor", "Sidorov", 70000, 2),
            new Employee("Renat", "Orlov", 60000, 2));

    private static Stream<Arguments> maxSalaryEmployeeInDepartmentTest(){
        return Stream.of(
                Arguments.of(1, 90000, employees),
                Arguments.of(1, 80000, employees)
        );
    }


    @ParameterizedTest
    @MethodSource("maxSalaryEmployeeInDepartmentTest")
    public void paramsForTestMaxSalaryInDepartment(int departmentId){
        when(employeeService.findAll()).thenReturn(employees);
        assertEquals(new Employee("Ivan", "Ivanov", 90000, 1 ),
                out.maxSalaryEmployeeInDepartment(departmentId));
    }

    private static Stream<Arguments> minSalaryEmployeeInDepartmentTest(){
        return Stream.of(
                Arguments.of(1, 90000, employees),
                Arguments.of(1, 80000, employees)
        );
    }

    @ParameterizedTest
    @MethodSource("minSalaryEmployeeInDepartmentTest")
    public void paramsForTestMinSalaryInDepartment(int departmentID){
        when(employeeService.findAll()).thenReturn(employees);
        assertEquals(new Employee("Petr", "Petrov", 80000, 1),
                out.minSalaryEmployeeInDepartment(departmentID));
    }

    @Test
    public void checkingIfAnEmployeeIsOnTheList(){
        Employee testEmployee = employeeService.addEmployee("Petr", "Petrov", 80000, 1);
        assertEquals(testEmployee, employeeService.findEmployee("Petr", "Petrov"));
    }

    @Test
    public void checkingEmployeeIsNotOnTheList(){
        assertEquals(0, employeeService.findAll().size());
        assertThrows(NotFound.class, () -> employeeService.findAll());
    }

}
