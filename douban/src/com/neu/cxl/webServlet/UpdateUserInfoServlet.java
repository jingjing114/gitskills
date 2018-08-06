package com.neu.cxl.webServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.neu.cxl.Entity.User;
import com.neu.cxl.ServiceImpl.UserServiceImpl;

/**
 * Servlet implementation class UpdateUserInfoServlet
 */
@WebServlet("/UpdateUserInfoServlet")
public class UpdateUserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*SmartUpload smart=new SmartUpload();
		smart.setCharset("utf-8");
		smart.initialize(this.getServletConfig(),request,response);
		try {
			smart.upload();
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		    response.setContentType("text/html;charset=utf-8");
	        request.setCharacterEncoding("utf-8");
	        response.setCharacterEncoding("utf-8");
	        PrintWriter out = response.getWriter();
	        try{
	            SmartUpload smart = new SmartUpload();//创建SmartUpload对象
	            smart.setCharset("utf-8");//设置编码
	            smart.initialize(this.getServletConfig(),request,response);//初始化设置             
	            smart.setAllowedFilesList("gif,bmp,jpg,png");//设置允许上传的文件扩展名
	            smart.setMaxFileSize(2*1024*1024);//设置单个文件允许最大长度(单位：字节)
	            smart.setTotalMaxFileSize(10*1024*1024);//设置上传文件的总大小(单位：字节)
	            smart.upload();//将文件数据上传
	            //注意：使用SmartUpload对象获取request这句代码要放在upload()方法后面，否则拿不到数据
	            
	            File f = smart.getFiles().getFile(0);//获取第一个上传文件
	            String savePath = "upload\\";
	            savePath += f.getFileName();//组装存储路径
	            f.saveAs(savePath);//将文件保存到指定位置
	            System.out.println("头像上传成功！");
	        
	            
	           String username= smart.getRequest().getParameter("username");
	           String password=smart.getRequest().getParameter("password");
	           String sex=smart.getRequest().getParameter("sex");
	           String age=smart.getRequest().getParameter("age");
	           String phone=smart.getRequest().getParameter("phone");
	           String email=smart.getRequest().getParameter("email");
	          // String icon=smart.getRequest().getParameter("icon");
	          // System.out.println(icon);
	           String introduction=smart.getRequest().getParameter("introduction");
	           User user=new User();
	           user.setUserName(username);
	           user.setAge(age);
	           user.setEmail(email);
	           user.setIcon(savePath);
	           user.setIntroduction(introduction);
	           user.setPassword(password);
	           user.setPhone(phone);
	           user.setSex(sex);
	           UserServiceImpl userServiceImpl=new UserServiceImpl();
	            
	           if( userServiceImpl.updateInfo(user))
	           {
	        	   request.getSession().setAttribute("user", user);
					out.write("<script languge='javascript'>alert('修改成功');</script>");
				}
				else
				{
					out.write("<script languge='javascript'>alert('修改失败'); ;</script>");
				}
	            
	        }catch(Exception ex){
	            ex.printStackTrace();
	            System.out.println("上传异常："+ex.getMessage());
	           
	        }
	        out.flush();
	        out.close();
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
