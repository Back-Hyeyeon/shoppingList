package view;

import java.util.Scanner;

public class MenuViewer {

	public static Scanner num = new Scanner(System.in);
	
	public static void mainMenuView() {
		System.out.println();
		System.out.println("여성 쇼핑몰 에비앙>>");
		System.out.println("원하는 목록을 선택해주세요");
		System.out.println("1. 회원가입 회원가입/로그인/내정보/내정보수정/");
		System.out.println("2. 카테고리 목록/장바구니추가");
		System.out.println("3. 장바구니 목록/삭제/");
		System.out.println("4. 관리자로그인 추가/수정/삭제/");
		System.out.println("5. 쇼핑몰 나가기");

	}
//회원가입 로그인페이지
	public static void loginMenu() {
		System.out.println();
		System.out.println("회원가입 페이지입니다.");
		System.out.println("1. 회원가입");
		System.out.println("2. 로그인");
		System.out.println("3. 내정보");
		System.out.println("4. 내정보 수정");
	}
//카테고리 페이지
	public static void categoryMenu() {
		System.out.println();
		System.out.println("카테고리 입니다.");
		System.out.println("1. 카테고리 목록");
		System.out.println("2. 장바구니 추가");
	}
//장바구니 페이지
	public static void cartMenu() {
		System.out.println();
		System.out.println("장바구니 입니다.");
		System.out.println("1. 장바구니 목록");
		System.out.println("2. 장바구니 삭제");
	}
//관리자 페이지
	public static void managerMenu() {
		System.out.println();
		System.out.println("관리자 로그인입니다.");
		System.out.println("1. 카테고리 추가");
		System.out.println("2. 카테고리 수정");
		System.out.println("3. 카테고리 삭제");
	}

}
