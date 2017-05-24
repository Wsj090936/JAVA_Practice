package genericUse;

import java.util.HashMap;
import java.util.List;

/*
 * 
 * */
public class Junit {
public static void main(String[] args){
	DAO<User> A = new DAO<User>();
	A.map = new HashMap<String,User>();
	A.save("1001",new User(1,18,"ÎâÊÀ¼Ñ"));
	A.save("1002",new User(2,32,"ÀîÈÙºÆ"));
	A.save("1003",new User(3,30,"ÑîØ©ÁÕ"));
	A.save("1004",new User(4,40,"µË³¬"));
	User u = A.get("1002");
	System.out.println(u);
	A.update("1001", new User(1,37,"Àî°×"));
	List<User> list = A.list();
	System.out.println(list);
} 
}
