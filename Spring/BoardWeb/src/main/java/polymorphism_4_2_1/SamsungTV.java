package polymorphism_4_2_1;

public class SamsungTV implements TV {
	
	private SonySpeaker speaker;		//��ü ���� ����
	private int price;					//���� ���� ����
	
	public SamsungTV() {	//�⺻ ������ : ��ü�� �����ɶ� ȣ��
		System.out.println("===> SamsungTV��ü ����");
	}
	
	//SamsungTV�������� �Ű� ������ SonySpeaker ��ü�� Spring �����ӿ�ũ���� DI (������ ����)
	
	//������ : �Ű������� 1���� ������
	public SamsungTV(SonySpeaker speaker) {
		System.out.println("====> SamsungTV ��ü���� 2: ������ ��ü ����");
		this.speaker = speaker;
	}
	
	//������ : �Ű������� 2���� ������
	public SamsungTV(SonySpeaker speaker, int price) {
		System.out.println("====> SamsungTV ��ü���� 3: �Ű����� 2���� ������ ȣ��");
		this.speaker = speaker;
		this.price = price;
	}
	
	public void initMethod() {	//��ü ���� ���Ŀ� ���ϸ��� ȣ��Ǵ� �޼ҵ�
		System.out.println("initMethod ȣ�� : ��ü �ʱ�ȭ �Ϸ�");
		
	}
	
	public void destroyMethod() {	//��ü ������ ȣ��Ǵ� �޼ҵ�
		System.out.println("destroyMethod ȣ�� : ��ü ������ ȣ��Ǵ� �޼ҵ�");
	}
	
	@Override
	public void powerOn() {
		System.out.println("�ＺTV -- ������ �Ҵ� ����: "+price);

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
