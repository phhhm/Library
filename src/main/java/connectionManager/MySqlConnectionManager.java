package connectionManager;

import java.sql.*;

public class MySqlConnectionManager implements ConnectionManager {

    private Connection connection;


    public Connection getConnection() {
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/library?serverTimezone=UTC", "parham", "123");

        }catch (Exception e){
            System.out.println("ERROR : connection");
        }
        return connection;
    }
}
