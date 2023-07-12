package org.application;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MySqlTests {

    @Autowired
    private Connection connection;

    @SneakyThrows
    private ResultSet getResultSet(String statement) {
        return connection.createStatement().executeQuery(statement);
    }

    @SneakyThrows
    @Test
    public void getFirstUserTest() {
        ResultSet rs;
        String statement = format("select * from users;");
        rs = getResultSet(statement);
        rs.next();
        assertThat(rs.getString("partial_name")).isEqualTo("Stepan");
        System.out.println(rs.getString("partial_name"));
    }
    @SneakyThrows
    public List<String> getUsers(String column){
        List<String> users = new ArrayList<>();
        ResultSet rs;
        String statement = format("select * from %s;", column);
        rs = getResultSet(statement);
        while (rs.next()){
            String username = rs.getString("partial_name");
            users.add(username);
        }
        System.out.println(users);
        return users;
    }

    @Test
    public void assertAllUsersTest(){
        List<String> users = getUsers("users");
        assertThat(users).contains("Pankesh");
    }
    //SCRUM + KANBAN + SCRUMBAN, estimation techniques,
    //Maven lifecycles //gradle task execution order (if can, make your own task and connect it to the test task)
    //testNG documentation vs Junit5
    //CICD setup through Jenkins
}
