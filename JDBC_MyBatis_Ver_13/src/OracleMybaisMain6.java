import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.dto.Dept;
import com.service.OracleMyBatisService;

public class OracleMybaisMain6 {

	public static void main(String[] args) {
	
		OracleMyBatisService service =new OracleMyBatisService();
	
		//5. Top-N 분석 ==>페이징처리
		List<Dept> deptList3 = service.selectTopN(8,3);   //idx 0부터 시작, 3개 
		for (Dept dept : deptList3) {
			System.out.println(">>>" + dept);
		}
		
		
		
		//4. multi insert
		List<Dept> deptList =
Arrays.asList(new Dept(1, "개발", "서울"),
		      new Dept(2, "영업", "부산"),new Dept(3, "관리", "제주") );
		//service.multiInsert(deptList);
	
		String date= service.getDate();
		System.out.println(date);
		
	}//end main
}//end class






