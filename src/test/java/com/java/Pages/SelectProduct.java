package com.java.Pages;

import com.java.Util.WebTestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectProduct extends WebTestBase {
    public static void selectProduct() throws InterruptedException {
        //Select Product
        WebElement product = driver.findElement(By.className("form-control"));
        Select s = new Select(product);
        s.selectByVisibleText("Banana");
        List<WebElement> Alloptions = s.getOptions();

        for (WebElement e : Alloptions) {
            System.out.println(e.getText());
        }
        //Entering amount
        driver.findElement(By.id("buyAmount")).sendKeys("2");
        //clickBuy
        driver.findElement(By.xpath("//*[@id='buyForm']/button")).click();
    }


}
