package Com.nopCommerce.Tests;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Com.nopCommerce.Base.TestBase;
import Com.nopCommerce.Pages.NopCommerceRegister;
import Com.nopCommerce.util.XLUtils;

public class NopCommerce_RegisterDDT_Tc002 extends TestBase {

	@Test(dataProvider="RegisterData")
	public void RegisterDDT(String user,String lName,String pswrd,String cpswrd) {
		
		NopCommerceRegister NCR = new NopCommerceRegister(driver);
		
		NCR.ClickOnRegister(); 
		NCR.SetuserName(user);
		logger.info("Entered FirstName");
		NCR.SetlastName(lName);
		logger.info("Entered LastName");
		NCR.Setpassword(pswrd);
		logger.info("Entered password");
		NCR.SetCnfPassword(cpswrd);
		logger.info("Entered cnfpassword");
		
		
		
	}
	
	@DataProvider(name="RegisterData")
	String[][] getData() throws IOException{
		
		 String Path = System.getProperty("user.dir")+"/src/main/java/Com/nopCommerce/TestData/nopCommerce.xlsx";
		 int rownum = XLUtils.getRowCount(Path, "RegisterData");
		 int colcount = XLUtils.getCellCount(Path, "RegisterData", 1);
		 
		 String Registerdata[][]=new String[rownum][colcount];
		 
		 for(int i =1;i<=rownum;i++) {
			 
			 for(int j = 0;j<colcount;j++) {
				 
				 Registerdata[i-1][j]=XLUtils.getCellData(Path, "RegisterData", i, j);
			 }
		 }
		 return Registerdata;
		 
	}

}
