package com.neu.cxl.webServlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.cxl.Entity.Actor;
import com.neu.cxl.Entity.Director;
import com.neu.cxl.ServiceImpl.AdminServiceImpl;

/**
 * Servlet implementation class DeleteDirectorServlet
 */
@WebServlet("/DeleteDirectorServlet")
public class DeleteDirectorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteDirectorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String directorid=request.getParameter("directorid");
		AdminServiceImpl adminServiceImpl=new AdminServiceImpl();
		Director r=new Director();
		r.setDirectorId(directorid);
		try {
			if(adminServiceImpl.deleteDirector(r))
			{
				request.setAttribute("deletemsg", "删除成功");
				response.getWriter().write("<script languge='javascript'>alert('删除成功'); window.location.href='JSP/directorSelect.jsp';</script>");
				
			}
			else
			{
				request.setAttribute("deletemsg", "删除失败");
			}	
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
