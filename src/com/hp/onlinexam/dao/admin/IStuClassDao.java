package com.hp.onlinexam.dao.admin;

import java.util.List;
import java.util.Map;

import com.hp.onlinexam.po.StuClass;

public interface IStuClassDao {

	public List findAllStuClassInfo(String name);

	public Map<String, Object> findStuClassById(int classId) ;

	public void addStuClass(StuClass sc) ;

	public void updateStuClassById(StuClass sc) ;
	
	public String findClassNamesByIds(String ids);

	/**
	 * 根据当前的教师id查询属于这个教师的班级
	 * @param teaId
	 * @return
	 */
	public void deleteStuClass(int classId);
	public List<StuClass> findStuClassesByTeacherId(int teaId);

	public List findClassNames();

}
