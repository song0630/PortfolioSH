package UDM_GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JToolBar;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import javax.swing.JScrollBar;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class UDM_Cart extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	
	
	public UDM_Cart(String name, String adr) throws ClassNotFoundException, SQLException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(UDM_Cart.class.getResource("/img/logo.png")));
		setTitle("\uC6B0 . \uB3D9 . \uB9DB");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 45, 600, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		cart(panel, name, adr);
		getContentPane().add(panel);
		
		JLabel lblNewLabel_10 = new JLabel("New label");
		lblNewLabel_10.setIcon(new ImageIcon(UDM_Cart.class.getResource("/bgimg/cart.png")));
		lblNewLabel_10.setBounds(0, 0, 584, 961);
		contentPane.add(lblNewLabel_10);
		
		
		
		
	}
	
	private void cart(JPanel panel, String name, String adr) throws ClassNotFoundException, SQLException {
		
		
		JLabel lblNewLabel = new JLabel("\uC7A5\uBC14\uAD6C\uB2C8");
		lblNewLabel.setFont(new Font("±º∏≤", Font.PLAIN, 30));
		lblNewLabel.setBounds(218, 50, 147, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uACB0\uC81C\uBC29\uBC95");
		lblNewLabel_1.setFont(new Font("±º∏≤", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(36, 511, 126, 50);
		contentPane.add(lblNewLabel_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("\uB9CC\uB098\uC11C \uACB0\uC81C");
		rdbtnNewRadioButton.setForeground(Color.WHITE);
		rdbtnNewRadioButton.setBackground(new Color(0, 153, 102));
		rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton.setBounds(36, 580, 121, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(Color.WHITE);
		comboBox.setBackground(new Color(0, 153, 102));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\uACB0\uC81C\uBC29\uC2DD", "\uCE74\uB4DC \uACB0\uC81C", "\uD604\uAE08 \uACB0\uC81C"}));
		comboBox.setBounds(36, 619, 153, 21);
		contentPane.add(comboBox);
		
		JLabel label = new JLabel("\uCD1D \uACB0\uC81C \uAE08\uC561");
		label.setFont(new Font("±º∏≤", Font.PLAIN, 20));
		label.setBounds(36, 701, 153, 30);
		contentPane.add(label);
		
		
		
		//¡÷πÆ«œ±‚ 
		JButton btnNewButton = new JButton("\uC8FC\uBB38\uD558\uAE30");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			UDM_MainProcess main = new UDM_MainProcess();
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					ArrayList<cartVO> list2 = select();
					if(list2.isEmpty()) {
						JOptionPane.showMessageDialog(null, "¿ÂπŸ±∏¥œ∏¶ √§øˆ¡÷ººø‰~");
					} else {
						delete();
						dispose();
						setVisible(false);
						main.showOrdered(name, adr);
					}
					
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnNewButton.setBounds(311, 834, 133, 50);
		contentPane.add(btnNewButton);
		
		ArrayList<cartVO> list = select();
		
		JButton btnEnlfhrkrl = new JButton("\uBA54\uB274");
		btnEnlfhrkrl.setForeground(Color.WHITE);
		btnEnlfhrkrl.setBackground(Color.ORANGE);
		btnEnlfhrkrl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				dispose();
				setVisible(false);
				new UDM_Main(name, adr).setVisible(true);
			}
		});
		btnEnlfhrkrl.setBounds(109, 834, 133, 50);
		contentPane.add(btnEnlfhrkrl);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(53, 118, 471, 337);
		contentPane.add(scrollPane);
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(new Color(255,204,153));
		
		
		
		Dimension d1 = new Dimension();
		d1.setSize(1000, 1000);
		panel1.setPreferredSize(d1);
		scrollPane.setViewportView(panel1);
		panel1.setLayout(null);
		
		int one1 = 0; int two1 = 0; int thr1 = 0; int fou1 = 0;
		int one2 = 0; int two2 = 0; int thr2 = 0; int fou2 = 0;
		
	
		JLabel label_2 = new JLabel("\uBA54\uB274\uBA85");
		
		
		if(!list.isEmpty() && list.size() >= 1) {
			label_2.setText(list.get(0).getcName());
		} else {
			label_2.setText("");
		}
		
		label_2.setFont(new Font("±º∏≤", Font.BOLD, 14));
		label_2.setBounds(25, 19, 102, 40);
		panel1.add(label_2);
		
		JLabel label_3 = new JLabel("\uAC00\uACA9");
		if(!list.isEmpty() && list.size() >= 1) {
			label_3.setText(list.get(0).getPrice());
			one1 = Integer.parseInt(list.get(0).getPrice());
		} else {
			label_3.setText("");
		}
		
		label_3.setFont(new Font("±º∏≤", Font.BOLD, 14));
		label_3.setBounds(196, 19, 57, 40);
		panel1.add(label_3);
		
		JLabel label_4 = new JLabel("\uC218\uB7C9");
		if(!list.isEmpty() && list.size() >= 1) {
			label_4.setText(list.get(0).getVolume());
			one2 = Integer.parseInt(list.get(0).getVolume());
		} else {
			label_4.setText("");
		}
		
		label_4.setFont(new Font("±º∏≤", Font.BOLD, 14));
		label_4.setBounds(357, 19, 57, 40);
		panel1.add(label_4);
		
		JLabel label_5 = new JLabel("\uBA54\uB274\uBA85");
		if(!list.isEmpty() && list.size() >= 2) {
			label_5.setText(list.get(1).getcName());
		} else {
			label_5.setText("");
		}
		
		label_5.setFont(new Font("±º∏≤", Font.BOLD, 14));
		label_5.setBounds(25, 107, 81, 40);
		panel1.add(label_5);
		
		JLabel label_6 = new JLabel("\uAC00\uACA9");
		if(!list.isEmpty() && list.size() >= 2) {
			label_6.setText(list.get(1).getPrice());
			two1 = Integer.parseInt(list.get(1).getPrice());
		} else {
			label_6.setText("");
		}
		
		label_6.setFont(new Font("±º∏≤", Font.BOLD, 14));
		label_6.setBounds(196, 107, 57, 40);
		panel1.add(label_6);
		
		JLabel label_7 = new JLabel("\uC218\uB7C9");
		if(!list.isEmpty() && list.size() >= 2) {
			label_7.setText(list.get(1).getVolume());
			two2 = Integer.parseInt(list.get(1).getVolume());
		} else {
			label_7.setText("");
		}
		
		label_7.setFont(new Font("±º∏≤", Font.BOLD, 14));
		label_7.setBounds(357, 107, 57, 40);
		panel1.add(label_7);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setFont(new Font("±º∏≤", Font.BOLD, 14));
		if(!list.isEmpty() && list.size() >= 3) {
			lblNewLabel_2.setText(list.get(2).getcName());
		} else {
			lblNewLabel_2.setText("");
		}
		
		lblNewLabel_2.setBounds(25, 188, 102, 40);
		panel1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setFont(new Font("±º∏≤", Font.BOLD, 14));
		if(!list.isEmpty() && list.size() >= 3) {
			lblNewLabel_3.setText(list.get(2).getPrice());
			thr1 = Integer.parseInt(list.get(2).getPrice());
		} else {
			lblNewLabel_3.setText("");
		}
		
		lblNewLabel_3.setBounds(196, 191, 57, 35);
		panel1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setFont(new Font("±º∏≤", Font.BOLD, 14));
		if(!list.isEmpty() && list.size() >= 3) {
			lblNewLabel_4.setText(list.get(2).getVolume());
			thr2 = Integer.parseInt(list.get(2).getVolume());
		} else {
			lblNewLabel_4.setText("");
		}
		
		
		lblNewLabel_4.setBounds(357, 195, 57, 27);
		panel1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setFont(new Font("±º∏≤", Font.BOLD, 14));
		if(!list.isEmpty() && list.size() == 4) {
				lblNewLabel_5.setText(list.get(3).getcName());
		} else {
			lblNewLabel_5.setText("");
		}
		
		
		
		lblNewLabel_5.setBounds(25, 266, 102, 40);
		panel1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setFont(new Font("±º∏≤", Font.BOLD, 14));
		if(!list.isEmpty() && list.size() == 4) {
			lblNewLabel_6.setText(list.get(3).getPrice());
			fou1 = Integer.parseInt(list.get(3).getPrice());
		} else {
			lblNewLabel_6.setText("");
		}
		
		lblNewLabel_6.setBounds(196, 269, 57, 35);
		panel1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setFont(new Font("±º∏≤", Font.BOLD, 14));
		if(!list.isEmpty() && list.size() == 4) {
			lblNewLabel_7.setText(list.get(3).getVolume());
			fou2 = Integer.parseInt(list.get(3).getVolume());
		} else {
			lblNewLabel_7.setText("");
		}
		
		lblNewLabel_7.setBounds(357, 273, 57, 27);
		panel1.add(lblNewLabel_7);
		
		JLabel label_1 = new JLabel("\uAE08\uC561 \uC608\uC2DC 10000");
		label_1.setFont(new Font("±º∏≤", Font.PLAIN, 20));
		
		int p1 = (one1*one2)+(two1*two2)+(thr1*thr2)+(fou1*fou2);
		String p2 = Integer.toString(p1);
		
		label_1.setText(p2);
		
		
		
		label_1.setBounds(36, 777, 126, 30);
		contentPane.add(label_1);
		
		JButton btnNewButton_1 = new JButton("\uC7A5\uBC14\uAD6C\uB2C8 \uBE44\uC6B0\uAE30");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(new Color(255, 69, 0));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					delete();
					label_2.setText(""); label_3.setText(""); label_4.setText("");
					label_5.setText(""); label_6.setText(""); label_7.setText("");
					lblNewLabel_2.setText(""); lblNewLabel_3.setText(""); lblNewLabel_4.setText("");
					lblNewLabel_5.setText(""); lblNewLabel_6.setText(""); lblNewLabel_7.setText("");
					
					label_1.setText("0");
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(377, 482, 147, 40);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_8 = new JLabel("\uC6D0");
		lblNewLabel_8.setFont(new Font("±º∏≤", Font.PLAIN, 20));
		lblNewLabel_8.setBounds(158, 781, 31, 22);
		contentPane.add(lblNewLabel_8);
		
	}
	
	public ArrayList<cartVO> select() throws ClassNotFoundException, SQLException {
		UdongDAO udmdao = new UdongDAO();
		ArrayList<cartVO> list = udmdao.selectCart();
		
		return list;
	}
	
	public void delete() throws ClassNotFoundException, SQLException {
		UdongDAO udmdao = new UdongDAO();
		boolean flag = udmdao.deleteCart();
		ArrayList<cartVO> list = new ArrayList<>();
		if(flag) {
			list = select();
			list.clear();
		}
		
	}
}
