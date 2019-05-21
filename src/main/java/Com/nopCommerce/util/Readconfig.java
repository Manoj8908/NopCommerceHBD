package Com.nopCommerce.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Readconfig {
	
	Properties prop;
	
	public Readconfig() {
		
		File Src = new File("E:\\Selenium Programs\\NopCommerce\\src\\main\\java\\Com\\nopCommerce\\Cofiguration\\Config.properties");
		try {
			 prop = new Properties();
			FileInputStream fis = new FileInputStream(Src);
			prop.load(fis);
		} catch (IOException e) {
			System.out.println("Exceptio is:"+e.getMessage());
		}
	}
	public String BrowserName() {
		String browser = prop.getProperty("Browser") ;
		return browser;
	}
	public String GetApplicationURL() {
		
		String URL = prop.getProperty("BASEURL");
		return URL;
	}
	public String RegGetuser1stname() {
	String firstname = prop.getProperty("FirstName");
	return firstname;
	}
	public String RegGetuser2ndname() {
		String lastname = prop.getProperty("LastName");
		return lastname;
	}
	public String Regemail() {
		String email = prop.getProperty("Email");
		return email;
	}
	public String RegPswrd() {
		String password = prop.getProperty("Password");
		return password;
	}
	public String RegRepswrd() {
		String repassword = prop.getProperty("RePassword");
		return repassword;
	}
	
}
