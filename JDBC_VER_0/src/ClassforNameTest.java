import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassforNameTest {

	public static void main(String[] args)throws Exception {
		Class  cl= Class.forName("java.lang.Math");
		//Class<?> c = Class.forName("java.lang.String");
		//메타데이터==> 리플렉션(reflection)
		Field[] fields = cl.getDeclaredFields();
		for (Field f : fields) {
			System.out.println("field:"+f.getName());
		}
		Method[] methods=cl.getDeclaredMethods();
		for (Method m : methods) {
			System.out.println("method:"+m.getName());
		}
		
		
	}

}
