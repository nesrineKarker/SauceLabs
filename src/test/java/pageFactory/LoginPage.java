package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(id = "user-name")
    WebElement champUserName;

    @FindBy(id="password")
    WebElement champPassword;

    @FindBy(id ="login-button")
    WebElement boutonLogin;

    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void saisirUserName(String LoginName){
        champUserName.sendKeys(LoginName);
    }

    public void saisirPassword(String password){
        champPassword.sendKeys(password);
    }

    public void cliquerSurBoutonLogin(){
        boutonLogin.click();
    }

}
