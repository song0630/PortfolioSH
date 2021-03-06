package com.wj.employees.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wj.client.model.VO.ClientVO;
import com.wj.utils.ConnUtil;

public class ClientDAO {
	private static ClientDAO instance = null;
	private ClientDAO() {}

	public static ClientDAO getInstance() {
		if(instance==null) {
			synchronized (ClientDAO.class) {
				instance = new ClientDAO();
			}
		}
		return instance;
	}


	//-------------------------------------- Client table Query--------------------------------------//


	// λ‘κ·Έ?Έκ²°κ³Ό λ°ν λ©μ?
	public int getLoginResult(String id, String pw) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			conn = ConnUtil.getConnection();
			pstmt = conn.prepareStatement(
					"SELECT pw FROM client WHERE id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString("pw").equals(pw)) {
					result = 1;	// λ‘κ·Έ?Έ ?±κ³?
				} else {
					result = -2;  // λΉλ?λ²νΈ ??λ¦?
				}
			} else {
				result = -1; // ??΄?κ°? ?? κ²½μ°
			}
		} catch (SQLException e) {
			e.printStackTrace();
			result = -3; // ?°?΄?°λ² μ΄?€ ?€λ₯?
		} finally {
			if(rs!=null) try {rs.close();} catch(SQLException sqle1) {}
			if(pstmt!=null) try {pstmt.close();} catch(SQLException sqle1) {}
			if(conn!=null) try {conn.close();} catch(SQLException sqle1) {}
		}
		return result;
	}

	// ??΄? μ€λ³΅ μ²΄ν¬
	public int idDoubleCheck(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			conn = ConnUtil.getConnection();
			pstmt = conn.prepareStatement(
					"SELECT pw FROM client WHERE id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = -1; // ??΄? μ€λ³΅
			} else {
				result = 1; // ?¬?©κ°??₯? ??΄?(μ€λ³΅X)
			}
		} catch (SQLException e) {
			e.printStackTrace();
			result = -3; // ?°?΄?°λ² μ΄?€ ?€λ₯?
		} finally {
			if(rs!=null) try {rs.close();} catch(SQLException sqle1) {}
			if(pstmt!=null) try {pstmt.close();} catch(SQLException sqle1) {}
			if(conn!=null) try {conn.close();} catch(SQLException sqle1) {}
		}
		return result;
	}

	// ??κ°?? λ©μ?
	public int joinToClient(ClientVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			conn = ConnUtil.getConnection();
			pstmt = conn.prepareStatement(
					"INSERT INTO client VALUES(?,?,?,?,?,?,?,?)");
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getTel());
			pstmt.setString(5, vo.getEmail());
			pstmt.setString(6, vo.getZipcode());
			pstmt.setString(7, vo.getAddress1());
			pstmt.setString(8, vo.getAddress2());

			if(pstmt.executeUpdate() > 0) {
				result = 1;	// ??κ°?? ?±κ³?
			} else {
				result = -1; // ??κ°?? ?€?¨
			}
		} catch (SQLException e) {
			e.printStackTrace();
			result = -3; // ?°?΄?°λ² μ΄?€ ?€λ₯?
		} finally {
			if(rs!=null) try {rs.close();} catch(SQLException sqle1) {}
			if(pstmt!=null) try {pstmt.close();} catch(SQLException sqle1) {}
			if(conn!=null) try {conn.close();} catch(SQLException sqle1) {}
		}
		return result;
	}

	// λ§μ΄??΄μ§?μ°? ??? λ³? λ°ν λ©μ?
	public ClientVO getClient(String id) {
		ClientVO client = new ClientVO();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = ConnUtil.getConnection();
			pstmt = conn.prepareStatement(
					"SELECT * FROM client WHERE id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				client.setId(id);
				client.setPw(rs.getString("pw"));
				client.setName(rs.getString("name"));
				client.setTel(rs.getString("tel"));
				client.setEmail(rs.getString("email"));
				client.setZipcode(rs.getString("zipcode"));
				client.setAddress1(rs.getString("address1"));
				client.setAddress2(rs.getString("address2"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) try {rs.close();} catch(SQLException sqle1) {}
			if(pstmt!=null) try {pstmt.close();} catch(SQLException sqle1) {}
			if(conn!=null) try {conn.close();} catch(SQLException sqle1) {}
		}
		return client;
	}

	// client ? λ³? λ³?κ²?
	public int updateClientInfo(ClientVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			conn = ConnUtil.getConnection();

			// λΉλ?λ²νΈ μ²΄ν¬
			pstmt = conn.prepareStatement(
					"SELECT pw FROM client WHERE id=?");
			pstmt.setString(1, vo.getId());
			rs = pstmt.executeQuery();
			if(!rs.next()) {
				return -10;	// ??΄? ?€λ₯?
			} else {
				if(!rs.getString("pw").equals(vo.getPw())) {
					return -11;	// λΉλ?λ²νΈ ?€λ₯?
				}
			}

			pstmt = conn.prepareStatement(
					"UPDATE client set name=?, tel=?, email=?, zipcode=?, address1=?, address2=? WHERE id=?");
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getTel());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getZipcode());
			pstmt.setString(5, vo.getAddress1());
			pstmt.setString(6, vo.getAddress2());
			pstmt.setString(7, vo.getId());

			if(pstmt.executeUpdate() > 0) {
				result = 1;	// ? λ³΄μ?  ?±κ³?
			} else {
				result = -1; // ? λ³΄μ?  ?€?¨
			}
		} catch (SQLException e) {
			e.printStackTrace();
			result = -3; // ?°?΄?°λ² μ΄?€ ?€λ₯?
		} finally {
			if(rs!=null) try {rs.close();} catch(SQLException sqle1) {}
			if(pstmt!=null) try {pstmt.close();} catch(SQLException sqle1) {}
			if(conn!=null) try {conn.close();} catch(SQLException sqle1) {}
		}
		return result;
	}

	// client λΉλ?λ²νΈ λ³?κ²?
	public int updateClientPassword(String id, String pw, String newPw) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			conn = ConnUtil.getConnection();

			// λΉλ?λ²νΈ μ²΄ν¬
			pstmt = conn.prepareStatement(
					"SELECT pw FROM client WHERE id=?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(!rs.next()) {
				return -10;	// ??΄? ?€λ₯?
			} else {
				if(!rs.getString("pw").equals(pw)) {
					return -11;	// λΉλ?λ²νΈ ?€λ₯?
				}
			}

			pstmt = conn.prepareStatement(
					"UPDATE client set pw=? WHERE id=?");
			pstmt.setString(1, newPw);
			pstmt.setString(2, id);

			if(pstmt.executeUpdate() > 0) {
				result = 1;	// ? λ³΄μ?  ?±κ³?
			} else {
				result = -1; // ? λ³΄μ?  ?€?¨
			}
		} catch (SQLException e) {
			e.printStackTrace();
			result = -3; // ?°?΄?°λ² μ΄?€ ?€λ₯?
		} finally {
			if(rs!=null) try {rs.close();} catch(SQLException sqle1) {}
			if(pstmt!=null) try {pstmt.close();} catch(SQLException sqle1) {}
			if(conn!=null) try {conn.close();} catch(SQLException sqle1) {}
		}
		return result;
	}
	
	// ??΄? μ°ΎκΈ° μΏΌλ¦¬ λ©μ?
	public String searchId(String name, String email) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String result = null;
		try {
			conn = ConnUtil.getConnection();
			pstmt = conn.prepareStatement(
					"SELECT id FROM CLIENT WHERE name = ? AND email = ?");
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getString(1);
			} else {
				result = "-1";	// ?? ₯? λ³? λΆμΌμΉ?
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	// λΉλ?λ²νΈ μ°ΎκΈ° μΏΌλ¦¬ λ©μ?
	public int searchPassword(String id, String email) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			conn = ConnUtil.getConnection();
			pstmt = conn.prepareStatement(
					"SELECT pw FROM CLIENT WHERE id = ? AND email = ?");
			pstmt.setString(1, id);
			pstmt.setString(2, email);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = 1;	// λΉλ?λ²νΈ μ°ΎκΈ° ?±κ³?
			} else {
				result = -1;	// ?? ₯? λ³? λΆμΌμΉ?
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	// λΉλ?λ²νΈ μ°ΎκΈ° ?? λΉλ?λ²νΈ ???₯
	public void updateToTemporaryPassword(String id, String tmpPw) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = ConnUtil.getConnection();

			pstmt = conn.prepareStatement(
					"UPDATE client set pw=? WHERE id=?");
			pstmt.setString(1, tmpPw);
			pstmt.setString(2, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) try {rs.close();} catch(SQLException sqle1) {}
			if(pstmt!=null) try {pstmt.close();} catch(SQLException sqle1) {}
			if(conn!=null) try {conn.close();} catch(SQLException sqle1) {}
		}
	}
}
