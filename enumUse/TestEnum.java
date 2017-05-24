package enumUse;
//��ö�����һ��Ӧ��
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
	LiRongHao("���ٺ�","����"){
		public void show(){
			System.out.println("�����ѵ����񣬳���ܺ���");
		}
	},
	LiuDeHua("���»�","���֡���Ա"){
		public void show(){
			System.out.println("��������");
		}
	},
	WuShiJia("������","����Գ"){
		public void show(){
			System.out.println("Ŭ����Ϊ���еĳ���Գ");
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