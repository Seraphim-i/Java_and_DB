package com.narae.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

class Update {

	void update(Scanner sc, Connection con) {

		// 리스트 출력
		Select select = new Select();
		select.list(con);
		System.out.println();

		// 사용자가 수정할 번호 입력
		// sc = new Scanner(System.in);
		System.out.print("내용을 수정할 회원의 번호를 입력하세요 : ");

		// 번호 저장
		int input = sc.nextInt();

		// 수정할 값 입력받기(이름, ID, 비밀번호, 등급)
		String name = "";
		String id = "";
		String pw = "";
		int grade;

		do {
			System.out.print("새 이름을 입력하세요(2자 이상 12자 이하) : ");
			name = sc.next();

		} while (name.length() < 2 || name.length() > 12);

		do {
			System.out.print("새 ID를 입력하세요(4자 이상 16자 이하) : ");
			id = sc.next();

		} while (id.length() < 4 || id.length() > 16);

		do {
			System.out.print("새 비밀번호를 입력하세요(8자 이상 32자 이하) : ");
			pw = sc.next();

		} while (pw.length() < 8 || pw.length() > 32);

		do {
			System.out.print("새 등급을 입력하세요(1 ~ 9) : ");
			grade = sc.nextInt();

		} while (grade < 1 || grade > 9);

		// sc.close();

		// 쿼리문 작성

		// con 객체 생성
		con = DBConn.getcon();

		// pstmt
		PreparedStatement pstmt = null;
		String sql = "UPDATE member SET member.mName = ?, member.mIdenti = ?, " + "member.mPass = ?, member.mGrade = ? "
				+ "WHERE member.mNumber = ?;";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, id);
			pstmt.setString(3, pw);
			pstmt.setInt(4, grade);
			pstmt.setInt(5, input);

		} catch (SQLException e) {
			e.printStackTrace();

		}

		// setString, setInt, ...
		try {
			int result = pstmt.executeUpdate();

			if (result == 1) {
				System.out.println();
				System.out.println("수정 성공. 다음과 같이 수정되었습니다.");
				System.out.println();
			} else {
				System.out.println("수정에 실패했습니다. (error : " + result + ")");
			}

			System.out.println();
			select.list(con);

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				
			}
		}
	}
}
