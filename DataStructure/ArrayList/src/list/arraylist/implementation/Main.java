package list.arraylist.implementation;

public class Main {

	public static void main(String[] args) {

		ArrayList numbers = new ArrayList();
		
		// addLast ����
		numbers.addLast(10);
		numbers.addLast(20);
		numbers.addLast(30);
		numbers.addLast(40);
		
		// add ����
		numbers.add(1, 15);
		
		// addFirst ���� ( ù��° ��ġ�� �߰� )
		numbers.addFirst(5);
		
		
		// remove ����
//		numbers.remove(4);
//		System.out.println(numbers.remove(1));
		
		// removeFirst ����
//		numbers.removeFirtst();
		
		
		System.out.println(numbers);
		
		
		// iterator ����, for���� �̿��غ���
		/*for(int i=0 ; i<numbers.size() ; i++){
			System.out.println(numbers.get(i));
		}*/
		
		
		ArrayList.ListIterator li = numbers.listIterator();
		
		// iterator ���� - ���� �ִ� for���� ���غ���
		while(li.hasNext()){
			System.out.println(li.next());
		}
		
		
		
		while(li.hasPrevious()){
			System.out.println(li.previous());
		}
		
		
		while(li.hasNext()){
			int number = (int) li.next();
			if(number == 30){
				li.add(35);
			}
			System.out.println(number);
		}
		System.out.println(numbers);
		
		while(li.hasNext()){
			int number = (int) li.next();
			if(number == 20){
				li.remove();
			}
			System.out.println(number);
		}
		System.out.println(numbers);
		
	}
}