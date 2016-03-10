package com.sist.dao;
import java.sql.*;
/*
 *   Connection : 오라클 연결 ==> Socket
 *   PreparedStatement : SQL 문장 전송 , 결과값을 읽어온다 ==> Reader,Writer
 *   ResultSet : 결과값 저장 => 메모리
 *   
 *   1) 드라이버 등록
 *   	Class.forName("드라이버 클래스명")    ojdbc6.jar(반드시 존재해야함 => 오라클과 application을 연결해주는 역할 => thin driver)
 *   	=============
 *   		메모리 할당 (리플렉션) : 클래스정보를 읽어서 메모리 할당, 메소드 호출, 멤버변수 제어 
 *   		new 사용 x (결합성이 강한 프로그램을 만들면 안됨) => new 대신에 Class.forName 사용
 *   	=> 오라클과 연결 준비
 *   2) 오라클 연결 객체를 얻어온다
 *   	Connection => getConnection(URL,USERNAME,PWD)
 *   3) SQL문장 전송
 *   	Statement
 *   	  = executeQuery : SELECT (결과 값 받아올때)
 *   	  = executeUpdate : INSERT,UPDATE,DELETE (자체적으로 갱신할 때)
 *   4) 결과값 받기
 *   	ResultSet
 *   	SELECT ename,job,hiredate
 *   	======================================
 *   	   ename        job         hiredate
 *   	======================================
 *   					BOF(Begin Of File)
 *   	======================================
 *   	    aaa         aaa           aaa      => next (bof -> eof)	
 *          bbb         bbb           bbb
 *          ccc         ccc           ccc	   => previous (eof -> bof)
 *   	======================================
 *   					EOF(End Of File)
 *   	======================================
 *   5) 종료
 *   	ResultSet => close
 *   	Statement => close
 *   	Connection => close
 *   
 */
import java.util.*; //ArrayList
public class EmpDAO {
	// 연결 객체 얻기
	private Connection conn;
	// 문장 전송 객체
	private PreparedStatement ps;
	// URL
	private final String URL = "jdbc:oracle:thin:@211.238.142.76:1521:ORCL";
	// DRIVER
	private final String DRIVER="oracle.jdbc.driver.OracleDriver"; //오라클 드라이버 클래스
	//USER NAME
	private final String USER="scott";
	// PWD
	private final String PWD="tiger";
	// 드라이버 등록
	public EmpDAO()
	{
		try
		{
			Class.forName(DRIVER);
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}
	// 연결 객체 얻기
	public void getConnection(){
		try
		{
			conn=DriverManager.getConnection(URL,USER,PWD);
			// conn scott/tiger
		}catch(Exception ex){}
	}
	// 연결 해제
	public void disConnection()
	{
		try 
		{
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		} catch (Exception ex) {}
	}
	// 기능
	// 1. emp에 등록된 사원 목록을 출력 JOIN
	public ArrayList<EmpDTO> empAllData()
	{
		ArrayList<EmpDTO> list=new ArrayList<EmpDTO>();
		try 
		{
			getConnection(); //연결
			String sql="SELECT empno,ename,job,dname,loc,grade FROM emp,dept,salgrade WHERE emp.deptno=dept.deptno AND sal BETWEEN losal AND hisal";
			// 오라클 전송
			ps=conn.prepareStatement(sql);
			// SQL문장을 실행후에 결과를 받는다
			ResultSet rs=ps.executeQuery(); //rs가 결과값 가지고 있음
			while(rs.next())
			{
				EmpDTO d=new EmpDTO();
				d.setEmpno(rs.getInt(1));
				d.setEname(rs.getString(2));
				d.setJob(rs.getString(3));
				d.getDdto().setDname(rs.getString(4));
				d.getDdto().setLoc(rs.getString(5));
				d.getSdto().setGrade(rs.getInt(6));
				
				list.add(d);
			}
			rs.close();
		} catch (Exception ex) 
		{
			System.out.println(ex.getMessage());
		}
		finally
		{
			disConnection();
		}
		return list;
	}
	// 2. emp에 등록된 사원의 상세보기 JOIN
	public EmpDTO empDetail(int empno)
	{
		EmpDTO d=new EmpDTO();
		return d;
	}
	// 3. emp에 찾기 => 이름,부서,입사일 
	// column : 이름,부서,입사일        data: 입력값
	public ArrayList<EmpDTO> empFind(String column,String data)
	{
		ArrayList<EmpDTO> list=new ArrayList<EmpDTO>();
		return list;
	}

}











