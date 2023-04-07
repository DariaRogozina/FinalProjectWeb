package Task4;
import io.github.bonigarcia.wdm.WebDriverManager;
import Pages.AuthorizationPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

import java.time.Duration;
public class AbstractTest {
    private static WebDriver webDriver;



    @BeforeAll
    static void setDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("start-maximized");
        options.addArguments("--remote-allow-origins=*");
        options.setPageLoadTimeout(Duration.ofSeconds(10));
        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
        @BeforeEach
        void initStartPage(){
        Assertions.assertDoesNotThrow(() -> webDriver.navigate().to("https://test-stand.gb.ru/login"),
                "Страница не доступна");
            Assertions.assertTrue(true);
    }
    @AfterAll
    public static void exit(){

        if(webDriver !=null) webDriver.quit();
    }
        public static WebDriver getWebDriver() {
            return webDriver;
        }




    }
