import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementTest {

	public static void main(String[] args) {
		//1. 4가지 정보
		String driver="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String userid ="scott";
		String passwd ="tiger";
		
		//2. 드라이버 생성=> new 이용
		Connection con = null;
		PreparedStatement pstmt =null;
		ResultSet rs =null;
		Statement stmt= null;
		try {
			Class.forName(driver);
		//3. 오라클 연결( Connection 연결)
		 con = DriverManager.getConnection(url, userid, passwd);
			
		//4. sql 작성
//		String sql="select deptno x,dname,loc from dept "; // ;제거
		 String name="RESEARCH";
		String sql="select deptno x,dname,loc from dept where dname='"+name+"'"; // ;제거
		
		
		//5. SQL 실행==> Statement, PreparedStatement,CallableStatement(PL/SQL)
		
		 stmt= con.createStatement();
		//6. 실행해서 결과받기
		 rs= stmt.executeQuery(sql);
		 ResultSetMetaData mrs= rs.getMetaData();
		 int count = mrs.getColumnCount();
		for (int i = 1; i <=count; i++) {
			System.out.print(mrs.getColumnName(i)+"\t");
		}
		System.out.println();
		System.out.println("===================================");
		 while(rs.next()) {
			
//			 int deptno= rs.getInt("x");
//			 String dname= rs.getString("dname");
//			 String loc= rs.getString("loc");
			 int deptno= rs.getInt(1);
			 String dname= rs.getString(2);
			 String loc= rs.getString(3);
			 System.out.println(deptno+ "\t"+ dname+ "\t"+ loc);
		 }
		 	}catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					//7. 자원반납 반대순서로 실행 
					if(rs!=null)rs.close();
					if(stmt!=null)stmt.close();
					if(con!=null)con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	
	}//end main
}
// end class
