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
 * Servlet implementation class confirmbookingservlet
 */
@WebServlet("/confirmbookingservlet")
public class confirmbookingservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Context ctx;
	DataSource ds;
	Connection con;
	String query="update  TRAINNAME_ID  SET AVAILABLE_SEATS=AVAILABLE_SEATS-1 WHERE TRAIN_ID=(?);";
	PreparedStatement ps;
       
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public confirmbookingservlet() {
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
		out.println("<h3>booking confirmed</h3>");
		
	}

}
