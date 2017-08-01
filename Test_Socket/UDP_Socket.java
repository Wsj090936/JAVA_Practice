package Test_Socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import org.junit.Test;

/**
 * Socket基于UDP的通信，发送方发送一个信息给接收方，在控制台上打印出来
 * @author wushijia
 *
 */
public class UDP_Socket {
	@Test
	public void Send(){
		DatagramSocket ds = null;
		try {
			ds = new DatagramSocket();
			byte[] b = "我是发送端，现在给你发送消息".getBytes();
			DatagramPacket packet = new DatagramPacket(b,0,b.length,
					InetAddress.getByName("localhost"),9090);//创建数据报，里面包含着接收端的IP地址和端口号，还有要发送的数据
			ds.send(packet);//发送数据
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			ds.close();
			
		}
	}
	@Test 
	public void Receive(){
		DatagramSocket ds = null;
		try {
			ds = new DatagramSocket(9090);
			byte[] b = new byte[1024];
			DatagramPacket packet = new DatagramPacket(b,0,b.length);//接收数据包
			ds.receive(packet);
			String str = new String(packet.getData(), 0, packet.getLength());
			System.out.println(str);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			
			ds.close();
		}
		
	}
}
