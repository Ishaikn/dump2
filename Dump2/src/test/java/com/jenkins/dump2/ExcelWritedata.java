package com.jenkins.dump2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelWritedata {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream Excel = new FileInputStream(".\\src\\test\\resources\\Testdata.xlsx");
		Workbook wrk = WorkbookFactory.create(Excel);
		Sheet sht1 = wrk.createSheet("Sheet5");
		Sheet sht = wrk.getSheet("Sheet1");
		sht1.createRow(1).createCell(0).setCellValue("irshad");
		sht1.getRow(1).createCell(1).setCellValue("Aairah");
		sht1.getRow(1).createCell(2).setCellValue("India");
		sht1.getRow(1).createCell(3).setCellValue("Punganur");
		sht1.getRow(1).createCell(4).setCellValue("Andhra");

		FileOutputStream fout = new FileOutputStream(".\\src\\test\\resources\\Testdata.xlsx");
		wrk.write(fout);

		wrk.close();

//		Sheet sheet=wrk.createSheet("Test");

	}

}
