package org.example.pageobject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.context.annotation.Bean;

public class WebDriverConfig {

    @Bean(destroyMethod = "quit")
    public ChromeOptions chromeOptions(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        return options;
    }
}
