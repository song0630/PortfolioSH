package UDM_GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Toolkit;

public class UDM_Main extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnNewButton_1;
	private JButton btnNewButton_5;
	private JButton btnNewButton_6;
	private JButton btnNewButton_7;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private String text;
	private UDM_MainProcess main;
	private JLabel lblNewLabel_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	}

	/**
	 * Create the frame.
	 */
	public UDM_Main(String name, String adr) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(UDM_Main.class.getResource("/img/logo.png")));
		setTitle("\uC6B0 . \uB3D9 . \uB9DB");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 45, 600, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		mainPanel(panel, name, adr);
		getContentPane().add(panel);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(UDM_Main.class.getResource("/bgimg/main.png")));
		lblNewLabel_3.setBounds(0, 0, 584, 961);
		contentPane.add(lblNewLabel_3);
		setVisible(true);
	}
	
	public void mainPanel(JPanel panel, String name, String adr) {
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		toolBar.setBounds(121, 124, 348, 54);
		contentPane.add(toolBar);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setIcon(new ImageIcon(UDM_Main.class.getResource("/img/\uAC80\uC0C9 \uBC84\uD2BC.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					UdongDAO udmdao = new UdongDAO();
					String menu = textField.getText();
					String n1 = udmdao.selectMenu(menu);
					
					if(n1.equals("Æ¯º°ÃÊ¹ä") || n1.equals("Â÷½´¶ó¸à") || n1.equals("Ä¡Áîµ·±î½º")) {
						dispose();
						setVisible(false);
						new UDM_Menu4(name, adr).setVisible(true);
					} else if(n1.equals("Â¥Àå¸é") || n1.equals("Â«»Í") || n1.equals("ÅÁ¼öÀ°")) {
						dispose();
						setVisible(false);
						new UDM_Menu2(name, adr).setVisible(true);
					} else if(n1.equals("ÆäÆÛ·Î´Ï ÇÇÀÚ") || n1.equals("½ÃÄ«°í ÇÇÀÚ") || n1.equals("µð·°½º ÇÇÀÚ")) {
						dispose();
						setVisible(false);
						new UDM_Menu3(name, adr).setVisible(true);
					} else if(n1.equals("ºÒ°í±â") || n1.equals("ÆÈ»öºñºö¹ä") || n1.equals("»ï°èÅÁ")) {
						dispose();
						setVisible(false);
						new UDM_Menu(name, adr).setVisible(true);
					}
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		toolBar.add(btnNewButton);
		btnNewButton.setVerticalAlignment(SwingConstants.BOTTOM);
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		
		textField = new JTextField();
		toolBar.add(textField);
		
		textField.addActionListener(new ActionListener() {
			UDM_MainProcess main=new UDM_MainProcess();
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == textField) {
					try {
						UdongDAO udmdao = new UdongDAO();
						String menu = textField.getText();
						String n1 = udmdao.selectMenu(menu);
						
						if(n1.equals("Æ¯º°ÃÊ¹ä") || n1.equals("Â÷½´¶ó¸à") || n1.equals("Ä¡Áîµ·±î½º")) {
							dispose();
							setVisible(false);
							new UDM_Menu(name, adr).setVisible(true);
						} else if(n1.equals("Â¥Àå¸é") || n1.equals("Â«»Í") || n1.equals("ÅÁ¼öÀ°")) {
							dispose();
							setVisible(false);
							new UDM_Menu2(name, adr).setVisible(true);
						} else if(n1.equals("ÆäÆÛ·Î´Ï ÇÇÀÚ") || n1.equals("½ÃÄ«°í ÇÇÀÚ") || n1.equals("µð·°½º ÇÇÀÚ")) {
							dispose();
							setVisible(false);
							new UDM_Menu3(name, adr).setVisible(true);
						} else if(n1.equals("ºÒ°í±â") || n1.equals("ÆÈ»öºñºö¹ä") || n1.equals("»ï°èÅÁ")) {
							dispose();
							setVisible(false);
							new UDM_Menu4(name, adr).setVisible(true);
						}
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
		});
		
		textField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(arg0.getSource()==textField) {
					textField.selectAll();
				}
			}
		});
		textField.setText("\uBA54\uB274\uBA85");
		textField.setColumns(10);
		
		btnNewButton_1 = new JButton("\uD55C\uC2DD");
		btnNewButton_1.setBorder(new EtchedBorder(new Color(0,141,98), new Color(0,141,98)));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBackground(new Color(113,238,184));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UDM_MainProcess main = new UDM_MainProcess();
				dispose();
				setVisible(false);
				new UDM_Menu(name, adr).setVisible(true);
			}
		});
		btnNewButton_1.setBounds(77, 282, 172, 69);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_5 = new JButton("\uC7A5\uBC14\uAD6C\uB2C8");
		btnNewButton_5.setForeground(Color.WHITE);
		btnNewButton_5.setBackground(new Color(0,141,98));
		btnNewButton_5.setBorder(new EtchedBorder(new Color(10,107,13), new Color(10,107,13)));
		UDM_MainProcess main = new UDM_MainProcess();
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			UDM_MainProcess main = new UDM_MainProcess();
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				setVisible(false);
				try {
					new UDM_Cart(name, adr).setVisible(true);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_5.setBounds(42, 669, 132, 69);
		contentPane.add(btnNewButton_5);
		
		btnNewButton_6 = new JButton("\uC74C\uC2DD\uC810 \uCD94\uCC9C");
		btnNewButton_6.setBackground(new Color(0,141,98));
		btnNewButton_6.setBorder(new EtchedBorder(new Color(10,107,13), new Color(10,107,13)));
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_6.setForeground(Color.WHITE);
		btnNewButton_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int num = ((int)(Math.random()*4)+1);
				if(num == 1) { 
					dispose();
					setVisible(false);
					new UDM_Menu(name, adr).setVisible(true);
				} else if(num == 2) {
					dispose();
					setVisible(false);
					new UDM_Menu2(name, adr).setVisible(true);
				} else if(num == 3) {
					dispose();
					setVisible(false);
					new UDM_Menu3(name, adr).setVisible(true);
				} else if(num == 4) {
					dispose();
					setVisible(false);
					new UDM_Menu4(name, adr).setVisible(true);
				}
			}
		});
		btnNewButton_6.setBounds(389, 669, 143, 69);
		contentPane.add(btnNewButton_6);
		
		btnNewButton_7 = new JButton("\uC608\uC0C1 \uC18C\uC694\uC2DC\uAC04");
		btnNewButton_7.setForeground(Color.WHITE);
		btnNewButton_7.setBackground(new Color(0,141,98));
		btnNewButton_7.setBorder(new EtchedBorder(new Color(10,107,13), new Color(10,107,13)));
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_7.addMouseListener(new MouseAdapter() {
			UDM_MainProcess main=new UDM_MainProcess();
			@Override
			public void mouseClicked(MouseEvent e) {
				main.showAtime(name, adr);
				dispose();
				setVisible(false);
			}
		});
		btnNewButton_7.setBounds(213, 669, 143, 69);
		contentPane.add(btnNewButton_7);
		
		lblNewLabel = new JLabel("\uB2D8 \uD658\uC601\uD569\uB2C8\uB2E4.");
		lblNewLabel.setFont(new Font("±¼¸²", Font.PLAIN, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(421, 10, 111, 30);
		contentPane.add(lblNewLabel);
		
		//¿©±â ÀÌ¸§
		lblNewLabel_1 = new JLabel(name);
		lblNewLabel_1.setFont(new Font("±¼¸²", Font.PLAIN, 13));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(332, 10, 97, 30);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("\uB85C\uADF8\uC544\uC6C3");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			UDM_MainProcess main = new UDM_MainProcess();
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				setVisible(false);
				 main.showOut();
				 
				 UdongDAO udmdao;
				try {
					udmdao = new UdongDAO();
					udmdao.deleteCart();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
				//new UDM_Out().setVisible(true);
			}
		});
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setFont(new Font("±¼¸²", Font.PLAIN, 13));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(441, 39, 87, 24);
		contentPane.add(lblNewLabel_2);
		
		button = new JButton("\uC911\uC2DD");
		button.setForeground(Color.BLACK);
		button.setBackground(new Color(113,238,184));
		button.setBorder(new EtchedBorder(new Color(0,141,98), new Color(0,141,98)));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				setVisible(false);
				new UDM_Menu2(name, adr).setVisible(true);
			}
		});
		button.setBounds(340, 282, 172, 69);
		contentPane.add(button);
		
		button_1 = new JButton("\uC591\uC2DD");
		button_1.setForeground(Color.BLACK);
		button_1.setBackground(new Color(113,238,184));
		button_1.setBorder(new EtchedBorder(new Color(0,141,98), new Color(0,141,98)));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				setVisible(false);
				new UDM_Menu3(name, adr).setVisible(true);
			}
		});
		button_1.setBounds(77, 419, 172, 69);
		contentPane.add(button_1);
		
		button_2 = new JButton("\uC77C\uC2DD");
		button_2.setBackground(new Color(113,238,184));
		button_2.setBorder(new EtchedBorder(new Color(0,141,98), new Color(0,141,98)));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_2.setForeground(Color.BLACK);
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				setVisible(false);
				new UDM_Menu4(name, adr).setVisible(true);
			}
		});
		button_2.setBounds(340, 419, 172, 69);
		contentPane.add(button_2);
	}
	
	public void setMain(UDM_MainProcess main) {
		// TODO Auto-generated method stub
		this.main=main;
	}
}
