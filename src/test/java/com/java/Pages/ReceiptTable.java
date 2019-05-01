package com.java.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReceiptTable extends PageObject{
	public ReceiptTable(WebDriver driver) {
        super(driver);
    }
	@FindBy(xpath = "//*[@id='0']/th[4]/button") 
	private WebElement wSellButton;
	@FindBy(xpath = "/html/body/div/table[1]")
	private WebElement wRecieptTable;
	@FindBy(xpath="//*[@id='0']/th[1]")
	private WebElement wProductName;

	public boolean sellButtonIsPresent() {
		return this.wSellButton.isDisplayed();
	}
	
	/*public verifyItemsAddedInRecipetTable(String ItemName,Int ItemPrice,String Amount,boolean sellbutton){
		
	}*/
	
	public String productName()
	{
		return this.wProductName.getText();
	}
}
