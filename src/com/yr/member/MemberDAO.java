package com.yr.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.yr.util.DBConnect;

public class MemberDAO {

	public int insert(MemberDTO dto) throws Exception {
		Connection con = DBConnect.getConnect();
		
		String sql = "insert into member values(?,?,?,?,?)";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, dto.getId());
		st.setString(2, dto.getPw());
		st.setString(3, dto.getName());
		st.setInt(4, dto.getAge());
		st.setDate(5, dto.getBirth());
		
		int result = st.executeUpdate();
		
		return result;
		
	}
	
	public int delete(String id) throws Exception {
		Connection con = DBConnect.getConnect();
		
		String sql = "delete member where id=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, id);
		
		int result = st.executeUpdate();
		
		return result;
		
	}
	public ArrayList<MemberDTO> searchMember(String id) throws Exception {  // ~가 속한 id를 전부 검색
		Connection con = DBConnect.getConnect();
		String sql = "select * from member where id like ?";
		PreparedStatement st = con.prepareStatement(sql);
		
		
		st.setString(1, "%"+id+"%");
		ResultSet rs = st.executeQuery();
		MemberDTO dto = null;
		
		ArrayList<MemberDTO> ar = new ArrayList<MemberDTO>();
		while(rs.next()) {
			dto = new MemberDTO();
			dto.setId(rs.getString("id"));
			dto.setPw(rs.getString("pw"));
			dto.setName(rs.getString("name"));
			dto.setAge(rs.getInt("age"));
			dto.setBirth(rs.getDate("birth"));
			ar.add(dto);
		}
		
		return ar;
	}
	
	public MemberDTO searchId(String id) throws Exception {
		Connection con = DBConnect.getConnect();
		
		String sql = "select * from member where id=?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, id);
		ResultSet rs = st.executeQuery();
		MemberDTO dto = null;
		
		if(rs.next()) {
			dto = new MemberDTO();
			dto.setId(rs.getString("id"));
			dto.setPw(rs.getString("pw"));
			dto.setName(rs.getString("name"));
			dto.setAge(rs.getInt("age"));
			dto.setBirth(rs.getDate("birth"));
		}
		
		return dto;
		
	}
	
	public ArrayList<MemberDTO> selectList() throws Exception {
		Connection con = DBConnect.getConnect();
		
		String sql = "select * from member";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		MemberDTO dto = null;
		ArrayList<MemberDTO> ar = new ArrayList<MemberDTO>();
		
		
		while(rs.next()) {
			dto = new MemberDTO();
			dto.setId(rs.getString("id"));
			dto.setPw(rs.getString("pw"));
			dto.setName(rs.getString("name"));
			dto.setAge(rs.getInt("age"));
			dto.setBirth(rs.getDate("birth"));
			ar.add(dto);
		}
		
		return ar;
	}
	
}
