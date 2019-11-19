//package Reserve_Hardprogram;
public class Seat {
	private String name; // 좌석 예약자 이름

	public Seat() {
		name = null;
	} // 생성자: name에 null을 저장

	public String getName() {
		return name;
	} // name을 반환

	public void resetName() {
		name = null;
	} // name에 null을 저장

	public void setName(String name) {
		this.name = name;
	} // 좌석 예약자 이름을 저장

	public boolean isOccupied() { // 좌석이 비어 있는지 체크
		if (name == null) // 좌석이 비어 있으면 false 반환
			return false;
		else // 좌석이 예약되어 있으면 true 반환
			return true;
	}

	public boolean match(String name) {// 예약자 이름과 예약 취소자 이름이 같은지 체크
		if (name.equals(this.name)) // 예약자 이름과 예약 취소자 이름이 같으면 true 반환
			return true;
		else
			return false;
	}
}