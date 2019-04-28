package cn.cc.myCollection;

/**
 * 自定义实现ArrayList，体会底层原理
 * 增加数组扩容
 * @author chenc
 *
 */
public class CcArrayList2 <E> {
	
	private Object[] elementData;
	private int size;
	private static final int DEFALT_CAPACITY = 10;
	
	public CcArrayList2() {
		elementData = new Object[DEFALT_CAPACITY];		
	}
	
	public CcArrayList2(int capacity) {
		elementData = new Object[capacity];
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
		CcArrayList2<String> s1 = new CcArrayList2<>();
		
		for(int i=0;i<40;i++) {
			s1.add("chen"+i);
		}
		
		System.out.println(s1);
		
	}
}
