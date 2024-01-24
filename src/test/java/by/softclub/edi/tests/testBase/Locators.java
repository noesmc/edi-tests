package by.softclub.edi.tests.testBase;

import org.openqa.selenium.By;
import java.io.InputStream;
import java.util.Properties;

public class Locators {
    private static final Properties locators;

    static {
        locators = new Properties();
        InputStream is = Locators.class.getResourceAsStream("/locators.properties");
        try {
            locators.load(is);
        } catch (Exception e) {
            System.out.println("Error reading from property file");
        }
    }

    public static By getLocator(String locator) throws Exception {
        String value = locators.getProperty(locator);
        String[] result = value.split("=", 2);
        LocatorType locatorType = LocatorType.valueOf(result[0].toUpperCase());
        String selector = result[1];
        switch (locatorType) {
            case ID -> {
                return By.id(selector);
            }
            case NAME -> {
                return By.name(selector);
            }
            case CSS -> {
                return By.cssSelector(selector);
            }
            case XPATH -> {
                return By.xpath(selector);
            }
            default -> throw new Exception("No such type of locator");
        }
    }
}
