package cn.cc.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 测试Collection接口中的方法
 * @author chenc
 *
 */
public class TestList {
	public static void main(String[] args) {
		test02();

	}
	
	public static void test01(){
		
		Collection<String> c= new ArrayList<>();
		
		System.out.println(c.size());
		System.out.println(c.isEmpty());
		
		c.add("11111");
		c.add("22222");
		
		System.out.println(c);
		System.out.println(c.size());
		System.out.println(c.isEmpty());
		System.out.println(c.contains("333"));
		
		c.remove("22222");
		System.out.println(c);
		
		Object[] objs = c.toArray();
		System.out.println(objs);
		
		c.clear();
		System.out.println(c);
	}
	
	public static void test02() {
		
		List<String> list01 = new ArrayList<>();
		list01.add("aa");
		list01.add("bb");
		list01.add("cc");
		
		List<String> list02 = new ArrayList<>();
		
		list02.add("aa");
		list02.add("dd");
		list02.add("ee");
		
		//list01.containsAll(list02);						
		//list01.removeAll(list02);		
		//list01.addAll(list02);
		list01.retainAll(list02);
		
		System.out.println("list01:"+list01);
		
		
		
	}
}
