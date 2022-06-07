package polymorphism_5_2_1;

import org.springframework.stereotype.Component;

@Component("sony")	//sony ��ü�� Speaker Ÿ�԰�, Sony Ÿ�� ��� ����
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
