package UDM_GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;

public class UDM_Out extends JFrame {

	private JPanel contentPane;
	private UDM_MainProcess main;

	/**
	 * Launch the application.
	 * 
	 * @throws InterruptedException
	 */
	public static void main(String[] args) {
		
	}

	/**
	 * Create the frame.
	 * 
	 * @throws InterruptedException
	 */
	public UDM_Out() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(UDM_Out.class.getResource("/img/logo.png")));
		setTitle("\uC6B0 . \uB3D9 . \uB9DB");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 45, 600, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		outPanel(panel);
		getContentPane().add(panel);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(UDM_Out.class.getResource("/bgimg/out.png")));
		lblNewLabel_3.setBounds(0, 0, 584, 961);
		contentPane.add(lblNewLabel_3);
	}

	public void outPanel(JPanel panel) {
		
		JButton button = new JButton("\uB85C\uADF8\uC778");
		button.setForeground(Color.WHITE);
		button.setBackground(Color.ORANGE);
		button.addMouseListener(new MouseAdapter() {
			UDM_MainProcess main = new UDM_MainProcess();
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				setVisible(false);
				main.showLogin();
			}
		});
		JLabel lblNewLabel = new JLabel("\uB85C\uADF8\uC544\uC6C3 \uB418\uC5C8\uC2B5\uB2C8\uB2E4.");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("±¼¸²", Font.PLAIN, 40));
		lblNewLabel.setBounds(12, 284, 560, 116);
		contentPane.add(lblNewLabel);
		
				JLabel lblNewLabel_1 = new JLabel("\uC624\uB298\uB3C4 \uB9DB\uC788\uB294 \uD558\uB8E8 \uB418\uC138\uC694~");
				lblNewLabel_1.setFont(new Font("±¼¸²", Font.PLAIN, 25));
				lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_1.setBounds(86, 388, 407, 35);
				contentPane.add(lblNewLabel_1);
		button.setBounds(70, 832, 182, 55);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\uC885\uB8CC");
		button_1.setBackground(new Color(255,69,0));
		button_1.setForeground(Color.WHITE);
		button_1.addMouseListener(new MouseAdapter() {
			UDM_MainProcess main = new UDM_MainProcess();
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		button_1.setBounds(326, 832, 182, 55);
		contentPane.add(button_1);
		
		JLabel label_3 = new JLabel("\uB124");
		label_3.setForeground(new Color(255, 140, 0));
		label_3.setFont(new Font("±¼¸²", Font.PLAIN, 25));
		label_3.setBounds(321, 184, 50, 55);
		contentPane.add(label_3);
		
		JLabel label_1_1 = new JLabel("\uC9D1");
		label_1_1.setForeground(new Color(255, 0, 0));
		label_1_1.setFont(new Font("±¼¸²", Font.PLAIN, 25));
		label_1_1.setBounds(469, 184, 50, 55);
		contentPane.add(label_1_1);
		
		JLabel label_2 = new JLabel("\uB9AC");
		label_2.setForeground(new Color(25, 25, 112));
		label_2.setFont(new Font("±¼¸²", Font.PLAIN, 25));
		label_2.setBounds(177, 184, 50, 55);
		contentPane.add(label_2);
		
		JLabel label_1 = new JLabel("\uB9DB.");
		label_1.setForeground(new Color(255, 0, 0));
		label_1.setFont(new Font("±¼¸²", Font.PLAIN, 80));
		label_1.setBounds(367, 123, 107, 116);
		contentPane.add(label_1);
		
		JLabel label = new JLabel("\uB3D9.");
		label.setForeground(new Color(255, 165, 0));
		label.setFont(new Font("±¼¸²", Font.PLAIN, 80));
		label.setBounds(217, 123, 107, 116);
		contentPane.add(label);
		
		JLabel lblNewLabel_2 = new JLabel("\uC6B0.");
		lblNewLabel_2.setForeground(new Color(25, 25, 112));
		lblNewLabel_2.setFont(new Font("±¼¸²", Font.PLAIN, 80));
		lblNewLabel_2.setBounds(70, 123, 107, 116);
		contentPane.add(lblNewLabel_2);
		setVisible(true);
	}

	public void setMain(UDM_MainProcess main) {
		// TODO Auto-generated method stub
		this.main = main;
	}
}
