package com.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlsessionFactory;
import com.dao.OracleMyBatisDAO;
import com.dto.Dept;

public class OracleMyBatisService {

	OracleMyBatisDAO dao;
	
	public OracleMyBatisService() {
		dao =new OracleMyBatisDAO();
	}

	public List<Dept> selectAll() {
		SqlSession session = MySqlsessionFactory.getSession();
		List<Dept> list = null;
		try {
			list = dao.selectAll(session);//jdbc버전의 con 전달과 비슷
		}finally {
			session.close();
		}
		return list;
	}//end select

	public void insert(Dept dept) {
		SqlSession session = MySqlsessionFactory.getSession();
		try {
			dao.insert(session,dept);
			session.commit();  //명시적으로 
		}finally {
			session.close();
		}
		
	}//end insert

	public void update(Dept dept) {
		SqlSession session = MySqlsessionFactory.getSession();
		try {
			dao.update(session,dept);
			session.commit();  //명시적으로 
		}finally {
			session.close();
		}
	}//end update

	public void delete(int deptno) {
		SqlSession session = MySqlsessionFactory.getSession();
		try {
			dao.delete(session, deptno);
			session.commit();  //명시적으로 
		}finally {
			session.close();
		}
		
	}

	public Dept selectByDeptno(int deptno) {
		SqlSession session = MySqlsessionFactory.getSession();
		Dept dept=null;
		try {
			dept = dao.selectByDeptno(session,deptno);
		}finally {
			session.close();
		}
		return dept;
	}

	public int deptRecordCount() {
		SqlSession session = MySqlsessionFactory.getSession();
		int num=0;
		try {
			num = dao.deptRecordCount(session);
		}finally {
			session.close();
		}
		return num;
	}
	public HashMap selectByDeptnoHashmap(int deptno) {
		SqlSession session = MySqlsessionFactory.getSession();
		HashMap dept=null;
		try {
			dept = dao.selectByDeptnoHashmap(session,deptno);
		}finally {
			session.close();
		}
		return dept;
	}

	public List<Dept> selectByHashmap(HashMap<String, Integer> map) {
		SqlSession session = MySqlsessionFactory.getSession();
		List<Dept> list =null;
		try {
			list = dao.selectByHashmap(session,map);
		}finally {
			session.close();
		}
		return list;
	}

	public List<Dept> selectDynamicDeptno(HashMap<String, Integer> map) {
		SqlSession session = MySqlsessionFactory.getSession();
		List<Dept> list =null;
		try {
			list = dao.selectDynamicDeptno(session,map);
		}finally {
			session.close();
		}
		return list;
	}

	public List<Dept> selectDynamicChoose(HashMap<String, String> map3) {
		SqlSession session = MySqlsessionFactory.getSession();
		List<Dept> list =null;
		try {
			list = dao.selectDynamicChoose(session,map3);
		}finally {
			session.close();
		}
		return list;
	}

	public List<Dept> multiSelect(List<Integer> deptnoes) {
		SqlSession session = MySqlsessionFactory.getSession();
		List<Dept> list =null;
		try {
			list =dao.multiSelect(session,deptnoes);
		}finally {
			session.close();
		}
		return list;
	}

	public void multiUpdate(List<Integer> deptnoes2) {
		SqlSession session = MySqlsessionFactory.getSession();
		try {
			dao.multiUpdate(session, deptnoes2);
			session.commit();
		}finally {
			session.close();
		}
		
	}//end multiUpdate

	public void multiDelete(List<Dept> deptList) {
		SqlSession session = MySqlsessionFactory.getSession();
		try {
			dao.multiDelete(session, deptList);
			session.commit();
		}finally {
			session.close();
		}
		
	}

	public void multiInsert(List<Dept> deptList) {
		SqlSession session = MySqlsessionFactory.getSession();
		try {
			dao.multiInsert(session, deptList);
			session.commit();
		}finally {
			session.close();
		}
		
	}

	public List<Dept> selectTopN(int i, int j) {
		SqlSession session = MySqlsessionFactory.getSession();
		List<Dept> list =null;
		try {
			list =dao.selectTopN(session,i,j);
		}finally {
			session.close();
		}
		return list;
	}
	
	public String getDate() {
		SqlSession session= MySqlsessionFactory.getSession();
		String date= null;
		try {
		 date= dao.getDate(session);
		}finally {
			session.close();
		}
		return date;
	}
}
