//package Reserve_Hardprogram;
import java.util.Scanner;

public class ReserveProgram {
	public static void main(String[] args) {
		System.out.println("************************************************************");
		System.out.println("************************************************************");
		System.out.println("**************** [ �������α׷��� �����մϴ� ] **************");
		System.out.println("************************************************************");
		System.out.println("************************************************************");
		System.out.println();

		Scanner sin = new Scanner(System.in);
		SeatType[] aSeatType = new SeatType[3];
		aSeatType[0] = new SeatType('S', 10); // S Ÿ�� �¼� ����
		aSeatType[1] = new SeatType('A', 10);// A Ÿ�� �¼� ����
		aSeatType[2] = new SeatType('B', 10);// B Ÿ�� �¼� ����
		int choice = 0;
		int type = 0;

		while (choice != 4) {
			System.out.print("����(1), ��ȸ(2), ���(3), ������(4)>>");
			choice = Integer.parseInt(sin.nextLine()); // ��ɼ���!!

			switch (choice) {
			case 1:// ����
				System.out.println("****** ����޴��� �����ϼ̽��ϴ�.");
				do {
					System.out.print("�¼����� S(1), A(2), B(3)>>");
					type = Integer.parseInt(sin.nextLine());
					if (type < 1 || type > 3) {
						System.out.println("�߸��� �¼� Ÿ���Դϴ�.");
					}
				} while (type > 3);
				aSeatType[type - 1].reserve(); // ����: reserve �޼ҵ� ȣ��
				break;

			case 2:// ��ȸ
				System.out.println("****** ��ȸ�޴��� �����ϼ̽��ϴ�.");
				for (int i = 0; i < aSeatType.length; i++)
					aSeatType[i].show(); // ��ȸ: show �޼ҵ� ȣ��
				System.out.println("******");
				break;

			case 3:// ���
				System.out.println("****** ��Ҹ޴��� �����ϼ̽��ϴ�.");
				do {
					System.out.print("�¼����� S(1), A(2), B(3)>>");
					type = Integer.parseInt(sin.nextLine());
					if (type < 1 || type > 3) {
						System.out.println("�߸��� �¼� Ÿ���Դϴ�.");
					}
				} while (type > 3);
				aSeatType[type - 1].cancel(); // ���: cancel �޼ҵ� ȣ��

				break;

			case 4:// ������
				System.out.println("*** �������α׷��� �����մϴ� ***");
				break;

			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			}
		}
	}
}