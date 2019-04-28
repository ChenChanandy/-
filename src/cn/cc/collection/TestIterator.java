package cn.cc.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 测试iterator的使用
 * @author chenc
 *
 */
public class TestIterator {
	public static void main(String[] args) {
		//IteratorList();
		//IteratorSet();
		//IteratorMap();
		IteratorMap2();
	}
	
	//迭代器测试List
	public static void IteratorList() {
		List<String> list = new ArrayList<>();
		list.add("aa");
		list.add("bb");
		list.add("cc");
		System.out.println(list);
		
		for(Iterator<String> iter=list.iterator();iter.hasNext();) {
			String temp = iter.next();
			System.out.println(temp);
		}		
	}
	
	//Iterator测试Set
	public static void IteratorSet() {
		Set<String> set = new HashSet<>();
		set.add("aaa");
		set.add("bbb");
		set.add("ccc");
		System.out.println(set);
		
		for(Iterator<String> iter=set.iterator();iter.hasNext();) {
			String temp = iter.next();
			System.out.print(temp+"\t");
		}
	}
	
	//遍历Map方式一
	public static void IteratorMap() {
		Map<Integer, String> map = new HashMap<>();
		map.put(10, "zhangsan");
		map.put(20, "lisi");
		map.put(30, "wangwu");
		
		Set<Entry<Integer, String>> ss = map.entrySet();
		for(Iterator<Entry<Integer,String>> iter=ss.iterator();iter.hasNext();) {
			Entry<Integer,String> temp = iter.next();
			System.out.println(temp.getKey()+"--"+temp.getValue());
		}
	}
	
	//遍历Map方式二
	public static void IteratorMap2() {
		Map<Integer, String> map = new HashMap<>();
		map.put(10, "zhangsan");
		map.put(20, "lisi");
		map.put(30, "wangwu");
		
		Set<Integer> keySet = map.keySet();
		for(Iterator<Integer> iter=keySet.iterator();iter.hasNext();) {
			Integer key = iter.next();
			System.out.println(key+"---"+map.get(key));
		}
	}
	
}
