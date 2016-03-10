package com.sist.emp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.SynthSeparatorUI;

import com.sist.dao.EmpDAO;
import com.sist.dao.EmpDTO;

public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//doGet �޼ҵ� = run �޼ҵ�
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ���� Ÿ�� ���� : text/html, text/xml
		response.setContentType("text/html;charset=EUC-KR");
		EmpDAO dao=new EmpDAO();
		List<String> jList=dao.empGetJob();
		List<Integer> mList=dao.empGetMgr();
		PrintWriter out=response.getWriter(); //getOutputStream
		out.println("<html>");
		out.println("<body>");
		out.println("<center>");
		out.println("<h3>��� ���</h3>");
		out.println("<form action=InsertServlet method=POST>"); //form���� ��ü�� ��� ����(textarea,input,select ���� �Ѿ)
		out.println("<table border=1 bordercolor=black width=300 cellspacing=0>");
		out.println("<tr>");
		out.println("<td width=25% align=right>�̸�</td>");
		out.println("<td width=75% align=left>");
		out.println("<input type=text size=12 name=ename>"); //input type=text : �Է�â
		out.println("</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td width=25% align=right>����</td>");
		out.println("<td width=75% align=left>");
		out.println("<select name=job>"); //select : �޺��ڽ�
		for(String job:jList)
		{
			out.println("<option>");
			out.println(job);
			out.println("</option>");
		}
		/*EmpDAO dao= new EmpDAO();
		ArrayList<String> joblist=dao.getjob();
		for(String d:joblist)
		{
			out.println("<option>"+d+"</option>");
		}*/
		out.println("</select>");
		out.println("</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td width=25% align=right>���</td>");
		out.println("<td width=75% align=left>");
		out.println("<select name=mgr>"); //select : �޺��ڽ�
		for(int mgr:mList)
		{
			out.println("<option>");
			out.println(mgr);
			out.println("</option>");
		}
		/*EmpDAO dao1= new EmpDAO();
		ArrayList<String> mgrlist= dao.getMgr(); 
		for(String d:mgrlist)
		{
			out.println("<option>"+d+"</option>"); //option : additem
		}*/
		out.println("</select>");
		out.println("</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td width=25% align=right>�޿�</td>");
		out.println("<td width=75% align=left>");
		out.println("<select name=sal>"); //select : �޺��ڽ�
		out.println("<option>1000</option>"); //option : additem
		out.println("<option>2000</option>");
		out.println("<option>3000</option>");
		out.println("<option>4000</option>");
		out.println("</select>");
		out.println("</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td width=25% align=right>������</td>");
		out.println("<td width=75% align=left>");
		out.println("<select name=comm>"); //select : �޺��ڽ�
		out.println("<option>0</option>"); //option : additem
		out.println("<option>100</option>");
		out.println("<option>200</option>");
		out.println("<option>300</option>");
		out.println("</select>");
		out.println("</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td width=25% align=right>�μ�</td>");
		out.println("<td width=75% align=left>");
		out.println("<select name=deptno>"); //select : �޺��ڽ�
		out.println("<option>10</option>"); //option : additem
		out.println("<option>20</option>");
		out.println("<option>30</option>");
		out.println("<option>40</option>");
		out.println("</select>");
		out.println("</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td colspan=2 align=center>"); //�����ٺ��� : colspan  �����ٺ��� : rowspan
		out.println("<input type=submit value=���>"); //���±׿��� �޾Ƽ� ó��
		out.println("<input type=button value=��� onclick=\"javascript:history.back()\">"); //onclick(javaScript)
		// �ڹٽ�ũ��Ʈ���� �̹� �����ϴ� �Լ��� �̿��Ҷ��� \"javascript:\"�� ����ؾ� �Ѵ�.
		out.println("</tr>");
		out.println("</table>");
		out.println("</form>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ���� �޴´�
		request.setCharacterEncoding("EUC-KR"); //****�ѱ۷� ���ڵ�
		String ename=request.getParameter("ename");
		String job=request.getParameter("job");
		String mgr=request.getParameter("mgr");
		String sal=request.getParameter("sal");
		String comm=request.getParameter("comm");
		String deptno=request.getParameter("deptno");
		//System.out.println(ename);
		EmpDTO d=new EmpDTO();
		d.setEname(ename);
		d.setJob(job);
		d.setMgr(Integer.parseInt(mgr));
		d.setSal(Integer.parseInt(sal));
		d.setComm(Integer.parseInt(comm));
		d.setDeptno(Integer.parseInt(deptno));
		// DAO => Insert
		EmpDAO dao=new EmpDAO();
		dao.empInsert(d);
		// ������ �̵� (List)
		response.sendRedirect("EmpListServlet"); //sendRedirect: ������ �ٲ��� �� ���
	}
}

