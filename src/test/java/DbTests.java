import application.Application;
import application.H2DbConfig;
import application.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = {Application.class, H2DbConfig.class})
public class DbTests extends AbstractTestNGSpringContextTests {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Test
    public void getListOfUsersFromDb() {
        String query = "SELECT * FROM users;";
        List<User> result = jdbcTemplate.query(query, (rs, rowNum) -> {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setPartialName(rs.getString("name"));
            return user;
        });
        Assert.assertTrue(result.isEmpty());
        System.out.println(result);
    }
}
