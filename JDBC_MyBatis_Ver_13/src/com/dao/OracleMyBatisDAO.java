package com.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.dto.Dept;

public class OracleMyBatisDAO {

	public List<Dept> selectAll(SqlSession session) {

		// id값만 사용하지 말고 namespace.id 형식 권장
		List<Dept> list = session.selectList("com.dept.DeptMapper.selectAll");

		return list;
	}

	public void insert(SqlSession session, Dept dept) {

		int n = session.insert("com.dept.DeptMapper.deptInsert", dept);

	}

	public void update(SqlSession session, Dept dept) {

		int n = session.update("com.dept.DeptMapper.deptUpdate", dept);

	}

	public void delete(SqlSession session, int deptno) {

		int n = session.delete("com.dept.DeptMapper.deptDelete", deptno);

	}

	public Dept selectByDeptno(SqlSession session, int deptno) {
		Dept dept = session.selectOne("com.dept.DeptMapper.selectByDeptno", deptno);
		return dept;
	}

	public int deptRecordCount(SqlSession session) {

		int num = session.selectOne("deptRecordCount");
		return num;
	}

	public HashMap selectByDeptnoHashmap(SqlSession session, int deptno) {
		HashMap map = session.selectOne("com.dept.DeptMapper2.selectByDeptnoHashmap", deptno);
		return map;
	}

	public List<Dept> selectByHashmap(SqlSession session, HashMap<String, Integer> map) {
		List<Dept> list = session.selectList("com.dept.DeptMapper2.selectByHashmap", map);

		return list;
	}

	public List<Dept> selectDynamicDeptno(SqlSession session, HashMap<String, Integer> map) {
		// id값만 사용하지 말고 namespace.id 형식 권장
		List<Dept> list = session.selectList("com.dept.DeptMapper2.selectDynamicDeptno", map);

		return list;
	}

	public List<Dept> selectDynamicChoose(SqlSession session, HashMap<String, String> map3) {
		// id값만 사용하지 말고 namespace.id 형식 권장
		List<Dept> list = session.selectList("com.dept.DeptMapper3.selectDynamicChoose", map3);

		return list;
	}

	public List<Dept> multiSelect(SqlSession session, List<Integer> deptnoes) {
		List<Dept> list = 
		session.selectList("com.dept.DeptMapper4.multiSelect", deptnoes);

		return list;
	}

	public void multiUpdate(SqlSession session, List<Integer> deptnoes2) {
		int n = session.update("com.dept.DeptMapper4.multiUpdate", deptnoes2);
		
	}

	public void multiDelete(SqlSession session, List<Dept> deptList) {
		int n = session.delete("com.dept.DeptMapper4.multiDelete", deptList);
		
	}

	public void multiInsert(SqlSession session, List<Dept> deptList) {
		int n = session.insert("com.dept.DeptMapper4.multiInsert", deptList);
		
	}
	public List<Dept> selectTopN(SqlSession session, int offset, int limit ) {//시작idx, select 갯수
		List<Dept> list = 
				session.selectList("com.dept.DeptMapper5.topN", null, new RowBounds(offset, limit));
		//selectList ("id", 검색어, RowBounds(시작idx, 갯수))
	
		

		return list;
	}
	
	public String getDate(SqlSession session) {
		String date= session.selectOne("com.dept.DeptMapper5.getDate");
		//System.out.println(date);
		return date;
	}
	
}
