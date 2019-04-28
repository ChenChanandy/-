package cn.cc.myCollection;

/**
 *增加泛型
 * @author chenc
 *
 */
public class MyHashMap3<K,V> {

	Node3[] table;	//位桶数组
	int size;		//存放键值对个数
	
	public MyHashMap3() {
		table = new Node3[16];	//长度一般为2的整数次幂
	}
	
	public void put(K key,V value) {
		//定义一个新的节点对象
		Node3 newNode = new Node3();
		newNode.hash = myHash(key.hashCode(), table.length);
		newNode.key = key;
		newNode.value = value;
		newNode.next = null;
		
		Node3 temp = table[newNode.hash];
		Node3 iterLast = null;
		boolean keyRepeat = false;
		if(temp==null) {
			//此处数组元素为空，则直接将新节点放进去
			table[newNode.hash] = newNode;
			size++;
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
				size++;
			}
			
		}
		
	}
	
	public V get(K key) {
		int hash = myHash(key.hashCode(), table.length);
		V value = null;
		if(table[hash]!=null) {
			Node3 temp = table[hash];
			while(temp!=null) {
				if(temp.key.equals(key)) {
					value = (V)temp.value;
					break;
				}else {
					temp = temp.next;
				}
			}
		}		
		return value;
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
			Node3 temp = table[i];
			while(temp!=null) {
				sb.append(temp.key+":"+temp.value+",");
				temp = temp.next;
			}
		}
		sb.setCharAt(sb.length()-1, '}');
		return sb.toString();
	}
	
	public static void main(String[] args) {
		MyHashMap3<Integer,String> m = new MyHashMap3<>();
		m.put(10, "aa");
		m.put(20, "bb");
		m.put(30, "cc");
		m.put(20, "ssss");
		
		m.put(53, "xx");
		m.put(69, "yy");
		m.put(85, "zz");
		
		System.out.println(m);
		System.out.println(m.get(85));
		
//		for(int i=0;i<100;i++) {
//			System.out.println(i+"---"+myHash(i, 16));	//85,69,53
//		}
	}
}
