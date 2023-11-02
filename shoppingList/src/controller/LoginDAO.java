package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.LoginVo;

public class LoginDAO {
//	 회원가입
	public void setLoginRegiste(LoginVo lgvo) {
		String sql = "INSERT into login VALUES (login_seq.nextval,?, ?, ?, ?)";

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, lgvo.getL_id());
			pstmt.setString(2, lgvo.getL_pw());
			pstmt.setString(3, lgvo.getL_email());
			pstmt.setString(4, lgvo.getL_address());

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
				
					pstmt.close();
			}
			return logins;
		}

//	 내정보
	public List<LoginVo> getLoginTotalList(String id) {
		String sql = "SELECT * FROM login WHERE l_id = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<LoginVo> loginList = new ArrayList<>();
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				LoginVo lgvo = new LoginVo();
				lgvo.setNo(rs.getInt("no"));
				lgvo.setL_id(rs.getString("l_id"));
				lgvo.setL_pw(rs.getString("l_pw"));
				lgvo.setL_email(rs.getString("l_email"));
				lgvo.setL_address(rs.getString("l_address"));
				loginList.add(lgvo);
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
				se.printStackTrace();
			}
		}
		return loginList;

	}

//	 내정보 수정
	public boolean setloginUpdata(LoginVo lgvo) throws Exception {
		// sql 업데이크 쿼리 생성
		String sql = "update login set l_pw = ?, l_email = ?, l_address = ? WHERE l_id = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean Information = false;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, lgvo.getL_pw());
			pstmt.setString(2, lgvo.getL_email());
			pstmt.setString(3, lgvo.getL_address());
			pstmt.setString(4, lgvo.getL_id());

			int i = pstmt.executeUpdate();

			if (i == 1) {
				System.out.println(lgvo.getL_id() + " : 정보 수정");
				System.out.println("정보가 수정 완료되었습니다");
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류: " + e.getMessage());
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return Information;
	}// setloginUpdata

	public void setLessonDelete(String id) {
		String sql = "delete from login where l_id = ?";
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			int i = pstmt.executeUpdate();
			if (i == 1) {
				System.out.println("id 삭제 완료.");
				System.out.println("id 삭제 성공!!!");
			} else {
				System.out.println("id 삭제 실패!!!");
			}
		} catch (SQLException e) {
			System.out.println("e=[" + e + "]");
		} catch (Exception e) {
			System.out.println("e=[" + e + "]");
		} finally {
			try {
				// 데이터베이스와의 연결에 사용되었던 오브젝트를 해제
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}

	}// setLessonDelete

}
