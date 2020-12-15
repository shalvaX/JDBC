package ge.edu.btu;

import ge.edu.btu.dao.EmployeeDAO;
import ge.edu.btu.dao.EmployeeDAOImpl;
import ge.edu.btu.model.Employee;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static List<Employee> empList(){
        List<Employee> employees = new ArrayList<>();
        Employee f1 = new Employee(1,"third","employee","female",true,"12345678902");
        Employee f2 = new Employee(2,"fourth","employee","female",true,"12345678903");
        Employee f3 = new Employee(3,"fifth","employee","female",true,"12345678904");
        employees.add(f1);
        employees.add(f2);
        employees.add(f3);
        return employees;
    }

    public static void main(String[] args) throws SQLException {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        //employeeDAO.addEmployee(new Employee(0,"first","employee","male",false,"12345678901"));
        //employeeDAO.addEmployee(new Employee(0,"second","employee","female",true,"12345678902"));
        //employeeDAO.deletEemployee(5);
        //employeeDAO.addEmployees(empList());
        //employeeDAO.deletEemployees(empList());
        //employeeDAO.updatEemployee(4,new Employee(0,"updated_first","employee","male",false,"12345678901"));
        employeeDAO.closeConnect();
    }

}
