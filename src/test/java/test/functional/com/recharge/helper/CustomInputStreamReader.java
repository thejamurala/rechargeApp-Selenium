/**
 * It provides multiple browser options to launch selenium test automation
 */
package test.functional.com.recharge.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Function;

import test.functional.com.recharge.helper.interfaces.ICustomInputStreamReader;

/**
 * @author thejaswimurala
 *
 */
public class CustomInputStreamReader implements ICustomInputStreamReader {

	@Override
	public String getUserInput(Void input) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter Browser number would you like to run from the following options:");
		System.out.println("1: CHROME");
		System.out.println("2: FIREFOX");
		System.out.println("3: IE");
		System.out.println("4: SAFARI");
		System.out.println("5: EDGE");

		String s = "DEFAULT";
		try {
			s = br.readLine();
		} catch (IOException e) {
			System.out.println("Exception occured while reading input: "+e);
		}
		return s.toUpperCase();
	}


}
