package pro.skyjavanamigemployeebook.skyproemployeebooknamig.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.skyjavanamigemployeebook.skyproemployeebooknamig.data.Employee;
import pro.skyjavanamigemployeebook.skyproemployeebooknamig.service.impl.DepartmentService;

import java.util.Collection;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/departments")
public class DepartmentController {

    public final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/all")
    public List<Employee> allStuff(){
        return departmentService.allStuff();
    }

    @GetMapping("/max-salary")
    public Optional<Employee> maxSalaryEmployeeInDepartment(@RequestParam Integer departmentId){
        return departmentService.maxSalaryEmployeeInDepartment(departmentId);
    }

    @GetMapping("/min-salary")
    public Optional<Employee> minSalaryEmployeeInDepartment(@RequestParam Integer departmentId){
        return departmentService.minSalaryEmployeeInDepartment(departmentId);
    }

    @GetMapping(name="/all", params = {"departmentId"})
    public Collection<Employee> allStuff(@RequestParam Integer departmentId){
        return departmentService.printDepartmentEmployee(departmentId);
    }

    @GetMapping(name ="/expenses", params = {"departmentsId"})
    public String expensesForSalaryInMonth(@RequestParam Integer departmentId) {
        return departmentService.salaryInMonth(departmentId);
    }
}
