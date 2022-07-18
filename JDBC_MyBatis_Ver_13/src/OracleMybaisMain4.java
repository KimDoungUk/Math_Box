import java.util.HashMap;
import java.util.List;

import com.dto.Dept;
import com.service.OracleMyBatisService;

public class OracleMybaisMain4 {

	public static void main(String[] args) {
	
		OracleMyBatisService service =new OracleMyBatisService();
	
		HashMap<String, String> map3 = new HashMap<String, String>();
		map3.put("dname", null);
		map3.put("loc", null);
		List<Dept> list3 = service.selectDynamicChoose(map3);
		for (Dept dept : list3) {
			System.out.println(">>>>"+dept);
		}
		
		
		//검색
		int deptno =10;
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("deptno", null);
		
		List<Dept> list = service.selectDynamicDeptno(map);
		for (Dept dept : list) {
			System.out.println(dept);
		}
	}//end main
}//end class






