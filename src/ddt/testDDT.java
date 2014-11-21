package ddt;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import jxl.Sheet;
import jxl.Workbook;


public class testDDT {
	
		Sheet s;
		protected static WebDriver driver;
		protected static WebDriverWait wait;
		
		@Before
		public void setUp() throws Exception {
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
	
		public static WebDriver getFirefoxDriver() {
	        return driver;
	    }
		
		@Test
		public void searchGoogle() throws Exception	{

			FileInputStream fi = new FileInputStream("C:\\Users\\kaior\\workspace\\testProject\\resources\\teste_ddt.xls");
			Workbook w = Workbook.getWorkbook(fi);
			s = w.getSheet(0);
			for(int row=1; row < s.getRows();row++)
			{
				String username = s.getCell(0, row).getContents();
				System.out.println("Username "+username);
				driver.get("http://www.gmail.com");
				driver.findElement(By.name("Email")).sendKeys(username);
				String password= s.getCell(1, row).getContents();
				System.out.println("Password "+password);
				driver.findElement(By.name("Passwd")).sendKeys(password);
				driver.findElement(By.name("signIn")).click();
			}
		}
		
		@After
		public void tearDown()
		{
			driver.quit();
		}
		

	}



