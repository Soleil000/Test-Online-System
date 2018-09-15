package com.hp.onlinexam.service.admin;

import java.util.List;
import java.util.Map;

import com.hp.onlinexam.dao.admin.IStuClassDao;
import com.hp.onlinexam.dao.admin.StuClassDao;
import com.hp.onlinexam.po.StuClass;

public class StuClassService implements IStuClassService {

	private IStuClassDao scd = new StuClassDao();
	@Override
	public List findAll(String name) {
		// TODO Auto-generated method stub
		return scd.findAllStuClassInfo(name);
	}

	@Override
	public void addstuClass(StuClass sc) {
		// TODO Auto-generated method stub
		scd.addStuClass(sc);
	}

	@Override
	public void updateStuClass(StuClass sc) {
		// TODO Auto-generated method stub
		scd.updateStuClassById(sc);

	}

	@Override
	public void deleteStuClass(int classId) {
		// TODO Auto-generated method stub
		scd.deleteStuClass(classId);
	}

	@Override
	public Map<String, Object> findStuClassById(int id) {
		// TODO Auto-generated method stub
		
		return scd.findStuClassById(id);
	}

	@Override
	public String findClassNamesByIds(String ids) {
		// TODO Auto-generated method stub
		return scd.findClassNamesByIds(ids);
	}

	@Override
	public List<StuClass> findStuClassesByTeacherId(int teaId) {
		// TODO Auto-generated method stub
		return scd.findStuClassesByTeacherId(teaId);
	}

	@Override
	public List findClassNames() {
		// TODO Auto-generated method stub
		
		return scd.findClassNames();
	}

}
