package cn.cc.myCollection;

/**
 * 实现put方法,重写toString方法
 * @author chenc
 *
 */
public class MyHashMap1 {

	Node2[] table;	//位桶数组
	int size;		//存放键值对个数
	
	public MyHashMap1() {
		table = new Node2[16];	//长度一般为2的整数次幂
	}
	
	public void put(Object key,Object value) {
		//定义一个新的节点对象
		Node2 newNode = new Node2();
		newNode.hash = myHash(key.hashCode(), table.length);
		newNode.key = key;
		newNode.value = value;
		newNode.next = null;
		
		Node2 temp = table[newNode.hash];
		Node2 iterLast = null;
		boolean keyRepeat = false;
		if(temp==null) {
			//此处数组元素为空，则直接将新节点放进去
			table[newNode.hash] = newNode;
		}else {
			//此处数组元素不为空，则遍历对应链表
			while(temp!=null) {
				//判断key如果重复，则覆盖
				if(temp.key.equals(key)) {
					keyRepeat = true;
					temp.value = value;	//只是覆盖value即可
					break;
				}else {
					//key不重复，则遍历下一个
					iterLast = temp;
					temp = temp.next;
				}
			}
			if(!keyRepeat) {
				iterLast.next = newNode;
			}
			
		}
		
	}
	
	public static int myHash(int v,int length) {
//		System.out.println(v&(length-1));	//直接位运算，效率高
//		System.out.println(v%(length-1));	//取模运算，效率低
		return v&(length-1);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("{");
		for(int i=0;i<table.length;i++) {
			Node2 temp = table[i];
			while(temp!=null) {
				sb.append(temp.key+":"+temp.value+",");
				temp = temp.next;
			}
		}
		sb.setCharAt(sb.length()-1, '}');
		return sb.toString();
	}
	
	public static void main(String[] args) {
		MyHashMap1 m = new MyHashMap1();
		m.put(10, "aa");
		m.put(20, "bb");
		m.put(30, "cc");
		m.put(20, "ssss");
		
		m.put(53, "xx");
		m.put(69, "yy");
		m.put(85, "zz");
		
		System.out.println(m);
		
//		for(int i=0;i<100;i++) {
//			System.out.println(i+"---"+myHash(i, 16));	//85,69,53
//		}
	}
}
