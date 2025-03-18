package jenkins.Sample.POM.OR.utility;

import java.io.FileInputStream;
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

public class CreateNewContactsUsingLeadSourceTest4 {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream("C:\\Users\\anjal\\Desktop\\commondata.properties");
		Properties Pobj = new Properties();
		Pobj.load(fis);
	String BROWSER = Pobj.getProperty("browser");
	String URL = Pobj.getProperty("url");
	String USERNAME = Pobj.getProperty("username");
	String PASSWORD = Pobj.getProperty("password");
	//generate random number
	Random rndm = new Random();
	int RndmInt = rndm.nextInt(1000);
	//fetch TSD from excel file
	FileInputStream fis1 = new FileInputStream("C:\\Users\\anjal\\Desktop\\TestScriptData.xlsx");
	Workbook wb = WorkbookFactory.create(fis1);
	Sheet sh = wb.getSheet("Org");
	Row rw = sh.getRow(1);
	String OrgName = rw.getCell(2).toString() + RndmInt;
	String LastName = rw.getCell(7).toString() + RndmInt;
	String LeadSource = rw.getCell(11).toString();
	wb.close();
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
	    
	    //click on create new org btn
	    ContactsPage cp = new ContactsPage(driver);
	    cp.getCreateContactButton().click();
	    //enter lastname lead source from dd
	    CreatingNewContactPage cncp = new CreatingNewContactPage(driver);
	    cncp.createContact(LastName, LeadSource);
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
