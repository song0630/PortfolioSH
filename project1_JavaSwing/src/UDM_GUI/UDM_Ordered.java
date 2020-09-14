package UDM_GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;

public class UDM_Ordered extends JFrame {

   private JPanel contentPane;
   private UDM_MainProcess main;
   /**
    * Create the frame.
    */
   
   
   public UDM_Ordered(String name, String adr) {
   	setIconImage(Toolkit.getDefaultToolkit().getImage(UDM_Ordered.class.getResource("/img/logo.png")));
   	setTitle("\uC6B0 . \uB3D9 . \uB9DB");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(600, 45, 600, 1000);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      
      JPanel panel = new JPanel();
      Ordered(panel, name, adr);
      getContentPane().add(panel);
      
      JLabel lblNewLabel_1 = new JLabel("New label");
      lblNewLabel_1.setIcon(new ImageIcon(UDM_Ordered.class.getResource("/bgimg/order.png")));
      lblNewLabel_1.setBounds(0, 0, 584, 961);
      contentPane.add(lblNewLabel_1);
      setVisible(true);
   }
   
   public void Ordered(JPanel panel,String name, String adr) {

      JLabel lblNewLabel = new JLabel("\uC8FC\uBB38\uC774 \uC644\uB8CC\uB418\uC5C8\uC2B5\uB2C8\uB2E4");
      lblNewLabel.setFont(new Font("±¼¸²", Font.PLAIN, 38));
      lblNewLabel.setBounds(90, 228, 421, 140);
      contentPane.add(lblNewLabel);
      
      JButton btnNewButton = new JButton("\uBA54\uC778\uC73C\uB85C");
      btnNewButton.setForeground(Color.WHITE);
      btnNewButton.setBackground(Color.ORANGE);
      btnNewButton.addMouseListener(new MouseAdapter() {
         UDM_MainProcess main=new UDM_MainProcess();
         @Override
         public void mouseClicked(MouseEvent e) {
            dispose();
            setVisible(false);
            
            main.showMain(name, adr);
         }
      });
      btnNewButton.setBounds(217, 697, 151, 48);
      contentPane.add(btnNewButton);
   }
   
   public void setMain(UDM_MainProcess main) {
      // TODO Auto-generated method stub
      this.main=main;
   }
}