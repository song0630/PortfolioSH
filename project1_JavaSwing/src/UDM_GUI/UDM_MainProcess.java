package UDM_GUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;



import javax.swing.Icon;

class cartVO {
	   private String cName;
	   private String price;
	   private String volume;
	   
	   public cartVO() {
	      // TODO Auto-generated constructor stub
	   }

	   public cartVO(String cName, String price, String volume) {
	      super();
	      this.cName = cName;
	      this.price = price;
	      this.volume = volume;
	   }

	   public String getcName() {
	      return cName;
	   }

	   public void setcName(String cName) {
	      this.cName = cName;
	   }

	   public String getPrice() {
	      return price;
	   }

	   public void setPrice(String price) {
	      this.price = price;
	   }

	   public String getVolume() {
	      return volume;
	   }

	   public void setVolume(String volume) {
	      this.volume = volume;
	   }
	}


class MenuVO {
	
	private Icon image;
	private String menu;
	private String price;
	
	public MenuVO() {
		// TODO Auto-generated constructor stub
	}

	public MenuVO(Icon image, String menu, String price) {
		super();
		this.image = image;
		this.menu = menu;
		this.price = price;
	}

	public Icon getImage() {
		return image;
	}

	public void setImage(Icon image) {
		this.image = image;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	public String getMenu() {
		return menu;
	}
	
	public void setMenu(String menu) {
		this.menu = menu;
	}
	
	

}


class UdongDBConn {

	private Connection con;

	public Connection getConnection() {
		return con;
	}

	public UdongDBConn() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
	}
}

class UdongDAO {
	private Connection con;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public UdongDAO() throws ClassNotFoundException, SQLException {
		con = new UdongDBConn().getConnection();
	}
	
	public void name(String getid, String getpw) {
	}
	
	public boolean id_doubleCheck(String getid) throws SQLException {
		String sql = "Select id From udongman Order By id";

		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		int sw = 0;
		while (rs.next()) {
			String id = rs.getString("id");
			if (getid.equals(id)) {
				sw = 1;
			}
		}
		if (sw == 1) {
			return false;
		} else {
			return true;
		}
	}

	public boolean insert(String name, String id, String pw, String tel, String adr) {
		String sql = "insert into udongman values(?,?,?,?,?)";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, id);
			pstmt.setString(3, pw);
			pstmt.setString(4, tel);
			pstmt.setString(5, adr);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			return false;
		}
		return true;
	}

	public boolean member_Check(String getid, String getpw) throws SQLException {

		String sql = "Select id, pw From udongman Order By id";
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		int sw = 0;
		while (rs.next()) {
			String id = rs.getString("id");
			String pw = rs.getString("pw");
			if (getid.equals(id) && getpw.equals(pw)) {
				sw = 1;
			}
		}
		if (sw == 1) {
			return true;
		} else {
			return false;
		}
	}
	

	public String getName(String id) throws SQLException {
	      String name = null;
	      String sql = "select name from udongman where id=?";
	      pstmt = con.prepareStatement(sql);
	      pstmt.setString(1, id);
	      rs = pstmt.executeQuery();
	      while(rs.next()) {
	         name = rs.getString("name");
	      }
	      return name;
	   }
	
	public String getAdr(String id) throws SQLException {
	      String adr = null;
	      String sql = "select adr from udongman where id=?";
	      pstmt = con.prepareStatement(sql);
	      pstmt.setString(1, id);
	      rs = pstmt.executeQuery();
	      while(rs.next()) {
	         adr = rs.getString("adr");
	      }
	      return adr;
	   }

	public boolean insertCart(String name, String price, String volume) {
	      String sql = "insert into cart values(?,?,?)";
	      
	      try {
	      pstmt = con.prepareStatement(sql);
	      pstmt.setString(1, name);
	      pstmt.setString(2, price);
	      pstmt.setString(3, volume);
	      
	      pstmt.executeUpdate();
	      }catch(SQLException e){
	         return false;
	      }
	      return true;
	   }

	public String selectMenu(String menu) throws SQLException {
		String name = null;
		String sql = "select name from menu where name like '%'||?||'%'";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, menu);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			name = rs.getString("name");
		}
		return name;
	}
	
	public ArrayList<cartVO> selectCart() throws SQLException {
	      ArrayList<cartVO> list = new ArrayList<>();
	      String sql = "select * from cart";
	      pstmt = con.prepareStatement(sql);
	      rs = pstmt.executeQuery();
	      while(rs.next()) {
	         String cName = rs.getString("cName");
	         String price = rs.getString("price");
	         String volume = rs.getString("volume");
	         
	         cartVO vo = new cartVO(cName, price, volume);
	         list.add(vo);
	      }
	      return list;
	   }
	
	public boolean deleteCart()  {
		String sql = "delete from cart";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
		
	}
	
	
}

public class UDM_MainProcess {
	UDM_Loading udm_loading;
	UDM_Login udm_login;
	UDM_Main udm_main;
	UDM_Signup udm_signup;
	UDM_GuestSignup udm_gsignup;
	UDM_ArrivalTime udm_atime;
	UdongDAO uddao;
	UDM_Menu menu;
	UDM_Menu udm_menu;
	private UDM_Out udm_out;
	private UDM_Ordered udm_odered;
	static int min=35;

	public static void main(String[] args) throws InterruptedException, ClassNotFoundException, SQLException {
		UdongDBConn con = new UdongDBConn();
		UDM_MainProcess main = new UDM_MainProcess();
		main.udm_loading = new UDM_Loading();
		Thread.sleep(3000);
		main.udm_loading.dispose();
		main.udm_login = new UDM_Login();
		main.udm_login.setMain(main);
		
		Timer t_min=new Timer();
		TimerTask m_task=new TimerTask() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while (true) {
					min-=1;
				}
			}
		}; t_min.schedule(m_task, 1000);
	}

	public void showMain(String name, String adr) {
		// TODO Auto-generated method stub
		this.udm_main = new UDM_Main(name, adr);
	}

	public void showSignup() {
		this.udm_signup = new UDM_Signup();
	}

	public void showGSignup() {
		this.udm_gsignup = new UDM_GuestSignup();
	}
	
	public void showAtime(String name, String adr) {
		// TODO Auto-generated method stub
		this.udm_atime = new UDM_ArrivalTime(name, adr);
	}

	public void showLogin() {
		// TODO Auto-generated method stub
		try {
			this.udm_login=new UDM_Login();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void showMenu(String name, String adr) {
		this.udm_menu = new UDM_Menu(name, adr);
	}
	
	 public void showOut() {
	      // TODO Auto-generated method stub
	      this.udm_out = new UDM_Out();
	   }
	 
	  public void showOrdered(String name, String adr) {
		   this.udm_odered = new UDM_Ordered(name, adr);
	   }
}
