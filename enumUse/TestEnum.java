package enumUse;
//对枚举类的一个应用
public class TestEnum {
	public static void main(String[] args){
		Friends A = Friends.LiRongHao;
		System.out.println(A);
		A.show();
		//1.values()
		Friends[] B = Friends.values();
		for(int i = 0;i<B.length;i++)
		{
			System.out.println(B[i]);
		}
		//2.valuesOf
		String str = "LiuDeHua";
		Friends C = Friends.valueOf(str);
		System.out.println(C);
		
	}
}
interface Info{
	void show();
}
enum Friends implements Info{
	LiRongHao("李荣浩","歌手"){
		public void show(){
			System.out.println("吴世佳的男神，唱歌很好听");
		}
	},
	LiuDeHua("刘德华","歌手、演员"){
		public void show(){
			System.out.println("大众男神");
		}
	},
	WuShiJia("吴世佳","程序猿"){
		public void show(){
			System.out.println("努力成为大佬的程序猿");
		}
	};
	private final String PersonName;
	private final String Desc;
	Friends(String PersonName,String Desc)
	{
		this.PersonName = PersonName;
		this.Desc = Desc;
	}
	public String getPersonName() {
		return PersonName;
	}
	public String getDesc() {
		return Desc;
	}
	@Override
		public String toString(){
		return "Friends[PersonName = "+PersonName+"Desc = "+Desc+"]";
	}
}
enum Person{
	MM,GG,JJ;
}