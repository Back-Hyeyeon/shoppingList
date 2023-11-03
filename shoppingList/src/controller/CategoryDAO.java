package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.CategoryVo;
import model.LoginVo;

public class CategoryDAO {
	//카테고리 전체 목록
	public void getCategoryList() throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CategoryVo atgrvo = null;
		
		try {
			con = DBUtil.getConnection();
			String sql = "select * from categorying order by no";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			System.out.println("일련번호\t바코드번호\t아이템\t가격\t사이즈\t색상");
			while (rs.next()) {
				atgrvo = new CategoryVo();
				atgrvo.setNo(rs.getInt("no"));
				atgrvo.setC_cord(rs.getString("c_cord"));
				atgrvo.setC_item(rs.getString("c_item"));
				atgrvo.setC_price(rs.getString("c_price"));
				atgrvo.setC_size(rs.getString("c_size"));
				atgrvo.setC_color(rs.getString("c_color"));
				
				System.out.println(atgrvo.getNo() + "\t" + atgrvo.getC_cord()+"\t"+atgrvo.getC_item()+"\t"+atgrvo.getC_price()+"\t"+atgrvo.getC_size()+"\t"+atgrvo.getC_color());

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
	}//getCategoryList
		
	
	
	
}
