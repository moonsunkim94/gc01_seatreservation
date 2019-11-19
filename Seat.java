//package Reserve_Hardprogram;
public class Seat {
	private String name; // �¼� ������ �̸�

	public Seat() {
		name = null;
	} // ������: name�� null�� ����

	public String getName() {
		return name;
	} // name�� ��ȯ

	public void resetName() {
		name = null;
	} // name�� null�� ����

	public void setName(String name) {
		this.name = name;
	} // �¼� ������ �̸��� ����

	public boolean isOccupied() { // �¼��� ��� �ִ��� üũ
		if (name == null) // �¼��� ��� ������ false ��ȯ
			return false;
		else // �¼��� ����Ǿ� ������ true ��ȯ
			return true;
	}

	public boolean match(String name) {// ������ �̸��� ���� ����� �̸��� ������ üũ
		if (name.equals(this.name)) // ������ �̸��� ���� ����� �̸��� ������ true ��ȯ
			return true;
		else
			return false;
	}
}