package test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.*;

public class BaseTest {
    static Playwright playwright;
    static Browser browser;

    BrowserContext context;
    Page page;

    @Parameters({"browserName"})
    @BeforeClass
    static void launchBrowser(@Optional("chrome") String browserName) {
        playwright = Playwright.create();
        browser = switch ("browserName".toLowerCase()) {
            case "firefox" -> playwright.firefox().launch();
            case "webkit" -> playwright.webkit().launch();
            default -> playwright.chromium().launch();
        };
    }

    @AfterClass
    static void closeBrowser() {
        playwright.close();
    }

    @BeforeMethod
    void createContextAndPage() {
        context = browser.newContext();
        page = context.newPage();
    }

    @AfterMethod
    void closeContext() {
        context.close();
    }
}
