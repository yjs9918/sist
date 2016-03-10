
package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.*;
import java.sql.ResultSet;

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
		// 기능 => List selectList(sql,int page)
		public List<EmpDTO> empAllData(int page) //페이지 나누기
		{
			List<EmpDTO> list = new ArrayList<EmpDTO>();
			try
			{
				getConnection();
				int rowSize=5;
				int start=(rowSize*page)-(rowSize-1); //오라클은 1부터 시작한다.
				int end=rowSize*page;
				//rownum BETWEEN start AND end
				//                 1        5
				//                 6        10
				String sql="SELECT empno,ename,job,hiredate,deptno,num "
						+"FROM (SELECT empno,ename,job,hiredate,deptno,rownum as num "
						+"FROM (SELECT empno,ename,job,hiredate,deptno "
						+"FROM emp ORDER BY empno DESC)) " // 테이블을 복사해서 만들어둔다.
						+"WHERE num BETWEEN "+start+" AND "+end;
				ps=conn.prepareStatement(sql);
				// SQL문장을 실행후에 결과를 받는다
				ResultSet rs=ps.executeQuery(); //rs가 결과값을 가지고 있다.
				while(rs.next())
				{
					EmpDTO d=new EmpDTO();
					d.setEmpno(rs.getInt(1));
					d.setEname(rs.getString(2));
					d.setJob(rs.getString(3));
					d.setHiredate(rs.getDate(4));
					d.setDeptno(rs.getInt(5));
					list.add(d);
				}
				rs.close();
			}catch(Exception ex)
			{
				System.out.println(ex.getMessage());
			}
			finally
			{
				disConnection();
			}
			return list;
		}
		public int empTotalPage() //총페이지
		{
			int total=0;
			try
			{
				getConnection();
				String sql="SELECT CEIL(COUNT(*)/5) FROM emp";
				ps=conn.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
				rs.next(); //연결 한번
				total=rs.getInt(1);
				rs.close();
			}catch(Exception ex)
			{
				System.out.println(ex.getMessage());
			}
			finally
			{
				disConnection();
			}
			return total;
		}
		/*public ArrayList<String> getMgr()
		{
			ArrayList<String> mgr=new ArrayList<String>();
			try
			{
				getConnection();
				String sql="SELECT Distinct empno FROM emp";
				ps=conn.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					mgr.add(rs.getString(1));
				}
			}catch(Exception ex)
			{
				System.out.println(ex.getMessage());
			}
			finally
			{
				disConnection();
			}
			return mgr;
		}
		public ArrayList<String> getjob()
		{
			ArrayList<String> job=new ArrayList<String>();
			try
			{
				getConnection();
				String sql="SELECT DISTINCT job FROM emp";
				ps=conn.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					job.add(rs.getString(1));
				}
			}catch(Exception ex)
			{
				System.out.println(ex.getMessage());
			}
			finally
			{
				disConnection();
			}
			return job;
		}*/
		// INSERT 관련
		public List<String> empGetJob()
		{
			List<String> list=new ArrayList<String>();
			try
			{
				getConnection();
				String sql="SELECT DISTINCT job FROM emp";
				ps=conn.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					list.add(rs.getString(1));
				}
				rs.close();
			}catch(Exception ex)
			{
				System.out.println(ex.getMessage());
			}
			finally
			{
				disConnection();
			}
			return list;
		}
		public List<Integer> empGetMgr()
		{
			List<Integer> list=new ArrayList<Integer>();
			try
			{
				getConnection();
				String sql="SELECT DISTINCT mgr FROM emp WHERE mgr IS NOT NULL";
				ps=conn.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					list.add(rs.getInt(1));
					// Integer i=10 (AutoBoxing)
					// int ii=i;
				}
				rs.close();
			}catch(Exception ex)
			{
				System.out.println(ex.getMessage());
			}
			finally
			{
				disConnection();
			}
			return list;
		}
		//Insert
		public void empInsert(EmpDTO d)
		{
			try
			{
				getConnection();
				String sql="INSERT INTO emp VALUES("
						+"(SELECT MAX(empno)+1 FROM emp),"
						+"?,?,?,SYSDATE,?,?,?)"; //사용자가 보낸 값은 ? 로 표현
				ps=conn.prepareStatement(sql);
				ps.setString(1, d.getEname());//홍길동 => '홍길동'
				ps.setString(2, d.getJob());
				ps.setInt(3, d.getMgr());
				ps.setInt(4, d.getSal());
				ps.setInt(5, d.getComm());
				ps.setInt(6, d.getDeptno());
				//실행
				ps.executeUpdate(); //commit 포함
			}catch(Exception ex)
			{
				System.out.println(ex.getMessage());
			}
			finally {
				disConnection();
			}
		}
		public EmpDTO empDetailData(int empno)
		{
			EmpDTO d=new EmpDTO();
			try
			{
				getConnection();
				String sql="SELECT empno,ename,job,mgr,hiredate,sal,comm,dname,loc "
						+"FROM emp JOIN dept "
						+"ON emp.deptno=dept.deptno "
						+"AND empno=?";
				ps=conn.prepareStatement(sql);
				ps.setInt(1, empno);
				ResultSet rs=ps.executeQuery();
				rs.next(); //한줄 가져오기
				d.setEmpno(rs.getInt(1));
				d.setEname(rs.getString(2));
				d.setJob(rs.getString(3));
				d.setMgr(rs.getInt(4));
				d.setHiredate(rs.getDate(5));
				d.setSal(rs.getInt(6));
				d.setComm(rs.getInt(7));
				d.getDdto().setDname(rs.getString(8));
				d.getDdto().setLoc(rs.getString(9));
			}catch(Exception ex)
			{
				System.out.println(ex.getMessage());
			}
			finally
			{
				disConnection();
			}
			return d;
		}
}

























