package dog_shoppingmall_proj.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dog_shoppingmall_proj.dto.ActionForward;
import dog_shoppingmall_proj.dto.Cart;
import dog_shoppingmall_proj.service.DogCartSearchService;

public class DogCartSearchAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		DogCartSearchService dogCartSearchService = new DogCartSearchService();
		int startMoney = Integer.parseInt(request.getParameter("startMoney"));
		int endMoney = Integer.parseInt(request.getParameter("endMoney"));
		ArrayList<Cart> cartList = dogCartSearchService.getCartSearchList(startMoney, endMoney, request);
		request.setAttribute("cartList", cartList);
		request.setAttribute("startMoney", startMoney);
		request.setAttribute("endMoney", endMoney);
		int totalMoney = 0;
		int money = 0;
		
		for(int i=0; i<cartList.size();i++) {
			money = cartList.get(i).getPrice()*cartList.get(i).getQty();
			totalMoney +=money;
		}
		
		request.setAttribute("totalMoney", totalMoney);
		ActionForward forward = new ActionForward("/dog_shopping/dogCartList.jsp", false);
		return forward;
	}

}
