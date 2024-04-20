package com.jenkins.dump2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excelassessment {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(".\\src\\main\\resources\\1.xlsx");

		Workbook book = WorkbookFactory.create(fis);

		Sheet sht = book.getSheet("Sheet1");

		int rownum = sht.getLastRowNum();
		int colnum = sht.getRow(0).getLastCellNum();

		for (int i = 0; i <= rownum; i++) {
			for (int j = 0; i < colnum; j++) {

				if (sht.getRow(i).getCell(0).getStringCellValue().contains("Name")) {
					String value = sht.getRow(i).getCell(j).getStringCellValue();
					String value1 = sht.getRow(0).getCell(j).getStringCellValue();
					System.out.println("Row Values: --> " + value);

				}

			}
		}

	}
}
