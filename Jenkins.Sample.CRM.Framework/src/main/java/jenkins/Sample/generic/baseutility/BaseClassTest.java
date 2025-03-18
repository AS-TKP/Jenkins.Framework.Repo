package jenkins.Sample.generic.baseutility;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import jenkins.Sample.POM.OR.utility.HomePage;
import jenkins.Sample.POM.OR.utility.LoginPage;
import jenkins.Sample.generic.databaseutility.DataBaseUtility;
import jenkins.Sample.generic.fileutility.ExcelUtility;
import jenkins.Sample.generic.fileutility.FileUtility;
import jenkins.Sample.generic.webdriverutility.JavaUtility;
import jenkins.Sample.generic.webdriverutility.UtilityClassObject;
import jenkins.Sample.generic.webdriverutility.WebDriverUtility;

public class BaseClassTest {
	public DataBaseUtility dblib = new DataBaseUtility();
	public ExcelUtility elib = new ExcelUtility();
	public FileUtility flib = new FileUtility();
	public JavaUtility jlib = new JavaUtility();
	public WebDriverUtility wlib = new WebDriverUtility();
	public WebDriver driver = null;
	
	public static WebDriver Sdriver = null; 
	//it wont participate in parallel execution due to static modifier so create a localThread for multiple objects

	@BeforeSuite(groups = {"SmokeTest", "RegressionTest"})
	public void configBS() throws Throwable {
		/* establish connection with db & report configuration */
		dblib.getDbConnection();
	}
//@Parameters("BROWSER")
//	@BeforeClass(groups = {"SmokeTest", "RegressionTest"})
//	public void configBC(String browser) throws Throwable {
//		/* launch browser */
//		String BROWSER = browser;
//				//flib.getDatafromPropertiesFile("browser");
//
//		if (BROWSER.equals("chrome")) {
//			driver = new ChromeDriver();
//		} else if (BROWSER.equals("firefox")) {
//			driver = new FirefoxDriver();
//		} else if (BROWSER.equals("edge")) {
//			driver = new EdgeDriver();
//		} else {
//			driver = new ChromeDriver();
//		}
//	}
@BeforeClass(groups = {"SmokeTest", "RegressionTest"})
public void configBC() throws Throwable {
	/* launch browser */
	String BROWSER = flib.getDatafromPropertiesFile("browser");

	if (BROWSER.equals("chrome")) {
		driver = new ChromeDriver();
	} else if (BROWSER.equals("firefox")) {
		driver = new FirefoxDriver();
	} else if (BROWSER.equals("edge")) {
		driver = new EdgeDriver();
	} else {
		driver = new ChromeDriver();
	}
	Sdriver = driver;
	UtilityClassObject.setDriver(driver); //in order to create multiple objects
}

	@BeforeMethod(groups = {"SmokeTest", "RegressionTest"})
	public void configBM() throws Throwable {
		/* login */
		String URL = flib.getDatafromPropertiesFile("url");
		String USERNAME = flib.getDatafromPropertiesFile("username");
		String PASSWORD = flib.getDatafromPropertiesFile("password");
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(URL, USERNAME, PASSWORD);
	}

	@AfterMethod(groups = {"SmokeTest", "RegressionTest"})
	public void configAM() {
		/* logout */
		HomePage hp = new HomePage(driver);
		hp.logout();
	}

	@AfterClass(groups = {"SmokeTest", "RegressionTest"})
	public void configAC() {
		/* close browser */
		driver.quit();
	}

	@AfterSuite(groups = {"SmokeTest", "RegressionTest"})
	public void configAS() throws Throwable {
		/* close connection with db & report backup */
		dblib.closeDbconnection();
	}

}
