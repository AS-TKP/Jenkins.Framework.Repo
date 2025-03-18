package jenkins.Sample.POM.OR.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class Auto_Healing_with_POMTest {
	@FindBy(name="user_name")
	WebElement UN;
	@FindBy(name="user_password")
	WebElement PWD;
	
	@FindAll({@FindBy(id="submitButton"), @FindBy(xpath="//input[@value=login]")})
	//@FindBys({@FindBy(id="submitButton"), @FindBy(xpath="//input[@value=login]")})
	WebElement Login;
	
	@Test
	public void AutoHealingPOMTest() {
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888");
		
		//create pagefactory class and call the initElements with (driver,classname.class) and give it a ref
		Auto_Healing_with_POMTest a = PageFactory.initElements(driver, Auto_Healing_with_POMTest.class);
		
		 //execute scripts with that ref
		a.UN.sendKeys("admin");
		a.PWD.sendKeys("admin");
		a.Login.click();
		System.out.println("hi");
		driver.quit();
	}
}
