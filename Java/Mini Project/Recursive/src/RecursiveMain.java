
public class RecursiveMain {

	public static void main(String[] args) {
		int result = 1;
		
		for(int i=1; i<=4; i++){
			result = result*i;
		}
		
//		System.out.println(result);
//
//		System.out.println("Factorial Method 적용: " + Factorial(5));
//		
//		System.out.println("======= 피보나치 수열 =======");
		
		System.out.println(fibo(5));
		
		
		
	}
	
	
	// 재귀함수 조건
	// 1. 끝나는 조건
	// 2. 자기 자신을 호출하는 부분이 있어야 함.
	public static int Factorial(int n){
		if(n <= 1)
			return n;
		else
			return Factorial(n-1)*n;
	}
	
	
	public static int fibo(int n){
		if(n<=2) {
//			System.out.println(1);
			return 1;
		}
		else if(n==3){
//			System.out.println(2);
			return 2;
		} else {
			System.out.println(fibo(n-1)+fibo(n-2));
			return fibo(n-1)+fibo(n-2);
		}
	}
}
