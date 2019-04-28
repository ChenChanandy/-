package cn.cc.myCollection;

/**
 * 增加remove方法
 * size、isEmpty方法
 * @author chenc
 *
 */
public class CcArrayList4 <E> {
	
	private Object[] elementData;
	private int size;
	private static final int DEFALT_CAPACITY = 10;
	
	public CcArrayList4() {
		elementData = new Object[DEFALT_CAPACITY];		
	}
	
	public CcArrayList4(int capacity) {
		if(capacity<0) {
			throw new RuntimeException("容器的容量不能为负数！");
		}else if(capacity==0) {
			elementData = new Object[DEFALT_CAPACITY];
		}else {
			elementData = new Object[capacity];
		}		
	}
	
	public void add(E element) {
		//什么时候扩容
		if(size==elementData.length) {
			//如何实现扩容
			Object[] newObject = new Object[elementData.length+(elementData.length>>1)];
			System.arraycopy(elementData, 0, newObject, 0, elementData.length);
			elementData = newObject;
		}		
		elementData[size++] = element;
	}
	
	public E get(int index) {
		checkRange(index);
		return (E)elementData[index];
	}
	
	public void set(E element,int index) {
		checkRange(index);
		elementData[index] = element;
	}
	
	public void checkRange(int index) {
		if(index<0||index>size-1) {
			throw new RuntimeException("索引不合法："+index);
		}
	}
	
	public void remove(int index) {
		int numMoved = size-index-1;
		if(numMoved>0) {
			System.arraycopy(elementData, index+1, elementData, index,numMoved);			
		}
		elementData[--size] = null;
	}
	
	public void remove(E element) {
		for(int i=0;i<size;i++) {
			if(element.equals(get(i))) {
				remove(i);
			}
		}
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		//[a,b,c]
		sb.append("[");
		for(int i=0;i<size;i++) {
			sb.append(elementData[i]+",");
		}
		sb.setCharAt(sb.length()-1,']');
		return sb.toString();
	}
	
	public static void main(String[] args) {
		CcArrayList4<String> s1 = new CcArrayList4<>();
		
		for(int i=0;i<40;i++) {
			s1.add("chen"+i);
		}
		
		System.out.println(s1.size());
		System.out.println(s1.isEmpty());
		s1.set("ddddd", 10);
		System.out.println(s1);
		System.out.println(s1.get(10));
		s1.remove(3);
		s1.remove("ddddd");
		System.out.println(s1);
	}
}
