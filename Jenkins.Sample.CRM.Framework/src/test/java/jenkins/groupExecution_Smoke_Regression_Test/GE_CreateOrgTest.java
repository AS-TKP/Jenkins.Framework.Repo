package jenkins.groupExecution_Smoke_Regression_Test;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import jenkins.Sample.POM.OR.utility.CreatingNewOrganizationPage;
import jenkins.Sample.POM.OR.utility.HomePage;
import jenkins.Sample.POM.OR.utility.OrganizationsPage;
import jenkins.Sample.generic.baseutility.BaseClassTest;

public class GE_CreateOrgTest extends BaseClassTest{
	@Test(groups = {"SmokeTest"})
	public void CreateOrgTest() throws Throwable {
	    String OrgName = elib.getDataFromExcel("Org", 1, 2)+ jlib.getRandomNumber();

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
		}
	@Test(groups = {"RegressionTest"})
	public void CreateOrgWithIndustryTest() throws Throwable {
		
		System.out.println("Execute Create Org With Industry Test");
		
//		String OrgName = elib.getDataFromExcel("Org", 1, 2)+ jlib.getRandomNumber();
//		String Industry = elib.getDataFromExcel("Org", 1, 4);
//		//naviagte to organization page
//	    HomePage hp = new HomePage(driver);
//	    hp.getOrganizationslink().click();
//	    //click on create new org btn
//	    OrganizationsPage op = new OrganizationsPage(driver);
//	    op.getCreateorganizationbtn().click();
//	    //enter all details 
//	    CreatingNewOrganizationPage cnop =new CreatingNewOrganizationPage(driver);
//	    cnop.createOrg(OrgName, Industry);
//	    //verify header msg
//	   String actorgname = op.getOrgHeaderMsg().getText();
//	   if(actorgname.contains(OrgName)) {
//		   System.out.println("OrgName:"+OrgName+" is verified===>PASS");
//	   }
//	   else {
//		   System.out.println("OrgName:"+OrgName+" is not verified===>FAIL");
//	   }
	}
	//@Test(groups = {"SmokeTest", "RegressionTest"})
//	public void CreateOrg_DeleteCreatedOrgFromListTest() throws Throwable {
//		String OrgName = elib.getDataFromExcel("Org", 1, 2)+jlib.getRandomNumber();
//	    String OrgNameDD = elib.getDataFromExcel("Org", 1, 25);
//	    /* click on organizations link */
//	    HomePage hp = new HomePage(driver);
//	    hp.getOrganizationslink().click();
//	    /* click on create org button */
//	    OrganizationsPage op = new OrganizationsPage(driver);
//	    op.getCreateorganizationbtn().click();
//	    /* enter org name and click on save btn */
//	    CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
//	    cnop.createOrg(OrgName);
//	    /* verify created org name */
//	    String OrgheaderMsg = op.getOrgHeaderMsg().getText();
//	    if(OrgheaderMsg.contains(OrgName)) {
//	    	System.out.println("Org Name:"+OrgName+ " is verified==>PASS");
//	    }
//	    else {
//	    	System.out.println("Org Name:"+OrgName+ " is not verified==>FAIL");
//	    }
//	    /* come back to organizations page */
//	    hp.getOrganizationslink().click();
//	    /* go to search bar and enter org name & click on srch btn*/
//	    op.searchOrg(OrgName, OrgNameDD);   
//	    
//		/*locate newly created org name as it is a dynamic element so locate directly*/
//	    WebElement NewlyCreatedOrg = driver.findElement(By.xpath("//a[text()='"+OrgName+"']"));
//	    
//	    /* click on delete link */
//	     op.moveToDeleteButton();
//	     op.handleDeleteAlert();
//	}
	}

