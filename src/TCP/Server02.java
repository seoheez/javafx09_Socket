package TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server02 {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(12345);
		System.out.println("서버 실행...");
		Socket sock = server.accept();//누군가가 접속 될 때 까지 멈춤.
		Socket sock1 = server.accept();
		Socket sock2 = server.accept();
		
		InputStream is = sock.getInputStream();
		DataInputStream di = new DataInputStream(is);
		
		System.out.println("수신 대기...");
		String readData = di.readUTF();
		System.out.println("수신 데이터: " + readData);
		
		System.out.println("서버에서 전송할 데이터 입력");
		String s = new Scanner(System.in).next();
		OutputStream os = sock.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		dos.writeUTF(s);
		
		di.close(); is.close(); sock.close(); server.close();
	}
}
