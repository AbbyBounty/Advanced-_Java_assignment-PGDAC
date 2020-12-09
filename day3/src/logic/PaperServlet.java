package logic;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Question;

@WebServlet("/paper")
public class PaperServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	
	public void init(ServletConfig config) throws ServletException {
		con = (Connection)config.getServletContext().getAttribute("jdbccon");
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//actual logic
		int tid = Integer.parseInt(request.getParameter("topicid"));
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Question> qlist = new ArrayList<>();
		PrintWriter out = response.getWriter();
		try
		{
			ps = con.prepareStatement("select * from questions where topicid = ?");
			ps.setInt(1, tid);
			rs = ps.executeQuery();
			int qno = 0;
			while(rs.next())
			{
				Question q = new Question(++qno,rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7).charAt(0));
				qlist.add(q);
			}
			
			qno =0;
			int qindex = 0;
			Question q = qlist.get(qindex);
			out.println("<form>");
			out.println("Q."+(++qno)+ q.getQtext()+"<br/>");
			out.println("<input type='radio' name='option' value='a'/> "+q.getOpt1()+"<br/>");
			out.println("<input type='radio' name='option' value='b'/> "+q.getOpt2()+"<br/>");
			out.println("<input type='radio' name='option' value='c'/> "+q.getOpt3()+"<br/>");
			out.println("<input type='radio' name='option' value='d'/> "+q.getOpt4()+"<br/>");
			out.print("<input type='submit' value='NEXT' />");
			out.println("</form>");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				rs.close();
				ps.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
