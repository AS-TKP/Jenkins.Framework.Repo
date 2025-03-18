package jenkins.Sample.POM.OR.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
	WebDriver driver;
	public ProductsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
private WebElement createProductBtn;

public WebElement getCreateProductBtn() {
	return createProductBtn;
}
@FindBy(className="lvtHeaderText")
private WebElement ProductInfoMsg;

public WebElement getProductInfoMsg() {
	return ProductInfoMsg;
}



}
