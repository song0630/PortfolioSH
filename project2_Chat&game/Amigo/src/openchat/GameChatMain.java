package openchat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;

import Amigo_v1.Amigo_ID;

public class GameChatMain {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		if(args.length != 3) {
//			System.out.println("사용법 : 클라이언트 실행 -- java 패키지명.클래스명 ip주소 포트번호 닉네임");
//			System.exit(0);
//		}
		
		try {
			Socket s1 = new Socket("127.0.0.1", 9445);
			System.out.println("서버에 연결...");
			
			DataOutputStream outputStream = new DataOutputStream(s1.getOutputStream());
			DataInputStream inputStream = new DataInputStream(s1.getInputStream());
			
			
			//아이디가 있는 확인하기------------------------------------------------------------------------------------------
//			AmigoDAO amigoDao = new AmigoDAO();
			//String nickname = amigoDao.searchNickname(Amigo_ID.getId());
			//String id = Amigo_ID.getId();
			String id = "지홍";
			outputStream.writeUTF("##" + id); //닉네임을 바로 보내는것은 똑같다
			
			//GUI로 가기 
			//KajaClientGUI는 GUI file
			//==========================================
			new GameChatClientGUI(outputStream, inputStream, id) {
				
				public void closeWork() throws IOException{
					outputStream.close();
					inputStream.close();
					System.exit(0);
				}
			};
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
