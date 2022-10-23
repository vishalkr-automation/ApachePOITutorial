package ReadAndWriteMultipleLoginMethod1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ReadAndWriteExcelMultipleLogin_Method2 {

	WebDriver driver;
	XSSFWorkbook wb;

	@Test
	public void f() throws Exception {

		File src = new File(".\\LoginTestData\\ExcelDataValue6.xlsx");
		FileInputStream fi = new FileInputStream(src);
		wb = new XSSFWorkbook(fi);
		XSSFSheet sheet = wb.getSheetAt(0);

		File src2 = new File(".\\LoginTestData\\ExcelDataValue7.xlsx");
		FileInputStream fis1 = new FileInputStream(src2);
		XSSFWorkbook wb1 = new XSSFWorkbook(fis1);
		XSSFSheet sheet1 = wb1.getSheetAt(0);
		FileOutputStream fout = new FileOutputStream(src2);

		int rowCount = sheet.getLastRowNum();
		System.out.println("Total Row Count: " + rowCount);

		String Result = null;

		for (int i = 1; i < rowCount + 1; i++) // rowcount+1 - is given because
												// here we are using i<rowcount
		{
			try {
				String userName = sheet.getRow(i).getCell(0).getStringCellValue();
				String password = sheet.getRow(i).getCell(1).getStringCellValue();

				System.out.println(userName);
				System.out.println(password);
				 
				System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe"); driver=new ChromeDriver();
				 driver.manage().window().maximize(); 
				 driver.get( "http://automationpractice.com/index.php?controller=authentication&back=my-account" ); 
				 driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
				 driver.findElement(By.name("email")).sendKeys(userName);
				 driver.findElement(By.name("passwd")).sendKeys(password);
				 driver.findElement(By.name("SubmitLogin")).click();
				 

				Thread.sleep(2000);
				driver.findElement(By.xpath("//a[@title='Log me out']")).click();

				Result = "Pass";

			} catch (Exception e) {

				Result = "Fail";
				System.out.println(e.getMessage());

			}

			Row row = sheet.getRow(i);

			int colCount = row.getLastCellNum();
			System.out.println("Total Column Number of First ExcelSheet: " + colCount);

			Row row2 = sheet1.createRow(i);
			for (int j = 0; j < row.getLastCellNum(); j++) {
				row2.createCell(2).setCellValue(Result);
				String data = row.getCell(j).getStringCellValue();
				System.out.println(data);
				row2.createCell(j).setCellValue(data);
			}

		}

		// First row (0 row) we have to create Row then we will set the data
		sheet1.createRow(0).createCell(0).setCellValue("UserName");
		sheet1.getRow(0).createCell(1).setCellValue("Password");
		sheet1.getRow(0).createCell(2).setCellValue("Result");

		wb1.write(fout);
		wb1.close();
	}

}