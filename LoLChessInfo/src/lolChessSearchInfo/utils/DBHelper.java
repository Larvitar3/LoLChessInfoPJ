package lolChessSearchInfo.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {

	private static final String DB_HOST = "localhost";
	private static final int DB_PORT = 3306;
	private static final String DB_DATABASE_NAME = "LoLChessInfo";
	private static final String DB_USER_NAME = "root";
	private static final String DB_CHARSET = "UTF-8";
	private static final String DB_PASSWORD = "asd1234";

	private static DBHelper dbHelper;
	private Connection conn;

	public DBHelper() {
	}

	public static DBHelper getInstance() {
		if (dbHelper == null) {
			dbHelper = new DBHelper();
		}
		return dbHelper;
	}

	public Connection getConnection() {
		if (conn == null) {
			String urlFormat = "jdbc:mysql://%s:%d/%s?serverTimezone=Asia/Seoul&characterEncoding=%s";
			String url = String.format(urlFormat, DB_HOST, DB_PORT, DB_DATABASE_NAME, DB_CHARSET);

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection(url, DB_USER_NAME, DB_PASSWORD);
				System.out.println(">>> Connection Success <<<");
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				System.out.println(">>> Connection Fail <<<");
				connectionClose();
			}
		}
		return conn;
	}

	public void connectionClose() {
		if (conn != null) {
			try {
				conn.close();
				conn = null;
				System.out.println(">>> Connection Close <<<");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println(">>> Connection Close Fail <<<");
			}
		}
	}
}
