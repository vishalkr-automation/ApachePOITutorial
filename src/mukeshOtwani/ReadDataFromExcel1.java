package mukeshOtwani;

import org.testng.annotations.Test;

public class ReadDataFromExcel1 {
	
	@Test
	public void f(){
		
		ExcelDataConfig excel=new ExcelDataConfig(System.getProperty("user.dir")+ "\\ExcelDataMukeshOtwani\\ExcelDataValue.xlsx");
		String data=excel.getData(0, 1, 0);
		System.out.println(data);
		
	}

}
