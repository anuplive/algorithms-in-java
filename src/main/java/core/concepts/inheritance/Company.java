package main.java.core.concepts.inheritance;

import java.util.ArrayList;
import java.util.List;

public class Company {

    List<Employee> employees;
    Company(){
        employees = new ArrayList<>();
    }
    public static void main(String[] args){
        Company company = new Company();
        initializeEmployees(company.employees);

        for (Employee employee: company.employees)
            System.out.println("Hi I am "+ employee.getName()+ " and am " + employee.getJob()+" my degree is "+ employee.getDegree());

    }
    public static void initializeEmployees(List<Employee> employees){
        employees.add(new Engineer("Bob", "Masters"));
        employees.add(new Accountant("Jonny", "MAccount"));
        employees.add(new Staff("Jenny", "High School"));
        employees.add(new Engineer("Steven", "Bachelors"));
    }
}
