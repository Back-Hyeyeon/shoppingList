package controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBUtil {
	public static Connection getConnection() throws Exception {

		Properties properties = new Properties();
		Connection con = null;
		try (FileInputStream fileInputStream = new FileInputStream("src/config/db.properties")) {
			// Properties 파일을 읽어옵니다.
			properties.load(fileInputStream);

			// 원하는 프로퍼티 값을 가져옵니다.
			String driver = properties.getProperty("driver");
			String dbUrl = properties.getProperty("url");
			String dbUsername = properties.getProperty("username");
			String dbPassword = properties.getProperty("password");

			
			Class.forName(driver);
			con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
			return con;
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.toString());
		}
		return con;

	}
}
