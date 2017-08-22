package org.study.mode.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.study.mode.dao.IPersonDao;
import org.study.mode.pojo.Person;
import org.study.util.DBConnection;

public class PersonDao implements IPersonDao {

	@Override
	public Person login(String userName, String userpass) {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		PreparedStatement pre = null;
		ResultSet rs = null;

		String sql = "select * from myuser where name = ? and password = ?";
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, userName);
			pre.setString(2, userpass);
			rs = pre.executeQuery();
			while (rs.next()) {
				Person p = new Person(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getDate(6), rs.getDate(7), rs.getString(8), rs.getString(9), rs.getInt(10),
						rs.getString(11));
				return p;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(con, pre, rs);
		}
		return null;
	}

	public int insertPerson(Person p) {
		Connection con = DBConnection.getConnection();
		PreparedStatement pre = null;
		String sql = "insert into myuser values(?,?,?,?,?,?,?,?,?,?,?)";
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, p.getUserId());
			pre.setString(2, p.getUserName());
			pre.setString(3, p.getUserPass());
			pre.setInt(4, p.getAge());
			pre.setString(5, p.getSex());
			pre.setDate(6, p.getDayOfBirth());
			pre.setDate(7, p.getRegistrationdate());
			pre.setString(8, p.getEmail());
			pre.setString(9, p.getPhone());
			pre.setInt(10, p.getLimits());
			pre.setString(11, p.getAddress());
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

	public int updatePerson(Person p) {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		PreparedStatement pre = null;
		String sql = "update myuser set name = ?, age = ?, sex = ?,dayOfBirth = ?,"
				+ "email = ?, phone = ?, adress = ? where userid = ?";
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, p.getUserName());
			pre.setInt(2, p.getAge());
			pre.setString(3, p.getSex());
			pre.setDate(4, p.getDayOfBirth());
			pre.setString(5, p.getEmail());
			pre.setString(6, p.getPhone());
			pre.setString(7, p.getAddress());
			pre.setString(8, p.getUserId());
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
	public int deletePerson(String pid) {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		PreparedStatement pre = null;
		String sql = "delete myuser where userid = ?";
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, pid);
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
	public List<Person> selectPagePerson(int page) {
		// TODO Auto-generated method stub
		int i = page * 5;
		int j = i - 5;
		Connection con = DBConnection.getConnection();
		PreparedStatement pre = null;
		ResultSet rs = null;
		List<Person> list = new ArrayList<>();
		String sql = "select * from (select rownum r,p.* from myuser p where rownum<=?) t where t.r>?";
		try {
			pre = con.prepareStatement(sql);
			pre.setInt(1, i);
			pre.setInt(2, j);
			rs = pre.executeQuery();
			while (rs.next()) {
				Person p = new Person(rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6),
						rs.getDate(7), rs.getDate(8), rs.getString(9), rs.getString(10), rs.getInt(11),
						rs.getString(12));
				p.setNum(rs.getInt(1));
				list.add(p);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(con, pre, rs);
		}
		return null;
	}

	@Override
	public int updateCount(int count) {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		PreparedStatement pre = null;
		String sql = "update count set count = ? where id = 1";
		try {
			pre = con.prepareStatement(sql);
			pre.setInt(1, count);
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
	public int selectCount() {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		PreparedStatement pre = null;
		ResultSet rs = null;
		String sql = "select count from count where id = 1";
		try {
			pre = con.prepareStatement(sql);
			rs = pre.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
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
	public boolean isUsed(String name) {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		PreparedStatement pre = null;
		ResultSet rs = null;
		String sql = "select * from myuser where name = ? ";
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, name);
			rs = pre.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(con, pre, rs);
		}
		return false;
	}

	@Override
	public int getMaxPage() {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		String sql = "select sum(1) from myuser";
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		int maxpage = -1;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			int num = 0;
			while (rs.next()) {
				num = rs.getInt(1);
			}
			maxpage = num / 5;
			if (num % 5 != 0)
				maxpage++;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(con, pstmt, rs);
		}
		return maxpage;
	}

	@Override
	public List<Person> selectAllUser() {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		List<Person> lst = new ArrayList<Person>();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = "select * from myuser order by limits DESC";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Person p = new Person(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getDate(6), rs.getDate(7), rs.getString(8), rs.getString(9), rs.getInt(10),
						rs.getString(11));
				lst.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(con, pstmt, rs);
		}
		return lst;
	}

	@Override
	public int updatePwd(String pid, String newPwd) {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		String sql = "update myuser set password=? where userid = ? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, newPwd);
			pstmt.setString(2, pid);
			int i = pstmt.executeUpdate();
			if (i > 0)
				return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(con, pstmt);
		}
		return 0;
	}

	@Override
	public int updateLimits(String pid, int limit) {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		String sql = "update myuser set limits=? where userid = ? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, limit);
			pstmt.setString(2, pid);
			int i = pstmt.executeUpdate();
			if (i > 0)
				return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(con, pstmt);
		}
		return 0;
	}

	@Override
	public int selectLimits(String pid) {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		String sql = "select limits from myuser where userid=?";
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		int limit = -1;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pid);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				limit = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(con, pstmt, rs);
		}
		return limit;
	}
}
