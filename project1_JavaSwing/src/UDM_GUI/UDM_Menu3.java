package UDM_GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JToolBar;
import javax.swing.JComboBox;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class UDM_Menu3 extends JFrame {

   private JPanel contentPane;
   private JTextField textField;
   int count = 1;
   int count1 = 1;
   int count2 = 1;
   private JTextField textField_1;
   private JTextField textField_2;
   private UDM_MainProcess main;
   private JLabel label_6;

   /**
    * Create the frame.
    */
   
   public UDM_Menu3(String name, String adr) {
   	setIconImage(Toolkit.getDefaultToolkit().getImage(UDM_Menu3.class.getResource("/img/logo.png")));
      setTitle("\uC6B0 . \uB3D9 . \uB9DB");
      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(600, 45, 600, 1000);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      
      JPanel panel = new JPanel();
      menu3(panel, name, adr);
      getContentPane().add(panel);
      
      JLabel lblNewLabel_4 = new JLabel("");
      lblNewLabel_4.setIcon(new ImageIcon(UDM_Menu3.class.getResource("/bgimg/menu.png")));
      lblNewLabel_4.setBounds(0, 0, 584, 961);
      contentPane.add(lblNewLabel_4);
      
      
   }
   
   private void menu3(JPanel panel, String name, String adr) {
         JButton button = new JButton("+");
         button.setForeground(Color.WHITE);
         button.setBackground(new Color(79,134,247));
         button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
               if(arg0.getSource() == button) {
                  count++;
               textField.setText(String.valueOf(count));
               }
            
            }
         });
         button.setFont(new Font("±¼¸²", Font.PLAIN, 14));
         button.setBounds(432, 275, 57, 29);
         contentPane.add(button);
         
         textField = new JTextField();
         textField.setText("1");
         textField.setColumns(10);
         textField.setBounds(385, 279, 28, 21);
         contentPane.add(textField);
         
         JButton button_1 = new JButton("-");
         button_1.setForeground(Color.WHITE);
         button_1.setBackground(new Color(79,134,247));
         button_1.addMouseListener(new MouseAdapter() {
            
            public void mouseClicked(MouseEvent e) {
               if(e.getSource() == button_1) {
                  count --;
                  if(count <1) {
                     count = 1;
                  }
                  
                  textField.setText(String.valueOf(count));
               }
            }
         });
         button_1.setFont(new Font("±¼¸²", Font.PLAIN, 14));
         button_1.setBounds(306, 275, 57, 29);
         contentPane.add(button_1);
         
         JLabel label = new JLabel("\uD398\uD37C\uB85C\uB2C8 \uD53C\uC790");
         label.setFont(new Font("±¼¸²", Font.BOLD, 14));
         label.setBounds(242, 192, 147, 40);
         contentPane.add(label);
         
         JLabel label_2 = new JLabel("\uC2DC\uCE74\uACE0 \uD53C\uC790");
         label_2.setFont(new Font("±¼¸²", Font.BOLD, 14));
         label_2.setBounds(242, 360, 116, 40);
         contentPane.add(label_2);
         
         JLabel label_3 = new JLabel("\uB514\uB7ED\uC2A4 \uD53C\uC790");
         label_3.setFont(new Font("±¼¸²", Font.BOLD, 14));
         label_3.setBounds(242, 526, 116, 40);
         contentPane.add(label_3);
         
         JLabel lblNewLabel_2 = new JLabel("8000");
         lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
         lblNewLabel_2.setFont(new Font("±¼¸²", Font.PLAIN, 13));
         lblNewLabel_2.setBounds(242, 228, 70, 21);
         contentPane.add(lblNewLabel_2);
         
         JLabel lblNewLabel_3 = new JLabel("\uC6D0");
         lblNewLabel_3.setFont(new Font("±¼¸²", Font.PLAIN, 13));
         lblNewLabel_3.setBounds(322, 228, 57, 20);
         contentPane.add(lblNewLabel_3);
         
         JLabel label_7 = new JLabel("\uC6D0");
         label_7.setFont(new Font("±¼¸²", Font.PLAIN, 13));
         label_7.setBounds(322, 398, 57, 20);
         contentPane.add(label_7);
         
         JLabel label_8 = new JLabel("12000");
         label_8.setHorizontalAlignment(SwingConstants.RIGHT);
         label_8.setFont(new Font("±¼¸²", Font.PLAIN, 13));
         label_8.setBounds(242, 562, 70, 21);
         contentPane.add(label_8);
         
         JLabel label_9 = new JLabel("\uC6D0");
         label_9.setFont(new Font("±¼¸²", Font.PLAIN, 13));
         label_9.setBounds(325, 562, 57, 20);
         contentPane.add(label_9);
         
         label_6 = new JLabel("12000");
         label_6.setHorizontalAlignment(SwingConstants.RIGHT);
         label_6.setFont(new Font("±¼¸²", Font.PLAIN, 13));
         label_6.setBounds(242, 398, 70, 21);
         contentPane.add(label_6);
         
         
         //Ãß°¡ÇÏ±â
         JButton button_2 = new JButton("Ãß°¡ÇÏ±â");
         button_2.setBackground(Color.ORANGE);
         button_2.setForeground(Color.WHITE);
         button_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
         });
         button_2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               if(e.getSource() == button_2) {
                  try {
               UdongDAO udmdao = new UdongDAO();
                  JOptionPane.showMessageDialog(null, "Ãß°¡ µÇ¾ú½À´Ï´Ù");
               udmdao.insertCart(label.getText(), lblNewLabel_2.getText(), textField.getText());
                  

            } catch (ClassNotFoundException | SQLException e1) {
               // TODO Auto-generated catch block
               e1.printStackTrace();
            }
               }
            }
         });
         button_2.setBounds(433, 200, 95, 32);
         contentPane.add(button_2);
         
         JLabel label_1 = new JLabel("\uC591\uC2DD\uAC00\uAC8C");
         label_1.setFont(new Font("±¼¸²", Font.BOLD, 35));
         label_1.setBounds(226, 66, 163, 70);
         contentPane.add(label_1);
         
         JButton button_4 = new JButton("Àå¹Ù±¸´Ï");
         button_4.setForeground(Color.WHITE);
         button_4.setBackground(Color.ORANGE);
         button_4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               dispose();
               setVisible(false);
              // new UDM_Cart().setVisible(true);
            }
         });
         button_4.setBounds(325, 710, 147, 55);
         contentPane.add(button_4);
         
         //µÚ·Î°¡±â
         JButton button_3 = new JButton("µÚ·Î°¡±â");
         button_3.setForeground(Color.WHITE);
         button_3.setBackground(Color.ORANGE);
         button_3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               UDM_MainProcess main = new UDM_MainProcess();
               dispose();
               setVisible(false);
               main.showMain(name, adr);
            }
         });
         button_3.setBounds(129, 712, 147, 55);
         contentPane.add(button_3);
         
         
         //Ãß°¡ÇÏ±â
      
         JButton button_5 = new JButton("Ãß°¡ÇÏ±â");
         button_5.setBackground(Color.ORANGE);
         button_5.setForeground(Color.WHITE);
         button_5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               try {
            UdongDAO udmdao = new UdongDAO();
            JOptionPane.showMessageDialog(null, "Ãß°¡ µÇ¾ú½À´Ï´Ù");
            udmdao.insertCart(label_2.getText(), label_6.getText(), textField_1.getText());
         } catch (ClassNotFoundException | SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
         }
               
            }
         });
         button_5.setBounds(433, 368, 95, 32);
         contentPane.add(button_5);
         
         JButton button_6 = new JButton("-");
         button_6.setForeground(Color.WHITE);
         button_6.setBackground(new Color(79,134,247));
         button_6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               count1 --;
               if(count1 <1) {
                  count1 = 1;
               }
               
               textField_1.setText(String.valueOf(count1));
            }
         });
         button_6.setFont(new Font("±¼¸²", Font.PLAIN, 14));
         button_6.setBounds(306, 443, 57, 29);
         contentPane.add(button_6);
         
         textField_1 = new JTextField();
         textField_1.setText("1");
         textField_1.setColumns(10);
         textField_1.setBounds(385, 447, 28, 21);
         contentPane.add(textField_1);
         
         JButton button_7 = new JButton("+");
         button_7.setForeground(Color.WHITE);
         button_7.setBackground(new Color(79,134,247));
         button_7.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
               count1++;
               textField_1.setText(String.valueOf(count1));
            }
         });
         button_7.setFont(new Font("±¼¸²", Font.PLAIN, 14));
         button_7.setBounds(432, 443, 57, 29);
         contentPane.add(button_7);
         
         
         JButton button_8 = new JButton("Ãß°¡ÇÏ±â");
         button_8.setBackground(Color.ORANGE);
         button_8.setForeground(Color.WHITE);
         button_8.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               try {
               UdongDAO udmdao = new UdongDAO();
               JOptionPane.showMessageDialog(null, "Ãß°¡ µÇ¾ú½À´Ï´Ù");
               udmdao.insertCart(label_3.getText(), label_8.getText(), textField_2.getText());
            } catch (ClassNotFoundException | SQLException e1) {
               // TODO Auto-generated catch block
               e1.printStackTrace();
            }
            }
         });
         button_8.setBounds(433, 534, 95, 32);
         contentPane.add(button_8);
         
         JButton button_9 = new JButton("-");
         button_9.setForeground(Color.WHITE);
         button_9.setBackground(new Color(79,134,247));
         button_9.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               count2 --;
               if(count2 <1) {
                  count2 = 1;
               }
               
               textField_2.setText(String.valueOf(count2));
            }
         });
         button_9.setFont(new Font("±¼¸²", Font.PLAIN, 14));
         button_9.setBounds(306, 609, 57, 29);
         contentPane.add(button_9);
         
         textField_2 = new JTextField();
         textField_2.setText("1");
         textField_2.setColumns(10);
         textField_2.setBounds(385, 613, 28, 21);
         contentPane.add(textField_2);
         
         JButton button_10 = new JButton("+");
         button_10.setForeground(Color.WHITE);
         button_10.setBackground(new Color(79,134,247));
         button_10.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               count2++;
               textField_2.setText(String.valueOf(count2));
            }
         });
         button_10.setFont(new Font("±¼¸²", Font.PLAIN, 14));
         button_10.setBounds(432, 609, 57, 29);
         contentPane.add(button_10);
         
         JLabel lblNewLabel_1 = new JLabel("");
         lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
         lblNewLabel_1.setIcon(new ImageIcon(UDM_Menu3.class.getResource("/img/\uD398\uD37C\uB85C\uB2C8\uD53C\uC790.jpg")));
         lblNewLabel_1.setBorder(new EtchedBorder(Color.orange, Color.orange));
         lblNewLabel_1.setBounds(41, 192, 172, 121);
         contentPane.add(lblNewLabel_1);
         
         JLabel label_4 = new JLabel("");
         label_4.setHorizontalAlignment(SwingConstants.CENTER);
         label_4.setIcon(new ImageIcon(UDM_Menu3.class.getResource("/img/\uC2DC\uCE74\uACE0\uD53C\uC790.jpg")));
         label_4.setBorder(new EtchedBorder(Color.orange, Color.orange));
         label_4.setBounds(41, 362, 172, 121);
         contentPane.add(label_4);
         
         JLabel label_5 = new JLabel("");
         label_5.setHorizontalAlignment(SwingConstants.CENTER);
         label_5.setIcon(new ImageIcon(UDM_Menu3.class.getResource("/img/\uBD88\uACE0\uAE30\uD53C\uC790.jpg")));
         label_5.setBorder(new EtchedBorder(Color.orange, Color.orange));
         label_5.setBounds(41, 526, 172, 121);
         contentPane.add(label_5);
         
         
   }
   public void setMain(UDM_MainProcess main) {
      // TODO Auto-generated method stub
      this.main=main;
   }

}