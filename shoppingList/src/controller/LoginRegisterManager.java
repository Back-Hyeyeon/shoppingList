package controller;

import java.util.Scanner;

import model.LoginVo;

public class LoginRegisterManager {

	public void membershipJoin() {
		Scanner input = new Scanner(System.in);
		Scanner input1 = new Scanner(System.in);
		
		LoginDAO lgdao = new LoginDAO();
		LoginVo lgvo = new LoginVo();
		
		//고객 회원가입 입력
		System.out.println("사용 할 아이디를 입력하세요");
		String id = input.nextLine();
		System.out.println("사용 할 비밀번호를 입력하세요");
		String pw = input.nextLine();
		System.out.println("이메일를 입력하세요");
		String email = input.nextLine();
		System.out.println("주소를 입력하세요");
		String address = input.nextLine();
		//입력받은 정보 LoginVo 설정
		lgvo.setL_id(id);
		lgvo.setL_pw(pw);
        lgvo.setL_email(email);
        lgvo.setL_address(address);
		//setLoginRegiste메서드 호출 회원가입 처리
        lgdao.setLoginRegiste(lgvo);
	}

	public void loginCheck() throws Exception {
		Scanner input = new Scanner(System.in);
		LoginDAO logvo = new LoginDAO();
		String id; 
		String pw;
		boolean success = false;

		System.out.println("로그인 페이지");
		do {
			System.out.print("아이디 : ");
			id = input.nextLine();
			System.out.print("비밀번호 : ");
			pw = input.nextLine();
			success = logvo.getLogin(id, pw);
			if (!success) {
				System.out.println("아이디 또는 비밀번호가 틀림 다시 입력");
			}
		} while (!success);
		
	}

	public void loginMypage() {
		// TODO Auto-generated method stub
		
	}

	public void loginUpdate() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
