import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Statement_Insert_1 {

	public static void main(String[] args) {
		//1. 4가지 정보
		String driver="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String userid ="scott";
		String passwd ="tiger";
		
		//2. 드라이버 생성=> new 이용
		Connection con = null;
		Statement stmt =null;
		PreparedStatement pstmt= null;
		ResultSet rs=null;
		try {
			Class.forName(driver);
		//3. 오라클 연결( Connection 연결)
		 con = DriverManager.getConnection(url, userid, passwd);
			
		//4. sql 작성
		 int deptno= 89;
		 String deptname="개발";
		 String loc="서울";
		String sql="insert into dept (deptno,dname,loc)"
		+"values ("+deptno+", '"+deptname+"','"+ loc+"')";
		System.out.println(sql);

		stmt = con.createStatement();
		int result= stmt.executeUpdate(sql);
		System.out.println("실행된 레코드 갯수:" + result);
		System.out.println();
		String sql2= "select deptno, dname, loc from dept";
		rs= stmt.executeQuery(sql2);
		while(rs.next()) {
			System.out.println(rs.getInt(1)+":"+ rs.getString(2)+":"+rs.getString(3));
		}
		//dml 사용한 경우 autoCommit : 자동 commit 실행 

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				//7. 자원반납
				if(rs!=null) rs.close();
				if(stmt!=null)stmt.close();
				if(con!=null)con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}//end main
}//end class
