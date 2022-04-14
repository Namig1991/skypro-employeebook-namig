package pro.skyjavanamigemployeebook.skyproemployeebooknamig.controller;

import org.springframework.web.bind.annotation.*;
import pro.skyjavanamigemployeebook.skyproemployeebooknamig.data.Employee;
import pro.skyjavanamigemployeebook.skyproemployeebooknamig.service.EmployeeService;

import java.util.Collection;


@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/hello")
    public String answerHello() {
        return "<b>Добро пожаловать в книгу учета сотрудников!</b>";
    }

    @GetMapping("/add")
    public Employee addEmployeeToList(@RequestParam String firstName,
                                      @RequestParam String lastName,
                                      @RequestParam Integer salary,
                                      @RequestParam Integer department) {
        Employee result = employeeService.addEmployee(firstName, lastName, salary, department);
        return result;
    }

    @GetMapping("/remove")
    public Employee removeEmployeeFromList(@RequestParam String firstName, @RequestParam String lastName) {
        Employee result = employeeService.removeEmployee(firstName, lastName);
        return result;
    }

    @GetMapping("/find")
    public Employee findEmployeeInList(@RequestParam String firstName, @RequestParam String lastName) {
        Employee result = employeeService.findEmployee(firstName, lastName);
        return result;
    }

    @GetMapping("/allStuff")
    public Collection<Employee> findAll() {
        return employeeService.findAll();
    }

}