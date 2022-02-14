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
public class UserLoginPageTest {

	private WebDriver driver;

	public UserLoginPageTest(WebDriver driver) {
		this.driver = driver;
	}

	public void testUserLoginPage() {
		//find email id element
		WebElement emaillogin = driver.findElement(By.name("email"));
		//Hold the control until email field loads
		RechargeAppUtils.waitOnFieldByName(driver, "email");
		emaillogin.sendKeys("automationexcersise@test.com");


//		RechargeAppUtils.sleepFor(500);
		//find email id element
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("123456");

		WebElement  captcha = driver.findElement(By.className("g-recaptcha"));
		captcha.click();
//		RechargeAppUtils.sleepFor(500);
	}
}
