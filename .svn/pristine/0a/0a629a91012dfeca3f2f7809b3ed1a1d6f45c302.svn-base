package org.study.mode.service.impl;

import java.util.List;
import java.util.UUID;

import org.study.mode.dao.IBlogDao;
import org.study.mode.dao.impl.BlogDao;
import org.study.mode.pojo.Blog;
import org.study.mode.service.IBlogService;

public class BlogService implements IBlogService {
	IBlogDao idao=new BlogDao();
	@Override
	public List<Blog> selectBlog() {
		// TODO Auto-generated method stub
		return idao.selectBlog();
	}
	@Override
	public int insertBlog(Blog b) {
		// TODO Auto-generated method stub
		b.setBlogId(UUID.randomUUID().toString());
		return idao.insertBlog(b);
	}
	@Override
	public int deleteBlog(String bid) {
		// TODO Auto-generated method stub
		return idao.deleteBlog(bid);
	}
	@Override
	public Blog selectBlogByBid(String bid) {
		// TODO Auto-generated method stub
		return idao.selectBlogByBid(bid);
	}
	@Override
	public int updateCmtNum(String bid, int cmtNum, boolean iod) {
		// TODO Auto-generated method stub
		return idao.updateCmtNum(bid, cmtNum, iod);
	}
	@Override
	public List<Blog> selectBlogByUserId(String userId) {
		// TODO Auto-generated method stub
		return idao.selectBlogByUserId(userId);
	}

}
