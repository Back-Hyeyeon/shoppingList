import controller.CartDAO;
import controller.CartRegisterManager;
import controller.CategoryRegisterManager;
import controller.LoginRegisterManager;
import controller.ManagerRegisterManager;
import model.LoginVo;
import view.Cart_Choice;
import view.Category_Choice;
import view.Login_Choice;
import view.Manager_Choice;
import view.MenuViewer;
import view.Menu_Choice;

public class ShoppingListMaimn {

	private static final String String = null;
	private static final LoginVo LoginVo = null;
	private static final java.lang.String id = null;

	public static void main(String[] args) {
		mainMenu();
		
		
	}

	private static void mainMenu() {
		int choiceNum = 0;
		boolean no = false;
		while (!no) {
			try {
				MenuViewer.mainMenuView();
				choiceNum = MenuViewer.num.nextInt();
				MenuViewer.num.nextLine();
				
				switch(choiceNum) {
				case Menu_Choice.LOGIN:
					loginMenu();
					break;
				case Menu_Choice.CATEGORY:
					categoryMenu();
					break;
				case Menu_Choice.CART:
					cartMenu();
					break;
				case Menu_Choice.MANAGER:
					managerMenu();
					break;
				case Menu_Choice.EXIT:
					System.out.println("프로그램을 종료합니다.");
					no = true;
					break;
					default :
						System.out.println("해당리스트 번호만 사용가능합니다.");
				}
				
			} catch (Exception e) {
				System.out.println("입력오류 다시 시작...");
				no = true;
			}
			
		}//while
	}//mainMenu

//==============================


	//회원가입 로그인페이지
	private static void loginMenu() throws Exception {
		int num = 0;
		LoginRegisterManager loginRegisterManager = new LoginRegisterManager();
		MenuViewer.loginMenu();
		num = MenuViewer.num.nextInt();
		MenuViewer.num.nextLine();
		switch(num) {
		case Login_Choice.MRMBERSHIP:
			loginRegisterManager.membershipJoin();
			break;
		case Login_Choice.LOGIN:
			loginRegisterManager.loginCheck();
			break;
		case Login_Choice.UPDATE:
			loginRegisterManager.loginUpdate();
			break;
		case Login_Choice.LOGOUT:
			loginRegisterManager.logout();
			break;
			
		default:
			System.out.println("해당번호만 입력하세요...");
			
		}
	}//loginMenu
	
	//카테고리 페이지
	private static void categoryMenu() throws Exception {
		int num = 0;
		CategoryRegisterManager categoryRegisterManager = new CategoryRegisterManager();
		CartRegisterManager cartRegisterManager = new CartRegisterManager();
		MenuViewer.categoryMenu();
		num = MenuViewer.num.nextInt();
		MenuViewer.num.nextLine();
		switch(num) {
		case Category_Choice.LIST:
			categoryRegisterManager.categoryList();
			break;
		case Category_Choice.INSERT:
			cartRegisterManager.addCart();
			break;
		default:
			System.out.println("해당번호만 입력하세요...");
		}
		
	}//categoryMenu
	
	//장바구니 페이지
	private static void cartMenu() throws Exception {
		int num = 0;
		
		CartRegisterManager cartRegisterManager = new CartRegisterManager();
		MenuViewer.cartMenu();
		num = MenuViewer.num.nextInt();
		MenuViewer.num.nextLine();
		switch(num) {
		case Cart_Choice.LIST:
			cartRegisterManager.cartChokList();
			break;
		case Cart_Choice.DELETE:
			cartRegisterManager.cartChokListDelete();
			break;
			
		default:
			System.out.println("해당번호만 입력하세요...");
			}
	}//cartMenu
	
	//관리자 페이지
	private static void managerMenu() throws Exception {
		int num = 0;
		ManagerRegisterManager managerRegisterManager = new ManagerRegisterManager();
		
		boolean mLogin = managerRegisterManager.managerLogin();
		if(!mLogin) {
			return;
			}
		
		MenuViewer.managerMenu();
		num = MenuViewer.num.nextInt();
		MenuViewer.num.nextLine();
		switch(num) {
		case Manager_Choice.INSERT:
			managerRegisterManager.addMCtgry();
			break;
		case Manager_Choice.UPDATE:
			managerRegisterManager.updateMCtgry();
			break;
		case Manager_Choice.DELETE:
			managerRegisterManager.deleteMCtgry();
			break;
		}
		
	}//managerMenu

}
