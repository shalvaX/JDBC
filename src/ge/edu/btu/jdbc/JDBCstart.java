package ge.edu.btu.jdbc;

import java.sql.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCstart {
    public static void main (String[] args) throws SQLException {
        Driver driver = new org.postgresql.Driver();
        DriverManager.registerDriver(driver);
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Employees","postgres","Overlooked23");
        Statement statement = connection.createStatement();
        statement.executeUpdate("INSERT INTO employee (name, surname, gender, alive, p_id) VALUES ('third','employee','male',true,'12345678903');");
        statement.close();
        connection.close();
    }
}
