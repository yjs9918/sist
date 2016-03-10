package com.sist.dao;
import java.sql.*;
/*
 *   Connection : ����Ŭ ���� ==> Socket
 *   PreparedStatement : SQL ���� ���� , ������� �о�´� ==> Reader,Writer
 *   ResultSet : ����� ���� => �޸�
 *   
 *   1) ����̹� ���
 *   	Class.forName("����̹� Ŭ������")    ojdbc6.jar(�ݵ�� �����ؾ��� => ����Ŭ�� application�� �������ִ� ���� => thin driver)
 *   	=============
 *   		�޸� �Ҵ� (���÷���) : Ŭ���������� �о �޸� �Ҵ�, �޼ҵ� ȣ��, ������� ���� 
 *   		new ��� x (���ռ��� ���� ���α׷��� ����� �ȵ�) => new ��ſ� Class.forName ���
 *   	=> ����Ŭ�� ���� �غ�
 *   2) ����Ŭ ���� ��ü�� ���´�
 *   	Connection => getConnection(URL,USERNAME,PWD)
 *   3) SQL���� ����
 *   	Statement
 *   	  = executeQuery : SELECT (��� �� �޾ƿö�)
 *   	  = executeUpdate : INSERT,UPDATE,DELETE (��ü������ ������ ��)
 *   4) ����� �ޱ�
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
 *   5) ����
 *   	ResultSet => close
 *   	Statement => close
 *   	Connection => close
 *   
 */
import java.util.*; //ArrayList
public class EmpDAO {
	// ���� ��ü ���
	private Connection conn;
	// ���� ���� ��ü
	private PreparedStatement ps;
	// URL
	private final String URL = "jdbc:oracle:thin:@211.238.142.76:1521:ORCL";
	// DRIVER
	private final String DRIVER="oracle.jdbc.driver.OracleDriver"; //����Ŭ ����̹� Ŭ����
	//USER NAME
	private final String USER="scott";
	// PWD
	private final String PWD="tiger";
	// ����̹� ���
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
	// ���� ��ü ���
	public void getConnection(){
		try
		{
			conn=DriverManager.getConnection(URL,USER,PWD);
			// conn scott/tiger
		}catch(Exception ex){}
	}
	// ���� ����
	public void disConnection()
	{
		try 
		{
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		} catch (Exception ex) {}
	}
	// ���
	// 1. emp�� ��ϵ� ��� ����� ��� JOIN
	public ArrayList<EmpDTO> empAllData()
	{
		ArrayList<EmpDTO> list=new ArrayList<EmpDTO>();
		try 
		{
			getConnection(); //����
			String sql="SELECT empno,ename,job,dname,loc,grade FROM emp,dept,salgrade WHERE emp.deptno=dept.deptno AND sal BETWEEN losal AND hisal";
			// ����Ŭ ����
			ps=conn.prepareStatement(sql);
			// SQL������ �����Ŀ� ����� �޴´�
			ResultSet rs=ps.executeQuery(); //rs�� ����� ������ ����
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
	// 2. emp�� ��ϵ� ����� �󼼺��� JOIN
	public EmpDTO empDetail(int empno)
	{
		EmpDTO d=new EmpDTO();
		return d;
	}
	// 3. emp�� ã�� => �̸�,�μ�,�Ի��� 
	// column : �̸�,�μ�,�Ի���        data: �Է°�
	public ArrayList<EmpDTO> empFind(String column,String data)
	{
		ArrayList<EmpDTO> list=new ArrayList<EmpDTO>();
		return list;
	}

}











