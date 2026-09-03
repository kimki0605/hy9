package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MemberDAO {
	
	//회원정보 조회 메소드
	public ArrayList<MemberDTO> memberSelect(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<MemberDTO> memList = new ArrayList<MemberDTO>();
		
		try {
			con = Util.getConn();
			String query = "select * from member";
			pstmt = con.prepareStatement(query);
			rs = pstmt
		}
	}
}
