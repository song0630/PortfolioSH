package UDM_GUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseMotionAdapter;
import java.sql.SQLException;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;

public class UDM_Loading extends JFrame {
	//private UDM_MainProcess main;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 * @throws InterruptedException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws InterruptedException {

		/*Thread.sleep(3000);
		new UDM_Login().setVisible(true);*/

	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws InterruptedException 
	 */
	public UDM_Loading() throws ClassNotFoundException, SQLException{
		setIconImage(Toolkit.getDefaultToolkit().getImage(UDM_Loading.class.getResource("/img/logo.png")));
		setTitle("\uC6B0 . \uB3D9 . \uB9DB");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 45, 600, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		lodingPanel(panel);
		getContentPane().add(panel);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setIcon(new ImageIcon(UDM_Loading.class.getResource("/bgimg/loading.png")));
		lblNewLabel_8.setBounds(0, 0, 584, 961);
		contentPane.add(lblNewLabel_8);
		setVisible(true);
	}
	
	public void lodingPanel(JPanel panel) throws ClassNotFoundException, SQLException {
		JLabel label = new JLabel("\uC6B0.");
		label.setBackground(new Color(0, 0, 0));
		label.setForeground(new Color(0, 0, 139));
		label.setFont(new Font("±¼¸²", Font.PLAIN, 99));
		label.setBounds(12, 10, 147, 177);
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("\uB3D9.");
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setForeground(new Color(255, 165, 0));
		lblNewLabel.setFont(new Font("±¼¸²", Font.PLAIN, 99));
		lblNewLabel.setBounds(12, 132, 147, 177);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uB9DB.");
		lblNewLabel_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setFont(new Font("±¼¸²", Font.PLAIN, 99));
		lblNewLabel_1.setBounds(12, 271, 147, 177);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uB9AC");
		lblNewLabel_2.setBackground(new Color(0, 0, 0));
		lblNewLabel_2.setForeground(new Color(0, 0, 139));
		lblNewLabel_2.setFont(new Font("±¼¸²", Font.PLAIN, 55));
		lblNewLabel_2.setBounds(171, 73, 81, 82);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\uB124");
		lblNewLabel_3.setBackground(new Color(0, 0, 0));
		lblNewLabel_3.setForeground(new Color(255, 165, 0));
		lblNewLabel_3.setFont(new Font("±¼¸²", Font.PLAIN, 55));
		lblNewLabel_3.setBounds(171, 195, 81, 82);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\uC9D1");
		lblNewLabel_4.setBackground(new Color(0, 0, 0));
		lblNewLabel_4.setForeground(new Color(255, 0, 0));
		lblNewLabel_4.setFont(new Font("±¼¸²", Font.PLAIN, 55));
		lblNewLabel_4.setBounds(171, 334, 81, 82);
		contentPane.add(lblNewLabel_4);
		
		JLabel label_1 = new JLabel("\uC5B4\uC81C\uB3C4 \uBA39\uAF2C");
		label_1.setBackground(new Color(0, 0, 0));
		label_1.setForeground(new Color(0, 0, 139));
		label_1.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(425, 115, 147, 24);
		contentPane.add(label_1);
		
		JLabel lblNewLabel_5 = new JLabel("\uB0B4\uC77C\uB3C4 \uBA39\uAF2C");
		lblNewLabel_5.setBackground(new Color(0, 0, 0));
		lblNewLabel_5.setForeground(new Color(255, 165, 0));
		lblNewLabel_5.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setBounds(425, 237, 147, 24);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("\uC624\uB298\uB3C4 \uBA39\uB294\uB2E4!");
		lblNewLabel_6.setBackground(new Color(0, 0, 0));
		lblNewLabel_6.setForeground(new Color(255, 0, 0));
		lblNewLabel_6.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6.setBounds(425, 376, 147, 24);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Loading...");
		lblNewLabel_7.setFont(new Font("±¼¸²", Font.PLAIN, 30));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(171, 821, 261, 41);
		contentPane.add(lblNewLabel_7);
		
		UdongDAO udmdao = new UdongDAO();
		udmdao.deleteCart();
	}

	/*public void setMain(UDM_MainProcess main) {
		// TODO Auto-generated method stub
		this.main=main;
	}*/
}