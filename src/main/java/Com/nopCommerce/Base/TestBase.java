package Com.nopCommerce.Base;


import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import Com.nopCommerce.util.Readconfig;
import Com.nopCommerce.util.TestUtil;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static Logger logger;
	
	static Properties prop;
	
	public static WebDriver driver;
	
	Readconfig readconfig = new Readconfig();
	
	/*public TestBase() {
		
		try {
			 prop = new Properties();
			FileInputStream fis = new FileInputStream("E:\\Selenium Programs\\NopCommerce\\src\\main\\java\\Com\\nopCommerce\\Cofiguration\\Config.properties");
			prop.load(fis);
		} catch (IOException e) {
			System.out.println("Exceptio is:"+e.getMessage());
		}
	
	}*/
	@BeforeClass
	public void SetUp() {
		
		logger = Logger.getLogger("NopCommerce");
		PropertyConfigurator.configure("Log4j.properties");
		
		String BrowserName = readconfig.BrowserName();
		if(BrowserName.equals("Firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(BrowserName.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.page_load_timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_wait, TimeUnit.SECONDS);
		
		driver.get(readconfig.GetApplicationURL());
		logger.info("Open Browser with URL");
		
	}
	@AfterClass
	public void Teardown() {
		
		driver.quit();
	}
public void captureScreen(WebDriver driver,String tname) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+ "/ScreenShots" + tname +".png");
		FileUtils.copyFile(src,target);
		System.out.println("Screenshot taken");
}
	public String randomstring() {
		
		String GeneratedString = RandomStringUtils.randomAlphabetic(12);
		return(GeneratedString);
	}
	
	public static String randomnumber() {
		
		String GeneratedNumber = RandomStringUtils.randomNumeric(6);
		return(GeneratedNumber);
	}
	
	}

