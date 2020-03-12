package ie.gmit;

import java.util.ArrayList;

public class EmployeeList {
    private ArrayList<Employee> employeeList;

    public EmployeeList() { employeeList = new ArrayList<Employee>(); }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);

        /*  Couldn't get testing for existing employees working  */


        // Loop through current array list
        // Check if employee exists already
        /*for(Employee e : employeeList) {
            if (e.getID().equals(employee.getID())) {
                throw new IllegalArgumentException("Employee already exists!");
            }
            else {
                employeeList.add(employee);
            }
        }*/
    }

    public int getListSize() {
        int count = 0;
        for (Employee e : employeeList)
            count++;

        return count;
    }
}
