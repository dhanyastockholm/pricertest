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
		storePage.enterAmount("1");
		storePage.selectItemToBuy("Orange");
		storePage.buyItem();
		Assert.assertEquals(Integer.parseInt(storePage.moneyAvailable()),
				intialMoney - priceTable.getProductPrice("Orange"));
	}

	@Test
	// Assertion Error occurs. Failure test case for product name mismatch
	public void productName() throws Exception {
		String productName = "Samsung S5";
		StorePage storePage = new StorePage(driver);
		storePage.enterAmount("1");
		storePage.selectItemToBuy(productName);
		storePage.buyItem();
		ReceiptTable receiptTable = new ReceiptTable(driver);
		Assert.assertEquals(productName, receiptTable.productName());

	}

	@Test
	public void sellButtonVisiblity() throws Exception {
		String productName = "Banana";
		StorePage storePage = new StorePage(driver);
		PriceTable priceTable = new PriceTable(driver);
		priceTable.getProductPrice(productName);
		storePage.enterAmount("1");
		storePage.selectItemToBuy(productName);
		storePage.buyItem();
		ReceiptTable receiptTable = new ReceiptTable(driver);
		Assert.assertEquals(true, receiptTable.sellButtonIsPresent());

	}

	@Test
	// Assertion Error. Failure test case foe decimal bug
	public void validateDecimalAmount() throws Exception {

		StorePage storePage = new StorePage(driver);
		ReceiptTable receiptTable = new ReceiptTable(driver);
		storePage.selectItemToBuy("Grape");
		storePage.enterAmount("2.6");
		storePage.buyItem();
		Assert.assertEquals(false, receiptTable.sellButtonIsPresent());
	}

}
