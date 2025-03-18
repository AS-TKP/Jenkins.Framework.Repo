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

public class CreateCampaignsUsingType_StatusTest7 {

	public static void main(String[] args) throws Throwable {
        JavaUtility jlib = new JavaUtility();
        FileUtility flib = new FileUtility();
        ExcelUtility elib = new ExcelUtility();
        WebDriverUtility wlib = new WebDriverUtility();
        
        //get login data from flib
        String BROWSER = flib.getDatafromPropertiesFile("browser");
        String URL = flib.getDatafromPropertiesFile("url");
        String USERNAME = flib.getDatafromPropertiesFile("username");
        String PASSWORD = flib.getDatafromPropertiesFile("password");
        
        //get excel data from elib
        String CampaignName = elib.getDataFromExcel("Org", 1, 15)+ jlib.getRandomNumber();
        String CampaignType = elib.getDataFromExcel("Org", 1, 16);
        System.out.println(CampaignType);
        String CampaignStatus = elib.getDataFromExcel("Org", 1, 17);
        System.out.println(CampaignStatus);
        String closingDateEdit = jlib.getRequiredDateYYYYMMDD(30);
        System.out.println(closingDateEdit);

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

    	//Login to app
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    	LoginPage lp = new LoginPage(driver);
    	lp.loginToApp(URL, USERNAME, PASSWORD);
    	
    	//click on more link
    	HomePage hp = new HomePage(driver);
    	hp.getMorelink().click();
    	hp.getCampaignslink().click();
//click on create camp btn
    	CampaignsPage cmpnP = new CampaignsPage(driver);
    	cmpnP.getCreateCampaignButton().click();
    	//creating new camp page
    	CreatingNewCampaignPage cncmpnP = new CreatingNewCampaignPage(driver);
    	cncmpnP.createCampaigns(CampaignName, CampaignType, CampaignStatus, closingDateEdit);
    	
    	//verify camp using info
    	String CampInfo = cmpnP.getCampInfoMsg().getText();
    	if(CampInfo.contains(CampaignName)) {
    		System.out.println("CampaignName:"+ CampaignName+ " is verified===>PASS");
    	}
    	else {
    		System.out.println("CampaignName:"+ CampaignName+ " is not verified===>FAIL");
    	}
    	//Logout
    	hp.logout();
    	driver.quit();
	}
}

