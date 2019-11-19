//package Reserve_Hardprogram;
import java.util.Scanner;

public class SeatType {
	private char type; // 좌석 타입
	private Seat[] aSeat; // 좌석 배열

	public SeatType(char type, int num) { // 생성자: 좌석 타입과 좌석 배열 생성
		this.type = type;
		aSeat = new Seat[num]; // 좌석 수 만큼 배열 방을 생성
		for (int i = 0; i < aSeat.length; i++)
			aSeat[i] = new Seat(); // 배열 aSeat[i]에 좌석 객체를 생성하여 저장
	}

	public boolean reserve() { // 예약 메소드:예약자 정보를 입력받아 예약이 처리되면 true 반환
		Scanner sin = new Scanner(System.in);
		int seatNum;
		String name;
		
		show(); // 좌석의 현재상황을 보여주는 메소드
		System.out.print("이름>>");
		name = sin.nextLine();
		System.out.print("번호>>");
		seatNum = Integer.parseInt(sin.nextLine());
		//System.out.println();
		
		if (seatNum < 1 || seatNum > aSeat.length) { // 존재하지 않는 좌석이면 false 반환
			System.out.println("잘못된 좌석번호입니다.");
			return false;
		}
		
		if (aSeat[seatNum - 1].isOccupied()) { // 이미 예약된 좌석이면 false 반환
			System.out.println("이미 예약된 좌석입니다.");
			return false;
		}
		aSeat[seatNum - 1].setName(name); // setName 메소드 호출
		System.out.println(type+"등급 "+seatNum+"번 자리에 "+name+"님으로 예약되었습니다." );
		return true; // "예약 잘됬다"
	}

	public boolean cancel() { // 취소 메소드: 예약 취소가 정상 처리되면 true 반환
		Scanner sin = new Scanner(System.in);
		show();
		System.out.print("이름>>");
		String name = sin.nextLine(); // 취소할 예약자 이름 입력
		if (name != null) {
			for (int i = 0; i < aSeat.length; i++) {
				if (aSeat[i].match(name)) { // match 메소드 호출:예약자=취소할 예약자이름?
					aSeat[i].resetName(); // resetName 메소드 호출:예약자 이름을 다시 null로 저장
					return true;
				}
			}
			System.out.println("예약자 이름을 찾을 수 없습니다.");
		}
		return false; // 예약자 이름을 찾지 못함
	}

	public void show() { // 조회 메소드: 좌석이 예약되어 있는지 비어 있는지를 출력
		System.out.print(type + ">> ");
		for (int i = 0; i < aSeat.length; i++) {
			System.out.print(i + 1 + ".");
			if (aSeat[i].isOccupied()) // 예약된 좌석인가?
				System.out.print(aSeat[i].getName()); // 예약자 이름 출력
			else // 빈 좌석이면 “---” 출력
				System.out.print("---");
			System.out.print(" ");
		}
		System.out.println();
	}
}