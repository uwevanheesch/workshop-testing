package net.vanheesch.persistence;

import net.vanheesch.domain.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDAOMySQL implements IItemDAO {

    IDBConnectionFactory dbConnectionFactory = new DBConnectionFactory();

    TestBackdoor testBackdoor = new TestBackdoor();

    @Override
    public List<Item> getItems() {
        List<Item> resultList = new ArrayList<>();
        String sqlQuery = "SELECT * FROM STOCK_ITEMS";
        // try-with-resources
        try (
                Connection con = dbConnectionFactory.getConnection();
                PreparedStatement preparedStatement = con.prepareStatement(sqlQuery);
                ResultSet resultSet = preparedStatement.executeQuery();
        ) {
            while (resultSet.next()) {
                resultList.add(new Item(resultSet.getString("name"), resultSet.getString("description")));
            }
            testBackdoor.mayThrowSQLException();
        } catch (SQLException e) {
            throw new RuntimeException("Values could not be retrieved due to database problem.", e);
        }
        return resultList;
    }

    @Override
    public Item findItemByName(String name) {
        String sqlQuery = "SELECT * FROM STOCK_ITEMS WHERE name=?";
        try (
                Connection con = dbConnectionFactory.getConnection();
                PreparedStatement preparedStatement = con.prepareStatement(sqlQuery);
        ) {
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Item(resultSet.getString("name"), resultSet.getString("description"));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Values could not be retrieved due to database problem.", e);
        }
        return null;
    }

}
