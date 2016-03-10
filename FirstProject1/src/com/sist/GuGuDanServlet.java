package com.sist;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GuGuDanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=EUC-KR"); //charset => 2바이트씩 묶어서 전송
		//Socket
		// PrintWriter == OutputStream
		PrintWriter out=response.getWriter();
		// OutputStream=s.getOutputStream();
		out.println("<html>");
		out.println("<body>");
		out.println("<center>");
		out.println("<h3>구구단</h3>");
		out.println("<table border=1 width=600>");
		out.println("<tr>");
		for(int i=2;i<=9;i++)
		{
			out.println("<th>"+i+"단</th>");
		}
		for(int i=1;i<=9;i++)
		{
			out.println("<tr>");
			for(int j=2;j<=9;j++)
			{
				out.println("<td>");
				out.println(j+"*"+i+"="+(j*i));
				out.println("</td>");
			}
			out.println("</tr>");
		}
		out.println("</tr>");
		out.println("</table>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
		//생략 가능 (body까지 인식)
	}

}
