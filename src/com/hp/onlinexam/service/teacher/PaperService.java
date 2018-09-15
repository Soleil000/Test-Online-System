package com.hp.onlinexam.service.teacher;

import java.util.List;
import java.util.Map;

import com.hp.onlinexam.dao.teacher.IPapersDao;
import com.hp.onlinexam.dao.teacher.PapersDao;
import com.hp.onlinexam.po.Papers;

public class PaperService implements IPaperService {

	IPapersDao pd = new PapersDao();
	@Override
	public int save(Papers paper) {
		// TODO Auto-generated method stub
		pd.save(paper);
		return 1;
	}

	@Override
	public List getPaperByStudentId(int studentId, int testId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getPaperByStudentId(int studentId, String name) {
		// TODO Auto-generated method stub
		return pd.getPaperByStudentId(studentId,name);
	}

	@Override
	public List getPaperCompare(int teaId, String key) {
		// TODO Auto-generated method stub
		return pd.getPaperCompare(teaId, key);
	}

	@Override
	public Map<String, Object> getPaperInfoByStudentId(int id, int studentId) {
		// TODO Auto-generated method stub
		return pd.getPaperInfoByStudentId(id, studentId);
	}

}
