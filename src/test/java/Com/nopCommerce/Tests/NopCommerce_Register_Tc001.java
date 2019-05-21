package Com.nopCommerce.Tests;

import org.testng.annotations.Test;

import Com.nopCommerce.Base.TestBase;
import Com.nopCommerce.Pages.NopCommerceRegister;

public class NopCommerce_Register_Tc001 extends TestBase {
	
	
	@Test
	public void RegisterNopCommerce() {
		
		NopCommerceRegister NCR = new NopCommerceRegister(driver);
		NCR.RegTitle();
		NCR.RegLogo();
		NCR.ClickOnRegister();
		NCR.RegistrationNOp();
	
	}
	

}
