package TestInetAdress;

import java.net.InetAddress;

/**
 * 想要通过网络进行与另一个主机之间的通信，就需要知道对方主机的IP地址
 * 因此可以用InetAddress类来获取
 * 每一个InetAddress代表着一个IP地址，通过它可以唯一的定位互联网上的一台主机
 * @author wushijia
 *
 */
public class TestInetAddress {
	public static void main(String[] args) throws Exception {
		//1、根据域名获取
		InetAddress IP1 = InetAddress.getByName("www.baidu.com");
		System.out.println(IP1);//www.baidu.com/119.75.216.20
		//2、获取主机IP
		InetAddress IP2 = InetAddress.getLocalHost();
		System.out.println(IP2);	
		System.out.println(IP2.getHostName());//获取主机名
		System.out.println(IP2.getHostAddress());//获取IP地址
		}
}
