package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class ElementsUtiles {
    WebDriver driver;
    public ElementsUtiles(WebDriver driver){
        this.driver = driver;
    }

    public void Confirmation(String url){
        String actualurl = url;
        String expectedurl = driver.getCurrentUrl();
        Assert.assertEquals(actualurl,expectedurl);

    }

    public void recherche(String message){
        String pagecontent =driver.findElement(By.tagName("html")).getText();
        List<String> motrecherche = new ArrayList<>();
        motrecherche.add(message);
        for (String mot : motrecherche) {
            if (pagecontent.contains(mot)) {
                System.out.println("le mot " + mot + "  existe sur la page");
            } else {
                System.out.println("le mot " + mot + " n'existe pas sur la page");
            }

        }

    }

    public void scroll(){
        JavascriptExecutor jse = ((JavascriptExecutor) driver);
        jse.executeScript("window.scrollBy(0," + 500 + ");");
    }
}
