package com.hp.onlinexam.dao.teacher;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hp.onlinexam.po.Papers;
import com.hp.onlinexam.util.DBUtil;

public class PapersDao implements IPapersDao {
	DBUtil db = new DBUtil();

	@Override
	public int save(Papers paper) {
		// TODO Auto-generated method stub
		String sql = "insert into stu_test(testId,courseId,time,score,wrongQueId,wrongAns,studentId,createDate) values (?,?,?,?,?,?,?,?)";
		try {
			db.execute(sql, new Object[] {paper.getTestId(),paper.getCourseId(),paper.getTime(),paper.getScore(),paper.getWrongQueId(),paper.getWrongAns(),paper.getStudentId(),paper.getCreateDate()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		String sql = "select st.*, c.name courseName, t.name testName from stu_test st,course c, test t where st.testId = t.id and st.courseId = c.id and studentId = ? ";
		if(!"".equals(name)) {
			sql += "and c.name like '%"+ name +"%'";
		}
		List testsList = new ArrayList();
		try {
			testsList = db.getQueryList(sql, new Object[] {studentId});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			testsList = new ArrayList();
			e.printStackTrace();
		}
		return testsList;
	}

	@Override
	public List getPaperCompare(int teaId, String key) {
		// TODO Auto-generated method stub
		Timestamp d = new Timestamp(System.currentTimeMillis());
		String sql = "SELECT sc.name className,sc.deptName,"
				+ "c.name courseName,t.name testName,t.endDate,"
				+ "t.id,AVG(st.score) avgScore FROM stu_class sc,stu_test st,"
				+ "course c,test t,student s,teacher te WHERE "
				+ "t.endDate<=? AND t.courseId = c.id AND "
				+ "t.teacherId = te.id AND FIND_IN_SET(sc.id,t.classIds) "
				+ "AND sc.id = s.classId AND st.testId = t.id "
				+ "AND st.studentId = s.id AND te.id = ? ";
		if(!"".equals(key)) {
			sql += "AND (t.name like '%"+ key +"%'";
			sql += " or c.name like '%"+ key +"%'";
			sql += " or sc.name like '%"+ key +"%') ";
		}
		sql += "GROUP BY sc.id,t.id";
		List evaList = new ArrayList();
		try {
			evaList = db.getQueryList(sql, new Object[] {d,teaId});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			evaList = new ArrayList();
			e.printStackTrace();
		}
		return evaList;
	}

	@Override
	public Map<String, Object> getPaperInfoByStudentId(int id, int studentId) {
		// TODO Auto-generated method stub
		String sql = "select t.name testName, t.questions, "
				+ "t.scores, c.name as courseName, sc.name className, st.* from test t, course c, stu_class sc, stu_test st, student s" + 
				" where st.testId=t.id and st.courseId = c.id and s.classId = sc.id and s.id = ? and st.id = ?";
		Map<String, Object> paperMap = new HashMap<String, Object>();
		try {
			paperMap = db.getObject(sql, new Object[] {studentId, id});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			paperMap = new HashMap<String, Object>();
			e.printStackTrace();
		}
		return paperMap;
	}

}
