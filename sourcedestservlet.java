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

import java.sql.*;



/**
 * Servlet implementation class sourcedestservlet
 */
@WebServlet("/sourcedestservlet")
	public class sourcedestservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Context ctx;
	DataSource ds;
	Connection con;
	Boolean status;
	PreparedStatement ps;
    String query="select distinct (a.TRAIN_ID),c.TRAIN_NAME,c.AVAILABLE_SEATS,a.DATES"+


"FROM TRAIN_DATE_TIME a,TRAIN_ID_STN_TIME_COST f,TRAINNAME_ID c"
+ "where a.train_id=f.train_id and f.train_id=c.train_id and"
+"A.TRAIN_ID IN (SELECT TRAIN_ID FROM TRAIN_ID_STN_TIME_COST WHERE STATION =(?)intersect SELECT TRAIN_ID FROM TRAIN_ID_STN_TIME_COST WHERE STATION ='(?))"
+"and a.DATES like (?)";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sourcedestservlet() {
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
			response.setContentType("text/html");	
		
		try
		{
			String src= request.getParameter("source");
			String des=request.getParameter("destination");
			String date=request.getParameter("date");

			
			ctx= new InitialContext();
			ds=(DataSource)ctx.lookup("jdbc/libdb");
			
			con=ds.getConnection();
			ps=con.prepareStatement(query);
			ps.setString(1, src);
			ps.setString(2, des);
			ps.setString(3,date);
			int retval=ps.executeUpdate();
			if(retval==1)
			{out.println("book");
			out.println("<a href = 'book.jsp'>Book</a>");
			}
	}catch(SQLException e){
		out.println("some sql exception");
	}
		catch(NamingException ie)
		{
			out.println("naming exception");
		}
		

	}}
