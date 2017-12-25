package dao;

import DBC.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserDAOImpl implements UserDAO{

    @Override
    public List<HashMap<String, String>> getUserInfo(int id, Connection connection) {
        List<HashMap<String, String>> list = new ArrayList<>();
        try {
            connection.setCatalog(DBConnection.getSchemaName());
            String sqlSelectQuery = "select * from v_user where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlSelectQuery);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            int columnCount = resultSet.getMetaData().getColumnCount();
            while (resultSet.next()) {
                HashMap<String, String> pair = new HashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    pair.put(resultSet.getMetaData().getColumnName(i), resultSet.getString(resultSet.getMetaData().getColumnName(i)));
                }
                list.add(pair);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<HashMap<String, String>> createUser(String login, String password, String email, Connection connection) {
        return null;
    }

    @Override
    public List<HashMap<String, String>> updateFullName(int id, String firstName, String surName, String lastName, Connection connection) {
        return null;
    }

    @Override
    public List<HashMap<String, String>> updatePassword(int id, String password, Connection connection) {
        return null;
    }

    @Override
    public List<HashMap<String, String>> updateEmail(int id, String email, Connection connection) {
        return null;
    }

    @Override
    public List<HashMap<String, String>> checkLogin(String login, Connection connection) {
        return null;
    }

    @Override
    public List<HashMap<String, String>> checkEmail(String email, Connection connection) {
        return null;
    }
}
