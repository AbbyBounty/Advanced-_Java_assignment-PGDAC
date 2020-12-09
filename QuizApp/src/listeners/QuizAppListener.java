package listeners;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class QuizAppListener implements ServletContextListener {

	Connection con;
   	
	//at the time of undeployment
    public void contextDestroyed(ServletContextEvent sce)  { 
         try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    //at the time of deployment
    public void contextInitialized(ServletContextEvent sce)  { 
        //read the info web.xml as ctx level parameters
    	//establish the connection
    	//set it as context level attribute
    	ServletContext ctx = sce.getServletContext();
    	String driver = ctx.getInitParameter("driver");
    	String url = ctx.getInitParameter("url");
    	String user = ctx.getInitParameter("user");
    	String pwd = ctx.getInitParameter("pwd");
    	
    	try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pwd);
			ctx.setAttribute("jdbccon", con);
			System.out.println("con is set as context level attribute");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	
    }
	
}
