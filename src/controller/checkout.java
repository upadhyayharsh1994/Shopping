package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.checkoutDAO;
import VO.cardDetailsVO;
import VO.loginVO;
import VO.orderDetailsVO;
import VO.orderVO;
import VO.productVO;

/**
 * Servlet implementation class checkout
 */
@WebServlet("/checkout")
public class checkout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String flag =request.getParameter("flag");
		System.out.println("Flagggggggg"+flag);
		
		if(flag!=null && flag.equals("checkout"))
		{
			checkout(request,response);
		}
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void checkout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int userId = Integer.parseInt(request.getParameter("userId"));
		String cardType = request.getParameter("CreditCardType");
		String cardNumber = request.getParameter("car_number");
		int cvv = Integer.parseInt(request.getParameter("car_code"));
		String expirationDate = request.getParameter("month");
		String year = request.getParameter("year");
		
		
        //System.out.println(items);
		
		cardDetailsVO carddetailsvo = new cardDetailsVO();
		carddetailsvo.setCardType(cardType);
		carddetailsvo.setCardNumber(cardNumber);
		carddetailsvo.setCVV(cvv);
		carddetailsvo.setExpirationDate(expirationDate);
		carddetailsvo.setYear(year);
		checkoutDAO checkoutdao = new checkoutDAO();
		checkoutdao.insert(carddetailsvo);
		
		HttpSession session = request.getSession();
		HashMap<String, productVO> items = (HashMap<String, productVO>) session.getAttribute("cartitems");
		
		
		
		
		Iterator it = items.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<String,productVO> pair = (Map.Entry)it.next();
			String productName = pair.getKey().toString();
			int price = pair.getValue().getPrice();
			loginVO loginvo = new loginVO();
		    loginvo.setUserIdd(userId);
		    orderDetailsVO ordervo = new orderDetailsVO();
		    ordervo.setProductName(productName);
		    //ordervo.setPrice(price);
 		    ordervo.setUserIdd(loginvo);
		    checkoutDAO checkoutdao1 = new checkoutDAO();
		    checkoutdao1.order(ordervo);
		}
		
		response.sendRedirect("thankyou.jsp");
        
	}
}
