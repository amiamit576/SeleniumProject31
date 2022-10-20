package php.crm.Vtiger.project31.genericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import php.crm.Vtiger.project31.pomrepository.Homepage;
import php.crm.Vtiger.project31.pomrepository.LoginPage;

public class BaseClass {

	public WebDriver driver;
	public static WebDriver sDriver;
	public JavaUtility jutils=new JavaUtility();
	WebDriverUtility wUtils=new WebDriverUtility();
	@BeforeSuite
	public void bsconfig() {
		System.out.println("data base connections has been established");
	}
	@BeforeClass
	public void bcconfig() throws IOException  {
		String url = jutils.fetchDataFromPropertyFile("url");
		WebDriverManager.chromedriver().setup();//to set up browser
		driver=new ChromeDriver();
		wUtils.maximizeWindow(driver);
		wUtils.implicitwait(driver);
		driver.get(url);
		System.out.println("Chrome browser is launched ");
		System.out.println("naviagte to Vtiger");
		sDriver=driver;
	}
	@BeforeMethod
	public void bmconfig() throws IOException  {
		
		
	String username = jutils.fetchDataFromPropertyFile("username");
	String password = jutils.fetchDataFromPropertyFile("password");
	LoginPage login = new LoginPage(driver);
	login.loginAction(username, password);
	System.out.println("Login action ahs been completed");
	}
	@AfterMethod
	public void amconfig() {
		Homepage home = new Homepage(driver);
		home.logoutAction();
		System.out.println("Logout action has been completed");
	}
	
	@AfterClass
	public void aconfig() {
		driver.quit();
		System.out.println("browser has been closed");
	}
	
	@AfterSuite
	public void asconfig() {
		System.out.println("database connection has been closed");
	}
	

}
