package polymorphism_4_3_1;

public class SonySpeaker implements Speaker {
	
	//�⺻ ������ 
	public SonySpeaker() {
		System.out.println("===> �Ҵ� ����Ŀ ��ü ���� ");
	}
	
	@Override
	public void volumeUp() {
		System.out.println("SonySpeaker  --- ���� ��");
	}
	
	@Override
	public void volumeDown() {
		System.out.println("SonySpeaker  --- ���� �ٿ� ");
	}

}
