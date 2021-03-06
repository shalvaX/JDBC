package ge.edu.btu.dao;

import ge.edu.btu.model.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {
    void addEmployee(Employee employee) throws SQLException;

    void addEmployees(List<Employee> employees) throws SQLException;

    void deletEemployees(List<Employee> employees) throws SQLException;

    void deletEemployee(long id) throws SQLException;

    void updatEemployees(List<Employee> employees);

    void updatEemployee(long id, Employee employee) throws SQLException;

    void setAliveEmployee(long id,boolean alive);

    void closeConnect() throws SQLException;

    List<Employee> getall() throws SQLException;
}
