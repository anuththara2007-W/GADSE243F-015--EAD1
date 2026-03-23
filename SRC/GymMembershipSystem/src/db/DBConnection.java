package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL =
            "jdbc:sqlserver://localhost:1433;databaseName=GymMembershipDB;encrypt=true;trustServerCertificate=true;";

    private static final String USER = "gymadmin";
    private static final String PASSWORD = "1234567890";

    public static Connection getConnection() throws Exception {

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}