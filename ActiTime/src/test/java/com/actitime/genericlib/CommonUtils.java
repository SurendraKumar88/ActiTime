package com.actitime.genericlib;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.mysql.jdbc.Driver;

/**
 * 
 * @author Administrator
 *
 */
public class CommonUtils {

	/**
	 * Get the data from Properties file
	 * 
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

	public static String getDatafromDB(String query) throws SQLException {

		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);

		Connection con = DriverManager.getConnection("HostName", "UserName", "pwd");

		Statement stat = con.createStatement();

		ResultSet res = stat.executeQuery(query);

		String data = null;
		while (res.next()) {
			data = res.getString(1);
		}

		return data;
	}

	public static String getDatafromExcel(String path, String sheet, int rowNum, int columnNum) throws Throwable {

		FileInputStream fis = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheet).getRow(rowNum).getCell(columnNum).getStringCellValue();

		return data;
	}
}
