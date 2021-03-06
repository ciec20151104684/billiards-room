package com.imnu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.tomcat.util.descriptor.web.LoginConfig;

import com.imnu.bean.Administratorbean;
import com.imnu.dao.Administratordao;
import com.sun.org.apache.bcel.internal.generic.DALOAD;


@WebServlet("/AdLoginServlet")
public class AdLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public AdLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;cahrset=utf-8");
		
		String adUsername = request.getParameter("adUsername");
		String adPassword = request.getParameter("adPassword");
		
		Administratordao dao = new Administratordao();
		Administratorbean Administrator = dao.login(adUsername,adPassword);
		
		if(Administrator == null) {
			response.sendRedirect("login.jsp");
		}
		else {
			HttpSession session = request.getSession();
			session.setAttribute("SESSIONUSER", Administrator);
			response.sendRedirect("index.jsp");
		}		

		
	}

}
