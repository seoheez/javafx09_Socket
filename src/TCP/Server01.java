package TCP;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server01 {
	public static void main(String[] args) throws IOException {
		//port: 2byte크기를 가지고 있으며, 특정 프로그램(어플리케이션)을 구분 지어준다.
		//2byte : 0 ~ 65535
		//bit(8) -> byte(1024) -> kbyte(1024)-> mbyte(1024) -> GB -> TB..
		//서버: 서비스를 제공하는 컴퓨터
		//클라이언트: 서비스를 제공받는 컴퓨터
		
		//자기 자신의 아이피와 port(12345)로 서버를 구동해 준다.
		ServerSocket server = new ServerSocket(12345);
		System.out.println("접속 대기합니다.");
		Socket sock = server.accept();
		System.out.println("접속 되었습니다.");
		System.out.println(sock.getInetAddress());
		
		InputStream input = sock.getInputStream();
		int readData = input.read();
		System.out.println("수신 데이터:" + readData);
		
		input.close(); 
		sock.close();
	}
}
