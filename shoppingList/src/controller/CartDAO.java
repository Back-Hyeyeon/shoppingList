package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.CartVo;
import model.CategoryVo;

public class CartDAO {
	//내장바구니에 추가하기
	public void addCart(CartVo cvo) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.getConnection();
			String sql = "INSERT into cart VALUES (cart_seq.nextval,?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cvo.getC_cord());
			pstmt.setString(2, cvo.getL_id());

			int i = pstmt.executeUpdate();

			if (i == 1) {
				System.out.println("카트정상 추가 되었습니다...");
			} else {
				System.out.println("추가 실패했습니다...");
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

//내 장바구니에 넣어진 목록
	public void CartList(String id) throws Exception {
		String sql = "select * from categorying ct, cart c where ct.c_cord = c.c_cord and l_id = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CartVo cvo = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			cvo = new CartVo();
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.printf("%-7s %-10s %-10s %-10s %-10s %-10s \n","일련번호","바코드","품목" ,"가격","사이즈","컬러");
				System.out.println();
				System.out.printf("%-7d %-10s %-10s %-10s %-10s %-10s \n", rs.getInt("cno"), rs.getString("c_cord"),
						rs.getString("c_item"), rs.getString("c_price"), rs.getString("c_size"),
						rs.getString("c_color"));

			}
		} catch (SQLException se) {
			System.out.println(se);
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
	}// getCategoryList

	// 내장바구니에서 삭제
	public void setCartDelete(int no) {
		String sql = "delete from cart where cno = ?";
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, no);
			int i = pstmt.executeUpdate();
			if (i == 1) {
				System.out.println("삭제 완료.");
			} else {
				System.out.println("삭제 실패!!!");
			}
		} catch (SQLException e) {
			System.out.println("e=[" + e + "]");
		} catch (Exception e) {
			System.out.println("e=[" + e + "]");
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}

	}//

}
