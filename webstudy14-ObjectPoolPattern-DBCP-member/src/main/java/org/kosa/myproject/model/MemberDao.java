package org.kosa.myproject.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class MemberDao {
	private static MemberDao instance = new MemberDao();
	//Database Connection Pool 객체의 표준 인터페이스 DataSource
	private DataSource dataSource;
	private MemberDao() {
		this.dataSource = DataSourceManager.getInstance().getDataSource();
	}
	public static MemberDao getInstance() {
		return instance;
	}
	public int getTotalMemberCount() throws SQLException {
		int totalCount=0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		try {
			con = this.dataSource.getConnection(); // dbcp로부터 connection 을 빌려온다
			String sql = "select count(*) from member";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				totalCount = rs.getInt(1);
			}
			
		}finally {
			closeAll(rs, pstmt, con);
		}
		
		return totalCount;
	}
	public void closeAll(ResultSet rs, PreparedStatement pstmt, Connection con) throws SQLException {
		if(rs!=null)
			rs.close();
		closeAll(pstmt,con);
	}
	public void closeAll(PreparedStatement pstmt, Connection con) throws SQLException {
		if(pstmt!=null)
			pstmt.close();
		if(con!=null)
			con.close();//컨넥션을 소멸 시키는 것이 아니라 DBCP에 컨넥션을 반납
	}
	
	public MemberVo findMemberById(String memberId) throws SQLException {
		MemberVo memberVo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			String sql = "SELECT id, password, name, address FROM member WHERE id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberId); // ?에 값 바인딩
			rs = pstmt.executeQuery();
			if (rs.next()) {
				memberVo = new MemberVo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 리소스 해제
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}
		return memberVo;
	}
	
	public List<MemberVo> findMemberListByAddress(String memberAddress) throws SQLException {
	    List<MemberVo> list = new ArrayList<>();
	    Connection con = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;

	    try {
	        con = dataSource.getConnection();
	        String sql = "SELECT id, name, address FROM member WHERE address = ?";
	        pstmt = con.prepareStatement(sql);
	        pstmt.setString(1, memberAddress);
	        rs = pstmt.executeQuery();

	        while (rs.next()) {
	            MemberVo memberVo = new MemberVo(rs.getString("id"), rs.getString("name"), rs.getString("address"));
	            list.add(memberVo);
	        }
	    } finally {
	        closeAll(rs, pstmt, con);
	    }

	    return list;
	}


}
