package polymorphism_2_3_1;

public class TVUser {

	public static void main(String[] args) {
		/*
		SamsungTV tv = new SamsungTV();		
		//������ ���� (�����ڰ� ���� ���α׷� �ڵ� ������ ��ü�� ����)
		
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();
		*/
		
		//������� �䱸�� ���ؼ� SamsungTV���� LGTV�� �������
			//��ü ����, �޼ҵ��̸� ��� ����
		LgTV tv = new LgTV();
		tv.turnOn();
		tv.turnOff();
		tv.soundUp();
		tv.soundDown();
		
	}

}
