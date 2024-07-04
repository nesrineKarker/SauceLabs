package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(id="add-to-cart-sauce-labs-backpack")
    WebElement addToCartBachPackBouton;

    @FindBy(id="add-to-cart-sauce-labs-bolt-t-shirt")
    WebElement addToCartTchirtBouton;

    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a")
    WebElement panierIcon;

    @FindBy(id = "react-burger-menu-btn")
    WebElement menuBurger;

    @FindBy(id = "logout_sidebar_link")
    WebElement logoutBouton;

    WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void cliquerSuraddToCartBachPackBouton(){
        addToCartBachPackBouton.click();
    }

    public void cliquerSuraddToCartTchirtBouton(){
        addToCartTchirtBouton.click();
    }

    public void cliquerSurpanierIcon(){
        panierIcon.click();
    }

    public void cliquerSurmenuBurger(){
        menuBurger.click();

    }

    public void cliquerSurlogoutBouton(){
        logoutBouton.click();

    }

}
