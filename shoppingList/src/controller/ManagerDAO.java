package controller;

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
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.getConnection();
			String sql = "INSERT into categorying VALUES(categorying_seq.nextval, ?, ?, ?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ctgrVo.getC_cord());
			pstmt.setString(2, ctgrVo.getC_item());
			pstmt.setString(3, ctgrVo.getC_price());
			pstmt.setString(4, ctgrVo.getC_size());
			pstmt.setString(5, ctgrVo.getC_color());

			int i = pstmt.executeUpdate();

			if (i == 1) {
				System.out.println("카탈로그 업데이트 완료...");
				System.out.println("카테고리 정상 처리 되었습니다...");
			} else {
				System.out.println("업데이트가 실패했습니다...");
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
			}
		}

	}

	// 카테고리 수정
	public void upMCtgry(CategoryVo ctgrVo) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.getConnection();
			String sql = "update categorying set c_cord = ?, c_item = ?, c_price = ? ,c_size = ?, c_color = ? where no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ctgrVo.getC_cord());
			pstmt.setString(2, ctgrVo.getC_item());
			pstmt.setString(3, ctgrVo.getC_price());
			pstmt.setString(4, ctgrVo.getC_size());
			pstmt.setString(5, ctgrVo.getC_color());
			pstmt.setInt(6, ctgrVo.getNo());

			int i = pstmt.executeUpdate();

			if (i == 1) {
				System.out.println("카테고리 수정 완료.");
			} else {
				System.out.println("학과 수정 실패!!!");
			}
		} catch (SQLException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
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

	}

	// 카테고리 삭제

	public void deleteList(int no) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.getConnection();
			String sql = "delete from categorying where no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);

			int i = pstmt.executeUpdate();
			if (i == 1) {
				System.out.println("카테고리 품목 삭제 완료.");
			} else {
				System.out.println("카테고리 삭제 실패!!!");
			}

		} catch (SQLException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
			}

		}

	}

}
