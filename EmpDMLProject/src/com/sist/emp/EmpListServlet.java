package com.sist.emp;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import com.sist.dao.*;

public class EmpListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//doGet �޼ҵ� = run �޼ҵ�
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ���� Ÿ�� ���� : text/html, text/xml
		response.setContentType("text/html;charset=EUC-KR");
		int curpage=0;
		int totalpage=0;
		// EmpListServlet?page=2&type=1
		// getParameter:����ڰ� ���� ���� ������ ���� �� => ? ���� ���� �޾ƿ;� �Ѵ� (page,type)
		String strPage=request.getParameter("page"); 
		// ù������ ==> ����Ʈ
		if(strPage==null)
		{
			strPage="1";
		}
		curpage=Integer.parseInt(strPage);
		// HTML => ��û�� ������� ����
		// TCP  ==> Stream 
		PrintWriter out=response.getWriter(); //getOutputStream
		out.println("<html>");
		out.println("<body>");
		out.println("<center>");
		out.println("<h3>��� ���</h3>");
		out.println("<table border=0 width=500>");
		out.println("<tr>");
		out.println("<td align=left>");
		out.println("<a href=InsertServlet>���</a>");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("<table border=0 width=500 cellspacing=0>");
		out.println("<tr bgcolor=#ccccff>");
		out.println("<th>���</th>");
		out.println("<th>�̸�</th>");
		out.println("<th>����</th>");
		out.println("<th>�Ի���</th>");
		out.println("<th>�μ���ȣ</th>");
		out.println("</tr>");
		//������ ���
		EmpDAO dao=new EmpDAO();
		List<EmpDTO> list=dao.empAllData(curpage);
		totalpage=dao.empTotalPage();
		for(EmpDTO d:list)
		{
			out.println("<tr>");
			out.println("<td align=center>"+d.getEmpno()+"</td>");
			out.println("<td align=center>");
			out.println("<a href=EmpDetailServlet?empno="+d.getEmpno()+">");
			out.println(d.getEname());
			out.println("</a>");
			out.println("</td>");
			out.println("<td align=center>"+d.getJob()+"</td>");
			out.println("<td align=center>"+d.getHiredate()+"</td>");
			out.println("<td align=center>"+d.getDeptno()+"</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("<hr width=500>");
		out.println("<table border=0 width=500 cellspacing=0>");
		out.println("<tr>");
		out.println("<td align=right>");
		out.println("<a href=EmpListServlet?page="+(curpage>1?curpage-1:curpage)+">");
		out.println("����</a>&nbsp;");
		out.println("<a href=EmpListServlet?page="+(curpage<totalpage?curpage+1:curpage)+">");
		out.println("����</a>&nbsp;&nbsp;&nbsp;");
		out.println(curpage+" page / "+totalpage+" pages");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
	}

}
