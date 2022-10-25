package dataDrivenFramework_jxl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Write_Excelfile {

	public static void main(String[] args) throws IOException {
		File f= new File("C:\\Selenium_training\\write_Exl.xlsx");
		XSSFWorkbook w = new XSSFWorkbook();
		XSSFSheet s=w.createSheet("TestData");
		XSSFRow r=s.createRow(0);
		r.createCell(0).setCellValue("items");
		r.createCell(1).setCellValue("price");
		
		
		FileOutputStream fop=new FileOutputStream(f);
		w.write(fop);
		System.out.println("writing process success");
		w.close();
		
		
			
			
		
		}
		
		
	}


