package org.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDB {

    private final static String CONNECTION_URL = "jdbc:sqlite:/home/mateusz/Desktop/SDA/TestDB/databases/firstDB";

    public static void main(String[] args) {

        try {
            Connection connection = DriverManager.getConnection(CONNECTION_URL);
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS contacts(name TEXT, phone INTEGER, email TEXT)");

            statement.close();
            connection.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
