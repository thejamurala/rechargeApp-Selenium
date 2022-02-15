/**
 * 
 */
package test.functional.com.recharge;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.netty.handler.timeout.TimeoutException;
import test.functional.com.recharge.utils.RechargeAppUtils;

/**
 * @author thejaswimurala
 *
 */
public class NotificationPopupWindowTest {
	private WebDriver driver;
	
	public NotificationPopupWindowTest(WebDriver driver) {
		this.driver = driver;
	}
	
	public void validatePopupExists() {
		try {
			//POPUP window
			RechargeAppUtils.waitOnFieldForXPath(driver, "/html/body/div[7]/div[2]");
			WebElement cancelPopup = driver.findElement(By.id("wzrk-cancel"));
			RechargeAppUtils.sleepFor(500);
			cancelPopup.click();
		} catch (TimeoutException te) {
			System.out.println("Web Cookies are already accepted. Continuing...");
		} catch (Exception e) {
			System.out.println("Web Cookies are already accepted. Continuing...");
		}
	}

}
