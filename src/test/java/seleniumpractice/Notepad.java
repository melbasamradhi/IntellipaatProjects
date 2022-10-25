package seleniumpractice;
/*Launch Notepad Application
Enter Text in Notepad
Copy Text and Paste Text in Notepad
Save File
Close Application*/


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class Notepad {

	public static void main(String[] args) throws IOException, AWTException, InterruptedException {
		Runtime rs = Runtime.getRuntime();
		rs. exec("notepad");
//	Enter Text in Notepad
		Robot r= new Robot();
		r.keyPress(KeyEvent.VK_H);
		r.keyRelease(KeyEvent.VK_H);
		r.keyPress(KeyEvent.VK_E);
		r.keyRelease(KeyEvent.VK_E);
		r.keyPress(KeyEvent.VK_L);
		r.keyRelease(KeyEvent.VK_L);
		r.keyPress(KeyEvent.VK_L);
		r.keyRelease(KeyEvent.VK_L);
		r.keyPress(KeyEvent.VK_O);
		r.keyRelease(KeyEvent.VK_O);
		Thread.sleep(5000);
//	Copy Text and Paste Text in Notepad....CTRL+A..CTRL+C..CRTL+V
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_END);
		r.keyRelease(KeyEvent.VK_END);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
//save the notepad..press CTRL+S...COPY THE FILE PATH IN CLIPBOARD		
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_S);
		r.keyRelease(KeyEvent.VK_S);
		r.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(5000);
		StringSelection s= new StringSelection("C:\\Selenium_training\\hello.txt");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
		
//paste the path in the window ..ctrl+v..use Java Robot class
		
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000);
	//close the notepad
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_W);
		r.keyRelease(KeyEvent.VK_W);
		r.keyRelease(KeyEvent.VK_CONTROL);
	}

}
