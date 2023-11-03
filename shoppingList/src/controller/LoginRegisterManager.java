package controller;

import java.util.List;
import java.util.Scanner;

import model.LoginVo;

public class LoginRegisterManager {
//회원가입 membershipJoin
	public void membershipJoin() {
		Scanner input = new Scanner(System.in);

		LoginDAO lgdao = new LoginDAO();
		LoginVo lgvo = new LoginVo();

		// 고객 회원가입 입력
		System.out.println("사용 할 아이디를 입력하세요");
		String id = input.nextLine();
		System.out.println("사용 할 비밀번호를 입력하세요");
		String pw = input.nextLine();
		System.out.println("이메일를 입력하세요");
		String email = input.nextLine();
		System.out.println("주소를 입력하세요");
		String address = input.nextLine();
		// 입력받은 정보 LoginVo 설정
		lgvo.setL_id(id);
		lgvo.setL_pw(pw);
		lgvo.setL_email(email);
		lgvo.setL_address(address);
		// setLoginRegiste메서드 호출 회원가입 처리
		lgdao.setLoginRegiste(lgvo);
	}
//로그인 후 내정보 확인 가능
	public String loginCheck() throws Exception {
		Scanner input = new Scanner(System.in);
		
		
		System.out.println("로그인 및 내정보 페이지");

		System.out.print("아이디: ");
		String id = input.nextLine();
		System.out.print("비밀번호: ");
		String pw = input.nextLine();

		LoginDAO loginDao = new LoginDAO();
		boolean Login = loginDao.getLogin(id, pw);

		if (Login) {
			System.out.println("로그인 성공!");
			return id;
		} else {
			System.out.println("아이디 또는 비밀번호가 틀림. 다시 입력");
			return null;
		}
	}
//내정보
	public void loginMypage(String id) {
		Scanner input = new Scanner(System.in);
		
		LoginDAO lgdao = new LoginDAO();
		List<LoginVo> loginList = lgdao.getLoginTotalList(id);

		if (loginList.isEmpty()) {
			System.out.println("해당 아이디의 정보가 없습니다.");
		} else {
			System.out.println("일련번호\t 아이디\t 비밀번호\t 이메일\t\t 주소");
			for (LoginVo lgvo : loginList) {
				System.out.println(lgvo.getNo() + "\t" + lgvo.getL_id() + "\t" + lgvo.getL_pw() + "\t"
						+ lgvo.getL_email() + "\t" + lgvo.getL_address());
			}
		}

	}
//내정보 수정
	public void loginUpdate(String id) throws Exception {
		Scanner input = new Scanner(System.in);

		LoginDAO lgdao = new LoginDAO();
		LoginVo lgvo = new LoginVo();

		
		String pw;
		String email;
		String address;

		
		System.out.println("======================================");
		System.out.println("전체 정보 (수정 전)");
		System.out.println("일련번호\t 아이디\t 비밀번호\t 이메일\t\t 주소");
		List<LoginVo> previousInfo = lgdao.getLoginTotalList(id);
		for (LoginVo lg : previousInfo) {
			System.out.println(lg.getNo() + "\t" + lg.getL_id() + "\t" + lg.getL_pw() + "\t" + lg.getL_email() + "\t"
					+ lg.getL_address());
		}
		System.out.println();
		System.out.println("======================================");

		System.out.println("수정할 비밀번호 입력");
		System.out.print("비밀번호 : ");
		pw = input.nextLine();
		System.out.println();

		System.out.println("수정할 이메일 입력");
		System.out.print("이메일 : ");
		email = input.nextLine();
		System.out.println();

		System.out.println("수정할 주소 입력");
		System.out.print("주소 : ");
		address = input.nextLine();
		System.out.println();

		lgvo.setL_id(id);
		lgvo.setL_pw(pw);
		lgvo.setL_email(email);
		lgvo.setL_address(address);
		lgdao.setloginUpdata(lgvo);
		System.out.println();
		
		System.out.println("======================================");
		System.out.println("전체 정보 (수정 후)");
		System.out.println("일련번호\t 아이디\t 비밀번호\t 이메일\t\t 주소");
		List<LoginVo> updatedInfo = lgdao.getLoginTotalList(id);
		for (LoginVo lg : updatedInfo) {
			System.out.println(lg.getNo() + "\t" + lg.getL_id() + "\t" + lg.getL_pw() + "\t" + lg.getL_email() + "\t"
					+ lg.getL_address());
		}
		System.out.println();
		System.out.println("======================================");
	}
	
	//아이디 삭
	public void logout() {
		Scanner input = new Scanner(System.in);
		
		LoginDAO lgdao = new LoginDAO();
		LoginVo lgvo = new LoginVo();
		
		String id;
		
		System.out.println("삭제할 id 입력");
		System.out.print("id : ");
		id = input.nextLine();
		
		lgdao.setLessonDelete(id);
		System.out.println("======================================");
		System.out.println("일련번호\t 아이디\t 비밀번호\t 이메일\t\t 주소");
		List<LoginVo> updatedInfo = lgdao.getLoginTotalList(id);
		for (LoginVo lg : updatedInfo) {
			System.out.println(lg.getNo() + "\t" + lg.getL_id() + "\t" + lg.getL_pw() + "\t" + lg.getL_email() + "\t"
					+ lg.getL_address());
		}
		
		
	}

}
