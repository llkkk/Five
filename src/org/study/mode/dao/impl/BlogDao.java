package org.study.mode.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.study.mode.dao.IBlogDao;
import org.study.mode.pojo.Blog;
import org.study.util.DBConnection;

public class BlogDao implements IBlogDao {
	
	@Override
	public List<Blog> selectBlog() {
		// TODO Auto-generated method stub
		List<Blog> lst=new ArrayList<>();
		Connection con = DBConnection.getConnection();
		PreparedStatement pre = null;
		ResultSet rs = null;
		String sql = "select blog.*,myuser.name from blog,myuser where myuser.userid=blog.userid order by DAYOFPUBLICATION DESC";
		try {
			pre = con.prepareStatement(sql);
			rs = pre.executeQuery();
			while (rs.next()) {
				String s=rs.getString(5);
				Date dop=null;
				try {
					dop = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(s);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Blog b = new Blog(rs.getString(1),rs.getString(2), rs.getString(3), rs.getString(4),dop, rs.getInt(6),rs.getString(7));
				lst.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(con, pre, rs);
		}
		return lst;
	}

	@Override
	public int insertBlog(Blog b) {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		PreparedStatement pre = null;
		String sql = "insert into blog values(?,?,?,?,?,?)";
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1,b.getBlogId());
			pre.setString(2,b.getUserId());
			pre.setString(3, b.getBlogName());
			pre.setString(4, b.getBlogContent());
			pre.setString(5, b.getBlogDate());
			pre.setInt(6, b.getCmtNum());
			int i = pre.executeUpdate();
			if (i > 0) {
				return i;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(con, pre);
		}
		return 0;
	}

	@Override
	public int deleteBlog(String bid) {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		PreparedStatement pre = null;
		String sql = "delete blog where blogid = ?";
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1,bid);
			int i = pre.executeUpdate();
			if (i > 0) {
				return i;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(con, pre);
		}
		return 0;
	}

	@Override
	public Blog selectBlogByBid(String bid) {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		PreparedStatement pre = null;
		ResultSet rs = null;
		Blog b=null;
		String sql = "select blog.*,myuser.name from blog,myuser where blogid=? and myuser.userid=blog.userid";
		try {
			pre=con.prepareStatement(sql);
			pre.setString(1, bid);
			rs=pre.executeQuery();
			while (rs.next()){
				String s=rs.getString(5);
				Date dop=null;
				try {
					dop = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(s);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				b=new Blog(bid, rs.getString(2), rs.getString(3), rs.getString(4), dop, rs.getInt(6), rs.getString(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBConnection.close(con, pre,rs);
		}
		return b;
	}

	@Override
	public int updateCmtNum(String bid,int cmtNum, boolean iod) {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		PreparedStatement pre = null;
		if(iod) cmtNum++;
		else cmtNum--;
		if(cmtNum<0) cmtNum=0;
		String sql="update blog set cmtnum=? where blogid=?";
		try {
			pre=con.prepareStatement(sql);
			pre.setInt(1, cmtNum);
			pre.setString(2, bid);
			pre.executeUpdate();
			if(cmtNum>0) return cmtNum;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBConnection.close(con, pre);
		}
		return 0;
	}

	@Override
	public List<Blog> selectBlogByUserId(String userId) {
		// TODO Auto-generated method stub
		List<Blog> lst=new ArrayList<>();
		Connection con = DBConnection.getConnection();
		PreparedStatement pre = null;
		ResultSet rs = null;
		String sql = "select blog.*,myuser.name from blog,myuser where myuser.userid=? and myuser.userid=blog.userid order by DAYOFPUBLICATION DESC";
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, userId);
			rs = pre.executeQuery();
			while (rs.next()) {
				String s=rs.getString(5);
				Date dop=null;
				try {
					dop = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(s);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Blog b = new Blog(rs.getString(1),rs.getString(2), rs.getString(3), rs.getString(4),dop, rs.getInt(6),rs.getString(7));
				lst.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(con, pre, rs);
		}
		return lst;
	}

}
