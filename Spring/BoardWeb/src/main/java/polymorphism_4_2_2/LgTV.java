package polymorphism_4_2_2;

public class LgTV implements TV {

	@Override
	public void powerOn() {
		System.out.println("LGTV -- ������ �Ҵ�");

	}

	@Override
	public void powerOff() {
		System.out.println("LGTV -- ������ ����");

	}

	@Override
	public void volumeUp() {
		System.out.println("LGTV -- �Ҹ��� ���δ�");

	}

	@Override
	public void volumeDown() {
		System.out.println("LGTV -- �Ҹ��� �����");
	}

}
