package list.arraylist.implementation;

public class ArrayList {
	
	// ArrayList ���������� ��� ������ ä�����°��� size�� ����Ų��.
	private int size = 0;
	
	// ��ü ���������� ����� �迭
	private Object[] elementData = new Object[100];
	// Object ������ Ÿ���� ������ �ؼ� elementData��� �ϴ� ����� ���������ڸ� ���� �ִ� �ν��Ͻ� ������ �Ҵ��� ���̴�.
	// �׸��� �� ������ �迭�� ������ �� �ִ� ���� ���ڴ� 100�� �̴�.
	
	// elementData�� ������ ũ��(100)�� ���´�.
	
	
	
	// addFirst ����
	public boolean addFirst(Object element){
		return add(0, element);
	}
		
	
	// addLast ����
	public boolean addLast(Object element){
		elementData[size] = element;
		size++;
		return true;
	}
	
	
	// add ����
	public boolean add(int index, Object element){
		for (int i = size-1 ; i >= index ; i--){
			elementData[i+1] = elementData[i];
		}
		elementData[index] = element;
		size++;
		return true;
	}
	
	// toString �޼ҵ� ����
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
	
	// remove ����
	public Object remove(int index){
		// ������ ���� ��ȯ���ֱ� ���� removed ������ ����
		Object removed = elementData[index];
		for (int i = index ; i < size-1  ; i++){
			elementData[i] = elementData[i+1];
		}
		size--;
		
		// ��ĭ�� ������ �̵���, ���� �������� ����Ǿ� �ִ� �����͸� null�� ������ش�.
		elementData[size] = null;
		
		return removed;	// �����ߴ� ���� �˷��ֱ� ���� ��ȯ
	}
	
	
	// removeFirst ����
	public Object removeFirst(){
		return remove(0);
	}
	
	// removeLast ����
	public Object removeLast(){
		return remove(size-1);
	}
	
	// get ���� - ArrayList�� ���� ū ����
	public Object get(int index){
		return elementData[index];
	}
	
	// size ����
	// ������ ���� �������� �ʰ�, �޼ҵ�� ����� ���� �ܺο��� size���� �������� ���ϰ� �ϱ� ���ؼ��̴�.
	// �׷��� ���� size�� private���� �Ǿ� �ִ�.
	public int size(){
		return size;
	}
	
	
	// size indexOf - �ش� ���� ���° �ε����� �ִ��� �˷��ִ� �޼ҵ�
	public int indexOf(Object o){
		for(int i=0 ; i<size ; i++){
			if(o.equals(elementData[i])){
				return i;
			}
		}
		return -1;	// ã�� ���� ���� ���
	}
	
	
	// ListIterator ����
	public ListIterator listIterator(){
		return new ListIterator();
	}
	
	public class ListIterator{
		private int nextIndex = 0;
		
		// hasNext()
		public boolean hasNext(){
			return nextIndex < size();
		}
		
		// next()
		public Object next(){
//			Object returnData = elementData[nextIndex];
//			nextIndex++;
//			return returnData;
			
			// ���� �ڵ带 �� �����ϰ� �ۼ�
			return elementData[nextIndex++];
		}
		
		//hasPrevious()
		public boolean hasPrevious(){
			return nextIndex > 0;
		}
		
		// previous()
		public Object previous(){
			return elementData[--nextIndex];
		}
		
		
		// iterator add
		public void add(Object element){
			ArrayList.this.add(nextIndex++, element);
		}
		
		
		// iterator remove - next()�� �ѹ��̶� ȣ���� �Ŀ� �����ؾ� ������ �ȳ���.
		public void remove(){
			ArrayList.this.remove(nextIndex-1);
			nextIndex--;
		}
		
	}
}