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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateNewOrganisationUsingOrgNameTest1 {
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
String Industry = rw.getCell(4).toString();

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
    
    //naviagte to organization page
    HomePage hp = new HomePage(driver);
    hp.getOrganizationslink().click();
    //click on create new org btn
    OrganizationsPage op = new OrganizationsPage(driver);
    op.getCreateorganizationbtn().click();
    //enter all details 
    CreatingNewOrganizationPage cnop =new CreatingNewOrganizationPage(driver);
    cnop.createOrg(OrgName);
    //verify header msg
   String actorgname = op.getOrgHeaderMsg().getText();
   if(actorgname.contains(OrgName)) {
	   System.out.println("OrgName:"+OrgName+" is verified===>PASS");
   }
   else {
	   System.out.println("OrgName:"+OrgName+" is not verified===>FAIL");
   }
   //logout
   hp.logout();
	
	driver.quit();
}}
