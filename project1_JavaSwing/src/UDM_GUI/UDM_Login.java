package UDM_GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class UDM_Login extends JFrame {

   private JPanel contentPane;
   private JTextField textField_1;
   private JLabel lblNewLabel;
   private JButton btnNewButton;
   private JTextField textField;
   private JLabel lblId;   
   private UDM_MainProcess main;
   String a1;
   private String text;
   private String text2;
   private JLabel lblNewLabel_2;
   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      
   }

   /**
    * Create the frame.
    * @throws SQLException 
    * @throws ClassNotFoundException 
    */
   public UDM_Login() throws ClassNotFoundException, SQLException {
   	setIconImage(Toolkit.getDefaultToolkit().getImage(UDM_Login.class.getResource("/img/logo.png")));
   	setTitle("\uC6B0 . \uB3D9 . \uB9DB");

      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(600, 45, 600, 1000);
      contentPane = new JPanel();
      contentPane.setBackground(new Color(255, 228, 181));
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      
      JPanel panel = new JPanel();
      loginPanel(panel);
      getContentPane().add(panel);
      
      lblNewLabel_2 = new JLabel("");
      lblNewLabel_2.setIcon(new ImageIcon(UDM_Login.class.getResource("/bgimg/login.png")));
      lblNewLabel_2.setBounds(0, 0, 584, 961);
      contentPane.add(lblNewLabel_2);
      setVisible(true);
   }
   
   public void loginPanel(JPanel panel) {
      JLabel lblLogin = new JLabel("Login");
      lblLogin.setForeground(new Color(0, 0, 0));
      lblLogin.setFont(new Font("굴림", Font.BOLD, 58));
      lblLogin.setBounds(198, 75, 199, 96);
      contentPane.add(lblLogin);

      JLabel lblPw = new JLabel("PW");
      lblPw.setForeground(new Color(0, 0, 0));
      lblPw.setFont(new Font("굴림", Font.BOLD, 32));
      lblPw.setBounds(65, 641, 63, 41);
      contentPane.add(lblPw);

      
      lblNewLabel = new JLabel("\uD68C\uC6D0\uAC00\uC785");
      lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 17));
      lblNewLabel.setForeground(Color.BLUE);
      lblNewLabel.addMouseListener(new MouseAdapter() {
    	  UDM_MainProcess main = new UDM_MainProcess();
         @Override
         public void mouseClicked(MouseEvent e) {
            dispose();
            setVisible(false);
            main.showSignup();
         }
      });
      lblNewLabel.setBounds(180, 722, 81, 27);
      contentPane.add(lblNewLabel);
      
      
      textField_1 = new JPasswordField();
      textField_1.setBounds(140, 641, 205, 33);
      contentPane.add(textField_1);
      
      textField_1.addActionListener(new ActionListener() {
         UDM_MainProcess main=new UDM_MainProcess();
         @Override
         public void actionPerformed(ActionEvent e) {
            if(e.getSource() == textField_1) {
               try {
                  UdongDAO udmdao = new UdongDAO();
                  if(textField.getText().equals("") && textField_1.getText().equals("")) {
                     JOptionPane.showMessageDialog(null, "아이디, 비밀번호를 입력해 주세요");
                  } else if(textField.getText().equals("")) {
                     JOptionPane.showMessageDialog(null, "아이디를 입력해 주세요");
                  } else if(textField_1.getText().equals("")) {
                     JOptionPane.showMessageDialog(null, "비밀번호를 입력해 주세요");
                  }
                  else if((textField.getText() != null && textField_1.getText() != null)) {
                     boolean a = udmdao.member_Check(textField.getText(), textField_1.getText());
                     if(a == true) {
                        String name=udmdao.getName(textField.getText());
                        String adr=udmdao.getAdr(textField.getText());
                        dispose();
                        setVisible(false);
                        main.showMain(name, adr);
                     } else {
                        JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호가 틀렸습니다.");
                     }
                  }
               } catch (ClassNotFoundException | SQLException e1) {
                  e1.printStackTrace();
               }   
            }
         }
      });

      btnNewButton = new JButton("\uB85C\uADF8\uC778");
      btnNewButton.setForeground(Color.WHITE);
      btnNewButton.setBackground(Color.ORANGE);
      btnNewButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
         }
      });
      btnNewButton.addMouseListener(new MouseAdapter() {
         UDM_MainProcess main=new UDM_MainProcess();
         @Override
         public void mouseClicked(MouseEvent e) {
            if(e.getSource() == btnNewButton) {
               try {
                  UdongDAO udmdao = new UdongDAO();
                  if(textField.getText().equals("") && textField_1.getText().equals("")) {
                     JOptionPane.showMessageDialog(null, "아이디, 비밀번호를 입력해 주세요");
                  } else if(textField.getText().equals("")) {
                     JOptionPane.showMessageDialog(null, "아이디를 입력해 주세요");
                  } else if(textField_1.getText().equals("")) {
                     JOptionPane.showMessageDialog(null, "비밀번호를 입력해 주세요");
                  }
                  else if((textField.getText() != null && textField_1.getText() != null)) {
                     boolean a = udmdao.member_Check(textField.getText(), textField_1.getText());
                     if(a == true) {
                        String name=udmdao.getName(textField.getText());
                        String adr=udmdao.getAdr(textField.getText());
                        dispose();
                        setVisible(false);
                        main.showMain(name, adr);
                     } else {
                        JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호가 틀렸습니다.");
                     }
                  }
               } catch (ClassNotFoundException | SQLException e1) {
                  e1.printStackTrace();
               }   
            }
         }
      });
      btnNewButton.setBounds(374, 594, 143, 80);
      contentPane.add(btnNewButton);

      

      JLabel lblNewLAbel_2 = new JLabel("\uAC8C\uC2A4\uD2B8 \uC544\uC774\uB514\uB85C \uB85C\uADF8\uC778");
      lblNewLAbel_2.setFont(new Font("굴림", Font.PLAIN, 16));
      lblNewLAbel_2.setForeground(Color.BLUE);
      lblNewLAbel_2.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            UDM_MainProcess main = new UDM_MainProcess();
            dispose();
            setVisible(false);
            main.showGSignup();
         }
      });
      lblNewLAbel_2.setBounds(283, 719, 183, 33);
      contentPane.add(lblNewLAbel_2);

      textField = new JTextField();
      textField.setColumns(10);
      textField.setBounds(140, 598, 205, 33);
      contentPane.add(textField);

      lblId = new JLabel("ID");
      lblId.setForeground(new Color(0, 0, 0));
      lblId.setFont(new Font("굴림", Font.BOLD, 32));
      lblId.setBounds(65, 590, 56, 41);
      contentPane.add(lblId);
      
      
   }

   public void setMain(UDM_MainProcess main) {
      // TODO Auto-generated method stub
      this.main=main;
   }
}