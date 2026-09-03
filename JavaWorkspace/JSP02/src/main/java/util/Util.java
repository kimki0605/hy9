package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Util {
	public static Connection getConnection() {
		Connection con = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521/xepd1";
			String user = "SQL_SELECT";
			String pwd = "1234";
			
			con = DriverManager.getConnection(url,user,pwd);
			
			if(con != null) {
				System.out.println("DB 연결 성공");
			}else {
				System.out.println("DB 연결 실패");
			}
		}
	}
}
