package utils;

import org.apache.poi.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class ExcelUtils {

    public static Map<String, String> readData(String fileLoc, String sheetname){
        HashMap testData = new HashMap();
        try {
            FileInputStream fis = new FileInputStream(fileLoc);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);

            XSSFSheet excelsheet = workbook.getSheet(sheetname);
            Row row1 = excelsheet.getRow(0);
            Row row2 = excelsheet.getRow(1);
            for(int i=0; i<row1.getLastCellNum();i++){
                String row1_cell_value = row1.getCell(i).getStringCellValue();
                String row2_cell_value = row2.getCell(i).getStringCellValue();
                testData.put(row1_cell_value, row2_cell_value);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return testData;
    }


}
