import org.example.pageobject.FacebookPage;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.Test;

import javax.annotation.Resource;

@SpringBootTest
public class FacebookTest {

    @Resource
    private FacebookPage facebookPage = new FacebookPage();

    @Test
    public void test1() {
        facebookPage.navigateTo("https://facebook.com");
        facebookPage.login();
    }
}
