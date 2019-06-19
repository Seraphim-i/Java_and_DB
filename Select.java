package com.narae.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class Select {

	void list(Connection conn) {

		// 데이터베이스 정보
		conn = DBConn.getcon();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// SQL
		String sql = "SELECT * FROM member;";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			System.out.println(
					"----------------------------------------------------------------------------------------------------------------------------------");
			System.out.printf("%s \t%s \t\t%s \t\t\t%s \t\t\t\t%s \t\t\t\t%s%n", 
					"번호", "이름", "ID", "비밀번호", "가입일", "등급");
			System.out.println(
					"----------------------------------------------------------------------------------------------------------------------------------");

			while (rs.next()) {
				int mno = rs.getInt(1);
				String mname = rs.getString(2);
				String mid = rs.getString(3);
				String mpw = rs.getString(4);
				String mdate = rs.getString(5);
				int mgrade = rs.getInt(6);

				System.out.printf("%-5d \t%-12s \t%-16s \t%-32s \t%-24s \t%-2d%n", mno, mname, mid, mpw, mdate, mgrade);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}

		// rs

		// print

		// END
	}
}
