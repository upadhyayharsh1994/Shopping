package controller;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import VO.productVO;

/**
 * Servlet implementation class addToCart
 */
@WebServlet("/addToCart")
public class addToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addToCart() {
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
		
		if(flag!=null && flag.equals("addToCart"))
		{
			addingCart(request,response);
		}
		if(flag!=null && flag.equals("delete"))
		{
			delete1(request,response);
		}
		if(flag!=null && flag.equals("cartDisplay"))
		{
			cartDisplay(request,response);
		}
		
	}



	


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void addingCart(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
        cart shoppingCart;
        shoppingCart = (cart) session.getAttribute("cart");
        //List product = session.getAttribute("phoneData");
        if(shoppingCart == null){
          shoppingCart = new cart();
          session.setAttribute("cart", shoppingCart);
        }
        
        String productName = request.getParameter("product_name");
        int price = Integer.parseInt(request.getParameter("priceHidden"));
        int Total = Integer.parseInt(request.getParameter("priceValue"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String productDescription = request.getParameter("productDescription");
        String imagePath = request.getParameter("productImage");
    
        
        
        productVO pv = new productVO();
        pv.setProductName(productName);
        pv.setPrice(Total);
        pv.setProductDescription(productDescription);
        pv.setImagePath(imagePath);
        pv.setQuantity(quantity);
        
        shoppingCart.addToCart(productName, pv);
        session.setAttribute("cart", shoppingCart);

        List<productVO> i = new ArrayList<productVO>();
        int size = 0;
        HashMap<String, productVO> items = shoppingCart.getCartItems();
        for(String key: items.keySet()){
            System.out.println(key+" - "+"$"+items.get(key)); 
            i.add(items.get(key));
        }
        size = i.size();
        System.out.println("##no of cart items"+size);
        session.setAttribute("sizeKey", size);
        
        int sum1=0;
        for(int m=0; m<i.size();m++){
        	productVO a = i.get(m);
        	int sum2 = a.getPrice();
        	sum1 += sum2;
       }
        session.setAttribute("Total", sum1);
        
       session.setAttribute("cartitems", items);
        RequestDispatcher rd=request.getRequestDispatcher("cart.jsp");
        rd.forward(request, response);       
        
	}
	
	private void delete1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
        cart shoppingCart;
        shoppingCart = (cart) session.getAttribute("cart");
        
        List<productVO> i = new ArrayList<productVO>();
        HashMap<String, productVO> items = shoppingCart.getCartItems();
        for(String key: items.keySet()){
            System.out.println(key+" - "+"$"+items.get(key)); 
            i.add(items.get(key));
        }
        
        int sum1=0;
        for(int m=0; m<i.size();m++){
        	productVO a = i.get(m);
        	int sum2 = a.getPrice();
        	sum1 += sum2;
       }
        session.setAttribute("Total", sum1);
        session.setAttribute("cartitems", items);
        
        RequestDispatcher rd=request.getRequestDispatcher("cart.jsp");
        rd.forward(request, response);   
		
	}
	
	

	private void cartDisplay(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
        cart shoppingCart;
        shoppingCart = (cart) session.getAttribute("cart");
        if(shoppingCart == null){
            shoppingCart = new cart();
            session.setAttribute("cart", shoppingCart);
        }
        HashMap<String, productVO> items = shoppingCart.getCartItems();
        List<productVO> i = new ArrayList<productVO>();
        for(String key: items.keySet()){
            System.out.println(key+" - "+"$"+items.get(key)); 
            i.add(items.get(key));
        }
        int sum1=0;
        for(int m=0; m<i.size();m++){
        	productVO a = i.get(m);
        	int sum2 = a.getPrice();
        	sum1 += sum2;
       }
        request.setAttribute("Total", sum1);
        request.setAttribute("cartitems", items);
        
        RequestDispatcher rd=request.getRequestDispatcher("cart.jsp");
        rd.forward(request, response);   
	}

}
