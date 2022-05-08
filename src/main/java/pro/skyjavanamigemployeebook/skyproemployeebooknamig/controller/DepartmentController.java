package pro.skyjavanamigemployeebook.skyproemployeebooknamig.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.skyjavanamigemployeebook.skyproemployeebooknamig.data.Employee;
import pro.skyjavanamigemployeebook.skyproemployeebooknamig.service.impl.DepartmentService;

import java.util.Collection;


@RestController
@RequestMapping("/departments")
public class DepartmentController {

    public final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/all")
    public Employee allStuff() {
        Employee result = (Employee) departmentService.findEmployeesByDepartment();
        return result;
    }

    @GetMapping("/max-salary")
    public Employee maxSalaryEmployeeInDepartment(@RequestParam Integer departmentId) {
        Employee result = departmentService.maxSalaryEmployeeInDepartment(departmentId);
        return result;
    }

    @GetMapping("/min-salary")
    public Employee minSalaryEmployeeInDepartment(@RequestParam Integer departmentId) {
        Employee result = departmentService.minSalaryEmployeeInDepartment(departmentId);
        return result;
    }

    @GetMapping(name = "/all", params = {"departmentId"})
    public Collection<Employee> allStuff(@RequestParam Integer departmentId) {
        return departmentService.printDepartmentEmployee(departmentId);
    }

    @GetMapping(name = "/expenses", params = {"departmentsId"})
    public String expensesForSalaryInMonth(@RequestParam Integer departmentId) {
        return departmentService.salaryInMonth(departmentId);
    }
}
