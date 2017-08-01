package Test_Socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.Test;

/**
 * �ͻ��˷��͸������һ����Ϣ���ڷ���˽������
 * @author wushijia
 *
 */
public class TCP_Socket {
	@Test
	public void Client(){
		Socket socket = null;
		OutputStream os = null;
		try {
			socket = new Socket("127.0.0.1", 9191);//����˵�IP��ַ�Ͷ˿ںţ����������Լ���������
			os = socket.getOutputStream();//��������
			os.write("����TCP��Socketͨ��".getBytes());//���͵�����
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{//�ر���Ӧ������Socket
			if(socket != null){
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(os != null){
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	@Test
	public void Server(){
		ServerSocket ss = null;
		Socket socket = null;
		InputStream in = null;
		try {
			ss = new ServerSocket(9191);//����ServerSocket���󣬹���������Ϊ�˿ں�
			socket = ss.accept();//����accept()����������һ��Socket����
			in = socket.getInputStream();//�õ��ͻ��˷�������Ϣ
			byte[] b = new byte[20];
			int len = 0;
			while((len = in.read(b)) != -1){//�����Ϣ
				String str = new String(b,0,len);
				System.out.println(str);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{//�ر���Ӧ������Socket
			if(ss != null){
				try {
					ss.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(socket != null){
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(in != null){
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
