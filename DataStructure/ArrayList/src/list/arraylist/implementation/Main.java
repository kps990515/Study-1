package list.arraylist.implementation;

public class Main {

	public static void main(String[] args) {

		ArrayList numbers = new ArrayList();
		
		// addLast 구현
		numbers.addLast(10);
		numbers.addLast(20);
		numbers.addLast(30);
		numbers.addLast(40);
		
		// add 구현
		numbers.add(1, 15);
		
		// addFirst 구현 ( 첫번째 위치에 추가 )
		numbers.addFirst(5);
		
		
		// remove 구현
//		numbers.remove(4);
//		System.out.println(numbers.remove(1));
		System.out.println(numbers);
		
		
	}

}
