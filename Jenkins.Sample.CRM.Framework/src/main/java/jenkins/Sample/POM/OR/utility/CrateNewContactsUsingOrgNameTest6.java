package jenkins.Sample.POM.OR.utility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import jenkins.Sample.generic.fileutility.ExcelUtility;
import jenkins.Sample.generic.fileutility.FileUtility;
import jenkins.Sample.generic.webdriverutility.JavaUtility;
import jenkins.Sample.generic.webdriverutility.WebDriverUtility;

public class CrateNewContactsUsingOrgNameTest6 {
	public static void main(String[] args) throws Throwable {
		FileUtility flib = new FileUtility();
		JavaUtility jlib =new JavaUtility();
		ExcelUtility elib = new ExcelUtility();
		WebDriverUtility wlib = new WebDriverUtility();
		
	String BROWSER = flib.getDatafromPropertiesFile("browser");
	String URL = flib.getDatafromPropertiesFile("url");
	String USERNAME = flib.getDatafromPropertiesFile("username");
	String PASSWORD = flib.getDatafromPropertiesFile("password");
	
	//fetch TSD from excel file
	
	    String OrgName = elib.getDataFromExcel("Org", 1, 2)+ jlib.getRandomNumber();
		String LastName = elib.getDataFromExcel("Org", 1, 7)+ jlib.getRandomNumber();
	
	//launch browser
	WebDriver driver = null;
	if(BROWSER.equals("chrome")) {
		driver = new ChromeDriver();}
	else if(BROWSER.equals("firefox")) {
		driver = new FirefoxDriver();}
	else if(BROWSER.equals("edge")) {
		driver = new EdgeDriver();}
	else {
		driver = new ChromeDriver();}
	
	//login to app
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    LoginPage lp = new LoginPage(driver);
    lp.loginToApp(URL, USERNAME, PASSWORD);
    
	//naviagte to oraganization page
    HomePage hp = new HomePage(driver);
    hp.getOrganizationslink().click();
    //click on create new org btn
    OrganizationsPage op = new OrganizationsPage(driver);
    op.getCreateorganizationbtn().click();;
    //enter org name
    CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
	cnop.createOrg(OrgName);
	 //verify header msg
	   String OrgHeaderInfo = op.getOrgHeaderMsg().getText();
	   if(OrgHeaderInfo.contains(OrgName)) {
		   System.out.println("OrgName:"+OrgName+" is verified===>PASS");
	   }
	   else {
		   System.out.println("OrgName:"+OrgName+" is not verified===>FAIL");
	   }
	//naviagte to contacts page
	   hp.getContactslink().click();
	   //click on create new contat btn
	   ContactsPage cp = new ContactsPage(driver);
	   cp.getCreateContactButton().click();
	   //enter last name
	   CreatingNewContactPage cncp =  new CreatingNewContactPage(driver);
	   cncp.getLastNameEdit().sendKeys(LastName);
	   cncp.getOrgNameSelectButton().click();
	   //switch to ch page
	   wlib.switchToNewBrowser(driver, "Accounts&action");
	   //search & select from org page
	   op.getSearchEdit().sendKeys(OrgName);
	   op.getSearchNowButtonChildPage().click();
	   //click on srch orgname as it is a dynamic element so locate directly
	   driver.findElement(By.xpath("//a[text()='"+OrgName+"']")).click();
	   //switch back to parent window
	   wlib.switchToNewBrowser(driver, "Contacts&action");
	   //click on save btn
	   cncp.getSaveButton().click();
	   //verify header msg
	   String ContactsHeaderInfo = cp.getHeaderMsg().getText();
	   if(ContactsHeaderInfo.contains(LastName)) {
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
