import org.application.Application;
import org.application.H2DbConfig;
import org.application.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@SpringBootTest(classes = {Application.class, H2DbConfig.class})
public class DbTests extends AbstractTestNGSpringContextTests {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    private DataSource dataSource;

    @Test
    public void tables() throws SQLException {
        String url = String.valueOf(dataSource.getConnection());
        System.out.println("Database URL: " + url);
        String query = "Select * from INFORMATION_SCHEMA.catalogs;";
        List<String> result = jdbcTemplate.queryForList(query, String.class);
        Assert.assertTrue(result.contains("TESTDB"));
        System.out.println("Result: " + result);
    }

    @Test
    public void showDB() {
        jdbcTemplate.update("INSERT INTO users (id, partial_name) VALUES (5, 'Pankesh');");
    }

    @Test
    public void getListOfUsersFromDb() throws SQLException {
        String query = "SELECT * FROM mydb.users;";
        List<User> result = jdbcTemplate.query(query, (rs, rowNum) -> {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setPartialName(rs.getString("name"));
            return user;
        });
        Assert.assertFalse(result.isEmpty());
        result.forEach(user -> System.out.println("User: " + user.getId() + ", Name: " + user.getPartialName()));
    }
}
