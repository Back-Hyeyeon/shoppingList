package controller;

import java.util.Scanner;

import model.LoginVo;

public class LoginRegisterManager {

	public void membershipJoin() {
		Scanner input = new Scanner(System.in);
		Scanner input1 = new Scanner(System.in);
		
		LoginDAO lgdao = new LoginDAO();
		LoginVo lgvo = new LoginVo();
		
		
	}

	public void loginCheck() throws Exception {
		Scanner input = new Scanner(System.in);
		LoginDAO logvo = new LoginDAO();
		String id; 
		String pw;
		boolean success = false;

		System.out.println("학생 정보 수정");
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
