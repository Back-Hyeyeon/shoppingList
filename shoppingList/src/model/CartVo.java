package model;

import java.util.Objects;

public class CartVo {
	private int no;
	private String c_cord;
	private String l_id;

	public CartVo() {
		super();
	}

	public CartVo(int no, String c_cord, String l_id) {
		super();
		this.no = no;
		this.c_cord = c_cord;
		this.l_id = l_id;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getC_cord() {
		return c_cord;
	}

	public void setC_cord(String c_cord) {
		this.c_cord = c_cord;
	}

	public String getL_id() {
		return l_id;
	}

	public void setL_id(String l_id) {
		this.l_id = l_id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.l_id,this.c_cord);
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof CartVo)) {return false;}
		CartVo csrtvo = (CartVo)obj;
		return csrtvo.l_id.equals(this.l_id) && csrtvo.c_cord.equals(this.c_cord);
	}

}
