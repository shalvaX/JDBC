package ge.edu.btu.dao;

import ge.edu.btu.model.Employee;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    private Connection connection;

    public EmployeeDAOImpl() throws SQLException {
        Driver driver = new org.postgresql.Driver();
        DriverManager.registerDriver(driver);
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Employee","postgres","");
    }

    @Override
    public void addEmployee(Employee employee) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO employee (name,surname,gender,alive,p_id) VALUES (?,?,?,?,?)");
        preparedStatement.setString(1,employee.getName());
        preparedStatement.setString(2,employee.getSurname());
        preparedStatement.setBoolean(3,employee.isAlive());
        preparedStatement.setString(4,employee.getP_id());

        preparedStatement.close();

    }

    @Override
    public void addEmployees(List<Employee> employees) {

    }

    @Override
    public void deletEemployees(List<Employee> employees) {

    }

    @Override
    public void deletEemployee(long id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM employee WHERE id = ?");
        preparedStatement.setLong(1,id );
        preparedStatement.close();
    }

    @Override
    public void updatEemployees(List<Employee> employees) {

    }

    @Override
    public void updatEemployee(long id) {

    }

    @Override
    public void setAliveEmployee(long id, boolean alive) {

    }

    @Override
    public List<Employee> getall() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM employee");

        List <Employee> list = new ArrayList<>();
        while (resultSet.next()){
            long id = resultSet.getLong("id");
            String name = resultSet.getString("name");
            String surname = resultSet.getString("surname");
            String gender = resultSet.getString("gender");
            boolean alive = resultSet.getBoolean("alive");
            String p_id = resultSet.getString("p_id");
        }

        return null;
    }

    public void closeConnect() throws SQLException {
        connection.close();
    }
}
