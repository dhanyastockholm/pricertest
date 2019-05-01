package com.java.Scenario;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.java.Pages.PriceTable;
import com.java.Pages.ReceiptTable;
import com.java.Pages.StorePage;
import com.java.Util.Setup;

public class RunTest extends Setup {

	@Test
	public void purchaseSingleItem() throws Exception {
		StorePage storePage = new StorePage(driver);
		PriceTable priceTable = new PriceTable(driver);
		int intialMoney = Integer.parseInt(storePage.moneyAvailable());
		System.out.println(intialMoney);
		System.out.println(priceTable.getProductPrice("Orange"));
		storePage.enterAmount("1");
		storePage.selectItemToBuy("Orange");
		storePage.buyItem();
		Assert.assertEquals(Integer.parseInt(storePage.moneyAvailable()),
				intialMoney - priceTable.getProductPrice("Orange"));
	}

	@Test(enabled = false)
	public void purchaseTwoItems() throws Exception {
		StorePage storePage = new StorePage(driver);
		PriceTable priceTable = new PriceTable(driver);
		int intialMoney = Integer.parseInt(storePage.moneyAvailable());
		System.out.println(intialMoney);
		System.out.println(priceTable.getProductPrice("Orange"));
		storePage.enterAmount("1");
		storePage.selectItemToBuy("Orange");
		storePage.buyItem();
		Assert.assertEquals(Integer.parseInt(storePage.moneyAvailable()),
				intialMoney - priceTable.getProductPrice("Orange"));
	}

	@Test
	// Assertion Error occurs. Failure test case
	public void productName() throws Exception {
		String productName = "Samsung S5";
		StorePage storePage = new StorePage(driver);
		PriceTable priceTable = new PriceTable(driver);
		int intialMoney = Integer.parseInt(storePage.moneyAvailable());
		System.out.println(intialMoney);
		System.out.println(priceTable.getProductPrice(productName));
		storePage.enterAmount("1");
		storePage.selectItemToBuy(productName);
		storePage.buyItem();
		ReceiptTable receiptTable = new ReceiptTable(driver);
		System.out.println("receiptTable.productName()..." + receiptTable.productName());
		Assert.assertEquals(productName, receiptTable.productName());

	}

	@Test
	public void visiblityOfSellButton() throws Exception {
		String productName = "Samsung S5";
		StorePage storePage = new StorePage(driver);
		PriceTable priceTable = new PriceTable(driver);
		int intialMoney = Integer.parseInt(storePage.moneyAvailable());
		System.out.println(intialMoney);
		System.out.println(priceTable.getProductPrice(productName));
		storePage.enterAmount("1");
		storePage.selectItemToBuy(productName);
		storePage.buyItem();
		ReceiptTable receiptTable = new ReceiptTable(driver);
		System.out.println("receiptTable.sellButtonIsPresent()..." + receiptTable.sellButtonIsPresent());
		Assert.assertEquals(true, receiptTable.sellButtonIsPresent());

	}
	
	
}
