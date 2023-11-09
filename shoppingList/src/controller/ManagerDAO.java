package controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.CategoryVo;

public class ManagerDAO {
	// 관리자 로그인
	public boolean managerLogin(String id, String pw) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean the = false;
		try {
			con = DBUtil.getConnection();
			String sql = "select * from ismanager WHERE m_id = ? and m_pw = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				the = true;
			}

		} catch (SQLException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			con.close();
			pstmt.close();
		}
		return the;
	}

	// 입고
	public void addMCInsert(CategoryVo ctgrVo) throws Exception {
		Connection con = null;
		CallableStatement callP = null;

		try {
			con = DBUtil.getConnection();
			String sql = "call categorying_IN(?,?,?,?,?)";
			callP = con.prepareCall(sql);
			callP.setString(1, ctgrVo.getC_cord());
			callP.setString(2, ctgrVo.getC_item());
			callP.setString(3, ctgrVo.getC_price());
			callP.setString(4, ctgrVo.getC_size());
			callP.setString(5, ctgrVo.getC_color());

			callP.execute();

			System.out.println("카탈로그 업데이트 완료...");

		} catch (SQLException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (callP != null) {
					callP.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e2) {
			}
		}

	}

	// 카테고리 수정
	public void upMCtgry(CategoryVo ctgrVo) {
		Connection con = null;
		CallableStatement callP = null;

		try {
			con = DBUtil.getConnection();
			String sql = "CALL categorying_Updat(?,?, ?, ?, ?, ?)";
			callP = con.prepareCall(sql);
			callP.setInt(1, ctgrVo.getNo());
			callP.setString(2, ctgrVo.getC_cord());
			callP.setString(3, ctgrVo.getC_item());
			callP.setString(4, ctgrVo.getC_price());
			callP.setString(5, ctgrVo.getC_size());
			callP.setString(6, ctgrVo.getC_color());

			callP.execute();
			System.out.println("카테고리 수정 완료.");

		} catch (SQLException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				// 데이터베이스와의 연결에 사용되었던 오브젝트를 해제
				if (callP != null)
					callP.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}

	}

	// 카테고리 삭제

	public void deleteList(int no) throws Exception {
		Connection con = null;
		CallableStatement callp = null;

		try {
			con = DBUtil.getConnection();
			String sql = "call categorying_Delete(?)";
			callp = con.prepareCall(sql);
			callp.setInt(1, no);

			callp.execute();

			System.out.println("카테고리 품목 삭제 완료.");

		} catch (SQLException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (callp != null)
					callp.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
			}

		}

	}

}
