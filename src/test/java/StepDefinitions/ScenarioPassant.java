package StepDefinitions;

import Utils.ConfigReader;
import Utils.ElementsUtiles;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pageFactory.CartPage;
import pageFactory.HomePage;
import pageFactory.LoginPage;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ScenarioPassant {
    WebDriver driver;
    LoginPage login;
    HomePage home;
    CartPage cart;

    Properties prop;
    ConfigReader site;

    ElementsUtiles element;

    @Given("Je me rends sur le site SwagLabs")
    public void je_me_rends_sur_le_site_swag_labs() {
        driver = new ChromeDriver();

        site = new ConfigReader();
        prop = site.ConfigurationManager();

        login = new LoginPage(driver);
        home = new HomePage(driver);
        cart = new CartPage(driver);
        driver.get(site.geturl());
        driver.manage().window().maximize();
    }

    @When("Je saisie le username")
    public void je_saisie_le_username() throws InterruptedException {
        login.saisirUserName(site.getusernname());
        Thread.sleep(3000);

    }
    @And("Je saisie le password")
    public void je_saisie_le_password() throws InterruptedException {
        login.saisirPassword(site.getpassword());
        Thread.sleep(3000);

    }
    @And("Je clique sur le bouton Login")
    public void je_clique_sur_le_bouton_login() throws InterruptedException {
        login.cliquerSurBoutonLogin();
        Thread.sleep(3000);

    }
    @And("La page des produit s affichent")
    public void la_page_des_produit_s_affichent() {
        element = new ElementsUtiles(driver);
        element.Confirmation("https://www.saucedemo.com/inventory.html");


    }
    @And("Je clique sur le bouton Add to cart du produit BackPack")
    public void je_clique_sur_le_bouton_add_to_cart_du_produit_back_pack() {
         home.cliquerSuraddToCartBachPackBouton();
    }
    @And("Je clique sur le bouton Add to cart du produit T-Shirt")
    public void je_clique_sur_le_bouton_add_to_cart_du_produit_t_shirt() {
        home.cliquerSuraddToCartTchirtBouton();
    }
    @Then("Les produit s ajoutent dans le panier")
    public void les_produit_s_ajoutent_dans_le_panier() throws InterruptedException {
         element = new ElementsUtiles(driver);
         element.recherche("Remove");

    }

    @And("Je clique sur l icone panier")
    public void je_clique_sur_l_icone_panier() {
        cart = new CartPage(driver);
        home = new HomePage(driver);
        home.cliquerSurpanierIcon();

    }
    @And("Je clique sur le bouton remove")
    public void je_clique_sur_le_bouton_remove() {
        cart.removeBouton();
    }
    @Then("Le produit sera supprimé du panier")
    public void le_produit_sera_supprimé_du_panier() throws InterruptedException {
        Thread.sleep(3000);
        element = new ElementsUtiles(driver);
        element.Confirmation("https://www.saucedemo.com/cart.html");

        element.recherche("Remove");

    }

    @When("Je clique sur le bouton checkout")
    public void je_clique_sur_le_bouton_checkout() {
        cart.checkOutBouton();
        element.scroll();
    }

    @When("Je rempli le username")
    public void je_rempli_le_username() {
         cart.saisirfirstName("standard_user");
    }

    @When("Je saisie le lastname")
    public void je_saisie_le_lastname() {
         cart.saisirLastName("user");
    }

    @When("Je saisie le code postal")
    public void je_saisie_le_code_postal() {
        cart.saisirCodePostal("5063");
    }

    @When("je clique sur le bouton continue")
    public void je_clique_sur_le_bouton_continue() {
        cart.continueBouton();
    }

    @Then("une page overview s affiche")
    public void une_page_overview_s_affiche() throws InterruptedException {
        Thread.sleep(3000);
        element = new ElementsUtiles(driver);
        element.Confirmation("https://www.saucedemo.com/checkout-step-two.html");
    }

    @When("je clique sur le bouton finish")
    public void je_clique_sur_le_bouton_finish() {
        cart.finishBouton();
    }

    @Then("une page Checkout:Complete s affiche")
    public void une_page_checkout_complete_s_affiche() throws InterruptedException {
        Thread.sleep(3000);
        element = new ElementsUtiles(driver);
        element.Confirmation("https://www.saucedemo.com/checkout-complete.html");
        element.recherche("Thank you for your order!\\n\" +\n" +
                "                \"Your order has been dispatched, and will arrive just as fast as the pony can get there!");
    }

    @When("Je clique sur le menu burger")
    public void je_clique_sur_le_menu_burger() throws InterruptedException {
        home = new HomePage(driver);
        home.cliquerSurmenuBurger();
        Thread.sleep(3000);
    }

    @When("Je clique surle bouton Logout")
    public void je_clique_surle_bouton_logout() {
        home.cliquerSurlogoutBouton();
    }

    @Then("Je me redirige vers la page d authentification {string}")
    public void je_me_redirige_vers_la_page_d_authentification(String string) throws InterruptedException {
        Thread.sleep(3000);
        element = new ElementsUtiles(driver);
        element.Confirmation("https://www.saucedemo.com/");
    }

}
