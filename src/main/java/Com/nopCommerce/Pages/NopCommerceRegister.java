package Com.nopCommerce.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.nopCommerce.Base.TestBase;
import Com.nopCommerce.util.Readconfig;
import junit.framework.Assert;

public class NopCommerceRegister extends TestBase{
	
	public static WebDriver driver;
	
	Readconfig readconfig = new Readconfig();
	
	public NopCommerceRegister(WebDriver rdriver) {
		
		driver = rdriver;
		
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(xpath = "/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a")
	@CacheLookup
	WebElement RegisterLink;
	
	@FindBy(xpath = "//*[@id=\"gender-male\"]")
	@CacheLookup
	WebElement GenderMle;
	
	@FindBy(xpath = "//*[@id=\"gender-female\"]")
	@CacheLookup
	WebElement GenderFml;
	
	@FindBy(xpath = "//*[@id=\"FirstName\"]")
	@CacheLookup
	WebElement Firstname;
	
	@FindBy(xpath = "//*[@id=\"LastName\"]")
	@CacheLookup
	WebElement LastName;
	
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[1]")
	WebElement date;
	
	
	
	@FindBy(xpath = "//*[@id=\"Email\"]")
	@CacheLookup
	WebElement Email;
	
	@FindBy(xpath = "//*[@id=\"Password\"]")
	@CacheLookup
	WebElement Password;
	
	@FindBy(xpath = "//*[@id=\"ConfirmPassword\"]")
	@CacheLookup
	WebElement CnfPassword;
	
	@FindBy(xpath = "//*[@id=\"register-button\"]")
	@CacheLookup
	WebElement RegisterButton;
	
	@FindBy(xpath = "/html/body/div[6]/div[1]/div[2]/div[1]/a/img")
	@CacheLookup
	WebElement NOPlogo;

	public void RegTitle()
	{
	String Regtitle = driver.getTitle();
	Assert.assertEquals(Regtitle, "nopCommerce demo store");
	logger.info("Title verified");
	}
	
	public boolean RegLogo() {
		
		return NOPlogo.isDisplayed();
		
	}
	public void ClickOnRegister() {
		RegisterLink.click();
		logger.info("Click operation done in Registraion link");
		logger.info("Entering the required field for NOP registration");
	}
	public void SetuserName(String uname) {
		
		Firstname.sendKeys(uname);
	}
	public void SetlastName(String lName) {
		
		LastName.sendKeys(lName);
	}
	
	public void SetEmail(String mail) {
		
		Email.sendKeys(randomstring()+"@gmail.com");
	}
	public void Setpassword(String pwrd) {
		
		Password.sendKeys(pwrd);
	}
	public void SetCnfPassword(String Cnpwrd) {
		
		CnfPassword.sendKeys(Cnpwrd);
	}
	public void RegistrationNOp() {
		
		
		logger.info("Click operation done in Registraion link");
		logger.info("Entering the required field for NOP registration");
		GenderMle.click();
		logger.info("Male button clicked");
		Firstname.sendKeys(readconfig.RegGetuser1stname());
		logger.info("Entered firstname");
		LastName.sendKeys(readconfig.RegGetuser2ndname());
		logger.info("Entered lastname");
		Email.sendKeys(readconfig.Regemail());
		logger.info("Entered eMail");
		Password.sendKeys(readconfig.RegPswrd());
		logger.info("Entered password");
		CnfPassword.sendKeys(readconfig.RegRepswrd());
		logger.info("Entered Repassword");
		/*RegisterButton.click();
		logger.info("Clicked on Regoster Button for creating Account");*/
	}
	
	

}

