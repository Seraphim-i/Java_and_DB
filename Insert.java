package com.narae.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

// 사용자 추가
class Insert {

	void insert(Scanner sc, Connection conn) {

		// 스캐너로 이름/아이디/비밀번호/등급을 받음
		// sc = new Scanner(System.in);
		String name = "";
		String id = "";
		String pw = "";
		int grade;

		do {
			System.out.print("이름을 입력하세요(2자 이상 12자 이하) : ");
			name = sc.next();

		} while (name.length() < 2 || name.length() > 12);

		do {
			System.out.print("ID를 입력하세요(4자 이상 16자 이하) : ");
			id = sc.next();

		} while (id.length() < 4 || id.length() > 16);

		do {
			System.out.print("비밀번호를 입력하세요(8자 이상 32자 이하) : ");
			pw = sc.next();

		} while (pw.length() < 8 || pw.length() > 32);

		do {
			System.out.print("등급을 입력하세요(1 ~ 9) : ");
			grade = sc.nextInt();

		} while (grade < 1 || grade > 9);

		// sc.close();

		// DB 접속
		PreparedStatement pstmt = null;
		conn = DBConn.getcon();

		String sql = "INSERT INTO member (member.mName, member.mIdenti, member.mPass, member.mGrade) "
				+ "VALUES (?, ?, ?, ?);";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, id);
			pstmt.setString(3, pw);
			pstmt.setInt(4, grade);

			// insert
			int result = pstmt.executeUpdate(); // select = execute, insert/delete/update = executeUpdate

			if (result == 1) {
				System.out.println();
				System.out.println("입력 성공");
				System.out.println();
			}

		} catch (SQLException e) {
			System.out.println("이름과 ID는 중복될 수 없습니다.");
			return;

		} finally {
			try {
				if (pstmt != null) { pstmt.close(); }
				if (conn != null) { conn.close(); }

			} catch (SQLException e) {
				e.printStackTrace();

			}
		}
		// End
	}
}
