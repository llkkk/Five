package org.study.mode.dao;

import java.util.List;

import org.study.mode.pojo.Cmt;

public interface ICmtDao {
	public int insertCmt(Cmt c);
	public int deleteCmt(String cid);
	public List<Cmt> selectCmtByBlogId(String bid);
}
