package polymorphism_4_2;

public class SkTV implements TV {

	@Override
	public void powerOn() {
		System.out.println("SkTV -- 전원을 켠다");

	}

	@Override
	public void powerOff() {
		System.out.println("SkTV -- 전원을 끈다");

	}

	@Override
	public void volumeUp() {
		System.out.println("SkTV -- 볼륨을 올린다");

	}

	@Override
	public void volumeDown() {
		System.out.println("SkTV -- 볼륨을 줄인다");

	}

}
