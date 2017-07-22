package list.arraylist.implementation;

public class ArrayList {
	
	// ArrayList 내부적으로 몇개의 값들이 채워졌는가를 size가 가리킨다.
	private int size = 0;
	
	// 객체 내부적으로 사용할 배열
	private Object[] elementData = new Object[100];
	// Object 데이터 타입을 생성을 해서 elementData라고 하는 비공개 접근제한자를 갖고 있는 인스턴스 변수에 할당한 것이다.
	// 그리고 그 변수에 배열에 수용할 수 있는 값의 숫자는 100개 이다.
	
	// elementData는 고정된 크기(100)를 갖는다.
	
	
	
	// addFirst 구현
	public boolean addFirst(Object element){
		return add(0, element);
	}
		
	
	// addLast 구현
	public boolean addLast(Object element){
		elementData[size] = element;
		size++;
		return true;
	}
	
	
	// add 구현
	public boolean add(int index, Object element){
		for (int i = size-1 ; i >= index ; i--){
			elementData[i+1] = elementData[i];
		}
		elementData[index] = element;
		size++;
		return true;
	}
	
	// toString 메소드 구현
	public String toString(){
		String str = "[";
		for(int i=0; i<size; i++){
			str += elementData[i];
			if(i < size-1){
				str += ", ";
			}
		}
		return str + "]";
	}
	
	// remove 구현
	public Object remove(int index){
		// 삭제할 값을 반환해주기 위해 removed 변수에 저장
		Object removed = elementData[index];
		for (int i = index ; i < size-1  ; i++){
			elementData[i] = elementData[i+1];
		}
		size--;
		
		// 한칸씩 앞으로 이동후, 가장 마지막에 저장되어 있는 데이터를 null로 만들어준다.
		elementData[size] = null;
		
		return removed;	// 삭제했던 값을 알려주기 위해 반환
	}
}