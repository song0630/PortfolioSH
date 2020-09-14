package openchat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GameChatClientGUI extends JFrame implements Runnable, ActionListener{
	DataOutputStream outputStream;
	DataInputStream inputSream;
	String nickname;

	JPanel panel = new JPanel();
	JTextArea jtarea1 = new JTextArea();
	JTextField jtfield1 = new JTextField();
	JScrollPane jScrollPane = new JScrollPane(jtarea1);
	
//	private JTextField textField = new JTextField();
//	private JButton btnNewButton = new JButton("\uBCF4\uB0B4\uAE30");
//	private JTextArea textArea = new JTextArea();;
//	private JButton btnNewButton_2 = new JButton(new ImageIcon(GameChatClient.class.getResource("/img/x.png")));

	
	
	
	public GameChatClientGUI(DataOutputStream outputStream, DataInputStream inputStream, String string) {
		this.outputStream = outputStream;
		this.inputSream = inputStream;
		nickname = string;
		getContentPane().setLayout(new BorderLayout());
		// N, S, W, E, C 북 남 서 동 중간
		panel.setBackground(new Color(26, 188, 156));
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton_1) {
					
				}
			}
		});
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setOpaque(false);
		btnNewButton_1.setIcon(new ImageIcon(GameChatClientGUI.class.getResource("/img/menu.png")));
		panel.add(btnNewButton_1);
		
		JLabel label = new JLabel("\uAC8C\uC784 \uCC44\uD305");
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("굴림", Font.BOLD, 25));
		panel.add(label);
		
		JButton btnNewButton_2 = new JButton(new ImageIcon(GameChatClientGUI.class.getResource("/img/close.png")));
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setOpaque(false);
		panel.add(btnNewButton_2);
		
		getContentPane().add("North",panel);
		
		
		
		//문자열이 출력되는 곳
		jtarea1.setBackground(new Color(193, 234, 242));
		jtarea1.setForeground(Color.black);
		jtarea1.setFont(new Font("굴림",Font.BOLD,22));
		jtarea1.setEditable(false);
		getContentPane().add("Center",jScrollPane);
		
		jtfield1.setBackground(Color.WHITE);
		jtfield1.setForeground(Color.black);
		jtfield1.setFont(new Font("굴림",Font.BOLD,25));
		getContentPane().add("South",jtfield1);
		jtfield1.addActionListener(this);
		
		setTitle("\uC544\uBBF8\uACE0 \uD1A1!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 1000);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
				System.exit(0); //이걸 해줘야 퇴장됨
				//단 한명 접속은 보낼사람이 없으니 안나오고 
				// 2명이상일때만 나옴
				setVisible(false);
			}
		
		});
		//=========================
		Thread th1 = new Thread(this); //서버로 부터 받아 taxtarea에 뿌려주는 쓰레드
		th1.start();
		//==========================
			
	
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == jtfield1) {
			try {
				outputStream.writeUTF(nickname + " --> " + jtfield1.getText());
				//nickname과 client의 채팅을 서버로
			}catch(IOException e1) {
//				e.printStackTrace();
			}
			jtfield1.setText("");//서버로 보내고 해당칸을 클리어
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(true) {
				String strServer1 = inputSream.readUTF();
				if(strServer1 == null) {
					jtarea1.append("\n종료");
					return;
				}
				jtarea1.append("\n" + strServer1);
			}
		}catch(Exception e) {
			jtarea1.append("\n" + e);
		}
	}
	
}

