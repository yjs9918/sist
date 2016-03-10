package com.sist.view;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import com.sist.dao.*;
public class EmpListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//404 ���� : ���� ��ã����
	//500 ���� : �ҽ� �߸����� �� => output�ʿ��� Ȯ��
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=EUC-KR"); //������ ���� : response �޴� ���� : request
		//PrintWriter = outputStream
		PrintWriter out=response.getWriter();
		//OutputStream out=s.getOutputStream();
		EmpDAO dao=new EmpDAO();
		ArrayList<EmpDTO> list=dao.empAllData();
		// ȭ�� ��� 
		/*
		 *   html => ML
		 *   		====
		 *   		�±�<>
		 *          �������
		 *          => �±� + �Ӽ�
		 *          <table border=0>
		 *          </table>
		 *          <br/> empty tag
		 */
		out.println("<html>");
		out.println("<head>");
		out.println("<style type=text/css>");
		out.println("th,td{font-family:���� ���;font-size:9pt}"); //font-family:�۲ú���
		out.println("a{text-decoration:none;color:black}"); //none : ������� ����
		out.println("a:hover{text-decoration:underline;color:green}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<center>");
		out.println("<h3>��� ���</h3>");
		out.println("<table border=0 width=600>");
		out.println("<tr bgcolor=#ccccff>");
		out.println("<th>���</th>");
		out.println("<th>�̸�</th>");
		out.println("<th>����</th>");
		out.println("<th>�μ���</th>");
		out.println("<th>�ٹ���</th>");
		out.println("<th>���</th>");
		out.println("</tr>");
		//id => �ߺ��� ������ ��� �ҷ��ö� #���� �ҷ���
		//class => �ߺ��� ������ ��� �ҷ��ö� .���� �ҷ���
		for(EmpDTO d:list)
		{
			out.println("<tr>");
			out.println("<td>"+d.getEmpno()+"</td>");
			out.println("<td>");
			out.println("<a href=EmpDetailServlet?empno="+d.getEmpno()+">"); //�ٸ� �������� ������ ����
			out.println(d.getEname()+"</a>");
			out.println("</td>");
			out.println("<td>"+d.getJob()+"</td>");
			out.println("<td>"+d.getDdto().getDname()+"</td>");
			out.println("<td>"+d.getDdto().getLoc()+"</td>");
			out.println("<td>"+d.getSdto().getGrade()+"</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("<hr width=600>"); //<hr> : ����
		out.println("<table border=0 width=600>");
		out.println("<tr>");
		out.println("<td align=left>"); //��������
		out.println("Search:");
		out.println("<select>"); //combobox => select
		out.println("<option value=ename>�̸�</option>"); //option: addItem
		out.println("<option value=deptno>�μ�</option>"); //value �� ����(column�� �ڵ����� �ٲ�)
		out.println("<option value=hiredate>�Ի���</option>");
		out.println("</select>");
		out.println("<input type=text size=12>"); //�Է�â
		out.println("<input type=button value=ã��>");
		/*
		 *   1) �Է¶�
		 *      <input type=()>
		 *        type=text : ���ٹ��ڿ�
		 *        type=password : ��й�ȣ
		 *        type=checkbox
		 *        type=radio
		 *        type=image => button(submit) ������ �����ϴ� ��ư
		 *        type=submit => ������ ���� ��ư
		 *        type=reset => �ʱ�ȭ
		 *        type=button => ����� ����(JS�̿�)
		 *        ============================================ �������
		 *        type=date
		 *        type=number
		 *        type=email
		 *        type=updown
		 *        ============================================ html5
		 *        <textarea> : ������ �Է�
		 *        <select> : �޺��ڽ�
		 *        
		 *        <br> => \n
		 *        <p> => �ܶ� ���� �� => <br><br>
		 *        &nbsp; => ����
		 *        <hr> => ����
		 *        <a> => ��ũ
		 *        <img> => �̹��� ���
		 *        
		 *        ============================================
		 *        ���â
		 *        <table>
		 *        <div>
		 *        ============================================
		 *        <form> : ���۹��, ������ ����
		 *        ============================================
		 *        <fieldset> : �ʵ带 ��ü�� ��� ����
		 *        
		 *        <nav> : �޴����鶧
		 *        <header> : Ÿ��Ʋ��
		 *        <section> : �������
		 *        <aside> : article ���ʿ��� �������� ���� ��� �±�
		 *        <footer> : �ּ� ����
		 *        ============================================
		 */
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
		
	}

}
