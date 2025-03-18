package jenkins.Sample.POM.OR.utility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import jenkins.Sample.generic.fileutility.ExcelUtility;
import jenkins.Sample.generic.fileutility.FileUtility;
import jenkins.Sample.generic.webdriverutility.JavaUtility;
import jenkins.Sample.generic.webdriverutility.WebDriverUtility;

public class CreateOrg_DeleteCreatedOrgFromListTest11 {
	
	public static void main(String[] args) throws Throwable {
    ExcelUtility elib = new ExcelUtility();
    FileUtility flib = new FileUtility();
    JavaUtility jlib = new JavaUtility();
    WebDriverUtility wlib = new WebDriverUtility();
    /* fetch data from properties file present in file utility */
    String BROWSER = flib.getDatafromPropertiesFile("browser");
    String URL = flib.getDatafromPropertiesFile("url");
    String USERNAME = flib.getDatafromPropertiesFile("username");
    String PASSWORD = flib.getDatafromPropertiesFile("password");

    /* fetch data from excel utility */
    String OrgName = elib.getDataFromExcel("Org", 1, 2)+jlib.getRandomNumber();
    String OrgNameDD = elib.getDataFromExcel("Org", 1, 25);

    /* launch browser */
    WebDriver driver = null;
	if(BROWSER.equals("chrome")) {
		driver = new ChromeDriver();}
	else if(BROWSER.equals("firefox")) {
		driver = new FirefoxDriver();}
	else if(BROWSER.equals("edge")) {
		driver = new EdgeDriver();}
	else {
		driver = new ChromeDriver();}
	/* login to app and navigate to home page*/
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    LoginPage lp = new LoginPage(driver);
    lp.loginToApp(URL, USERNAME, PASSWORD);
    /* click on organizations link */
    HomePage hp = new HomePage(driver);
    hp.getOrganizationslink().click();
    /* click on create org button */
    OrganizationsPage op = new OrganizationsPage(driver);
    op.getCreateorganizationbtn().click();
    /* enter org name and click on save btn */
    CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
    cnop.createOrg(OrgName);
    /* verify created org name */
    String OrgheaderMsg = op.getOrgHeaderMsg().getText();
    if(OrgheaderMsg.contains(OrgName)) {
    	System.out.println("Org Name:"+OrgName+ " is verified==>PASS");
    }
    else {
    	System.out.println("Org Name:"+OrgName+ " is not verified==>FAIL");
    }
    /* come back to organizations page */
    hp.getOrganizationslink().click();
    /* go to search bar and enter org name & click on srch btn*/
    op.searchOrg(OrgName, OrgNameDD);   
    
	/*locate newly created org name as it is a dynamic element so locate directly*/
    WebElement NewlyCreatedOrg = driver.findElement(By.xpath("//a[text()='"+OrgName+"']"));
    
    /* click on delete link */
     op.moveToDeleteButton();
     op.handleDeleteAlert();
    
    hp.logout();
    driver.quit();
    
    
	}

}



























