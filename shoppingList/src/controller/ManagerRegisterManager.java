package controller;

import java.util.Scanner;

import model.ManagerVo;

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
			boolean mLogin = mdao.managerLogin(id , pw);
			if(mLogin) {
				System.out.println("로그인 성공");
				return true;
			}else {
				System.out.println("로그인 실패. 다시 입력해주세요!");
				return false;
			}
		}
		//관리자로 카테고리 목록 추가
		public void addMCtgry() {
			
			
			
			
			
		}
		
		//관리자로 카테고리 정보 수정
		public void updateMCtgry() {
			
		}
		
		//관리자로 카테고리 목록 삭제. 
		public void deleteMCtgry() {
			
		}
}
