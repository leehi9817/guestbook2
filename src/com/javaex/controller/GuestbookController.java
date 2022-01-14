package com.javaex.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.dao.GuestbookDao;
import com.javaex.util.WebUtil;
import com.javaex.vo.GuestbookVo;

@WebServlet("/gbc")
public class GuestbookController extends HttpServlet {
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String action = request.getParameter("action");
		
		if("addList".equals(action)) {
			System.out.println("action=addList");
			GuestbookDao guestbookDao = new GuestbookDao();
			List<GuestbookVo> guestbookList = guestbookDao.getList();
			
			request.setAttribute("gList", guestbookList);
			
			//포워드
			WebUtil.forward(request, response, "/WEB-INF/addList.jsp");
		} else if ("add".equals(action)) {
			System.out.println("action=add");
			
			//파라미터 값 추출
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String content = request.getParameter("content");
			
			//파라미터 값으로 vo 생성
			GuestbookVo guestbookVo = new GuestbookVo(name, password, content);
			
			//dao 메모리에 올리기
			GuestbookDao guestbookDao = new GuestbookDao();
			
			//dao.insert(vo);
			guestbookDao.insert(guestbookVo);

			//리다이렉트
			response.sendRedirect("/guestbook2/gbc?action=addList");
			
		} else if ("deleteForm".equals(action)) {
			System.out.println("action=deleteForm");
			
			//포워드
			WebUtil.forward(request, response, "/WEB-INF/deleteForm.jsp");
			
		} else if ("delete".equals(action)) {
			
			System.out.println("action=delete");
			
			//파라미터 값 추출
			int no = Integer.parseInt(request.getParameter("no"));
			String password = request.getParameter("password");
			
			//파라미터 값으로 vo 생성
			GuestbookVo guestbookVo = new GuestbookVo(no, password);
			
			//dao 메모리에 올리기
			GuestbookDao guestbookDao = new GuestbookDao();
			
			//dao.delete(vo);
			guestbookDao.delete(guestbookVo);
			
			//리다이렉트
			WebUtil.redirect(request, response, "/guestbook2/gbc?action=addList");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
