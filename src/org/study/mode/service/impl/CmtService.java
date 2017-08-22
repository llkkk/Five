package org.study.mode.service.impl;

import java.util.List;
import java.util.UUID;

import org.study.mode.dao.ICmtDao;
import org.study.mode.dao.impl.CmtDao;
import org.study.mode.pojo.Cmt;
import org.study.mode.service.IBlogService;
import org.study.mode.service.ICmtService;

public class CmtService implements ICmtService {
	ICmtDao idao=new CmtDao();
	@Override
	public int insertCmt(Cmt c,int cmtNum) {
		// TODO Auto-generated method stub
		c.setCmtId(UUID.randomUUID().toString());
		IBlogService bs=new BlogService();
		bs.updateCmtNum(c.getBlogId(),cmtNum , true);
		return idao.insertCmt(c);
	}

	@Override
	public int deleteCmt(String cid,String bid,int cmtNum) {
		// TODO Auto-generated method stub
		IBlogService bs=new BlogService();
		bs.updateCmtNum(bid,cmtNum , false);
		return idao.deleteCmt(cid);
	}

	@Override
	public List<Cmt> selectCmtByBlogId(String bid) {
		// TODO Auto-generated method stub
		return idao.selectCmtByBlogId(bid);
	}

}
