package com.sist.dao;
/*
 *   DTO => 데이터베이스에서 값을 읽어서 저장
 *   => 웹,윈도우에 전송
 *   DESC emp (테이블 구조 먼저 확인)
 *   데이터형
 *   오라클                                                          자바
 *   CHAR(1~2000자)             
 *   VARCHAR2(1~4000자)
 *   CLOB(4GB저장)               => String
 *   =============================================== 문자형
 *   NUMBER(4)                 => int 
 *   NUMBER(7,2)               => double
 *   ===========               저장된 데이터가 정수면 int
 *   =============================================== 숫자형
 *   DATE , TIMESTAMP          => java.util.Date
 *   =============================================== 날짜형
 *   BLOB (4GB 저장) Binary 형태
 *   BFILE (4GB 저장) File 형태(동영상,사진) => java.io.InputStream
 *   =============================================== 기타형
 *   
 *   이름                                      널?      유형
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
// 읽기(getXXXX), 쓰기(setXXXX)
// JOIN 을 걸었을 땐 포함클래스!!!!!!!!
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
	//JOIN => 포함클래스로 사용!
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























