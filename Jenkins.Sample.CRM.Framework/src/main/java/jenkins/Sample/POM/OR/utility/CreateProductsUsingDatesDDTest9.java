package jenkins.Sample.POM.OR.utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import jenkins.Sample.generic.fileutility.ExcelUtility;
import jenkins.Sample.generic.fileutility.FileUtility;
import jenkins.Sample.generic.webdriverutility.JavaUtility;
import jenkins.Sample.generic.webdriverutility.WebDriverUtility;

public class CreateProductsUsingDatesDDTest9 {
public static void main(String[] args) throws Throwable {
	ExcelUtility elib = new ExcelUtility();
	FileUtility flib = new FileUtility();
	JavaUtility jlib = new JavaUtility();
	WebDriverUtility wlib = new WebDriverUtility();
	
	String BROWSER = flib.getDatafromPropertiesFile("browser");
	String URL = flib.getDatafromPropertiesFile("url");
	String USERNAME = flib.getDatafromPropertiesFile("username");
	String PASSWORD = flib.getDatafromPropertiesFile("password");
	
	String ProductName = elib.getDataFromExcel("Org", 1, 19)+jlib.getRandomNumber();
	String ProductCategory = elib.getDataFromExcel("Org", 1, 20);
	System.out.println(ProductCategory);
	String Manufacturer = elib.getDataFromExcel("Org", 1, 21);
	System.out.println(Manufacturer);
	
	String salesStartDateEdit = jlib.getSystemDateYYYYMMDD();
	String salesEndDateEdit = jlib.getRequiredDateYYYYMMDD(30);
	String supportStartdateEdit = jlib.getSystemDateYYYYMMDD();
	String supportExpiryDateEdit = jlib.getRequiredDateYYYYMMDD(30);
	
	WebDriver driver = null;
	if(BROWSER.equals("chrome")) {
		driver = new ChromeDriver();}
	else if(BROWSER.equals("firefox")) {
		driver = new FirefoxDriver();}
	else if(BROWSER.equals("edge")) {
		driver = new EdgeDriver();}
	else {
		driver = new ChromeDriver();}

	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	LoginPage lp = new LoginPage(driver);
	lp.loginToApp(URL, USERNAME, PASSWORD);
	
	HomePage hp = new HomePage(driver);
	hp.getProductslink().click();
	
	ProductsPage pp = new ProductsPage(driver);
	pp.getCreateProductBtn().click();
	
	CreatingNewProductPage cnpp = new CreatingNewProductPage(driver);
	cnpp.createProduct(ProductName, salesStartDateEdit, ProductCategory, salesEndDateEdit,
			Manufacturer, supportStartdateEdit, supportExpiryDateEdit);
	
	String ProductInfo = pp.getProductInfoMsg().getText();
	if(ProductInfo.contains(ProductName)) {
		System.out.println("ProductName:"+ ProductName+" is verified===>PASS");
	}
	else {
		System.out.println("ProductName:"+ ProductName+" is not verified===>FAIL");
	}
	hp.logout();
	driver.quit();
}
}






























