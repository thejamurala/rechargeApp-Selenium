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
public class LandingPageTest {
	private WebDriver driver;
	
	public LandingPageTest(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public void testRechargeDetailsPage() {
		//Hold the execution until the specified item intractable
		RechargeAppUtils.waitOnFieldByName(driver, "operator");
		
		
		WebElement operator = driver.findElement(By.name("operator"));
		operator.click();
		RechargeAppUtils.sleepFor(100);
		
		WebElement telcel = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[2]/div/div[1]/form/div/div[1]/div[1]/div[2]/ul/li[1]/div/div/div/ul/li[1]"));
		telcel.click();
		
		//Find the mobile number element
		WebElement mobile = driver.findElement(By.name("mobile"));
		mobile.sendKeys("8465433546");
		
		WebElement  amountField = driver.findElement(By.name("amount"));
		amountField.click();
		
		WebElement rechargeAmount = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[2]/div/div[1]/form/div/div[1]/div[1]/div[2]/ul/li[3]/div/div/div/ul[1]/li[1]"));
		rechargeAmount.click();
				
		//Click on next Button
		WebElement next = driver.findElement(By.xpath("//*[@id=\"col-sm-12\"]/form/div/div[1]/div[1]/div[3]/div/button"));
		next.click();
		
	}

}
