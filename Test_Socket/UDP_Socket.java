package Test_Socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import org.junit.Test;

/**
 * Socket����UDP��ͨ�ţ����ͷ�����һ����Ϣ�����շ����ڿ���̨�ϴ�ӡ����
 * @author wushijia
 *
 */
public class UDP_Socket {
	@Test
	public void Send(){
		DatagramSocket ds = null;
		try {
			ds = new DatagramSocket();
			byte[] b = "���Ƿ��Ͷˣ����ڸ��㷢����Ϣ".getBytes();
			DatagramPacket packet = new DatagramPacket(b,0,b.length,
					InetAddress.getByName("localhost"),9090);//�������ݱ�����������Ž��ն˵�IP��ַ�Ͷ˿ںţ�����Ҫ���͵�����
			ds.send(packet);//��������
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
			DatagramPacket packet = new DatagramPacket(b,0,b.length);//�������ݰ�
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
