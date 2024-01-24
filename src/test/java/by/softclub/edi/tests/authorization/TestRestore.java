package by.softclub.edi.tests.authorization;

import by.softclub.edi.pages.authorization.RestorePage;
import io.qameta.allure.Description;
import by.softclub.edi.tests.testBase.TestBase;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestRestore extends TestBase {

    @Test(groups = {"stt", "bidmart", "me"})
    @Description("Check existing web-elements")
    public void existingPageElements() throws Exception {
        SoftAssert softAssert = new SoftAssert();
        RestorePage restorePage = new RestorePage(driver);

        restorePage.redirectToRestorePage();
        softAssert.assertEquals(restorePage.getAttribute("restorePage.emailInput", "placeholder"),
            "Введите Email");
        softAssert.assertEquals(restorePage.getAttribute("restorePage.unpInput", "placeholder"),
            "Введите УНП организации");
        softAssert.assertEquals(restorePage.getText("restorePage.restoreButtonLocator"), "Восстановить");
        softAssert.assertAll();
    }
}
