package by.softclub.edi.tests.authorization;

import by.softclub.edi.pages.authorization.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import by.softclub.edi.tests.testBase.TestBase;

@Epic("Login")
@Feature("Authorization")

public class TestLogin extends TestBase {

    @Test(groups = {"stt", "bidmart", "me"})
    @Description("Check existing web-elements")
    public void existingPageElements() throws Exception {
        SoftAssert softAssert = new SoftAssert();
        LoginPage loginPage = new LoginPage(driver);

        softAssert.assertEquals(loginPage.getText("loginPage.choiceLoginByCreds"), "По логину и паролю");
        softAssert.assertEquals(loginPage.getText("loginPage.choiceLoginByCert"), "По ЭЦП");
        softAssert.assertEquals(loginPage.getAttribute("loginPage.loginInput", "placeholder"),
            "Введите логин");
        softAssert.assertEquals(loginPage.getAttribute("loginPage.passwordInput", "placeholder"),
            "Введите пароль");
        softAssert.assertEquals(loginPage.getText("loginPage.forgotPasswordButton"), "Забыли пароль?");
        softAssert.assertEquals(loginPage.getText("loginPage.loginButton"), "Войти");
        softAssert.assertAll();
    }

    @Test(groups = {"stt", "bidmart", "me"})
    @Description("Check changing password's visibility")
    public void checkChangingVisibility() throws Exception {
        SoftAssert softAssert = new SoftAssert();
        LoginPage loginPage = new LoginPage(driver);

        softAssert.assertEquals(loginPage.getText("loginPage.changeVisibility"), "visibility");
        softAssert.assertEquals(loginPage.getAttribute("loginPage.passwordInput", "type"),
            "password");
        loginPage.changeVisibility();
        softAssert.assertEquals(loginPage.getText("loginPage.changeVisibility"), "visibility_off");
        softAssert.assertEquals(loginPage.getAttribute("loginPage.passwordInput", "type"),
            "text");
        softAssert.assertAll();
    }

    @Test(groups = {"stt", "bidmart", "me"})
    @Description("Login with valid credentials")
    public void successfulLoginTest() throws Exception {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("connector1", "1Qaz1Qaz");
        Thread.sleep(1000);
        Assert.assertEquals(driver.getTitle(), "Заказы", "Authorization failed");
    }

    @Test(groups = {"stt", "bidmart", "me"})
    @Description("Check existing notice about version update")
    public void checkExistingNotice() throws Exception {
        SoftAssert softAssert = new SoftAssert();
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("connector1", "1Qaz1Qaz");
        Thread.sleep(1000);
        Assert.assertEquals(driver.getTitle(), "Заказы", "Authorization failed");
        softAssert.assertEquals(loginPage.getText("loginPage.headerText"), "Версия ПО обновлена.");
        softAssert.assertEquals(loginPage.getText("loginPage.messageText"),
            "Будут очищены временные файлы и файлы cookie.");
        softAssert.assertAll();
    }

    @Test(groups = {"stt", "bidmart", "me"})
    @Description("Logout")
    public void logout() throws Exception {
        SoftAssert softAssert = new SoftAssert();
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("connector1", "1Qaz1Qaz");
        Thread.sleep(1000);
        Assert.assertEquals(driver.getTitle(), "Заказы", "Authorization failed");
        softAssert.assertEquals(loginPage.getText("loginPage.headerText"), "Версия ПО обновлена.");
        softAssert.assertEquals(loginPage.getText("loginPage.messageText"),
            "Будут очищены временные файлы и файлы cookie.");
        loginPage.acceptUpdatingVersion();
        Thread.sleep(1000);
        loginPage.logout();
        Assert.assertEquals(driver.getTitle(), "Bidmart EDI", "Failed");
        softAssert.assertAll();
    }
}
