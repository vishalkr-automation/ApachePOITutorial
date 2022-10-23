package ReadAndWriteMultipleLoginMethod1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import ReadWriteMultipleLoginMethod4.ReadDataFromExcel;

public class ReadMultipleLogin {
	WebDriver driver;
	
	@Test(enabled=true)
	public void f1() throws Exception{
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		ReadDataFromExcel.readExcelFile(".\\LoginTestData\\ExcelDataValue.xlsx");
		
		//Count the total Number of rows from excel
		int rowCount=ReadDataFromExcel.getRowCount("Sheet1");
		System.out.println(rowCount);
		
		for(int i=1; i<=rowCount; i++){
		try{
		String userName=ReadDataFromExcel.getData("Sheet1", i, 0);
		String password=ReadDataFromExcel.getData("Sheet1", i, 1);
		driver.findElement(By.name("email")).sendKeys(userName);
		driver.findElement(By.name("passwd")).sendKeys(password);
		driver.findElement(By.name("SubmitLogin")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@title='Log me out']")).click();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		continue;
		}
		
	}
	
	@Test(enabled=false)
	public void f2() throws Exception{
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		ReadDataFromExcel.readExcelFile(".\\LoginTestData\\ExcelDataValue.xlsx");
		
		//Count the total Number of rows from excel
		int rowCount=ReadDataFromExcel.getRowCount("Sheet1");
		System.out.println(rowCount);
		
		for(int i=1; i<=rowCount; i++){
		
		String userName=ReadDataFromExcel.getData("Sheet1", i, 0);
		String password=ReadDataFromExcel.getData("Sheet1", i, 1);
		driver.findElement(By.name("email")).sendKeys(userName);
		driver.findElement(By.name("passwd")).sendKeys(password);
		try{
		driver.findElement(By.name("SubmitLogin")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@title='Log me out']")).click();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		}
		
	}
}
