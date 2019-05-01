package com.java.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class StorePage extends PageObject {
    public StorePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"message\"]")
    private WebElement wMessage;
    @FindBy(xpath= "//*[@id=\"money\"]")
    private WebElement wMoney;
    @FindBy(xpath = "//*[@id=\"buyAmount\"]")
    private WebElement wAmount;
    @FindBy(xpath = "//*[@id=\"buyForm\"]/button")
    private WebElement wBuyButton;
    @FindBy(xpath = "//*[@id=\"message\"]")
    private WebElement wPriceTable;
    @FindBy(xpath = "//*[@id=\"message\"]")
    private WebElement wReciept;
    @FindBy(className = "form-control")
    private WebElement wSelect;
    @FindBy(xpath = "//*[@id=\"0\"]/th[4]/button")
    private WebElement wSellButton;


    public void enterAmount(String amount) {
        this.wAmount.clear();
        this.wAmount.sendKeys(amount);
    }

    public void selectItemToBuy(String itemToSelect) {
        Select select = new Select(wSelect);
        select.selectByVisibleText(itemToSelect);
    }

    public void buyItem(){
        this.wBuyButton.click();
    }
    public String moneyAvailable()
    {
        return this.wMoney.getText();
    }


}
