package com.example.dataDrivenTesting;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadingDataFromExcel {
    public static void main(String[] args) throws IOException {
        FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/TestData/data.xlsx");  //File location
        XSSFWorkbook workbook = new XSSFWorkbook(file); //Extract workbook from Excel file
        XSSFSheet sheet = workbook.getSheet("Sheet1");

        int totalRow = sheet.getLastRowNum();
        int totalCells = sheet.getRow(1).getLastCellNum();

        System.out.println("Number of rows: " + totalRow);
        System.out.println("Number of cells " + totalCells);

        for (int r = 0; r <= totalRow; r++) {
            XSSFRow currentRow = sheet.getRow(r);
            for (int c = 0; c < totalCells; c++) {
                XSSFCell cell = currentRow.getCell(c);
                System.out.print(cell.toString() + "\t");
            }
            System.out.println();
        }
        workbook.close();
        file.close();
    }
}
