package openchat;

public class Test02 {
	
public static void main(String[] args) {
	
	int s1;
	String b1;
	String c1;
	

	Game1 g1= new Game1(3,"õ��","�� õ���");
		System.out.println(g1);
	
		}
	
}
class Game1{
	private int score=0;
	private String ban=null;
	private String chat=null;
	
	public Game1() {
		// TODO Auto-generated constructor stub
	}
	public Game1(int score, String ban, String chat) {
		if(search(chat,ban)) {
			score-=1;
			System.out.println("�������� 1 �𿴽��ϴ�.");
			
		}
		this.score = score;
		this.ban = ban;
		this.chat = chat;
	}
	public String getChat() {
		return chat;
	}
	public void setChat(String chat) {
		this.chat = chat;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getBan() {
		return ban;
	}
	public void setBan(String ban) {
		this.ban = ban;
	}
	@Override
	public String toString() {
		return "[���� Life : " + score + "]";
	}
	public boolean search(String ct, String ban) {//������ Ȯ�� �޼���
	
		if(ct.contains(ban)) {
			return true;
		}
	
		return false;

	}

}
