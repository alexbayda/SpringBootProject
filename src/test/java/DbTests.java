import application.Application;
import application.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

@SpringBootTest(classes = Application.class)
public class DbTests extends AbstractTestNGSpringContextTests {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void getListOfUsersFromDb() {
        String query = "select * from users;";
        List<User> result = jdbcTemplate.query(query, (rs, rowNum) -> {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setName(rs.getString("name"));
            return user;
        });
        Assert.assertTrue(result.isEmpty());
        System.out.println(result);
    }
}
