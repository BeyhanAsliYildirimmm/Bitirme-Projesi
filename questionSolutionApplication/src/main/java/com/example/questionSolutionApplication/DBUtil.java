package com.example.questionSolutionApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static Connection connection=null;
    public static Connection getConnection() throws SQLException {
        if (connection != null) {

        } else {
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/question-solution?useSSL=false";
            String user = "root";
            String password = "root";
            try {
                Class.forName(driver);
                connection= DriverManager.getConnection(url,user,password);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
        return connection;
    }
}
