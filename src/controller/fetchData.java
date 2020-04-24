package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.fetchDataDAO;
import VO.loginVO;
import VO.productVO;

/**
 * Servlet implementation class fetchData
 */
@WebServlet("/fetchData")
public class fetchData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public fetchData() {
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
		System.out.println(flag);
		
		if(flag!=null && flag.equals("search"))
		{
			load(request,response);
		}
		if(flag!=null && flag.equals("phoneSearch"))
		{
			System.out.println("........."+flag);
			search(request,response);
		}
		if(flag!=null && flag.equals("singleProduct"))
		{
			
			singleProduct(request,response);
		}
		if(flag!=null && flag.equals("delete"))
		{
			
			delete(request,response);
		}
		
		
	}


	


	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	void load(HttpServletRequest request, HttpServletResponse response) throws IOException
	{	
		
		fetchDataDAO fetchdatadao = new fetchDataDAO();
		List data = fetchdatadao.search();
		System.out.println(data);
		HttpSession session=request.getSession();
		session.setAttribute("categoryData",data);
		response.sendRedirect("header.jsp");
		
	}

	private void search(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		fetchDataDAO fetchdatadao = new fetchDataDAO();
		List data = fetchdatadao.searchProduct();
		System.out.println(data);
		HttpSession session=request.getSession();
		session.setAttribute("phoneData",data);
		response.sendRedirect("productpage.jsp");
	}

	private void singleProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		int productId = (Integer.parseInt(request.getParameter("productId")));
		//System.out.println(productId);
		
		productVO productvo = new productVO();
		productvo.setProductId(productId);
		
		fetchDataDAO fetchdatadao = new fetchDataDAO();
		List data = fetchdatadao.searchSingleProduct(productvo);
		HttpSession session=request.getSession();
		session.setAttribute("singlePhoneData",data);
		response.sendRedirect("singleProduct1.jsp");
	}

	
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String name = request.getParameter("name");
		
		System.out.println(name);
		HttpSession session = request.getSession();
	    cart shoppingCart;
	    shoppingCart = (cart) session.getAttribute("cart");
	    shoppingCart.deleteCart(name);
	    session.setAttribute("cart", shoppingCart);
	    shoppingCart = (cart) session.getAttribute("cart");
	   
	    RequestDispatcher rd=request.getRequestDispatcher("addToCart");
        rd.forward(request, response);       
        
	}
}
