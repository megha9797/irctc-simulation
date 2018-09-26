package com.railwayy;
import javax.naming.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import java.sql.*;
/**
 * Servlet implementation class registerservlet
 */
@WebServlet("/registerservlet")
public class registerservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Context ctx;
	DataSource ds;
	Connection con;
	String query="insert into login_customers values(?,?,?,?)";
	PreparedStatement ps;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerservlet() {
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
			String fn=request.getParameter("firstname");
			String ln=request.getParameter("lastname");
			String un=request.getParameter("name");
			String pwd= request.getParameter("password");
			response.setContentType("text/html");
			
			ctx= new InitialContext();
			ds=(DataSource)ctx.lookup("jdbc/libdb");
			
			con=ds.getConnection();
			ps=con.prepareStatement(query);
			ps.setString(1, fn);
			ps.setString(2, ln);
			ps.setString(3, un);
			ps.setString(4, pwd);
			int retval=ps.executeUpdate();
			if(retval==1)
			{
				out.println(" you are registered...");
				out.println("<a href='Login.jsp'>login</a>");
				
			}
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
