package com.narae.db;

import java.sql.Connection;
import java.util.Scanner;

public class Member {

	// insert
	// update
	// select
	// delete

	public void update(Scanner sc, Connection conn) {
		Update update = new Update();
		update.update(sc, conn);
	}

	public void insert(Scanner sc, Connection conn) {
		Insert insert = new Insert();
		insert.insert(sc, conn);
	}

	public void select(Connection conn) {
		Select select = new Select();
		select.list(conn);
	}

	public void delete(Scanner sc, Connection conn) {
		Delete delete = new Delete();
		delete.delete(sc, conn);
	}

	public static void main(String[] args) {

		// 객체
		Member member = new Member();
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("작업을 선택해주세요.");
			System.out.println("1. 입력    2. 수정    3. 삭제    4. 종료");
			System.out.println("----------------------------------------");
			System.out.print(">> ");
			
			int input = sc.nextInt();
			Connection conn = DBConn.getcon();

			switch (input) {
			case 0:
				System.out.println("리스트 출력");
				member.select(conn);
				System.out.println();
				break;
			case 1:
				System.out.println("입력");
				member.insert(sc, conn);
				break;
			case 2:
				System.out.println("수정");
				member.update(sc, conn);
				break;
			case 3:
				System.out.println("삭제");
				member.delete(sc, conn);
				break;
			case 4:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				break;
			default:
				System.out.println("다시 선택해주세요.");
			}
		}
	}
}
