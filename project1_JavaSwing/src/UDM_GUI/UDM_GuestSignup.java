package UDM_GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class UDM_GuestSignup extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_3;
	private JTextField textField_4;
	private JButton btnNewButton;
	private UDM_MainProcess main;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	}

	/**
	 * Create the frame.
	 */
	public UDM_GuestSignup() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(UDM_GuestSignup.class.getResource("/img/logo.png")));
		setTitle("\uC6B0 . \uB3D9 . \uB9DB");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 45, 600, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		gsignupPanel(panel);
		getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(UDM_GuestSignup.class.getResource("/bgimg/signup.png")));
		lblNewLabel.setBounds(0, 0, 584, 961);
		contentPane.add(lblNewLabel);
		setVisible(true);
	}

	public void gsignupPanel(JPanel panel) {
		
		JButton btnNewButton_1 = new JButton("\uB4A4 \uB85C");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			UDM_MainProcess main = new UDM_MainProcess();
			@Override
			public void mouseClicked(MouseEvent e) {
				main.showLogin();
				dispose();
				setVisible(false);
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.ORANGE);
		btnNewButton_1.setBounds(324, 776, 135, 48);
		contentPane.add(btnNewButton_1);
		JLabel label = new JLabel("\uAC8C\uC2A4\uD2B8 \uB85C\uADF8\uC778");
		label.setFont(new Font("굴림", Font.PLAIN, 32));
		label.setBounds(35, 142, 268, 54);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\uC774\uB984");
		label_1.setBounds(43, 311, 78, 28);
		contentPane.add(label_1);
		
		JLabel label_4 = new JLabel("\uC804\uD654\uBC88\uD638");
		label_4.setBounds(25, 429, 65, 28);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("\uC8FC\uC18C");
		label_5.setBounds(37, 548, 54, 53);
		contentPane.add(label_5);
		
		textField = new JTextField();
		textField.setBounds(144, 305, 164, 40);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(145, 422, 196, 44);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(145, 547, 358, 156);
		contentPane.add(textField_4);
		
		btnNewButton = new JButton("\uAC00\uC785 \uC644\uB8CC");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.ORANGE);
		UDM_MainProcess main=new UDM_MainProcess();
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String name=textField.getText();
				String tel=textField_3.getText();
				String adr=textField_4.getText();
				if(name.equals("")){
					
					JOptionPane.showMessageDialog(null, "이름을 입력해 주세요");
				} else if(tel.equals("")) {
					JOptionPane.showMessageDialog(null, "전화번호를 입력해 주세요");
				} else if(adr.equals("")) {
					JOptionPane.showMessageDialog(null, "주소를 입력해 주세요");
				}else if (!name.equals("") && !tel.equals("") && !adr.equals("")) {
					
					String [] bae = {textField.getText()};
					String [] bae1 = {textField_3.getText()};
					String [] bae2 = {textField_4.getText()};
					
					if (check(bae) == true) {
						JOptionPane.showMessageDialog(null, "아이디에 공백창 없이 입력해 주세요");	
					} else if (check(bae1) == true) {
						JOptionPane.showMessageDialog(null, "비밀번호에 공백창 없이 입력해 주세요");	
					} else {
						
						main.showMain(name, adr);
						dispose();
						setVisible(false);
					}
				}
			}
		});
		btnNewButton.setBounds(144, 776, 135, 48);
		contentPane.add(btnNewButton);
	}
	
	public boolean check(String[] bae) { //메소드 정의문

		int n=-1;
		for(int i=0; i<bae.length; i++) {
			if(bae[i].toUpperCase().indexOf(" ")!= -1) { //없으면 -1  or >=0
				n++;
				return true;
			}
		}
		return false;
		
	}//kajaSearch end
	
	public void setMain(UDM_MainProcess main) {
		// TODO Auto-generated method stub
		this.main=main;
	}
}