package com.sist.emp;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 *   ���� ���α׷� : (��ȭ), �ܵ�, ����, ����, �����....
 *   ���� ���α׷� : ����, (���θ�).... => ���� ����
 *   ��Ƽ�̵�� : ������īTV, ���....,��Ʃ��
 *   ���� ���α׷� : �������...
 *   ERP : ���üũ, ���ڹ���
 *   ��Ÿ : �������α׷�
 */
public class EmpDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//doGet �޼ҵ� = run �޼ҵ�
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ���� Ÿ�� ���� : text/html, text/xml
		response.setContentType("text/html;charset=EUC-KR");
		PrintWriter out=response.getWriter(); //getOutputStream
		out.println("<html>");
		out.println("<body>");
		out.println("<center>");
		out.println("<h3>��� �� ����</h3>");
		out.println("<>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
	}
}
