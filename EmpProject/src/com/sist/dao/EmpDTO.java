package com.sist.dao;
/*
 *   DTO => �����ͺ��̽����� ���� �о ����
 *   => ��,�����쿡 ����
 *   DESC emp (���̺� ���� ���� Ȯ��)
 *   ��������
 *   ����Ŭ                                                          �ڹ�
 *   CHAR(1~2000��)             
 *   VARCHAR2(1~4000��)
 *   CLOB(4GB����)               => String
 *   =============================================== ������
 *   NUMBER(4)                 => int 
 *   NUMBER(7,2)               => double
 *   ===========               ����� �����Ͱ� ������ int
 *   =============================================== ������
 *   DATE , TIMESTAMP          => java.util.Date
 *   =============================================== ��¥��
 *   BLOB (4GB ����) Binary ����
 *   BFILE (4GB ����) File ����(������,����) => java.io.InputStream
 *   =============================================== ��Ÿ��
 *   
 *   �̸�                                      ��?      ����
-------------------- -------- ----------------------------
EMPNO                NOT NULL NUMBER(4)
ENAME                         VARCHAR2(10)
JOB                           VARCHAR2(9)
MGR                           NUMBER(4)
HIREDATE                      DATE
SAL                           NUMBER(7,2)
COMM                          NUMBER(7,2)
DEPTNO                        NUMBER(2)
 */
// �б�(getXXXX), ����(setXXXX)
// JOIN �� �ɾ��� �� ����Ŭ����!!!!!!!!
import java.util.*;
public class EmpDTO {
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private Date hiredate;
	private int sal;
	private int comm;
	private int deptno;
	//JOIN => ����Ŭ������ ���!
	private DeptDTO ddto=new DeptDTO();
	private SalgradeDTO sdto=new SalgradeDTO();
	
	public DeptDTO getDdto() {
		return ddto;
	}
	public void setDdto(DeptDTO ddto) {
		this.ddto = ddto;
	}
	public SalgradeDTO getSdto() {
		return sdto;
	}
	public void setSdto(SalgradeDTO sdto) {
		this.sdto = sdto;
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getMgr() {
		return mgr;
	}
	public void setMgr(int mgr) {
		this.mgr = mgr;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public int getComm() {
		return comm;
	}
	public void setComm(int comm) {
		this.comm = comm;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
}























