package polymorphism_4_2;

public class SamsungTV implements TV {
	
	private SonySpeaker speaker;		//��ü ���� ����
	
	public SamsungTV() {	//�⺻ ������ : ��ü�� �����ɶ� ȣ��
		System.out.println("===> SamsungTV��ü ����");
	}
	
	//SamsungTV�������� �Ű� ������ SonySpeaker ��ü�� Spring �����ӿ�ũ���� DI (������ ����)
	
	public SamsungTV(SonySpeaker speaker) {
		System.out.println("====> SamsungTV ��ü���� 2: ������ ��ü ����");
		this.speaker = speaker;
	}
	
	public void initMethod() {	//��ü ���� ���Ŀ� ���ϸ��� ȣ��Ǵ� �޼ҵ�
		System.out.println("initMethod ȣ�� : ��ü �ʱ�ȭ �Ϸ�");
		
	}
	
	public void destroyMethod() {	//��ü ������ ȣ��Ǵ� �޼ҵ�
		System.out.println("destroyMethod ȣ�� : ��ü ������ ȣ��Ǵ� �޼ҵ�");
	}
	
	@Override
	public void powerOn() {
		System.out.println("�ＺTV -- ������ �Ҵ�");

	}

	@Override
	public void powerOff() {
		System.out.println("�ＺTV -- ������ ����");
	}
	
	//������ ����, ���α׷� ������ ��ü�� ������ ���, ���ο� ����� ����Ŀ�� ��ü�Ҷ� �ڵ带 �����ؾ� �Ѵ�.
	
	@Override
	public void volumeUp() {
		speaker.volumeUp();				//SonySpeaker �޼ҵ� ȣ��
	}

	@Override
	public void volumeDown() {
		speaker.volumeDown();
		
	}

}
