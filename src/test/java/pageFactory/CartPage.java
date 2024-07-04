package pageFactory;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    @FindBy(id = "checkout")
    WebElement checkOutBouton;

    @FindBy(id = "first-name")
    WebElement champFirstname;

    @FindBy(id = "last-name")
    WebElement champlastname;

    @FindBy(id = "postal-code")
    WebElement champCodePostal;

    @FindBy(id="remove-sauce-labs-backpack")
    WebElement removeBouton;

    @FindBy(id="continue")
    WebElement continueBouton;

    @FindBy(id = "finish")
    WebElement finishBouton;

    WebDriver driver;
    public CartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }

    public void checkOutBouton(){
        checkOutBouton.click();
    }

    public void saisirfirstName(String FirstName){
        champFirstname.sendKeys(FirstName);
    }

    public void saisirLastName(String LastName){
        champlastname.sendKeys(LastName);
    }

    public void saisirCodePostal(String CodePostal){
        champCodePostal.sendKeys(CodePostal);
    }

    public void continueBouton(){
        continueBouton.click();
    }

    public void finishBouton(){
        finishBouton.click();
    }

    public void removeBouton(){
        removeBouton.click();
    }

}
