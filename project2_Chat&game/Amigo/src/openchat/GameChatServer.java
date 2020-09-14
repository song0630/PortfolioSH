package openchat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class GameChatServer {
	ArrayList<ThreadServerClass> threadList // 제네릭
			= new ArrayList<ThreadServerClass>();
	Socket socket;
	DataOutputStream outputStream;

	public GameChatServer(int num) throws IOException {
		Socket s = null;
		ServerSocket ss = new ServerSocket(num);
		System.out.println("연결 기다림...");
		while (true) {
			s = ss.accept();
			System.out.println("접속주소: " + s.getInetAddress() + " , 접속포트: " + s.getPort());
			ThreadServerClass ts = new ThreadServerClass(s);
			ts.start();
			threadList.add(ts);

			System.out.println("총" + threadList.size());

		}
	}

	public void sendChat(String chat) throws IOException {
		for (int i = 0; i < threadList.size(); i++) {
			threadList.get(i).outputStream.writeUTF(chat);
		}
	}

	
	
	class ThreadServerClass extends Thread {
		Socket so;
		DataOutputStream outputStream;
		DataInputStream inputStream;

		public ThreadServerClass(Socket s) throws IOException {
			this.so = s;
			inputStream = new DataInputStream(s.getInputStream());
			outputStream = new DataOutputStream(s.getOutputStream());
		}

		@Override
		public void run() {
			String nickname = "";
			try {
				if (inputStream != null) {
					nickname = inputStream.readUTF();
					sendChat(nickname + " 님 입장 ");
				}
				// 메소드2형식 호출문
				while (inputStream != null) {
					sendChat(inputStream.readUTF());
				}
				System.out.println("총 " + threadList.size());
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				for (int i = 0; i < threadList.size(); i++) {
					if (so.equals(threadList.get(i).so)) {
						threadList.remove(i);/////// 퇴장시 remove
						try {
							sendChat(nickname + " 님 퇴장 ");
						} catch (IOException e) {
							// e.printStackTrace();
						}
					}
				}
			}

			

		}

	}
	
	public static void main(String[] args) throws IOException {
		new GameChatServer(10000);
	}

}
