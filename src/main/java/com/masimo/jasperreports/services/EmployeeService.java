package com.masimo.jasperreports.services;

import com.masimo.jasperreports.model.Compliance;
import com.masimo.jasperreports.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    public List<Employee> getEmployees() {
        List<Employee> employeeList = new ArrayList<>();
        Employee emp1 = new Employee(100, "Rahul Ganta", 65000.00, "Software Engineering");
        Employee emp2 = new Employee(200, "Sansa Stark", 75000.00, "Software Engineering");
        Employee emp3 = new Employee(300, "Tyrion Lanister", 85000.00, "Software Engineering");
        Employee emp4 = new Employee(400, "Daenarys Targerian", 95000.00, "Software Engineering");
        Employee emp5 = new Employee(500, "Jon Snow", 105000.00, "Software Engineering");
        Employee emp6 = new Employee(600, "Harvey Spector", 115000.00, "Software Engineering");
        Employee emp7 = new Employee(700, "Niel Cafrey", 125000.00, "Software Engineering");

        employeeList.add(emp1);
        employeeList.add(emp2);
        employeeList.add(emp3);
        employeeList.add(emp4);
        employeeList.add(emp5);
        employeeList.add(emp6);
        employeeList.add(emp7);

        return employeeList;
    }

    public List<Compliance> getCompliance() {
        List<Compliance> complianceList = new ArrayList<>();

        Compliance comp1 = new Compliance("In Compliance", 94);
        Compliance comp2 = new Compliance("Out of Compliance", 6);

        complianceList.add(comp1);
        complianceList.add(comp2);

        return complianceList;
    }

}
