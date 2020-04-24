package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.loginDAO;
import DAO.registrationDAO;
import VO.loginVO;
import VO.registrationVO;


/**
 * Servlet implementation class addUser
 */
@WebServlet("/addUser")
public class addUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addUser() {
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
		if(flag!=null && flag.equals("insert"))
		{
			insert(request,response);
		}
		if(flag!=null && flag.equals("search"))
		{
			search(request,response);
		}
		if(flag!=null && flag.equals("logout"))
		{
			logout(request,response);
		}
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
	}
	
	public void insert(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		
		System.out.println("insert");
		String name=(String)request.getParameter("name");
		String email=(String)request.getParameter("email");
		String password=(String)request.getParameter("password");
		String address1=(String)request.getParameter("address1");
		String address2=(String)request.getParameter("address2");
		String city=(String)request.getParameter("city");
		String state=(String)request.getParameter("state");
		String zip = (String)request.getParameter("zip");
		
		String password1 = Encryption.MD5(password);
		System.out.println("---------------------");
		System.out.println(password1);
		System.out.println("---------------------");
		loginVO loginvo = new loginVO();
		loginvo.setEmail(email);
		loginvo.setPassword(password1);
		
		registrationVO registrationvo = new registrationVO();
		registrationvo.setName(name);
		registrationvo.setAddress1(address1);
		registrationvo.setAddress2(address2);
		registrationvo.setCity(city);
		registrationvo.setState(state);
		registrationvo.setZip(zip);
		registrationvo.setUserIdd(loginvo);
		
		loginDAO logindao = new loginDAO();
		logindao.insert(loginvo);
		
		registrationDAO registrationdao = new registrationDAO();
		registrationdao.insert(registrationvo);
		
		response.sendRedirect("login.jsp");
	}
	
	
	private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		HttpSession session =((HttpServletRequest) request).getSession();
		RequestDispatcher requestDispatcher;
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String password1 = Encryption.MD5(password);
		
		loginVO loginvo = new loginVO();
		loginvo.setEmail(email);
		loginvo.setPassword(password1);
		
		loginDAO logindao = new loginDAO();
		List list = logindao.authentication(loginvo);
		
		if(list != null && list.size()>=1){
			System.out.println("List size is  : "+list.size());
			Iterator itr = list.iterator();
			
			while(itr.hasNext()){
				loginVO user=(loginVO) itr.next();
				int userIdd = user.getUserIdd();
				//System.out.println(userIdd);
				session.setAttribute("userIDD",userIdd);
				
//				loginVO loginvo1 = new loginVO();
//				loginvo1.setUserIdd(userIdd);
				registrationVO user1 = new registrationVO();
				user1.setUserId(userIdd);
				loginDAO userdao = new loginDAO();
				List userRegistration = userdao.fetchProfile(user1);
				session.setAttribute("profileData",userRegistration);
				System.out.println(userRegistration);
			}
			session.setAttribute("emailId", email);
			requestDispatcher = request.getRequestDispatcher("/profile.jsp");  
			requestDispatcher.forward(request,response);  
		}
		else{
			session.setAttribute("getAlert", "Incorrect Email/Password");
			RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");  
			rd.forward(request,response);
		}	
	}
	
	
	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		  HttpSession session=request.getSession();  
          session.removeAttribute("profileData");
          session.removeAttribute("sizeKey");
          response.sendRedirect("index.jsp");
		
	}

}
