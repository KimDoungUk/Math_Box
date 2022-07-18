import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCTest5 {

	public static void main(String[] args) {
		//1. 4가지 정보
		String driver="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		String userid ="scott";
		String passwd ="tiger";
		
		//2. 드라이버 생성=> new 이용
		Connection con = null;
		PreparedStatement pstmt =null;
		ResultSet rs= null;
		
		//14번 부서 삭제 후 전체 select sql 실행 하여 확인 
		
		
		
		try {
			Class.forName(driver);
			con= DriverManager.getConnection(url,userid, passwd);
			String sql= "delete from dept where deptno=?";
			pstmt= con.prepareStatement(sql);
			pstmt.setInt(1, 14);
			int num= pstmt.executeUpdate();
			System.out.println("삭제된 데이터"+num);
			String sql2= "select * from dept";
			pstmt= con.prepareStatement(sql2);
			rs= pstmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"\t"+ rs.getString(2)+"\t"+rs.getString(3));
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
				try {
					if(rs!=null)rs.close();
					if(pstmt!=null)	pstmt.close();
					if(con!=null)con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	
	}//end main
}//end class
