package controller;

import java.util.Scanner;

import model.CartVo;

public class CartRegisterManager {
	public static Scanner input = new Scanner(System.in);

	public void addCart() throws Exception {
		CategoryDAO ctDAO = new CategoryDAO();
		CartDAO cdao = new CartDAO();
		CartVo cvo = new CartVo();

		System.out.println("카테고리 전체 리스트:");
		ctDAO.getCategoryList();

		System.out.println("일련번호를 입력하세요");
		String c_cord = input.nextLine();

		System.out.println("아이디를 입력하세요");
		String id = input.nextLine();

		cvo.setC_cord(c_cord);
		cvo.setL_id(id);

		cdao.addCart(cvo);

	}

	public void cartChokList() throws Exception {

		CartDAO cdao = new CartDAO();
		CartVo cvo = new CartVo();

		System.out.println("나의 장바구니 목록");

		System.out.println("아이디를 입력하세요");
		String id = input.nextLine();
		cdao.CartList(id);

	}

	public void cartChokListDelete() {
		
		CartDAO cdao = new CartDAO();
		CartVo cvo = new CartVo();
		
		System.out.println("삭제할 일련번호를 입력하세요");
		int no = input.nextInt();
		input.nextLine();
		cdao.setCartDelete(no);
		

	}

}
