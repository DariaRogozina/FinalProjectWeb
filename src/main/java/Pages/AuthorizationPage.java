package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
public class AuthorizationPage extends AbstractPage{
    @FindBy(xpath = "//*[@id=\"login\"]/div[1]/label/input")
    private WebElement username;

    @FindBy(xpath = "//*[@id=\"login\"]/div[2]/label/input")
    private WebElement password;

    @FindBy(xpath = "//span[@class=\"mdc-button__label\"]")
    private WebElement login;


    public AuthorizationPage(WebDriver driver){
        super(driver);
    }

    public void loginIn(){
        this.login.click();
    }

    public AuthorizationPage setUsername(String login){
        this.username.sendKeys(login);
        return this;
    }

    public AuthorizationPage setPassword(String password){
        this.password.click();
        this.password.sendKeys(password);
        return this;
    }

}
