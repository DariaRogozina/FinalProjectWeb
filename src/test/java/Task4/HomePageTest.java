package Task4;
import Pages.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import Pages.AuthorizationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class HomePageTest extends AbstractTest {
    @BeforeEach
    void PositiveAuthorizationTest1() throws InterruptedException {
        new AuthorizationPage(getWebDriver())
                .setUsername("jamesb007")
                .setPassword("ae7b01d6eb")
                .loginIn();
        Thread.sleep(1000);
        Assertions.assertEquals("Symfony Blog", getWebDriver().getTitle(), "Авторизация не успешная");
    }
    @Test
    @Description("Переход между страницами")
    @Severity(SeverityLevel.CRITICAL)
void  TransitionBetweenPagesTest() throws InterruptedException {
     HomePage homePage = new HomePage(getWebDriver());
     homePage.clickToNext2Page();
        Thread.sleep(1000);
     Assertions.assertEquals("https://test-stand.gb.ru/?page=2", getWebDriver().getCurrentUrl());
    }
    @Test
    @Description("Наличие заголовка")
    @Severity(SeverityLevel.CRITICAL)
    void verificationOfPostsTest1() {
        HomePage homePage = new HomePage(getWebDriver());
        homePage.clickToAnyPost();
        Assertions.assertEquals("Пост двенадцатый", getWebDriver().findElement(By.xpath("//h1[@class=\"svelte-tv8alb\"]")).getText());
    }
    @Test
    @Description("Наличие картинки")
    @Severity(SeverityLevel.NORMAL)
    void verificationOfPostsTest2(){
        HomePage homePage = new HomePage(getWebDriver());
        homePage.clickToAnyPost();
        Assertions.assertDoesNotThrow(() -> getWebDriver().findElements(By.xpath("//img[@class=\"svelte-tv8alb\"]")).get(0),
                "Элемент не найден");
    }
    @Test
    @Description("Наличие описания")
    @Severity(SeverityLevel.NORMAL)
    void verificationOfPostsTest3() throws InterruptedException {
        HomePage homePage = new HomePage(getWebDriver());
        homePage.clickToAnyPost();
        Thread.sleep(1000);
        Assertions.assertDoesNotThrow(() -> getWebDriver().findElements(By.xpath("//*[contains(text(), \"Программистский пьедестал\")]")).get(0),
                "Элемент не найден");
    }
    @Test
    @Description("Переход между страницами и проверка отображения превью")
    @Severity(SeverityLevel.CRITICAL)
    void verificationOfPostsTest4() throws InterruptedException {
        HomePage homePage = new HomePage(getWebDriver());
        homePage.clickToNext2Page();
        homePage.clickToNext3Page();
        homePage.clickToNext4Page();
        homePage.clickToNext3Page();
        Thread.sleep(1000);
        Assertions.assertEquals("https://test-stand.gb.ru/?page=3", getWebDriver().getCurrentUrl());
        Assertions.assertEquals("Пост седьмой", getWebDriver().findElement(By.xpath("//*[@class=\"posts svelte-127jg4t\"]/a[1]/h2")).getText());
        Assertions.assertEquals("Не доверяйте программисту", getWebDriver().findElement(By.xpath("//*[@class=\"posts svelte-127jg4t\"]/a[1]/div")).getText());
        Assertions.assertDoesNotThrow(() -> getWebDriver().findElements(By.xpath("//img[@src=\"http://test-stand.gb.ru/files/public/image/fbf50c688840ca2a2a6ee9af8ddff6ca.jpg\"]")).get(0),
                "Элемент не найден");
        Thread.sleep(1000);

    }
}

