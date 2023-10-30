package model;

import java.util.Objects;

public class LoginVo {

	private int no;
	private String l_id;
	private String l_pw;
	private String l_email;
	private String l_address;

	public LoginVo() {
		super();
	}

	public LoginVo(int no, String l_id, String l_pw, String l_email, String l_address) {
		super();
		this.no = no;
		this.l_id = l_id;
		this.l_pw = l_pw;
		this.l_email = l_email;
		this.l_address = l_address;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getL_id() {
		return l_id;
	}

	public void setL_id(String l_id) {
		this.l_id = l_id;
	}

	public String getL_pw() {
		return l_pw;
	}

	public void setL_pw(String l_pw) {
		this.l_pw = l_pw;
	}

	public String getL_email() {
		return l_email;
	}

	public void setL_email(String l_email) {
		this.l_email = l_email;
	}

	public String getL_address() {
		return l_address;
	}

	public void setL_address(String l_address) {
		this.l_address = l_address;
	}
//	private int no = 0;
//	private String l_id = null;
//	private String l_pw = null;
//	private String l_email = null;
//	private String l_address = null;
	@Override
	public String toString() {
		return String.format("일련번호 : %d , 아이디 : %s ,비밀번호 : %s ,이메일 : %s ,주소 : %s \n", getNo(),getL_id(),getL_pw(), getL_email(),getL_address());
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.l_id, this.l_pw);
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof LoginVo)) {return false;}
		LoginVo lgvo = (LoginVo)obj;
		return lgvo.l_id.equals(this.l_id) && lgvo.l_pw.equals(this.l_pw);
	}
	
	

}
