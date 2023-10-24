package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.LoginVo;

public class LoginDAO {
//	 회원가입
	public void setLoginRegiste(LoginVo lgvo) {
		String sql = "INSERT into login VALUES(login_seq.nextval,?,?,?,?)";

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, lgvo.getL_id());
			pstmt.setString(1, lgvo.getL_pw());
			pstmt.setString(1, lgvo.getL_email());
			pstmt.setString(1, lgvo.getL_address());

			int i = pstmt.executeUpdate();

			if (i == 1) {
				System.out.println(lgvo.getL_id() + "회원가입 완료...");
				System.out.println("회원가입 정상처리 되었습니다...");
			} else {
				System.out.println("회원가입 실패했습니다...");
			}
		} catch (SQLException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e2) {
				// TODO: handle exception
			}
		}
	}

//	 로그인
	public boolean getLogin(String id, String pw) throws Exception {
		String sql = "select * from login WHERE l_id = ? and l_pw = ?";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		boolean logins = false;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				logins = true;
			}

		} catch (SQLException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e2) {
			}
			return logins;
		}
	}

//	 내정보
	public void getLoginTotalList() {
		String sql = "select * from login order by no";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		LoginVo lgvo = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			System.out.println("일련번호\t 아이디\t 비밀번호\t 이메일\t\t 주소");
			while (rs.next()) {
				lgvo = new LoginVo();
				lgvo.setNo(rs.getInt("no"));
				lgvo.setL_id(rs.getString("l_id"));
				lgvo.setL_pw(rs.getString("l_pw"));
				lgvo.setL_email(rs.getString("l_email"));
				lgvo.setL_address(rs.getString("l_address"));

				System.out.println(lgvo.toString());
			}

		} catch (SQLException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {
			}
		}

	}

//	 내정보 수정
	private void setloginUpdata(LoginVo lgvo) throws Exception {
		String sql = "update login set l_id=?, l_pw=?, l_email=?, l_address=? where no=?";
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, lgvo.getL_id());
			pstmt.setString(2, lgvo.getL_pw());
			pstmt.setString(3, lgvo.getL_email());
			pstmt.setString(4, lgvo.getL_address());
			pstmt.setInt(5, lgvo.getNo());
			int i = pstmt.executeUpdate();
			if (i == 1) {
				System.out.println("정보가 수정 완료되었습니다");
			} else {
				System.out.println("정보 수정 실패입니다. 다시 수정하시기 바랍니다...");
			}
		} catch (SQLException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
	}//setloginUpdata

}
