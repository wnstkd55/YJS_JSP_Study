package polymorphism_3_1_2;

public class SamsungTV implements TV {

	@Override
	public void powerOn() {
		System.out.println("»ï¼ºTV -- Àü¿øÀ» ÄÒ´Ù");

	}

	@Override
	public void powerOff() {
		System.out.println("»ï¼ºTV -- Àü¿øÀ» ²ö´Ù");
	}

	@Override
	public void volumeUp() {
		System.out.println("»ï¼ºTV -- ¼Ò¸®¸¦ ³ôÀÎ´Ù");

	}

	@Override
	public void volumeDown() {
		System.out.println("»ï¼ºTV -- ¼Ò¸®¸¦ ³·Ãá´Ù");

	}

}
