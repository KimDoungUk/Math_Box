package com.simpeDAO;
import java.util.ArrayList;

public class JDBCTest {
	
	public static void main(String[] args) {
		DeptDAO dao= new DeptDAO();
		dao.selectAllDept();
		System.out.println("==============");
		ArrayList<DeptDTO> list= dao.selectAllDept2();
		for (DeptDTO dto : list) {
			System.out.println(dto);
		}		
		
		
		
		//1. 
	//	dao.insertDept(99, "서울", "부산");
		
		//2. 
		//dao.insertDept(new DeptDTO(99, "영업", "부산"));
		int num =dao.insertDept2(new DeptDTO(99, "영업", "부산"));
		System.out.println("insert 갯수 : "+ num);
	}

//	public static void main(String[] args) {
//		// 1. 4가지 정보
//		String driver = "oracle.jdbc.driver.OracleDriver";
//		String url = "jdbc:oracle:thin:@localhost:1521:xe";
//		String userid = "scott";
//		String passwd = "tiger";
//
//		// 2. 드라이버 생성=> new 이용
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		try {
//			Class.forName(driver);
//			// 3. 오라클 연결( Connection 연결)
//			con = DriverManager.getConnection(url, userid, passwd);
//
//			// 4. sql 작성
////			String sql = "select deptno x,dname,loc from dept where deptno=?"; // ;제거
//			String sql = "select deptno x,dname,loc from dept where dname=?"; // ;제거
//
//			// 5. SQL 실행==> Statement, PreparedStatement,CallableStatement(PL/SQL)
//			pstmt = con.prepareStatement(sql);
//
//			// 6. 실행해서 결과받기
//			pstmt.setString(1,"aa");
//			rs = pstmt.executeQuery();
//
//			while (rs.next()) {
//				int deptno = rs.getInt("x");
//				String dname = rs.getString("dname");
//				String loc = rs.getString("loc");
//				System.out.println(deptno + "\t" + dname + "\t" + loc);
//			}
//
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			try {
//				// 7. 자원반납
//				if (rs != null)
//					rs.close();
//				if (pstmt != null)
//					pstmt.close();
//				if (con != null)
//					con.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//
//	}// end main
}// end class
