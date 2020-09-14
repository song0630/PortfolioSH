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
//			System.out.println("���� : Ŭ���̾�Ʈ ���� -- java ��Ű����.Ŭ������ ip�ּ� ��Ʈ��ȣ �г���");
//			System.exit(0);
//		}
		
		try {
			Socket s1 = new Socket("127.0.0.1", 9445);
			System.out.println("������ ����...");
			
			DataOutputStream outputStream = new DataOutputStream(s1.getOutputStream());
			DataInputStream inputStream = new DataInputStream(s1.getInputStream());
			
			
			//���̵� �ִ� Ȯ���ϱ�------------------------------------------------------------------------------------------
//			AmigoDAO amigoDao = new AmigoDAO();
			//String nickname = amigoDao.searchNickname(Amigo_ID.getId());
			//String id = Amigo_ID.getId();
			String id = "��ȫ";
			outputStream.writeUTF("##" + id); //�г����� �ٷ� �����°��� �Ȱ���
			
			//GUI�� ���� 
			//KajaClientGUI�� GUI file
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
