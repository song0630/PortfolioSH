package UDM_GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class UDM_Signup extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
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
	public UDM_Signup() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(UDM_Signup.class.getResource("/img/logo.png")));
		setTitle("\uC6B0 . \uB3D9 . \uB9DB");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 45, 600, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		signupPanel(panel);
		getContentPane().add(panel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(UDM_Signup.class.getResource("/bgimg/signup.png")));
		label.setBounds(0, 0, 584, 961);
		contentPane.add(label);
		setVisible(true);
	}
	
	public void signupPanel(JPanel panel) {
		
		JButton btnNewButton_1 = new JButton("\uB4A4 \uB85C");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
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
		btnNewButton_1.setBounds(319, 774, 133, 48);
		contentPane.add(btnNewButton_1);
		JLabel label = new JLabel("\uD68C\uC6D0\uAC00\uC785");
		label.setFont(new Font("굴림", Font.PLAIN, 32));
		label.setBounds(19, 96, 172, 64);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\uC774\uB984");
		label_1.setBounds(48, 232, 78, 28);
		contentPane.add(label_1);
		
		JLabel lblId = new JLabel("\uC544\uC774\uB514");
		lblId.setBounds(48, 286, 78, 28);
		contentPane.add(lblId);
		
		JLabel lblPw = new JLabel("\uD328\uC2A4\uC6CC\uB4DC");
		lblPw.setBounds(48, 351, 78, 28);
		contentPane.add(lblPw);
		
		JLabel label_4 = new JLabel("\uC804\uD654\uBC88\uD638");
		label_4.setBounds(48, 410, 78, 28);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("\uC8FC\uC18C");
		label_5.setBounds(48, 497, 78, 28);
		contentPane.add(label_5);
		
		textField = new JTextField();
		textField.setBounds(140, 236, 128, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(140, 290, 128, 24);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(140, 348, 128, 28);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(140, 413, 249, 37);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(140, 498, 362, 207);
		contentPane.add(textField_4);
		
		btnNewButton = new JButton("\uAC00\uC785 \uC644\uB8CC");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.addMouseListener(new MouseAdapter() {
			UDM_MainProcess main = new UDM_MainProcess();
			@Override
			public void mouseClicked(MouseEvent e) {
			if (e.getSource() == btnNewButton) {
				try {
					UdongDAO d1 = new UdongDAO();
					if((textField.getText().equals(""))){
						JOptionPane.showMessageDialog(null, "이름을 입력해 주세요");
					} else if ((textField_1.getText().equals(""))) {
						JOptionPane.showMessageDialog(null, "아이디를 입력해 주세요");
					} else if ((textField_2.getText().equals(""))) {
						JOptionPane.showMessageDialog(null, "비밀번호를 입력해 주세요");
					} else if ((textField_3.getText().equals(""))) {
						JOptionPane.showMessageDialog(null, "전화번호를 입력해 주세요");
					} else if ((textField_4.getText().equals(""))) {
						JOptionPane.showMessageDialog(null, "주소를 입력해 주세요");
					} else if(textField.getText() != null || textField_1.getText() != null || textField_2.getText() != null || textField_3.getText() != null || textField_4.getText() != null) {
						boolean b1 = d1.id_doubleCheck(textField_1.getText());
						if(b1) {
							boolean b11 = d1.insert(textField.getText(), textField_1.getText(), textField_2.getText(), textField_3.getText(), textField_4.getText());
							UDM_MainProcess main=new UDM_MainProcess();
							if(b11) {
							dispose();
							setVisible(false);
							main.showLogin();
						} 
						} else {
						JOptionPane.showMessageDialog(null, "중복된 아이디 입니다");
						}
					} 
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
			}
		});
		btnNewButton.setBounds(140, 774, 133, 48);
		contentPane.add(btnNewButton);
	}
	
	public void setMain(UDM_MainProcess main) {
		// TODO Auto-generated method stub
		this.main=main;
	}
}
