/**
 * 
 */
package test.functional.com.recharge;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import test.functional.com.recharge.utils.RechargeAppUtils;

/**
 * @author thejaswimurala
 *
 */
public class RechargeConfirmationPageTest {
	private WebDriver driver;
	
	public RechargeConfirmationPageTest(WebDriver  driver) {
		this.driver = driver;
	}
	
	public void testRechargeConfirationPage() {
		try {
			RechargeAppUtils.waitOnFieldForXPath(driver, "/html/body/div[34]/div/div/div[3]/button[1]");
			WebElement toContinue = driver.findElement(By.xpath("/html/body/div[34]/div/div/div[3]/button[1]"));
			RechargeAppUtils.sleepFor(500);
			toContinue.click();
		} catch (Exception e) {
			System.out.println("Recharge has not been done in  last 5 minutes. Continuing with the recharge!");
		}
		RechargeAppUtils.sleepFor(1000);
	}

}
