package controller;

import java.util.Scanner;

import model.CategoryVo;

public class ManagerRegisterManager {
	// 관리자 로그인
	public boolean managerLogin() throws Exception {
		Scanner input = new Scanner(System.in);

		System.out.println("관리자 로그인");
		System.out.println("===========================");
		System.out.println("아이디 : ");
		String id = input.nextLine();
		System.out.println("비밀번호 : ");
		String pw = input.nextLine();

		ManagerDAO mdao = new ManagerDAO();
		boolean mLogin = mdao.managerLogin(id, pw);
		if (mLogin) {
			System.out.println("로그인 성공");
			return true;
		} else {
			System.out.println("로그인 실패. 다시 입력해주세요!");
			return false;
		}
	}

	// 관리자로 카테고리 목록 추가
	public void addMCtgry() throws Exception {
		Scanner input = new Scanner(System.in);

		ManagerDAO mdao = new ManagerDAO();
		CategoryVo ctgrVo = new CategoryVo();
		CategoryDAO ctgrdao = new CategoryDAO();

		System.out.println("바코드 6자리를 입력해주세요...");
		String C_cord = input.nextLine();

		System.out.println("상품을 입력해주세요...");
		String c_item = input.nextLine();

		System.out.println("가격을 입력해주세요...");
		String c_price = input.nextLine();

		System.out.println("사이즈를 입력해주세요...");
		String c_size = input.nextLine();

		System.out.println("컬러를 입력해주세요...");
		String c_color = input.nextLine();

		ctgrVo.setC_cord(C_cord);
		ctgrVo.setC_item(c_item);
		ctgrVo.setC_price(c_price);
		ctgrVo.setC_size(c_size);
		ctgrVo.setC_color(c_color);
		mdao.addMCInsert(ctgrVo);

		System.out.println();
		System.out.println("======================================");
		System.out.println("카테고리 전체 리스트");
		ctgrdao.getCategoryList();
		System.out.println();
		System.out.println("======================================");
	}

	// 관리자로 카테고리 정보 수정
	public void updateMCtgry() throws Exception {
		Scanner input = new Scanner(System.in);

		ManagerDAO mdao = new ManagerDAO();
		CategoryVo ctgrVo = new CategoryVo();
		CategoryDAO ctgrdao = new CategoryDAO();

		System.out.println("======================================");
		System.out.println("카테고리 전체 리스트");
		ctgrdao.getCategoryList();
		System.out.println();
		System.out.println("======================================");

		System.out.println("수정 일련번호를 입력하세요");
		int no = input.nextInt();
		input.nextLine();

		System.out.println("수정 바코드 6자리를 입력하세요");
		String C_cord = input.nextLine();

		System.out.println("수정 품목를 입력하세요");
		String C_item = input.nextLine();
		
		System.out.println("수정 가격을 입력하세요");
		String C_price = input.nextLine();
		System.out.println("수정 사이즈를 입력하세요");
		String C_size = input.nextLine();
		System.out.println("수정 컬러를 입력하세요");
		String C_color = input.nextLine();

		ctgrVo.setNo(no);
		ctgrVo.setC_cord(C_cord);
		ctgrVo.setC_item(C_item);
		ctgrVo.setC_price(C_price);
		ctgrVo.setC_size(C_size);
		ctgrVo.setC_color(C_color);
	
		mdao.upMCtgry(ctgrVo);

		System.out.println("======================================");
		System.out.println("카테고리 전체 리스트");
		ctgrdao.getCategoryList();
		System.out.println();
		System.out.println("======================================");

	}

	// 관리자로 카테고리 목록 삭제.
	public void deleteMCtgry() throws Exception {
		Scanner input = new Scanner(System.in);
		
		ManagerDAO mdao = new ManagerDAO();
		CategoryVo ctgrVo = new CategoryVo();
		CategoryDAO ctgrdao = new CategoryDAO();
		
		System.out.println("======================================");
		System.out.println("카테고리 전체 리스트");
		ctgrdao.getCategoryList();
		System.out.println();
		System.out.println("======================================");
		
		
		System.out.println("삭제할 카테고리 일련번호 입력");
		System.out.print("일련번호 : ");
		int no = input.nextInt();
		input.nextLine();
		
		mdao.deleteList(no);
		
		System.out.println("======================================");
		System.out.println("카테고리 전체 리스트");
		ctgrdao.getCategoryList();
		System.out.println();
		System.out.println("======================================");
		
		
		
		
		
		
		
		
		

	}
}
