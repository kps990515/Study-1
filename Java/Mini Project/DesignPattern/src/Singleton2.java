
public class Singleton2 {

	// 3. 자기 자신을 담아두는 저장공간을 만들고
	private static Singleton2 instance = new Singleton2();
	
	// 1. 생성자를 private 으로 만들어 외부에서 생성할 수 없도록 제한한다.
	private Singleton2(){
		
	}
	
	
	// 2. 외부에서 생성할 수 없으므로
	// 내부에서 생성한 후 사용할 수 있도록 인터페이스를 제공해야 한다.
	// 외부에서 new가 안되므로 함수는 static으로 구성해야 한다.
	public static Singleton2 getInstance(){
		// 4. 저장공간에 instance 가 있으면 instance를 return 한다.
		return instance;
	}
}