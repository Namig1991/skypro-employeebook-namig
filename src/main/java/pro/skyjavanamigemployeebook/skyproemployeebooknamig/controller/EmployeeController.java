package pro.skyjavanamigemployeebook.skyproemployeebooknamig.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.skyjavanamigemployeebook.skyproemployeebooknamig.service.EmployeeService;

import java.util.List;

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

    @GetMapping("/all")
    public List<String> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/add")
    public boolean addEmployeeToList(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.addEmployee(firstName,lastName);
    }

    @GetMapping("/remove")
    public boolean removeEmployeeFromList(@RequestParam String firstName, @RequestParam String lastName) {
       return employeeService.removeEmployee(firstName,lastName);
    }

    @GetMapping("/find")
    public boolean findEmployeeInList(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.findEmployee(firstName, lastName);
    }

}
