//package Reserve_Hardprogram;
import java.util.Scanner;

public class ReserveProgram {
	public static void main(String[] args) {
		System.out.println("************************************************************");
		System.out.println("************************************************************");
		System.out.println("**************** [ 예약프로그램을 시작합니다 ] **************");
		System.out.println("************************************************************");
		System.out.println("************************************************************");
		System.out.println();

		Scanner sin = new Scanner(System.in);
		SeatType[] aSeatType = new SeatType[3];
		aSeatType[0] = new SeatType('S', 10); // S 타입 좌석 생성
		aSeatType[1] = new SeatType('A', 10);// A 타입 좌석 생성
		aSeatType[2] = new SeatType('B', 10);// B 타입 좌석 생성
		int choice = 0;
		int type = 0;

		while (choice != 4) {
			System.out.print("예약(1), 조회(2), 취소(3), 끝내기(4)>>");
			choice = Integer.parseInt(sin.nextLine()); // 기능선탣!!

			switch (choice) {
			case 1:// 예약
				System.out.println("****** 예약메뉴를 선택하셨습니다.");
				do {
					System.out.print("좌석구분 S(1), A(2), B(3)>>");
					type = Integer.parseInt(sin.nextLine());
					if (type < 1 || type > 3) {
						System.out.println("잘못된 좌석 타입입니다.");
					}
				} while (type > 3);
				aSeatType[type - 1].reserve(); // 예약: reserve 메소드 호출
				break;

			case 2:// 조회
				System.out.println("****** 조회메뉴를 선택하셨습니다.");
				for (int i = 0; i < aSeatType.length; i++)
					aSeatType[i].show(); // 조회: show 메소드 호출
				System.out.println("******");
				break;

			case 3:// 취소
				System.out.println("****** 취소메뉴를 선택하셨습니다.");
				do {
					System.out.print("좌석구분 S(1), A(2), B(3)>>");
					type = Integer.parseInt(sin.nextLine());
					if (type < 1 || type > 3) {
						System.out.println("잘못된 좌석 타입입니다.");
					}
				} while (type > 3);
				aSeatType[type - 1].cancel(); // 취소: cancel 메소드 호출

				break;

			case 4:// 끝내기
				System.out.println("*** 예약프로그램을 종료합니다 ***");
				break;

			default:
				System.out.println("잘못 입력하셨습니다.");
			}
		}
	}
}