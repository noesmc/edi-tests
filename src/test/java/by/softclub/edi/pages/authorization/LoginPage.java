package by.softclub.edi.pages.authorization;

import by.softclub.edi.tests.implementation.Implementation;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import static by.softclub.edi.tests.testBase.Locators.getLocator;

public class LoginPage extends Implementation {

    Logger LOG = Logger.getLogger(LoginPage.class);
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Entering credentials, clicking login button")
    public void login(String username, String password) throws Exception {
        LOG.info("Attempting to login");
        driver.findElement(getLocator("loginPage.loginInput")).sendKeys(username);
        driver.findElement(getLocator("loginPage.passwordInput")).sendKeys(password);
        driver.findElement(getLocator("loginPage.loginButton")).click();
        LOG.info("Credentials have entered");
    }

    @Step("ChangeVisibility")
    public void changeVisibility() throws Exception {
        LOG.info("Changing text's visibility");
        driver.findElement(getLocator("loginPage.changeVisibility")).click();
        LOG.info("Visibility has changed");
    }

    @Step("Accept update")
    public void acceptUpdatingVersion() throws Exception {
        LOG.info("Click \"Accept\" button");
        driver.findElement(getLocator("loginPage.acceptButton")).click();
        LOG.info("\"Accept\" button has clicked");
    }
    @Step("Logout")
    public void logout() throws Exception {
        LOG.info("Click \"Logout\" button");
        driver.findElement(getLocator("loginPage.logoutButton")).click();
        LOG.info("\"Logout\" button has clicked");
    }
}