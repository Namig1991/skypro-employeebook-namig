package pro.skyjavanamigemployeebook.skyproemployeebooknamig;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public Employee[] findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/add")
    public Employee addEmployeeToList(@RequestParam String firstName, @RequestParam String lastName) {
        Employee result = employeeService.addEmployee(firstName, lastName);
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

}
