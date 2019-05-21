package Com.nopCommerce.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NopCommerceLogIn {
	
public NopCommerceLogIn(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//*[@id=\"Email\"]")
	WebElement LoginEmail;
	
	@FindBy(xpath = "//*[@id=\"Password\"]")
	WebElement LoginPasswrd;
	
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/input")
	WebElement LoginButton;
	
	

}
