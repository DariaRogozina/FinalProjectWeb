package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
public class HomePage extends AbstractPage{
    @FindBy(xpath = "//a[@href=\"/?page=2\"]")
    private WebElement next2Page;

    @FindBy(xpath = "//div[@class=\"posts svelte-127jg4t\"]/a[4]/h2")
    private WebElement anyPost;

    @FindBy(xpath = "//a[@href=\"/?page=3\"]")
    private WebElement next3Page;
    @FindBy(xpath = "//a[@href=\"/?page=4\"]")
    private WebElement next4Page;

    public HomePage(WebDriver driver){
        super(driver);
    }
    public HomePage clickToNext2Page(){
        next2Page.click();
        return this;
    }
    public HomePage clickToAnyPost(){
        anyPost.click();
        return this;
    }
    public HomePage clickToNext3Page() {
        next3Page.click();
        return this;
    }
    public HomePage clickToNext4Page() {
        next4Page.click();
        return this;
}
    }
