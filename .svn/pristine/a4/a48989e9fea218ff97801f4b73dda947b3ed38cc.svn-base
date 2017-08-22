package org.study.mode.dao;

import java.util.List;

import org.study.mode.pojo.Blog;

public interface IBlogDao {
	public List<Blog> selectBlog();
	public int insertBlog(Blog b);
	public int deleteBlog(String bid);
	public Blog selectBlogByBid(String bid);
	public List<Blog> selectBlogByUserId(String userId);
	public int updateCmtNum(String bid,int cmtNum,boolean iod);//true增加，false减少.返回值是评论数
}
