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
        preparedStatement.setString(3,employee.getGender());
        preparedStatement.setBoolean(4,employee.isAlive());
        preparedStatement.setString(5,employee.getP_id());

        preparedStatement.executeUpdate();

        preparedStatement.close();

    }

    @Override
    public void addEmployees(List<Employee> employees) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO employee (name,surname,gender,alive,p_id) VALUES (?,?,?,?,?)");
        for(Employee employee : employees) {
            preparedStatement.setString(1,employee.getName());
            preparedStatement.setString(2,employee.getSurname());
            preparedStatement.setString(3,employee.getGender());
            preparedStatement.setBoolean(4,employee.isAlive());
            preparedStatement.setString(5,employee.getP_id());
            preparedStatement.executeUpdate();
        }
        preparedStatement.close();
    }

    @Override
    public void deletEemployees(List<Employee> employees) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM employee WHERE id = ?");
        for(Employee employee : employees) {
            preparedStatement.setLong(1,employee.getId());
            preparedStatement.executeUpdate();
        }
        preparedStatement.close();
    }

    @Override
    public void deletEemployee(long id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM employee WHERE id = ?");
        preparedStatement.setLong(1,id );
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @Override
    public void updatEemployees(List<Employee> employees) {
        for (int i = employees.size(); i != 0; --i){
            System.out.println();
        }
    }

    @Override
    public void updatEemployee(long id,Employee employee) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE employee SET name = ?,surname = ?,gender = ?,alive = ?, p_id = ?  WHERE id = ?");
        preparedStatement.setString(1,employee.getName());
        preparedStatement.setString(2,employee.getSurname());
        preparedStatement.setString(3,employee.getGender());
        preparedStatement.setBoolean(4,employee.isAlive());
        preparedStatement.setString(5,employee.getP_id());
        preparedStatement.setLong(6,id);

        preparedStatement.executeUpdate();

        preparedStatement.close();
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
            Employee employee = new Employee(id,name, surname, gender, alive, p_id);
            list.add(employee);
        }
        statement.close();
        return list;
    }

    public void closeConnect() throws SQLException {
        connection.close();
    }
}
