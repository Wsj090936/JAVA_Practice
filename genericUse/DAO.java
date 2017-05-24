package genericUse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DAO<T> {
	Map<String,T> map = new HashMap<String,T>();
	public void save(String id,T entity)
	{
		map.put(id, entity);
	}
	public T get(String id)
	{
		return map.get(id);
	}
	public void update(String id,T entity)
	{
		map.put(id, entity);
	}
	public List<T> list()
	{
		List<T> list = new ArrayList<>();
		for(String each:map.keySet())
		{
			list.add(map.get(each));
		}
		return list;
	}
	public void delete(String id)
	{
		map.remove(id);
	}
}
