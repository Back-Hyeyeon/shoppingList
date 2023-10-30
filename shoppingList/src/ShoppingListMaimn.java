import controller.LoginRegisterManager;
import model.LoginVo;
import view.Login_Choice;
import view.MenuViewer;
import view.Menu_Choice;

public class ShoppingListMaimn {

	private static final String String = null;
	private static final LoginVo LoginVo = null;

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
		int num;
		LoginRegisterManager loginRegisterManager = new LoginRegisterManager();
		MenuViewer.loginMenu();
		num = MenuViewer.num.nextInt();
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
	private static void categoryMenu() {
		// TODO Auto-generated method stub
		
	}//categoryMenu
	
	//장바구니 페이지
	private static void cartMenu() {
		// TODO Auto-generated method stub
		
	}//cartMenu
	
	//관리자 페이지
	private static void managerMenu() {
		// TODO Auto-generated method stub
		
	}//managerMenu

}
