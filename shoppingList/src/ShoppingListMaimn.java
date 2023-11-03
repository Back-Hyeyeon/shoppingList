import controller.CartRegisterManager;
import controller.CategoryRegisterManager;
import controller.LoginRegisterManager;
import controller.ManagerRegisterManager;
import model.LoginVo;

import view.Category_Choice;
import view.Login_Choice;
import view.Manager_Choice;
import view.MenuViewer;
import view.Menu_Choice;

public class ShoppingListMaimn {


	public static void main(String[] args) {
		mainMenu();

	}

	private static void mainMenu() {
		int choiceNum = 0;
		boolean no = false;
		String id = null;
		while (!no) {
			try {
				MenuViewer.mainMenuView();
				choiceNum = MenuViewer.num.nextInt();
				MenuViewer.num.nextLine();

				switch (choiceNum) {
				case Menu_Choice.LOGIN:
					id = usereMenu();
					break;
				case Menu_Choice.CATEGORY:
					categoryMenu(id);
					break;
				case Menu_Choice.MANAGER:
					managerMenu();
					break;
				case Menu_Choice.EXIT:
					System.out.println("프로그램을 종료합니다.");
					no = true;
					break;
				default:
					System.out.println("해당리스트 번호만 사용가능합니다.");
				}

			} catch (Exception e) {
				System.out.println("입력오류 다시 시작...");
				no = true;
			}

		} // while
	}// mainMenu

//==============================

	// 회원가입 로그인페이지
	private static String usereMenu() throws Exception {
		int num = 0;
		int num1 =0;
		String id = null;
		LoginRegisterManager loginRegisterManager = new LoginRegisterManager();
		boolean or = false;
		while(!or) {
			MenuViewer.memberMenu();
			num1 = MenuViewer.num.nextInt();
			MenuViewer.num.nextLine();
			
			switch (num1) {
			case 1:
				loginRegisterManager.membershipJoin();
				break;
			case 2:
				id = loginMenu();
				
				break;
			case 0:
				or = true;
				break;
			default:
				System.out.println("해당번호만 입력하세요...");	
			}
		}
		return id;
	}// loginMenu
	
	private static String loginMenu() throws Exception {
		int num = 0;
		int num1 =0;
		LoginRegisterManager loginRegisterManager = new LoginRegisterManager();
		boolean or = false;
		
		String id = loginRegisterManager.loginCheck();
		if(id == null) {
			return null;
		}
		
		while (!or) {
			MenuViewer.loginMenu();
			num = MenuViewer.num.nextInt();
			MenuViewer.num.nextLine();
			switch (num) {
			case Login_Choice.LOGIN:
				loginRegisterManager.loginMypage(id);
				break;
			case Login_Choice.UPDATE:
				loginRegisterManager.loginUpdate(id);
				break;
			case Login_Choice.LOGOUT:
				loginRegisterManager.logout();
				or = true;
				break;
			case 0:
				or = true;
				break;
			default:
				System.out.println("해당번호만 입력하세요...");
			}
		}
		return id;
	}// loginMenu
	

	// 카테고리 페이지
	private static void categoryMenu(String id) throws Exception {
		int num = 0;
		LoginRegisterManager loginRegisterManager = new LoginRegisterManager();
		CategoryRegisterManager categoryRegisterManager = new CategoryRegisterManager();
		CartRegisterManager cartRegisterManager = new CartRegisterManager();
		boolean or = false;
		
//		String id = loginRegisterManager.loginCheck();
		if(id == null) {
			System.out.println("로그인 부터 해주세요...");
			return;
		}
		while (!or) {
			MenuViewer.categoryMenu();
			num = MenuViewer.num.nextInt();
			MenuViewer.num.nextLine();

			switch (num) {
			case Category_Choice.LIST:
				categoryRegisterManager.categoryList();
				break;
			case Category_Choice.INSERT:
				cartRegisterManager.addCart(id);
				break;
			case  Category_Choice.CARTLIST:
				cartRegisterManager.cartChokList(id);
				break;
			case  Category_Choice.DELETE:
				cartRegisterManager.cartChokListDelete(id);
				break;
			case 0:
				or = true;
				break;
			default:
				System.out.println("해당번호만 입력하세요...");
			}
		}
	}// categoryMenu


	// 관리자 페이지
	private static void managerMenu() throws Exception {
		int num = 0;
		ManagerRegisterManager managerRegisterManager = new ManagerRegisterManager();

		boolean mLogin = managerRegisterManager.managerLogin();
		if (!mLogin) {
			return;
		}
		boolean or = false;
		while (!or) {
			MenuViewer.managerMenu();
			num = MenuViewer.num.nextInt();
			MenuViewer.num.nextLine();
			switch (num) {
			case Manager_Choice.INSERT:
				managerRegisterManager.addMCtgry();
				break;
			case Manager_Choice.UPDATE:
				managerRegisterManager.updateMCtgry();
				break;
			case Manager_Choice.DELETE:
				managerRegisterManager.deleteMCtgry();
				break;
			case 0:
				or = true;
				break;
			default:
				System.out.println("해당번호만 입력하세요...");
			}
		}

	}// managerMenu

}
