import java.util.List;

import com.dto.Dept;
import com.service.OracleMyBatisService;

public class OracleMybaisMain2 {

	public static void main(String[] args) {
	
		OracleMyBatisService service =new OracleMyBatisService();
	
		//2. 조건검색
		Dept dto =service.selectByDeptno(10);
		System.out.println("10검색:" + dto);
		
		//1. selectAll
		List<Dept> list = service.selectAll();
		for (Dept dept : list) {
			System.out.println(dept);
		}
		
		
	}//end main
}//end class






