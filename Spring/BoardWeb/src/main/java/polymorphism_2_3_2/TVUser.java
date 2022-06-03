package polymorphism_2_3_2;

public class TVUser {

	public static void main(String[] args) {
		//SamsungTV tv = new SamsungTV();
		
		//LgTV tv = new LgTV();
		
		//TV tv = new SamsungTV();		//업캐스팅(다형성 구현)
		TV tv = new LgTV();
		
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();
		
		//인터페이스를 사용하면 약결합을 만들어서 유지보수를 쉽게한다.
		
	}

}
