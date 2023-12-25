package authorization.implementation;

import io.qameta.allure.Step;

import static testBase.Locators.getLocator;
import static testBase.TestBase.driver;

public abstract class Implementation {

    @Step("Getting web-element's text")
    public String getText(String locator) throws Exception {
        return driver.findElement(getLocator(locator)).getText();
    }

    @Step("Getting web-element's attribute")
    public String getAttribute(String locator, String attribute) throws Exception {
        return driver.findElement(getLocator(locator)).getAttribute(attribute);
    }
}
