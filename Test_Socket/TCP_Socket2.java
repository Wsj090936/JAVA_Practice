package Test_Socket;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.Test;

/**
 * 客户端发送文件给服务端，服务端接收文件并保存在本地，然后给客户端一个反馈
 * @author wushijia
 *
 */
public class TCP_Socket2 {
	@Test
	public void client(){
		Socket socket = null;
		OutputStream os = null;

		FileInputStream fis = null;

		InputStream in = null;
		try {
			socket = new Socket(InetAddress.getByName("localhost"),9292);
			//从本地获取一个文件，发送给服务端
			os = socket.getOutputStream();
			fis = new FileInputStream(new File("cat.png"));
			byte[] b = new byte[1024];
			int len = 0;
			while((len = fis.read(b)) != -1){
				os.write(b, 0, len);
			}
			socket.shutdownOutput();
			//接收服务端发来的消息
			in = socket.getInputStream();
			byte[] b1 = new byte[20];
			int len1 = 0;
			while((len1 = in.read(b1)) != -1){
				String str = new String(b1,0,len1);
				System.out.println(str);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{//关闭连接
			if(in != null){
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(fis != null){
				
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(os != null){
				
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(socket != null){
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
	}
	@Test
	public void server(){
		ServerSocket ss = null;
		Socket socket = null;
		InputStream in = null;

		FileOutputStream fos = null;

		OutputStream os = null;
		try {
			ss = new ServerSocket(9292);
			socket = ss.accept();
			//服务端保存从客户端发送过来的文件到本地
			in = socket.getInputStream();
			fos = new FileOutputStream(new File("TomCat.png"));
			byte[] b = new byte[1024];
			int len = 0;
			while((len = in.read(b)) != -1){
				fos.write(b, 0, len);
			}
			//向客户端反馈
			os = socket.getOutputStream();
			os.write("我已经收到你发的文件".getBytes());
			socket.shutdownOutput();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(os != null){
				
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(fos != null){
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			if(in != null){
				
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(socket != null){
				
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(ss != null){
				
				try {
					ss.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
