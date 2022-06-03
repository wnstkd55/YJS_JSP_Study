package polymorphism_3_1_2;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {
		
		//TVUser Ŭ�������� ��ü�� �������� �ʰ� �ܺ� Ŭ�������� ��ü�� ������ ������ ��ü�� ������ �´�.
			//���յ��� ���ߴ� ���
		
		// ���յ� ���ߴ� 2���� ���
			//1. �������̽��� ���. (������ �޼ҵ�)
			//2. ������ ���� Factory ����
				//��ü�� �����ϴ� ������ Ŭ������ ����(BeanFactory) <== ��ü ����, ����
			//3. Spring �����ӿ�ũ���� ��ü�� ���� �� �����ϴ� ���
				// - IoC(������ ����) : ��ü(������) ===> ��ü(Spring �����ӿ�ũ)
				// - DI(������ ����) : ��ü�� �ڹ��ڵ� ���ο��� �������� �ʰ� Spring ������ ��ũ���� ��ü�� ������
									// ������ ��ü�� �ڹ��ڵ� ���η� �����Ѵ�.
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
			//GenericXmlApplicationContext : Bean ���������� �ε���
		
		TV tv = (TV)factory.getBean("tv");	//������ ��ü�� TV Ÿ������ ��ĳ����
		
		tv.powerOn();		//TV�� �޼ҵ� ȣ�� ==> ������ ��ü�� �޼ҵ带 ȣ��
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();

	}

}
