package site.metacoding.mvc.config;

import java.sql.Connection;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


// 책임 : connection 객체를 리턴
public class DBConn { // 만들어져있는 것을 접근하는 코드
	
	public static Connection getConnection() { // 찾는 코드
		Connection conn = null;
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/TestDB");
			conn = ds.getConnection();
			System.out.println("연결 성공");
			//etc.
		} catch (Exception e) {
			System.out.println("");
			e.printStackTrace();
		}
		return conn;
		
	}
}