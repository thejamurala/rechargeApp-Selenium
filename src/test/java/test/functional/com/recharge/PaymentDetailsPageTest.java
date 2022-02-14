/**
 * 
 */
package test.functional.com.recharge;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import test.functional.com.recharge.utils.RechargeAPPConstants;
import test.functional.com.recharge.utils.RechargeAppUtils;

/**
 * @author thejaswimurala
 *
 */
public class PaymentDetailsPageTest {
	
	private WebDriver driver;

	public PaymentDetailsPageTest(WebDriver driver) {
		this.driver =  driver;
	}
	
	public  void testNewCardDetailsPage() {
		
		//Wait until the payment page loads.
		RechargeAppUtils.waitOnFieldForXPath(driver, RechargeAPPConstants.CARD_XPATH);
		
		WebElement card = driver.findElement(By.xpath(RechargeAPPConstants.CARD_XPATH));
//		RechargeAppUtils.waitOnFieldForXPath(driver, RechargeAPPConstants.CARD_XPATH);
		RechargeAppUtils.sleepFor(1000);
		card.click();
		
		//Select new card option
		WebElement useNewcard = driver.findElement(By.xpath(RechargeAPPConstants.NEW_CARD_XPATH));
		RechargeAppUtils.sleepFor(500);
		useNewcard.click();
		
		//find cardNubmer element
		WebElement cardnumber = driver.findElement(By.id("cardnumberunique"));
		RechargeAppUtils.waitOnFieldById(driver, "cardnumberunique");
//		RechargeAppUtils.sleepFor(5000);
		cardnumber.sendKeys("4111111111111111");

//		RechargeAppUtils.sleepFor(100);
		//find expiryMonth element
		WebElement expiryMonth = driver.findElement(By.xpath("//*[@id=\"payment-form\"]/div[3]/div[1]/div/div[1]/input"));
		expiryMonth.sendKeys("11");

		//find expiryYear element
		WebElement expiryYear = driver.findElement(By.xpath("//*[@id=\"payment-form\"]/div[3]/div[1]/div/div[3]/input"));
		expiryYear.sendKeys("25");

		//find cvv element
		WebElement cvv = driver.findElement(By.xpath("//*[@id=\"payment-form\"]/div[3]/div[2]/div/input"));
		cvv.sendKeys("111");
		
		//find email id element
		WebElement email1 = driver.findElement(By.xpath("/html/body/div[34]/div[1]/div[3]/div/div[1]/div/div/div[2]/div[2]/div/div/div/div/div/div/div[1]/table/tbody/tr[2]/td/div/div/div[2]/form/div[4]/div/div/input"));
		email1.sendKeys("test@test.com");
	}

}
