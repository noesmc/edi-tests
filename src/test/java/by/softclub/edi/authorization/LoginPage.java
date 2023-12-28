package by.softclub.edi.authorization;

import by.softclub.edi.authorization.implementation.Implementation;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import static by.softclub.edi.testBase.Locators.getLocator;

public class LoginPage extends Implementation {

    Logger LOG = Logger.getLogger(LoginPage.class);
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Entering credentials, clicking login button")
    public void login(String username, String password) throws Exception {
        LOG.info("Attempting to login with credentials:" + username + " " + password);
        driver.findElement(getLocator("loginPage.loginInput")).sendKeys(username);
        driver.findElement(getLocator("loginPage.passwordInput")).sendKeys(password);
        driver.findElement(getLocator("loginPage.loginButton")).click();
    }

    @Step("ChangeVisibility")
    public void changeVisibility() throws Exception {
        LOG.info("Changing text's visibility");
        driver.findElement(getLocator("loginPage.changeVisibility")).click();
        LOG.info("Visibility has changed");
    }

//    public String getText(String locator) throws Exception {
//        return driver.findElement(getLocator(locator)).getText();
//    }
//
//    public String getAttribute(String locator, String attribute) throws Exception {
//        return driver.findElement(getLocator(locator)).getAttribute(attribute);
//    }
}