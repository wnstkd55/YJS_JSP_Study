package polymorphism_2_3_2;

public interface TV {
	/*
	  인터페이스를 사용하려면 메소드 이름을 동일하게 사용해서 유지보수를 쉽게 할수있다.(결합도를 낮춘다.)
	  결합도를 낮추는 여러 방법중의 하나
	  
	  -- 인터페이스의 메소드를 오버라이딩해서 결합도를낮춘다.
	  
	 */
	
	//메소드 선언만 되고 구현부가 없는 메소드(추상메소드)
	
	public void powerOn();
	public void powerOff();
	public void volumeUp();
	public void volumeDown();
	
	
}
