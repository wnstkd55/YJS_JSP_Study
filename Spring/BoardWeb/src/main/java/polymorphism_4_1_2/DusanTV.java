package polymorphism_4_1_2;

public class DusanTV implements TV {

	@Override
	public void powerOn() {
		System.out.println("�λ�TV - TV�� �մϴ�.");

	}

	@Override
	public void powerOff() {
		System.out.println("�λ�TV - TV�� ���ϴ�.");

	}

	@Override
	public void volumeUp() {
		System.out.println("�λ�TV - �Ҹ��� ���Դϴ�.");
	}

	@Override
	public void volumeDown() {
		System.out.println("�λ�TV - �Ҹ��� ���Դϴ�.");
	}

}
