package com.jenkins.dump2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class FileOutpuStreamdata1 {
	public static void main(String[] args) throws IOException {

//		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Storedata.properties");
		
		Properties Pobj = new Properties();
		Pobj.setProperty("browser", "chrome");
		Pobj.setProperty("url", "http://rmgtestingserver/domain/Online_Banking_System/index.php");
		Pobj.setProperty("staffid", "210001");
		Pobj.setProperty("staffpwd", "password");

		FileOutputStream fout = new FileOutputStream(".\\src\\test\\resources\\Storedata.properties");
		Pobj.store(fout, "data");

	}
}
