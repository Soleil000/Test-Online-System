package com.hp.onlinexam.service.teacher;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hp.onlinexam.po.Pager;

public class PageService{

    private IQuestionService qs = new QuestionService();

    public Pager findPage(String key, String value, int page, int count) throws Exception {
        List quesList = qs.findAll(key, value);
		int totleCount = quesList.size();
		List queList = new ArrayList();
		if(((page-1)*count+count)<=totleCount)
			queList = quesList.subList((page-1)*count, (page-1)*count+count);	
		else
			queList = quesList.subList((page-1)*count, quesList.size());	
		Pager p = new Pager();
		p.setContent(queList);
		p.setCurrentPage(page);
		p.setCount(count);
		p.setTotalCount(totleCount);
		int totlePage = totleCount%count==0?totleCount/count:(totleCount/count)+1;
		p.setTotalPage(totlePage);
		return p;
    }
}
