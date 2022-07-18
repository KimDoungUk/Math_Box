import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCTest4 {

	public static void main(String[] args) {
		//1.4가지정보 저장
		String driver="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		String user="scott";
		String passwd="tiger";
		//2.드라이버 생성->new사용
		Connection con= null;
		PreparedStatement pstmt= null;
		ResultSet rs= null;
		try {
			Class.forName(driver);
			//3. 오라클 연결 -connection생성
			con= DriverManager.getConnection(url, user, passwd); 
			//4. sql작성
			String sql= "update dept set dname=? , loc=? where deptno=?"; //; 제거
			//5. sql실행
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, "영업");
			pstmt.setString(2, "부산");
			pstmt.setInt(3, 14);			
			int num= pstmt.executeUpdate();
			System.out.println("업데이트된 레코드 "+ num);
			//전체 select sql 작성, 실행 
			
			
			
			
			String sql2="select deptno, dname, loc from dept";
			pstmt= con.prepareStatement(sql2);
			rs= pstmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt(1)+ "\t"+ rs.getString(2)+ "\t"+rs.getString("loc"));
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
			if(rs!= null)rs.close();
			if(pstmt!= null)pstmt.close();
			if(con!= null)con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	}//end main
}//end class
