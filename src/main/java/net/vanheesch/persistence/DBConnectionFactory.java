package net.vanheesch.persistence;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnectionFactory implements IDBConnectionFactory {

    private static Properties properties;

    static {
        properties = new Properties();
        ClassLoader classLoader = DBConnectionFactory.class.getClassLoader();

        try {
            FileInputStream fileInputStream = new FileInputStream(classLoader.getResource("database.properties").getFile());
            properties.load(fileInputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Class.forName(properties.getProperty("MYSQL_JDBC_DRIVER_CLASS"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(
                    properties.getProperty("ITEM_DB_CONNECTION_STRING"),
                    properties.getProperty("DB_USER"),
                    properties.getProperty("DB_PASSWORD"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

}
