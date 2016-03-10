package com.sist.view;

import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파싱하는 형태가 무엇인지 알려줌 : setContentType
		response.setContentType("text/html;charset=EUC-KR");
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<center>");
		out.println("<table border=1 width=1000 height=780>");
		out.println("<tr>");
		String str="LoginServlet";
		RequestDispatcher rd=request.getRequestDispatcher(str);
		out.println("<td height=100 colspan=2>");
		rd.include(request, response);
		out.println("</td>"); //header
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td height=580 width=200>&nbsp;</td>");
		out.println("<td height=580 width=800>"); //valign=top
		rd=request.getRequestDispatcher("Gugudan.jsp");
		rd.include(request, response);
		out.println("</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td height=100 colspan=2>&nbsp;</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
		
	}

}
