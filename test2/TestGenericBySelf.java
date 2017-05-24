package test2;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
//自定义泛型类的测试
public class TestGenericBySelf {
	@Test
	public void test2(){
	GenericBySelf<Integer> i = new GenericBySelf<>();
	i.setName("MM");
	String a = i.Get(i.getName());
	System.out.println(a);
	Integer[] in = new Integer[]{1,2,3};
	List<Integer> list = new ArrayList<Integer>();
	List<Integer> list1 = i.ArrayToList(in, list);
	System.out.println(list1);
	}
}
