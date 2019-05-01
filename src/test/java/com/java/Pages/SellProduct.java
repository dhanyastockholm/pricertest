package com.java.Pages;

import org.openqa.selenium.By;

import com.java.Util.WebTestBase;

public class SellProduct extends WebTestBase {

    public static void sellProduct() {
        //click on the sell button.. taken from local.. so could not generate xpath properly

        driver.findElement(By.xpath("//*[@id='0']/th[4]/button")).click();
    }
}
