package com.hp.onlinexam.dao.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hp.onlinexam.po.StuClass;
import com.hp.onlinexam.util.DBUtil;

public class StuClassDao implements IStuClassDao {
	
	private DBUtil db = new DBUtil();
	
	@Override
	public List findAllStuClassInfo(String name) {
		// TODO Auto-generated method stub
		String sql = "select * from stu_class";
		if(!"".equals(name)) {
			sql += " where stu_class.name like '%"+ name +"%'";
		}
		List stuclassList = new ArrayList();
		try {
			stuclassList = db.getQueryList(StuClass.class, sql, new Object[] {});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			stuclassList = new ArrayList();
			e.printStackTrace(); 
		}
		
		return stuclassList;
	}

	@Override
	public Map<String, Object> findStuClassById(int classId) {
		// TODO Auto-generated method stub
		String sql = "select * from stu_class where id = ?";
		Map<String,Object> stuMap = new HashMap<String,Object>();
		try {
			stuMap = db.getObject(sql, new Object[] {classId});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			stuMap = new HashMap<String,Object>();
			e.printStackTrace();
		}
		return stuMap;
	}

	@Override
	public void addStuClass(StuClass sc) {
		// TODO Auto-generated method stub
		String sql = "insert into stu_class(name, deptName) values (?, ?)";
		try {
			db.execute(sql, new Object[] {sc.getName(),sc.getDeptName()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void updateStuClassById(StuClass sc) {
		// TODO Auto-generated method stub
		String sql = "update stu_class set name = ?, deptName = ? where id = ?";
		try {
			db.execute(sql, new Object[] {sc.getName(), sc.getDeptName(), sc.getId()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String findClassNamesByIds(String ids) {
		// TODO Auto-generated method stub
		String sql = "select * from stu_class where id in ("+ids+")";
		List<Map<String,Object>> nameList = new ArrayList<Map<String,Object>>();
		try {
			nameList = db.getQueryList(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			nameList = new ArrayList<Map<String,Object>>();
			e.printStackTrace();
		}
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<nameList.size(); i++) {
			sb.append(nameList.get(i).get("name")+" ");
		}
		return sb.toString();
	}

	@Override
	public void deleteStuClass(int classId) {
		// TODO Auto-generated method stub
		String sql = "delete from stu_class where id = ?";
		try {
			db.execute(sql, new Object[] {classId});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<StuClass> findStuClassesByTeacherId(int teaId) {
		// TODO Auto-generated method stub
		String sql = "select * from stu_class where id in (select classId from teach_course where teacherId = ?)";
		List stuClassList = new ArrayList();
		try {
			stuClassList = db.getQueryList(StuClass.class, sql, new Object[] {teaId});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			stuClassList = new ArrayList();
			e.printStackTrace();
		}
		return stuClassList;
	}
//	public static void main(String args[]) {
//		//声明的时候会向上转型:父类与子类之间，接口与实现类之间
//		//上转型好处：1.接口有多个实现改动少，多态
//		IStuClassDao scd = new StuClassDao();
//		List scList = scd.findAllStuClassInfo();
//	}

	@Override
	public List findClassNames() {
		// TODO Auto-generated method stub
		String sql = "select id, name from stu_class";
		List classList = new ArrayList();
		try {
			classList = db.getQueryList(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			classList = new ArrayList();
			e.printStackTrace();
		}
		return classList;
		
	}

}
