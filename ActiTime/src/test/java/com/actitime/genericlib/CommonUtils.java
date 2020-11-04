package com.actitime.genericlib;

import java.io.FileInputStream;
import java.util.Properties;
/**
 * 
 * @author Administrator
 *
 */
public class CommonUtils {

	/**
	 * Get the data from Properties file
	 * @param path
	 * @param attribute
	 * @return
	 * @throws Throwable
	 */
	public static String getPropertiesFileData(String path, String attribute) throws Throwable {
		FileInputStream fis = new FileInputStream(path);

		Properties prop = new Properties();

		prop.load(fis);
		String data = prop.getProperty(attribute);

		return data;

	}
}
