package test;

import com.microsoft.playwright.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;
import test.BaseTest;

import java.nio.file.Paths;

public class Example extends BaseTest {
    private static final String URL = "https://www.saucedemo.com/";
    private static final String USERNAME_FIELD = "#user-name";
    private static final String PASSWORD_FIELD = "#password";
    private static final String LOGIN_BUTTON = "#login-button";


    @Test(dataProvider = "test-data-users", dataProviderClass = TestDataClass.class)
    public void testOne(String userName, String userPassword) {
        page.navigate(URL);
        page.click(USERNAME_FIELD);
        page.fill(USERNAME_FIELD, userName);
        page.click(PASSWORD_FIELD);
        page.fill(PASSWORD_FIELD, userPassword);
        page.click(LOGIN_BUTTON);
    }
}


