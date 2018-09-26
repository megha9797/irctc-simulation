package com.railwayy;

import java.io.IOException;

import javax.naming.*;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import java.sql.*;


/**
 * Servlet implementation class bookservlet
 */
@WebServlet("/bookservlet")
public class bookservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Context ctx;
	DataSource ds;
	Connection con;
	String query="insert into BOOKING2 values(?,?)";
	PreparedStatement ps;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bookservlet() {
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
			
			String name=request.getParameter("name");
			String age= request.getParameter("age");
			response.setContentType("text/html");
			
			ctx= new InitialContext();
			ds=(DataSource)ctx.lookup("jdbc/libdb");
			
			con=ds.getConnection();
			ps=con.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, age);
			int retval=ps.executeUpdate();
			if(retval==1)
			{
				out.println("<form action='confirmbookingservlet' method='post'>");
				out.println("<input type='submit' value= 'CONFIRM BOOKING'>");
				out.println("</form>");
				
				
				
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
