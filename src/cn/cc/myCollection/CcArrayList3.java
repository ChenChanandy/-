package cn.cc.myCollection;

/**
 * 增加get、set方法
 * 增加数组边界判断
 * @author chenc
 *
 */
public class CcArrayList3 <E> {
	
	private Object[] elementData;
	private int size;
	private static final int DEFALT_CAPACITY = 10;
	
	public CcArrayList3() {
		elementData = new Object[DEFALT_CAPACITY];		
	}
	
	public CcArrayList3(int capacity) {
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
		CcArrayList3<String> s1 = new CcArrayList3<>();
		
		for(int i=0;i<40;i++) {
			s1.add("chen"+i);
		}
		
		s1.set("ddddd", 10);
		System.out.println(s1);
		System.out.println(s1.get(10));
	}
}
