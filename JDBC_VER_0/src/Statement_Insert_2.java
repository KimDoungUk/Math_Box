import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Statement_Insert_2 {

	public static void main(String[] args) {
		//1. 4가지 정보
		String driver="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String userid ="scott";
		String passwd ="tiger";
		
		//2. 드라이버 생성=> new 이용
		Connection con = null;
		Statement stmt =null;
	
		try {
			Class.forName(driver);
		//3. 오라클 연결( Connection 연결)
		 con = DriverManager.getConnection(url, userid, passwd);
			
		//4. sql 작성
		String sql="insert into dept (deptno,dname,loc)"
				+ " values (13 ,'개발', '서울')";
		
		
		//5. SQL 실행==> Statement, PreparedStatement,CallableStatement(PL/SQL)
		 stmt = con.createStatement();
		 
		 
//		 pstmt.setString(2,"개발");
//		 pstmt.setString(3,"서울");
//		 pstmt.setInt(1, 13);
		 int num = stmt.executeUpdate(sql);
		 String sql2="insert into dept (deptno,dname,loc)"
					+ " values ("+14+",'개발2', '서울2')";
//		 pstmt.setString(2,"개발2");
//		 pstmt.setString(3,"서울2");
//		 pstmt.setInt(1, 14);
		 int num2 = stmt.executeUpdate(sql2);
		 
		System.out.println("실행된 레코드 갯수:" + (num+num2));
	

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				//7. 자원반납
				
				if(stmt!=null)stmt.close();
				if(con!=null)con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}//end main
}//end class
