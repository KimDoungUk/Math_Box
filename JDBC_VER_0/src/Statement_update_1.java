import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Statement_update_1 {

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
		String dname="영업";
		String loc="제주";
		int deptno=90;
		//4. sql 작성
		String sql="update dept set dname='"+dname+"', loc='"+loc+"'"
				+" where deptno="+deptno;			
		//		
		System.out.println(sql);
		
		//5. SQL 실행==> Statement, PreparedStatement,CallableStatement(PL/SQL)
		 stmt = con.createStatement();
		
		 
		//6. 실행해서 결과받기
		 int num = stmt.executeUpdate(sql);
		System.out.println("실행된 레코드 갯수:" + num);
	

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
