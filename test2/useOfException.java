package test2;

//����������쳣�����һ���ۺ��Ե���Ŀ�������������Զ����쳣ȥ�����˲������븺�����쳣
public class test2 {
public static void main(String[] args)
{
	try {
		int i = Integer.parseInt(args[0]);//������
		int j = Integer.parseInt(args[1]);//����
		mac(i,j);
	} catch (NumberFormatException e){
		System.out.println("������������Ͳ�ͬ");
	} catch(ArrayIndexOutOfBoundsException e){
		System.out.println("ȱ�������в���");
	} catch(ArithmeticException e){
		System.out.println("��ĸΪ0��");
	} catch(ExDef e){
		System.out.println(e.getMessage());
	}
}
public static void mac(int i,int j) throws ExDef//ʹ����������ĺ���
{
	if(i<0||j<0){
		throw new ExDef("�����ֵ���ڸ���");
	}
	System.out.println(i/j);
	
	}
}
class ExDef extends Exception{//�Զ����������
	static final long serialVersionUID = -338752422948L;
	public ExDef(){}
	public ExDef(String ms){
	super(ms);
	}
	
}