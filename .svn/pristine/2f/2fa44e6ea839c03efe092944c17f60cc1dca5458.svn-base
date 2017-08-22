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

import org.study.mode.dao.ICmtDao;
import org.study.mode.pojo.Cmt;
import org.study.util.DBConnection;

public class CmtDao implements ICmtDao {

	@Override
	public int insertCmt(Cmt c) {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		PreparedStatement pre = null;
		String sql = "insert into cmt values(?,?,?,?,?)";
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, c.getCmtId());
			pre.setString(2, c.getBlogId());
			pre.setString(3, c.getUserId());
			pre.setString(4, c.getCmtContent());
			pre.setString(5, c.getDayOfCmt());
			int i = pre.executeUpdate();
			if (i > 0)
				return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(con, pre);
		}
		return 0;
	}

	@Override
	public int deleteCmt(String cid) {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		PreparedStatement pre = null;
		String sql = "delete cmt where cmtid = ?";
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, cid);
			int i = pre.executeUpdate();
			if (i > 0)
				return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(con, pre);
		}
		return 0;
	}

	@Override
	public List<Cmt> selectCmtByBlogId(String bid) {
		// TODO Auto-generated method stub
		List<Cmt> lst=new ArrayList<>();
		Connection con = DBConnection.getConnection();
		PreparedStatement pre = null;
		ResultSet rs = null;
		String sql = "select cmt.*,myuser.name from cmt,myuser where cmt.blogid=? and myuser.userid=cmt.userid order by DAYOFCMT";
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, bid);
			rs = pre.executeQuery();
			while(rs.next()){
				String s=rs.getString(5);
				Date doc=null;
				try {
					doc = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(s);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Cmt c=new Cmt(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),doc,rs.getString(6));
				lst.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBConnection.close(con, pre,rs);
		}
		return lst;
	}

}
