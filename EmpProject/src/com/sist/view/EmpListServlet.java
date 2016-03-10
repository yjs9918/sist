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
	//404 에러 : 파일 못찾을때
	//500 에러 : 소스 잘못됐을 때 => output쪽에서 확인
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=EUC-KR"); //보내는 정보 : response 받는 정보 : request
		//PrintWriter = outputStream
		PrintWriter out=response.getWriter();
		//OutputStream out=s.getOutputStream();
		EmpDAO dao=new EmpDAO();
		ArrayList<EmpDTO> list=dao.empAllData();
		// 화면 출력 
		/*
		 *   html => ML
		 *   		====
		 *   		태그<>
		 *          구성요소
		 *          => 태그 + 속성
		 *          <table border=0>
		 *          </table>
		 *          <br/> empty tag
		 */
		out.println("<html>");
		out.println("<head>");
		out.println("<style type=text/css>");
		out.println("th,td{font-family:맑은 고딕;font-size:9pt}"); //font-family:글꼴변경
		out.println("a{text-decoration:none;color:black}"); //none : 언더라인 없앰
		out.println("a:hover{text-decoration:underline;color:green}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<center>");
		out.println("<h3>사원 목록</h3>");
		out.println("<table border=0 width=600>");
		out.println("<tr bgcolor=#ccccff>");
		out.println("<th>사번</th>");
		out.println("<th>이름</th>");
		out.println("<th>직위</th>");
		out.println("<th>부서명</th>");
		out.println("<th>근무지</th>");
		out.println("<th>등급</th>");
		out.println("</tr>");
		//id => 중복이 없을때 사용 불러올때 #으로 불러옴
		//class => 중복이 있을때 사용 불러올때 .으로 불러옴
		for(EmpDTO d:list)
		{
			out.println("<tr>");
			out.println("<td>"+d.getEmpno()+"</td>");
			out.println("<td>");
			out.println("<a href=EmpDetailServlet?empno="+d.getEmpno()+">"); //다른 서블릿으로 데이터 전송
			out.println(d.getEname()+"</a>");
			out.println("</td>");
			out.println("<td>"+d.getJob()+"</td>");
			out.println("<td>"+d.getDdto().getDname()+"</td>");
			out.println("<td>"+d.getDdto().getLoc()+"</td>");
			out.println("<td>"+d.getSdto().getGrade()+"</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("<hr width=600>"); //<hr> : 수평선
		out.println("<table border=0 width=600>");
		out.println("<tr>");
		out.println("<td align=left>"); //왼쪽정렬
		out.println("Search:");
		out.println("<select>"); //combobox => select
		out.println("<option value=ename>이름</option>"); //option: addItem
		out.println("<option value=deptno>부서</option>"); //value 값 설정(column값 자동으로 바꿈)
		out.println("<option value=hiredate>입사일</option>");
		out.println("</select>");
		out.println("<input type=text size=12>"); //입력창
		out.println("<input type=button value=찾기>");
		/*
		 *   1) 입력란
		 *      <input type=()>
		 *        type=text : 한줄문자열
		 *        type=password : 비밀번호
		 *        type=checkbox
		 *        type=radio
		 *        type=image => button(submit) 데이터 전송하는 버튼
		 *        type=submit => 데이터 전송 버튼
		 *        type=reset => 초기화
		 *        type=button => 기능이 없다(JS이용)
		 *        ============================================ 공통버전
		 *        type=date
		 *        type=number
		 *        type=email
		 *        type=updown
		 *        ============================================ html5
		 *        <textarea> : 여러줄 입력
		 *        <select> : 콤보박스
		 *        
		 *        <br> => \n
		 *        <p> => 단락 나눌 때 => <br><br>
		 *        &nbsp; => 공백
		 *        <hr> => 수평선
		 *        <a> => 링크
		 *        <img> => 이미지 출력
		 *        
		 *        ============================================
		 *        출력창
		 *        <table>
		 *        <div>
		 *        ============================================
		 *        <form> : 전송방식, 전송할 파일
		 *        ============================================
		 *        <fieldset> : 필드를 전체로 모아 관리
		 *        
		 *        <nav> : 메뉴만들때
		 *        <header> : 타이틀바
		 *        <section> : 내용들어갈때
		 *        <aside> : article 안쪽에서 부차적인 내용 담는 태그
		 *        <footer> : 주소 쓸때
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
