package TestInetAdress;

import java.net.InetAddress;

/**
 * ��Ҫͨ�������������һ������֮���ͨ�ţ�����Ҫ֪���Է�������IP��ַ
 * ��˿�����InetAddress������ȡ
 * ÿһ��InetAddress������һ��IP��ַ��ͨ��������Ψһ�Ķ�λ�������ϵ�һ̨����
 * @author wushijia
 *
 */
public class TestInetAddress {
	public static void main(String[] args) throws Exception {
		//1������������ȡ
		InetAddress IP1 = InetAddress.getByName("www.baidu.com");
		System.out.println(IP1);//www.baidu.com/119.75.216.20
		//2����ȡ����IP
		InetAddress IP2 = InetAddress.getLocalHost();
		System.out.println(IP2);	
		System.out.println(IP2.getHostName());//��ȡ������
		System.out.println(IP2.getHostAddress());//��ȡIP��ַ
		}
}
