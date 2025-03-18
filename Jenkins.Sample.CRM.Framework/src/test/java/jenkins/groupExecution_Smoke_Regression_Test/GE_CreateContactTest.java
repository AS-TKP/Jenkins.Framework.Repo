package jenkins.groupExecution_Smoke_Regression_Test;

import org.openqa.selenium.By;

import org.testng.annotations.Test;

import jenkins.Sample.POM.OR.utility.ContactsPage;
import jenkins.Sample.POM.OR.utility.CreatingNewContactPage;
import jenkins.Sample.POM.OR.utility.CreatingNewOrganizationPage;
import jenkins.Sample.POM.OR.utility.HomePage;
import jenkins.Sample.POM.OR.utility.OrganizationsPage;
import jenkins.Sample.generic.baseutility.BaseClassTest;



public class GE_CreateContactTest extends BaseClassTest {
	@Test(groups = "SmokeTest")
	public void CreateContactTest() throws Throwable {
		String URL = System.getProperty("url");
	    String BROWSER = System.getProperty("browser");
	    String USERNAME = System.getProperty("username");
	    String PASSWORD = System.getProperty("password");
	    
	    System.out.println(URL);
	    System.out.println(BROWSER);
	    System.out.println(USERNAME);
	    System.out.println(PASSWORD);
	    
		// fetch TSD from excel file
		String LastName = elib.getDataFromExcel("Org", 1, 7) + jlib.getRandomNumber();
		// naviagte to contacts page
		HomePage hp = new HomePage(driver);
		hp.getContactslink().click();
		// click on create new org btn
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateContactButton().click();
		// enter lastname
		CreatingNewContactPage cncp = new CreatingNewContactPage(driver);
		cncp.createContact(LastName);
		System.out.println("Executed CreateContactTest");
		
	}

	@Test(groups = {"RegressionTest"})
	public void CreateContactWithDateTest() throws Throwable {
		
		System.out.println("Executed CreateContactWithDateTest");
		
//		// fetch TSD from excel file
//		String LastName = elib.getDataFromExcel("Org", 1, 7) + jlib.getRandomNumber();
//
//		// write support date
//		String startDateEdit = jlib.getSystemDateYYYYMMDD();
//		String endDateEdit = jlib.getRequiredDateYYYYMMDD(30);
//
//		// naviagte to contacts page
//		HomePage hp = new HomePage(driver);
//		hp.getContactslink().click();
//
//		// click on create new contact btn
//		ContactsPage cp = new ContactsPage(driver);
//		cp.getCreateContactButton().click();
//		// enter lastname
//		CreatingNewContactPage cncp = new CreatingNewContactPage(driver);
//		cncp.createContact(LastName, startDateEdit, endDateEdit);
	}
	
	@Test(groups = {"RegressionTest"})
	public void CreateContactWithOrgNameTest() throws Throwable {
		
		System.out.println("Executed CreateContactWithOrgNameTest");
		
//		//fetch TSD from excel file
//	    String OrgName = elib.getDataFromExcel("Org", 1, 2)+ jlib.getRandomNumber();
//		String LastName = elib.getDataFromExcel("Org", 1, 7)+ jlib.getRandomNumber();
//		//naviagte to oraganization page
//	    HomePage hp = new HomePage(driver);
//	    hp.getOrganizationslink().click();
//	    //click on create new org btn
//	    OrganizationsPage op = new OrganizationsPage(driver);
//	    op.getCreateorganizationbtn().click();;
//	    //enter org name
//	    CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
//		cnop.createOrg(OrgName);
//		
//		//naviagte to contacts page
//		   hp.getContactslink().click();
//		   //click on create new contat btn
//		   ContactsPage cp = new ContactsPage(driver);
//		   cp.getCreateContactButton().click();
//		   //enter last name
//		   CreatingNewContactPage cncp =  new CreatingNewContactPage(driver);
//		   cncp.getLastNameEdit().sendKeys(LastName);
//		   cncp.getOrgNameSelectButton().click();
//		   //switch to ch page
//		   wlib.switchToNewBrowser(driver, "Accounts&action");
//		   //search & select from org page
//		   op.getSearchEdit().sendKeys(OrgName);
//		   op.getSearchNowButtonChildPage().click();
//		   //click on srch orgname as it is a dynamic element so locate directly
//		   driver.findElement(By.xpath("//a[text()='"+OrgName+"']")).click();
//		   //switch back to parent window
//		   wlib.switchToNewBrowser(driver, "Contacts&action");
//		   //click on save btn
//		   cncp.getSaveButton().click();
	}
	
	@Test(groups = "SmokeTest")
	public void CreateContactUsingLeadSourceTest() throws Throwable {
		
		System.out.println("Executed CreateContactUsingLeadSourceTest");
		
//	    String OrgName = elib.getDataFromExcel("Org", 1, 2)+ jlib.getRandomNumber();
//		String LastName = elib.getDataFromExcel("Org", 1, 7)+ jlib.getRandomNumber();
//		String LeadSource = elib.getDataFromExcel("Org", 1, 11);
//		//naviagte to contacts page
//	    HomePage hp = new HomePage(driver);
//	    hp.getContactslink().click();
//	    
//	    //click on create new org btn
//	    ContactsPage cp = new ContactsPage(driver);
//	    cp.getCreateContactButton().click();
//	    //enter lastname lead source from dd
//	    CreatingNewContactPage cncp = new CreatingNewContactPage(driver);
//	    cncp.createContact(LastName, LeadSource);
	}
	
}

