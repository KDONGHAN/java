package ch04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class insertDAO {
	public static void main(String[] args) {
	}

	public static boolean create(DTO dto) throws Exception {
		
		boolean flag = false;
		Connection con = null;
		java.sql.Statement stmt = null;
		String name = dto.getname();
		String id = dto.getid();
		String dep = dto.getdep();
		String tel = dto.gettel();
		String birth = dto.getbirth();
		
		String sql = "INSERT INTO guest(name, id, dep, tel, birth) VALUES";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysqlL//localhost:3306/pj", "root", "123456");
			stmt = (Statement)con.createStatement();
			stmt.executeUpdate(sql);
			
			flag = true;
		} catch (Exception e) {
			System.out.println(e);
			flag = false;
		} finally {
			
			try {
				if(stmt != null)
					stmt.close();
				if(con != null)
					con.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		return flag;
	}
}
