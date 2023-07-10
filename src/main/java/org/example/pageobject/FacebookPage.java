package org.example.pageobject;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

@Component
public class FacebookPage {

    private final SelenideElement login = $x("//input[@id='email']");
    private final SelenideElement password = $x("//input[@id='pass']");
    private final SelenideElement loginButton = $x("//button[@id='loginbutton']");

    public void navigateTo(String baseUrl) {
        Selenide.open(baseUrl);
    }


    public void wait(WebElement element){
        WebDriverWait wait = new WebDriverWait(WebDriverManager.chromedriver().getWebDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void login(){
        login.sendKeys("test@email.com");
        password.sendKeys("secretPassword");
        loginButton.click();
    }
}
