package cn.cc.myCollection;

/**
 * 自定义实现ArrayList，体会底层原理
 * 增加泛型
 * @author chenc
 *
 */
public class CcArrayList1 <E> {
	
	private Object[] elementData;
	private int size;
	private static final int DEFALT_CAPACITY = 10;
	
	public CcArrayList1() {
		elementData = new Object[DEFALT_CAPACITY];		
	}
	
	public CcArrayList1(int capacity) {
		elementData = new Object[capacity];
	}
	
	public void add(E element) {
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
		CcArrayList1<String> s1 = new CcArrayList1<>();
		
		s1.add("aa");
		s1.add("bb");
		
		System.out.println(s1);
		
	}
}
