package com.eeit.FoodMap.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.eeit.FoodMap.controller.FoodSearcher;

@WebServlet("/FoodMapRandomizer")
public class FoodMapRandomizer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn;
    public FoodMapRandomizer() {
        super();
    }

    public void initCon() {
    	try {
    		Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/jdbc/FoodMapDB");
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		initCon();
		String condition = request.getParameter("conditionJSON");
		FoodSearcher fs = new FoodSearcher();
//		System.out.println(condition);
		String output = fs.queryStart(conn, condition);
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		request.setAttribute("toFront", output);
//		System.out.println("IN Servlet: "+output);
//		RequestDispatcher rd = request.getRequestDispatcher("/Front/Tester.jsp");
		int number = fs.getNumber();
		if(number == 0) {
			RequestDispatcher rd = request.getRequestDispatcher("/Front/ListAll.jsp");
			rd.forward(request, response);
		}
		else{
			RequestDispatcher rd = request.getRequestDispatcher("/Front/RandomMachine.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
