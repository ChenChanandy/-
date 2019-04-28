package cn.cc.myCollection;

import java.util.HashMap;

public class MyHashSet {
	
	HashMap map;
	
	private static final Object PRESENT = new Object();
	
	public MyHashSet(){
		map = new HashMap();
	}
	
	public void add(Object o) {
		map.put(o, PRESENT);
	}
	
	public int size() {
		return map.size();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		for(Object key:map.keySet()) {
			sb.append(key+",");
		}
		sb.setCharAt(sb.length()-1, ']');
		return sb.toString();
	}
	
	public static void main(String[] args) {
		MyHashSet set = new MyHashSet();
		set.add("aa");
		set.add("bb");
		set.add("cc");
		
		System.out.println(set);
	}
}
