package day3_employee;

import java.util.ArrayList;
import java.util.List;

public class DemoEmployee {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        Employee fullTimeEmployee1 = new FullTimeEmloyee(1, "hoaianh", 1000);
        Employee fullTimeEmployee2 = new FullTimeEmloyee(2, "duonganh", 500);
        Employee partTimeEmployee1 = new PartTimeEmployee(3, "long", 10, 10.5d);
        Employee partTimeEmployee2 = new PartTimeEmployee(4, "long", 30, 2.6d);

        employeeList.add(fullTimeEmployee1);
        employeeList.add(fullTimeEmployee2);
        employeeList.add(partTimeEmployee1);
        employeeList.add(partTimeEmployee2);

        for(Employee employee : employeeList){
            employee.printInfo();
        }
    }
}
