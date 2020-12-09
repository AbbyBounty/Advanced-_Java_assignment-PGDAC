package logic;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.User;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	
	public void init(ServletConfig config) throws ServletException {
		
		con = (Connection)config.getServletContext().getAttribute("jdbccon");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//actual business logic
		String uid = request.getParameter("uid");
		String pwd = request.getParameter("pwd");
		PrintWriter out = response.getWriter();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement("select * from users where u_id = ? and password = ?");
			ps.setString(1, uid);
			ps.setString(2, pwd);
			rs = ps.executeQuery();
			boolean flag = false;
			String name = "";
			User u = null;
			while(rs.next())
			{
				if(rs.getString(1).equals(uid) && rs.getString(2).equals(pwd))
				{
					u = new User(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
					HttpSession session = request.getSession();
					session.setAttribute("currentuser", u);
					flag = true;
					break;
				}
			}
			if(flag)  //success
			{
				//loginerror cookie is deleted
				Cookie [] allcookies = request.getCookies();
				if(allcookies != null)
				{
					for(Cookie c: allcookies)
					{
						if(c.getName().equals("loginerror"))
						{
							c.setMaxAge(0);
							response.addCookie(c);
						}
					}
				}
				RequestDispatcher rd =request.getRequestDispatcher("/showSubjects");
				rd.forward(request, response);
				/*out.print("Login successful");
				out.print("<h1> Welcome "+ name +"</h1>");*/
			}
			else //login failed
			{
				//out.print("Login failed");
				//cookie is created but not added in the response
				Cookie c = new Cookie("loginerror","Wring_ID/PWD"); 
				response.addCookie(c);
				response.sendRedirect("/QuizApp/login.jsp");
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally
		{
			try {
				rs.close();
				ps.close();
				//con.close();    don't close it here
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	  //init -  ServletContext -  config.getServletContext()
	  //service -  ServletContext  -  getServletContext()
}
