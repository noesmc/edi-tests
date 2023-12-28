package by.softclub.edi.authorization;

import by.softclub.edi.authorization.implementation.Implementation;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static by.softclub.edi.testBase.Locators.getLocator;

public class LoginPage extends Implementation {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Entering credentials, clicking login button")
    public void login(String username, String password) throws Exception {
        driver.findElement(getLocator("loginPage.loginInput")).sendKeys(username);
        driver.findElement(getLocator("loginPage.passwordInput")).sendKeys(password);
        driver.findElement(getLocator("loginPage.loginButton")).click();
    }

    @Step("ChangeVisibility")
    public void changeVisibility() throws Exception {
        driver.findElement(getLocator("loginPage.changeVisibility")).click();
    }

//    public String getText(String locator) throws Exception {
//        return driver.findElement(getLocator(locator)).getText();
//    }
//
//    public String getAttribute(String locator, String attribute) throws Exception {
//        return driver.findElement(getLocator(locator)).getAttribute(attribute);
//    }
}