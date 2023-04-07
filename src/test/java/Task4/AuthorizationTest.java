package Task4;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import Pages.AuthorizationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class AuthorizationTest extends AbstractTest {
    @Test
    @Description("Валидные данные")
    @Severity(SeverityLevel.CRITICAL)
    void PositiveAuthorizationTest1() throws InterruptedException {
        new AuthorizationPage(getWebDriver())
                .setUsername("jamesb007")
                .setPassword("ae7b01d6eb")
                .loginIn();
        Thread.sleep(1000);
        Assertions.assertEquals("Symfony Blog", getWebDriver().getTitle(), "Авторизация не успешная");
    }

    @Test
    @Description("Валидные данные, у пользователя нет постов")
    @Severity(SeverityLevel.CRITICAL)
    void PositiveAuthorizationTest2() throws InterruptedException {
        new AuthorizationPage(getWebDriver())
                .setUsername("Hom")
                .setPassword("d82c0c322e")
                .loginIn();
        Thread.sleep(1000);
        Assertions.assertEquals("Symfony Blog", getWebDriver().getTitle(), "Авторизация не успешная");
        Assertions.assertEquals("No items for your filter", getWebDriver().findElement(By.xpath("//*[@class=\"content\"]/p")).getText());
    }

    @Test
    @Description("Валидные данные")
    @Severity(SeverityLevel.CRITICAL)
    void PositiveAuthorizationTest3() throws InterruptedException {
        new AuthorizationPage(getWebDriver())
                .setUsername("login12345login67890")
                .setPassword("88ff97c1c1")
                .loginIn();
        Thread.sleep(1000);
        Assertions.assertEquals("Symfony Blog", getWebDriver().getTitle(), "Авторизация не успешная");
    }

    @Test
    @Description("Невалидные данные")
    @Severity(SeverityLevel.CRITICAL)
    void NegativeAuthorizationTest1() throws InterruptedException {
        new AuthorizationPage(getWebDriver())
                .setUsername("русский")
                .setPassword("72f72a0734")
                .loginIn();
        Thread.sleep(1000);
        Assertions.assertDoesNotThrow(() -> getWebDriver().findElements(By.xpath("//*[contains(text(), \"Неправильный логин. Может состоять только из латинских букв и цифр, без спецсимволов\")]")).get(0),
                "Элемент не найден");
    }

    @Test
    @Description("Невалидные данные")
    @Severity(SeverityLevel.CRITICAL)
    void NegativeAuthorizationTest2() throws InterruptedException {
        new AuthorizationPage(getWebDriver())
                .setUsername("ghjf.kl1,5")
                .setPassword("ac420365cb")
                .loginIn();
        Thread.sleep(1000);
        Assertions.assertDoesNotThrow(() -> getWebDriver().findElements(By.xpath("//*[contains(text(), \"Неправильный логин. Может состоять только из латинских букв и цифр, без спецсимволов\")]")).get(0),
                "Элемент не найден");
    }

    @Test
    @Description("Невалидные данные")
    @Severity(SeverityLevel.CRITICAL)
    void NegativeAuthorizationTest3() throws InterruptedException {
        new AuthorizationPage(getWebDriver())
                .setUsername("jhgfdvbn67jug281hjk81")
                .setPassword("161d25d16f")
                .loginIn();
        Thread.sleep(1000);
        Assertions.assertDoesNotThrow(() -> getWebDriver().findElements(By.xpath("//*[contains(text(), \"Неправильный логин. Может быть не менее 3 и не более 20 символов\")]")).get(0),
                "Элемент не найден");
    }
    @Test
    @Description("Невалидные данные")
    @Severity(SeverityLevel.CRITICAL)
    void NegativeAuthorizationTest4() throws InterruptedException {
        new AuthorizationPage(getWebDriver())
                .setUsername("jamesb007")
                .loginIn();
        Thread.sleep(1000);
        Assertions.assertDoesNotThrow(() -> getWebDriver().findElements(By.xpath("//*[contains(text(), \"Поле не может быть пустым\")]")).get(0),
                "Элемент не найден");
    }
}


