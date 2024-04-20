package com.jenkins.dump2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.stream.FileImageInputStream;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DDTFromExcel {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		FileInputStream Excel = new FileInputStream(".\\src\\test\\resources\\Testdata.xlsx");

		Workbook wrk = WorkbookFactory.create(Excel);

		Sheet sht = wrk.getSheet("Sheet1");
		int rowcount = sht.getLastRowNum();//0 based index
		int cellcount = sht.getRow(0).getLastCellNum();//1 bases index
		
		//getphysicalrow

		for (int i = 0; i <= rowcount; i++) {
			for (int j = 0; j < cellcount; j++) {
				String Value = sht.getRow(i).getCell(j).getStringCellValue();
				System.out.print(Value + " ");
			}System.err.println();
		}
		
		wrk.close();
	}

}

//FileInputStream Exc=new FileInputStream(".\\src\\test\\resources\\Testdata.xlsx");
//
//Workbook workbook1=WorkbookFactory.create(fis);
// 
//Sheet sht = workbook1.getSheet("Sheet1");
//////Row rw = sht.getRow(1);
//////Cell d = rw.getCell(1);
////String value = sht.getRow(0).getCell(0).getStringCellValue();
////System.out.println(value);
//int rowcount = sht.getLastRowNum();
//int cellcount = sht.getRow(0).getLastCellNum();
//for (int i = 0; i < rowcount; i++) {
//
//	for (int j = 0; j < cellcount; j++) {
//		String value = sht.getRow(i).getCell(j).getStringCellValue();
//		System.out.print(value + " ");
//	}
//	System.out.println(" ");
//String value = sht.getRow(3).getCell(3).getStringCellValue();
//System.out.println(value);