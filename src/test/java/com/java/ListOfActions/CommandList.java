package com.java.ListOfActions;

import com.java.Pages.SelectProduct;
import com.java.Pages.SellProduct;
import com.java.Util.WebTestBase;

public class CommandList {
public static void selectStep(String command, String datas) throws InterruptedException
{
	String value[]=datas.split(";;");
	switch(command.toLowerCase())
	{
	case "browseropen":
		WebTestBase.browserOpen(value[0]);
	break;
	
	case "browserclose":
		WebTestBase.browserClose();
	break;
	
	case "applaunch":
		WebTestBase.appLaunch(value[0]);
	break;
	
	case "selectProduct":
		SelectProduct.selectProduct();
	break;
	
	case "sellProduct":
		SellProduct.sellProduct();
	break;
	}
	
}
}
