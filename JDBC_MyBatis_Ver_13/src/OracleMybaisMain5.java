import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.dto.Dept;
import com.service.OracleMyBatisService;

public class OracleMybaisMain5 {

	public static void main(String[] args) {
	
		OracleMyBatisService service =new OracleMyBatisService();
	
		//3. multi delete
		List<Dept> deptList =
Arrays.asList(new Dept(12, "", ""),new Dept(13, "", ""),new Dept(14, "", "") );
		service.multiDelete(deptList);
		
		//2. multi update
		List<Integer> deptnoes2 =Arrays.asList(77, 14,88 );
		service.multiUpdate(deptnoes2);
		
		// 1. multi select
		List<Integer> deptnoes =Arrays.asList(10,20);
		
		List<Dept> list = service.multiSelect(deptnoes);
		for (Dept dept : list) {
			System.out.println(dept);
		}
		
		//http://github.com
		
		
	}//end main
}//end class






