package keyboardDriven_FW;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class  ExcelUtils {
	public XSSFWorkbook w;
	public XSSFSheet s;
  @Test(priority=1)
  public void setExcelFile(String path, String sheetName) throws IOException {
	  FileInputStream fip=new FileInputStream(path);
	  w=new XSSFWorkbook(fip);
	 s= w.getSheet(sheetName); 
	// return s;
	 
  }
  
  @Test(priority=2)
  public String getCellData(int row,int column) {
	String celldata;
	
	celldata=s.getRow(row).getCell(column).getStringCellValue();
	
	return celldata;
	  
	 
  }
  
}
