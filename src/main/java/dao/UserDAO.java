package dao;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;

public interface UserDAO {

    List<HashMap<String, String>> getUserInfo(int id, Connection connection);

    List<HashMap<String, String>> createUser(String login, String password, String email, Connection connection);

    List<HashMap<String, String>> updateFullName(int id, String firstName, String surName, String lastName, Connection connection);

    List<HashMap<String, String>> updatePassword(int id, String password, Connection connection);

    List<HashMap<String, String>> updateEmail(int id, String email, Connection connection);

    List<HashMap<String, String>> checkLogin(String login, Connection connection);

    List<HashMap<String, String>> checkEmail(String email, Connection connection);
}
