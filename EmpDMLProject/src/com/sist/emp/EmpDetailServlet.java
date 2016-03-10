package com.sist.emp;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 *   예약 프로그램 : (영화), 콘도, 열차, 맛집, 여행사....
 *   결제 프로그램 : 은행, (쇼핑몰).... => 결제 서버
 *   멀티미디어 : 아프리카TV, 멜론....,유튜브
 *   관리 프로그램 : 매장관리...
 *   ERP : 출결체크, 전자문서
 *   기타 : 강좌프로그램
 */
public class EmpDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//doGet 메소드 = run 메소드
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 응답 타입 결정 : text/html, text/xml
		response.setContentType("text/html;charset=EUC-KR");
		PrintWriter out=response.getWriter(); //getOutputStream
		out.println("<html>");
		out.println("<body>");
		out.println("<center>");
		out.println("<h3>사원 상세 보기</h3>");
		out.println("<>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
	}
}
