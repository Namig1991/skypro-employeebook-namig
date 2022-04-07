package pro.skyjavanamigemployeebook.skyproemployeebooknamig.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.skyjavanamigemployeebook.skyproemployeebooknamig.data.Employee;
import pro.skyjavanamigemployeebook.skyproemployeebooknamig.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/hello")
    public String answerHello() {
        return "<b>Добро пожаловать в книгу учета сотрудников!</b>";
    }

    @GetMapping("/add")
    public boolean addEmployeeToList(@RequestParam String firstName, @RequestParam String lastName) {
        boolean result = employeeService.addEmployee(firstName, lastName);
        return result;
    }

    @GetMapping("/find")
    public Employee findEmployeeInList(@RequestParam String firstName, @RequestParam String lastName) {
        Employee result = employeeService.findEmployee(firstName, lastName);
        return result;
    }

    @GetMapping("/remove")
    public Employee removeEmployeeFromList(@RequestParam String firstName, @RequestParam String lastName) {
        Employee result = employeeService.removeEmployee(firstName, lastName);
        return result;
    }

    @GetMapping("/all")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

}
