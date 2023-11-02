package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.CategoryVo;

public class CategoryRegisterManager {

	public void categoryList() throws Exception {
		CategoryDAO cdao = new CategoryDAO();
		System.out.println("카테고리 전체 리스트");
		cdao.getCategoryList();
		System.out.println();

	}
	//카트 목록에 들어갈 리스트를 추가하기 위한 저장리스트

	
}
