package polymorphism_3_1_2;

public class SamsungTV implements TV {

	@Override
	public void powerOn() {
		System.out.println("�ＺTV -- ������ �Ҵ�");

	}

	@Override
	public void powerOff() {
		System.out.println("�ＺTV -- ������ ����");
	}

	@Override
	public void volumeUp() {
		System.out.println("�ＺTV -- �Ҹ��� ���δ�");

	}

	@Override
	public void volumeDown() {
		System.out.println("�ＺTV -- �Ҹ��� �����");

	}

}
