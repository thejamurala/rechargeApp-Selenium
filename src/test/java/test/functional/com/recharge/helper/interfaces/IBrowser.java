/**
 * 
 */
package test.functional.com.recharge.helper.interfaces;

import org.openqa.selenium.WebDriver;

import test.functional.com.recharge.helper.Browser;

/**
 * @author thejaswimurala
 *
 */
@FunctionalInterface
public interface IBrowser {
	WebDriver getDriver(Browser browser);
}
