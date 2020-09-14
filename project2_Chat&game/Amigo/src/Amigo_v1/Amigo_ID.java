package Amigo_v1;


public class Amigo_ID {
	private static String id = null;
	private int Gameindex = 1;
	private int score = 0;
	private static String nickname = null;
	
	public Amigo_ID() {
		// TODO Auto-generated constructor stub
	}
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getGameindex() {
		return Gameindex;
	}

	public void setGameindex(int gameindex) {
		Gameindex = gameindex;
	}

	public static String getId() {
		return id;
	}

	public static void setId(String id) {
		Amigo_ID.id = id;
	}
	public static String getNickname() {
		return nickname;
	}
	public static void setNickname(String nickname) {
		Amigo_ID.nickname = nickname;
	}
	

}