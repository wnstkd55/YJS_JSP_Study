package polymorphism_5_1_1;

import org.springframework.stereotype.Component;

@Component("apple") 		//Speaker Ÿ�԰� AppleSpeaker ��� ����
public class AppleSpeaker implements Speaker {
	
	public AppleSpeaker () {
		System.out.println("====> AppleSpeaker ��ü ���� ");
	}

	@Override
	public void volumeUp() {
		System.out.println("AppleSpeaker - ���� ��");

	}

	@Override
	public void volumeDown() {
		System.out.println("AppleSpeaker - ���� �ٿ�");

	}

}
