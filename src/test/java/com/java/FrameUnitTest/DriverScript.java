package com.java.FrameUnitTest;

import com.java.ListOfActions.CommandList;
import com.java.Util.Retry;
import com.java.Util.WebTestBase;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class DriverScript {
    @Test(retryAnalyzer = Retry.class)
    public void TestCaseExecutor() throws BiffException, IOException {

        File f = new File("./src/test/java/com/java/ExternalSource/MasterSheet.xls");
        Workbook w = Workbook.getWorkbook(f);
        Sheet s = w.getSheet("Sheet1");
        int rowCount = s.getRows();
        int columnCount = s.getColumns();
        String flag = "";
        String command = "";
        String datas = "";
        for (int currentRow = 1; currentRow < rowCount; currentRow++) {
            try {
                flag = s.getCell(1, currentRow).getContents();
                if (flag.equalsIgnoreCase("yes") || flag.equalsIgnoreCase("y") || flag.equalsIgnoreCase("true")) {
                    for (int currenColumn = 2; currenColumn < columnCount; currenColumn++) {
                        command = s.getCell(currenColumn, currentRow).getContents();
                        datas = s.getCell(++currenColumn, currentRow).getContents();
                        CommandList.selectStep(command, datas);
                    }
                }
            } catch (Exception e) {
                WebTestBase.browserClose();

            }
        }
    }
}
