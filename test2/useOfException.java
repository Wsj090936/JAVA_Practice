package test2;

//这个程序是异常处理的一道综合性的题目，其中运用了自定义异常去定义了不能输入负数的异常
public class test2 {
public static void main(String[] args)
{
	try {
		int i = Integer.parseInt(args[0]);//被除数
		int j = Integer.parseInt(args[1]);//除数
		mac(i,j);
	} catch (NumberFormatException e){
		System.out.println("输入的数据类型不同");
	} catch(ArrayIndexOutOfBoundsException e){
		System.out.println("缺少命令行参数");
	} catch(ArithmeticException e){
		System.out.println("分母为0！");
	} catch(ExDef e){
		System.out.println(e.getMessage());
	}
}
public static void mac(int i,int j) throws ExDef//使两个数相除的函数
{
	if(i<0||j<0){
		throw new ExDef("输入的值存在负数");
	}
	System.out.println(i/j);
	
	}
}
class ExDef extends Exception{//自定义错误类型
	static final long serialVersionUID = -338752422948L;
	public ExDef(){}
	public ExDef(String ms){
	super(ms);
	}
	
}