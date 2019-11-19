//package Reserve_Hardprogram;
import java.util.Scanner;

public class SeatType {
	private char type; // �¼� Ÿ��
	private Seat[] aSeat; // �¼� �迭

	public SeatType(char type, int num) { // ������: �¼� Ÿ�԰� �¼� �迭 ����
		this.type = type;
		aSeat = new Seat[num]; // �¼� �� ��ŭ �迭 ���� ����
		for (int i = 0; i < aSeat.length; i++)
			aSeat[i] = new Seat(); // �迭 aSeat[i]�� �¼� ��ü�� �����Ͽ� ����
	}

	public boolean reserve() { // ���� �޼ҵ�:������ ������ �Է¹޾� ������ ó���Ǹ� true ��ȯ
		Scanner sin = new Scanner(System.in);
		int seatNum;
		String name;
		
		show(); // �¼��� �����Ȳ�� �����ִ� �޼ҵ�
		System.out.print("�̸�>>");
		name = sin.nextLine();
		System.out.print("��ȣ>>");
		seatNum = Integer.parseInt(sin.nextLine());
		//System.out.println();
		
		if (seatNum < 1 || seatNum > aSeat.length) { // �������� �ʴ� �¼��̸� false ��ȯ
			System.out.println("�߸��� �¼���ȣ�Դϴ�.");
			return false;
		}
		
		if (aSeat[seatNum - 1].isOccupied()) { // �̹� ����� �¼��̸� false ��ȯ
			System.out.println("�̹� ����� �¼��Դϴ�.");
			return false;
		}
		aSeat[seatNum - 1].setName(name); // setName �޼ҵ� ȣ��
		System.out.println(type+"��� "+seatNum+"�� �ڸ��� "+name+"������ ����Ǿ����ϴ�." );
		return true; // "���� �߉��"
	}

	public boolean cancel() { // ��� �޼ҵ�: ���� ��Ұ� ���� ó���Ǹ� true ��ȯ
		Scanner sin = new Scanner(System.in);
		show();
		System.out.print("�̸�>>");
		String name = sin.nextLine(); // ����� ������ �̸� �Է�
		if (name != null) {
			for (int i = 0; i < aSeat.length; i++) {
				if (aSeat[i].match(name)) { // match �޼ҵ� ȣ��:������=����� �������̸�?
					aSeat[i].resetName(); // resetName �޼ҵ� ȣ��:������ �̸��� �ٽ� null�� ����
					return true;
				}
			}
			System.out.println("������ �̸��� ã�� �� �����ϴ�.");
		}
		return false; // ������ �̸��� ã�� ����
	}

	public void show() { // ��ȸ �޼ҵ�: �¼��� ����Ǿ� �ִ��� ��� �ִ����� ���
		System.out.print(type + ">> ");
		for (int i = 0; i < aSeat.length; i++) {
			System.out.print(i + 1 + ".");
			if (aSeat[i].isOccupied()) // ����� �¼��ΰ�?
				System.out.print(aSeat[i].getName()); // ������ �̸� ���
			else // �� �¼��̸� ��---�� ���
				System.out.print("---");
			System.out.print(" ");
		}
		System.out.println();
	}
}