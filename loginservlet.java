package com.railwayy;

import javax.naming.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




/**
 * Servlet implementation class loginservlet
 */
@WebServlet("/loginservlet")
public class loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Context ctx;
	DataSource ds;
	Connection con;
	String query ="select user_id,password from login_customers where user_id=(?)and"
			+ " password=(?) ";
	PreparedStatement ps;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out=response.getWriter();
		
		try
		{
			
			String uname=request.getParameter("name");
			String pwd= request.getParameter("password");
			response.setContentType("text/html");
			
			ctx= new InitialContext();
			ds=(DataSource)ctx.lookup("jdbc/libdb");
			
			con=ds.getConnection();
			ps=con.prepareStatement(query);
			ps.setString(1, uname);
			ps.setString(2, pwd);
			int retval=ps.executeUpdate();
			if(retval==1)
			{
				out.println(" you are logged in...");
				RequestDispatcher rd=request.getRequestDispatcher("sourcedest.jsp");
				rd.forward(request, response);//response.sendRedirect("sourcedest.jsp");
				
			}
			
			else
				{out.println("incorrect userid or password...");
			out.println("<a href='Login.jsp'>try again!</a>");}
		}
		catch(NamingException e)
		{
			out.println("probably the reg name is diff...");
			e.printStackTrace();
			
		}
		catch(SQLException ie)
		{
			out.println("some sql exception...");
			ie.printStackTrace();
			
		}
		
		
	}
}

