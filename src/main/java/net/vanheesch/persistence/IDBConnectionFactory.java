package net.vanheesch.persistence;

import java.sql.Connection;
import java.sql.SQLException;

public interface IDBConnectionFactory {
    Connection getConnection() throws SQLException;
}
