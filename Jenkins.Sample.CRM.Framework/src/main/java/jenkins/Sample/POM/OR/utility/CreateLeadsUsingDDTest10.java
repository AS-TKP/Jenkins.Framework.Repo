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

public class CreateLeadsUsingDDTest10 {

	public static void main(String[] args) throws Throwable {
		ExcelUtility elib = new ExcelUtility();
		FileUtility flib = new FileUtility();
		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();
		
		String BROWSER = flib.getDatafromPropertiesFile("browser");
		String URL = flib.getDatafromPropertiesFile("url");
		String USERNAME = flib.getDatafromPropertiesFile("username");
		String PASSWORD = flib.getDatafromPropertiesFile("password");
		
		String FirstName = elib.getDataFromExcel("Org", 1, 22);
		String LastName = elib.getDataFromExcel("Org", 1, 7)+jlib.getRandomNumber();
		String Company = elib.getDataFromExcel("Org", 1, 10)+jlib.getRandomNumber();
		String Industry = elib.getDataFromExcel("Org", 1, 4);
		String LeadSource = elib.getDataFromExcel("Org", 1, 11);
		String LeadStatus = elib.getDataFromExcel("Org", 1, 23);
		String Rating = elib.getDataFromExcel("Org", 1, 24);
		
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
		hp.getLeadslink().click();
		
		LeadsPage ldp = new LeadsPage(driver);
		ldp.getCreateLeadButton().click();
		
		CreatingNewLeadPage cnlp = new CreatingNewLeadPage(driver);
		cnlp.createNewLead(FirstName, LastName, Company, Industry, LeadStatus, Rating, LeadSource);
		
		String LeadInfo = ldp.getLeadInfoMsg().getText();
		if(LeadInfo.contains(LastName)) {
			System.out.println("LeadInfo:"+LastName+" is verified===>PASS");
		}
		else {
			System.out.println("LeadInfo:"+LastName+" is not verified===>FAIL");
		}
        hp.logout();
        driver.quit();

		
		
	}

}
