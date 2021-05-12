package dog_shoppingmall_proj.service;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dog_shoppingmall_proj.ds.JndiDs;
import dog_shoppingmall_proj.dto.Cart;
import dog_shoppingmall_proj.impl.DogDaoImpl;

public class DogCartRemoveService {
	private DogDaoImpl dao = DogDaoImpl.getInstance();
	private Connection con = JndiDs.getConnection();

	public DogCartRemoveService() {
		dao.setCon(con);
	}

	public void cartRemove(HttpServletRequest request, String[] kindArray) {
	
		HttpSession session = request.getSession();
		ArrayList<Cart> cartList = (ArrayList<Cart>) session.getAttribute("cartList");

		for (int i = 0; i < kindArray.length; i++) {
			for (int j = 0; j < cartList.size(); j++) {
				if (cartList.get(j).getKind().equals(kindArray[i])) {
					cartList.remove(cartList.get(j));
				}
			}
		}
	}
}
