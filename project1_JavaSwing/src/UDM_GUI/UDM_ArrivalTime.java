package UDM_GUI;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Toolkit;

public class UDM_ArrivalTime extends JFrame {

	private JPanel contentPane;
	private UDM_MainProcess main;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	}

	/**
	 * Create the frame.
	 */
	public UDM_ArrivalTime(String name, String adr) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(UDM_ArrivalTime.class.getResource("/img/logo.png")));
		setTitle("\uC6B0 . \uB3D9 . \uB9DB");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 45, 600, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		atimePanel(panel, name, adr);
		getContentPane().add(panel);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon(UDM_ArrivalTime.class.getResource("/bgimg/arrival.png")));
		lblNewLabel_5.setBounds(0, 0, 584, 961);
		contentPane.add(lblNewLabel_5);
		setVisible(true);
	}
	
	public void atimePanel(JPanel panel, String name, String adr) {
		JLabel lblNewLabel = new JLabel("\uBC30\uC1A1 \uC8FC\uC18C\uC9C0");
		lblNewLabel.setBounds(174, 77, 233, 53);
		lblNewLabel.setFont(new Font("±¼¸²", Font.PLAIN, 40));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(adr);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(51, 157, 478, 44);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(UDM_ArrivalTime.class.getResource("/img/\uBC30\uB2EC \uACBD\uB85C1.png")));
		lblNewLabel_2.setBounds(61, 211, 468, 296);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\uB3C4\uCC29 \uC608\uC815 \uC2DC\uAC04 ");
		lblNewLabel_3.setFont(new Font("±¼¸²", Font.PLAIN, 40));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setBounds(148, 650, 297, 63);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("00:35 \uBD84");
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setFont(new Font("±¼¸²", Font.PLAIN, 40));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setBounds(194, 726, 173, 35);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("\uBA54\uC778 \uD654\uBA74");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.addMouseListener(new MouseAdapter() {
			UDM_MainProcess main=new UDM_MainProcess();
			@Override
			public void mouseClicked(MouseEvent e) {
				main.showMain(name, adr);
				dispose();
				setVisible(false);
			}
		});
		btnNewButton.setBounds(217, 813, 149, 44);
		contentPane.add(btnNewButton);
	}
	
	public void setMain(UDM_MainProcess main) {
		// TODO Auto-generated method stub
		this.main=main;
	}
}
