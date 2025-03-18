package jenkins.Sample.POM.OR.utility;

import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import jenkins.Sample.generic.fileutility.ExcelUtility;
import jenkins.Sample.generic.fileutility.FileUtility;
import jenkins.Sample.generic.webdriverutility.JavaUtility;
import jenkins.Sample.generic.webdriverutility.WebDriverUtility;

public class CreateNewContactsUsingDatesTest5 {

	public static void main(String[] args) throws Throwable {
		JavaUtility jlib = new JavaUtility();
		FileUtility flib = new FileUtility();
		WebDriverUtility wlib = new WebDriverUtility();
		ExcelUtility elib = new ExcelUtility();
		
	String BROWSER = flib.getDatafromPropertiesFile("browser");
	String URL = flib.getDatafromPropertiesFile("url");
	String USERNAME = flib.getDatafromPropertiesFile("username");
	String PASSWORD = flib.getDatafromPropertiesFile("password");
	
	//fetch TSD from excel file
	String LastName = elib.getDataFromExcel("Org", 1, 7)+ jlib.getRandomNumber();
	
	//write support date
	String startDateEdit = jlib.getSystemDateYYYYMMDD();
	String endDateEdit = jlib.getRequiredDateYYYYMMDD(30);
	
	WebDriver driver = null;
	if(BROWSER.equals("chrome")) {
		driver = new ChromeDriver();}
	else if(BROWSER.equals("firefox")) {
		driver = new FirefoxDriver();}
	else if(BROWSER.equals("edge")) {
		driver = new EdgeDriver();}
	else {
		driver = new ChromeDriver();}
	    
		//st1: login to app
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	    LoginPage lp = new LoginPage(driver);
	    lp.loginToApp(URL, USERNAME, PASSWORD);	
	    
	    //naviagte to contacts page
	    HomePage hp = new HomePage(driver);
	    hp.getContactslink().click();
	    
	    //click on create new contact btn
	    ContactsPage cp = new ContactsPage(driver);
	    cp.getCreateContactButton().click();
	    //enter lastname 
	    CreatingNewContactPage cncp = new CreatingNewContactPage(driver);
	    cncp.createContact(LastName, startDateEdit,endDateEdit);
	    	    
	    //verify Header msg
	  String actlastname = cp.getHeaderMsg().getText();
	    if(actlastname.contains(LastName)) {
	    	System.out.println("LastName:"+LastName+" is verified===>PASS");
	    }
	    else {
	    	System.out.println("LastName:"+LastName+" is not verified===>FAIL");
	    }
	    //logout
	    hp.logout();
	    driver.quit();
	    
	}

}
