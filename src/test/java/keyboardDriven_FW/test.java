package keyboardDriven_FW;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//File f=new File();
		 FileInputStream fip=new FileInputStream("C:\\Selenium_training\\test\\src\\test\\resources\\keyboarddriven.xlsx");
		XSSFWorkbook  w =new XSSFWorkbook(fip);
		XSSFSheet s= w.getSheet("Sheet1"); 
	System.out.println(s.getRow(1).getCell(3).getStringCellValue());
	}

}
