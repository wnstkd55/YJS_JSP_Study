package polymorphism_4_3_2;

public class AppleSpeaker implements Speaker {
	
	public AppleSpeaker () {
		System.out.println("====> AppleSpeaker °´Ã¼ »ý¼º ");
	}

	@Override
	public void volumeUp() {
		System.out.println("AppleSpeaker - º¼·ý ¾÷");

	}

	@Override
	public void volumeDown() {
		System.out.println("AppleSpeaker - º¼·ý ´Ù¿î");

	}

}
