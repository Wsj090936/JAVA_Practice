package Test_Socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.Test;

/**
 * 客户端发送给服务端一条消息，在服务端进行输出
 * @author wushijia
 *
 */
public class TCP_Socket {
	@Test
	public void Client(){
		Socket socket = null;
		OutputStream os = null;
		try {
			socket = new Socket("127.0.0.1", 9191);//服务端的IP地址和端口号，这里我向自己发送数据
			os = socket.getOutputStream();//发送数据
			os.write("基于TCP的Socket通信".getBytes());//发送的内容
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{//关闭相应的流和Socket
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
			ss = new ServerSocket(9191);//创建ServerSocket对象，构造器参数为端口号
			socket = ss.accept();//调用accept()方法，返回一个Socket对象
			in = socket.getInputStream();//得到客户端发来的消息
			byte[] b = new byte[20];
			int len = 0;
			while((len = in.read(b)) != -1){//输出消息
				String str = new String(b,0,len);
				System.out.println(str);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{//关闭相应的流和Socket
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
