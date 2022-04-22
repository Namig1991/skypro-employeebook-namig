package pro.skyjavanamigemployeebook.skyproemployeebooknamig.data;

import java.util.Objects;

public class Employee {
    private final String firstName;
    private final String lastName;
    private final Integer salary;
    private final Integer departmentId;

    public Employee(String firstName, String lastName, Integer salary, Integer departmentId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.departmentId = departmentId;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getSalary() {
        return salary;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee emploees = (Employee) obj;
        return Objects.equals(firstName, emploees.firstName) && Objects.equals(lastName, emploees.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        return "Имя: " + firstName + " " +
                " Фамилия: " + lastName +
                " Зарплата = " + salary +
                " Департамент - " + departmentId;
    }

}