package polymorphism_4_2;

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
//		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
			//GenericXmlApplicationContext : Bean ���������� �ε���
/*		
		TV tv = (TV)factory.getBean("tv");	//������ ��ü�� TV Ÿ������ ��ĳ����
		
		tv.powerOn();		//TV�� �޼ҵ� ȣ�� ==> ������ ��ü�� �޼ҵ带 ȣ��
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();
		
		
		//������ �����̳ʷκ��� �ϳ��� ��ü�� ������ ��û�� �� �ִ�.
		TV tv10 = (TV) factory.getBean("tv");
		TV tv11 = (TV) factory.getBean("tv");
		TV tv12 = (TV) factory.getBean("tv");
		TV tv13 = (TV) factory.getBean("tv");
		
		factory.close(); 		//�޸𸮿��� ��ü ����
*/		
		System.out.println("========================================");
		//������ ��ü�� ������ ��� : �޸��� ���� �ʷ���
		TV tv1 = new SamsungTV();
		TV tv2 = new SamsungTV();
		TV tv3 = new SamsungTV();
		TV tv4 = new SamsungTV();
			
		System.out.println(tv1);
		System.out.println(tv2);
		System.out.println(tv3);
		System.out.println(tv4);
			
		System.out.println("========================================");
		
		//�ּҸ� �����ؼ�  ����ϸ� �޸��� ���� �ٿ��� �� �ִ�.
		TV tv5 = new SamsungTV();
		TV tv6 = tv5;		//tv6�� tv5�� �ּҸ� ������.
		TV tv7 = tv6;
		
		System.out.println(tv5);
		System.out.println(tv6);
		System.out.println(tv7);
	}

}
