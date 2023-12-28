package by.softclub.edi.authorization;

import by.softclub.edi.authorization.implementation.Implementation;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static by.softclub.edi.testBase.Locators.getLocator;

public class RestorePage extends Implementation {

    WebDriver driver;

    public RestorePage(WebDriver driver) {
        this.driver = driver;
    }

//    public String getAttribute(String locator, String attribute) throws Exception {
//        return driver.findElement(getLocator(locator)).getAttribute(attribute);
//    }

    @Step("Click to restore button")
    public void redirectToRestorePage() throws Exception {
        driver.findElement(getLocator("loginPage.forgotPasswordButton")).click();
    }
}
