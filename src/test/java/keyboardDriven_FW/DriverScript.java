package keyboardDriven_FW;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class DriverScript {
	public WebDriver driver;
	ExcelUtils excel;
	ActionKeywords ackw;
  @Test
  public void login_module01() throws IOException, InterruptedException {
	  String path="C:\\Selenium_training\\test\\src\\test\\resources\\keyboarddriven.xlsx";
	  String sheetName="Sheet1";
	  excel=new  ExcelUtils();
	  ackw=new ActionKeywords();
	  excel.setExcelFile(path,sheetName);
	  
	  for(int irow=1;irow<=6;irow++)
	  {
		  String  actionKeywrd = excel.getCellData(irow,3);
		  if(actionKeywrd.equals("openbrowser"))
		  {
			  ackw.openbrowser();
		  }
		  else if(actionKeywrd.equals("navigate"))
		  {
			  ackw.navigate();;
		  }
		  else if(actionKeywrd.equals("inputusername"))
		  {
			  ackw.inputusername();;
		  }
		  else if(actionKeywrd.equals("inputpassword"))
		  {
			  ackw.inputpassword();;
		  }
		  else if(actionKeywrd.equals("clicklogin"))
		  {
			  ackw.clicklogin();;
		  }
		  else if(actionKeywrd.equals("closebrowser"))
		  {
			  ackw.closebrowser();;
		  }
		  
		  
	  }
	 

  }
}

