package com.java.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PriceTable extends PageObject {
	public PriceTable(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "/html/body/div/table[1]")
	private WebElement wPriceTable;

	public int getProductPrice(String itemSelected) {
		List<WebElement> rows = wPriceTable.findElements(By.tagName("tr"));
		for (int j = 0; j < rows.size(); j++) {
			String get = rows.get(j).getText();
			if (get.contains(itemSelected)) {
				return Integer.parseInt(get.substring(get.lastIndexOf(" ") + 1, get.length()));
			}
		}
		return 0;
	}

}