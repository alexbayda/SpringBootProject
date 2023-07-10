import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

    public void setup() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
        Configuration.baseUrl = "facebook";
    }

    public void innit() {
        setup();
    }
}
