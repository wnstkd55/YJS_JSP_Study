package polymorphism_4_2;

public class SkTV implements TV {

	@Override
	public void powerOn() {
		System.out.println("SkTV -- ������ �Ҵ�");

	}

	@Override
	public void powerOff() {
		System.out.println("SkTV -- ������ ����");

	}

	@Override
	public void volumeUp() {
		System.out.println("SkTV -- ������ �ø���");

	}

	@Override
	public void volumeDown() {
		System.out.println("SkTV -- ������ ���δ�");

	}

}
