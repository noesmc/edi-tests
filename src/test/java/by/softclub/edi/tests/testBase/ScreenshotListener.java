package by.softclub.edi.tests.testBase;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


import static by.softclub.edi.tests.testBase.TestBase.driver;


public class ScreenshotListener implements ITestListener {

    public void onTestFailure(ITestResult result) {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            Allure.addAttachment(result.getMethod().getMethodName() + "_" + timeStamp , new FileInputStream(screenshot));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
