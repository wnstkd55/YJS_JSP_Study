package polymorphism_2_3_2;

public class SamsungTV implements TV {

	@Override
	public void powerOn() {
		System.out.println("SamsungTV -- ������ Ų��.");
	}

	@Override
	public void powerOff() {
		System.out.println("SamsungTV -- ������ ����.");

	}

	@Override
	public void volumeUp() {
		System.out.println("SamsungTV -- �Ҹ��� �ø���.");

	}

	@Override
	public void volumeDown() {
		System.out.println("SamsungTV -- �Ҹ��� ������.");

	}

}
