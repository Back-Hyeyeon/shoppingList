package model;

import java.util.Objects;

public class CategoryVo {
	
	private int no;
	private String c_cord;
	private String c_item;
	private String c_price;
	private String c_size;
	private String c_color;
	
	
	
	public CategoryVo() {
		super();
	}



	public CategoryVo(int no, String c_cord, String c_item, String c_price, String c_size, String c_color) {
		super();
		this.no = no;
		this.c_cord = c_cord;
		this.c_item = c_item;
		this.c_price = c_price;
		this.c_size = c_size;
		this.c_color = c_color;
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



	public String getC_item() {
		return c_item;
	}



	public void setC_item(String c_item) {
		this.c_item = c_item;
	}



	public String getC_price() {
		return c_price;
	}



	public void setC_price(String c_price) {
		this.c_price = c_price;
	}



	public String getC_size() {
		return c_size;
	}



	public void setC_size(String c_size) {
		this.c_size = c_size;
	}



	public String getC_color() {
		return c_color;
	}



	public void setC_color(String c_color) {
		this.c_color = c_color;
	}



	@Override
	public int hashCode() {
		
		return Objects.hash(this.no,this.c_cord);
	}



	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof CategoryVo)) {return false;}
		CategoryVo ctgvo = (CategoryVo)obj;
		return ctgvo.no == this.no && ctgvo.c_cord.equals(this.c_cord);
	}
	
	
	
	
	
	
} 
