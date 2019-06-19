package com.narae.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

// 삭제하기
class Delete {

	void delete(Scanner sc, Connection conn) {

		// 리스트 출력
		Select select = new Select();
		select.list(null);
		System.out.println();

		// 지울 글 index 입력받기
		// sc = new Scanner(System.in);
		System.out.print("삭제할 회원의 번호를 입력하세요 : ");

		// 지정
		int input = sc.nextInt();

		// SQL
		String sql = "DELETE FROM member WHERE member.mNumber = ?;";
		conn = DBConn.getcon();
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, input);
			int result = pstmt.executeUpdate();

			if (result == 1) {
				System.out.println();
				System.out.println("삭제 완료");
				System.out.println();
			} else {
				System.out.println("삭제에 실패했습니다. (error : " + result + ")");
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
				// sc.close();
			} catch (SQLException e) {
				e.printStackTrace();

			}
		}
		// END
	}
}
