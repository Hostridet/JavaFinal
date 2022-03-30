package com.company;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class bd {

    private String name;
    private Statement statement;

    public bd(){
        name = "sdsd";
    }

    public void connection() throws SQLException
    {
        Connection connection;
        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jokings", "root", "1002");
            this.statement = connection.createStatement();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void add(String str) throws SQLException {
        statement.execute("INSERT INTO JOKES(JOKE) values('"+str+"')");
    }

    public void show() throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT * FROM JOKES");
        while (resultSet.next()) {
            System.out.println("Шутка: ");
            System.out.println(resultSet.getString("JOKE"));
        }
    }

    public void close() throws SQLException {
        statement.close();
    }

}
