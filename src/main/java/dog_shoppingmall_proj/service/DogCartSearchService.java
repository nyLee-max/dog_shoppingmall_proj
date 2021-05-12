package dog_shoppingmall_proj.service;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dog_shoppingmall_proj.ds.JndiDs;
import dog_shoppingmall_proj.dto.Cart;
import dog_shoppingmall_proj.impl.DogDaoImpl;

public class DogCartSearchService {
	private DogDaoImpl dao = DogDaoImpl.getInstance();
	private Connection con = JndiDs.getConnection();
	
	public DogCartSearchService() {
		dao.setCon(con);
	}
	
	public ArrayList<Cart> getCartSearchList(int start_money, int end_money, HttpServletRequest request){
		HttpSession session = request.getSession();
		ArrayList<Cart> oldCartList = (ArrayList<Cart>) session.getAttribute("cartList");
		ArrayList<Cart> cartList = new ArrayList<Cart>();
		
		for(int i=0; i<oldCartList.size();i++) {
			if(oldCartList.get(i).getPrice()>=start_money&&oldCartList.get(i).getPrice()<=end_money) {
				cartList.add(oldCartList.get(i));
			}
		}
		return cartList;
	}
}
