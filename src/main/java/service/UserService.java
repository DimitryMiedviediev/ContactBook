package service;

import DBC.DBConnection;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.UserDAO;
import dao.UserDAOImpl;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@EnableAutoConfiguration
public class UserService {

    private UserDAO userDAO = new UserDAOImpl();
    private List<HashMap<String, String>> list = new ArrayList<>();

    @RequestMapping(value = "/getUserInfo",
            method = RequestMethod.GET)
    @ResponseBody
    List<HashMap<String, String>> getUserInfo(@RequestParam(value = "id") int id) {
        Connection connection = DBConnection.getConnection();
        list = userDAO.getUserInfo(id, connection);
        DBConnection.stopConnection(connection);
        return list;
    }

    @RequestMapping(value = "/getUserInfoJson",
            method = RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    List<HashMap<String, String>> getUserInfoJson(@RequestBody String string) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode actualObj = mapper.readTree(string);

        System.out.println(actualObj);
        System.out.println("Id       : " + actualObj.get("id").asInt());
        System.out.println("Login    : " + actualObj.get("login").asText());
        System.out.println("Password : " + actualObj.get("password").asText());
        return null;
    }

}
