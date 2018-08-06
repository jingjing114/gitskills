package com.neu.cxl.webServlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.cxl.Entity.Review;
import com.neu.cxl.Entity.User;
import com.neu.cxl.ServiceImpl.ReviewServiceImpl;
import com.neu.cxl.ServiceImpl.UserServiceImpl;

/**
 * Servlet implementation class SelectUserInfoServlet
 */
@WebServlet("/SelectUserInfoServlet")
public class SelectUserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectUserInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=request.getParameter("username");
		User user=new User();
		ArrayList<Review> reviewList=new ArrayList();
		user.setUserName(username);
		UserServiceImpl userServiceImpl=new UserServiceImpl();
		ReviewServiceImpl reviewServiceImpl=new ReviewServiceImpl();
		try {
			reviewList=reviewServiceImpl.selectReview(user);
		 	request.setAttribute("reviewInfo", reviewList);
			request.setAttribute("userInfo",userServiceImpl.selectInfo(user));
			request.getRequestDispatcher("single.jsp").forward(request, response);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
