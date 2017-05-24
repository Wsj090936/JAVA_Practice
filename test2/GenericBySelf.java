package test2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

//自定义泛型类以及自定义泛型方法
public class GenericBySelf<T> {
	private String name;
	private Integer id;
	private T t;
	List<T> list = new ArrayList<>();
	public void add(){
		list.add(t);
	}
	public void SetT(T t){
		this.t = t;
	}
	public T getT(){
		return t;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "GenericBySelf [name=" + name + ", id=" + id + ", t=" + t + "]";
	}
    <E> E Get(E e)
    {
       //......
                return e;
    }

	//自定义泛型方法，将数组转换为List
	<E> List<E> ArrayToList(E[] e,List<E> list)
	{
		for(E each:e)
		{
			list.add(each);
		}
		return list;
	}
	@Test
	public void test1(){
		//		List<String> L2 = new ArrayList<>();
		List<Object> L1 = new ArrayList<>();
		List<?> L3 = new ArrayList();
		L3 = L1;
	}
}
class son extends GenericBySelf<Integer>{
	//....
}
