package cn.cc.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo01 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();		
		list.add("长沙");
		list.add("衡阳");
		list.add("常德");
		System.out.println(list);
		
		Map<String,List<String>> map = new HashMap<String, List<String>>();	
		map.put("湖南省", list);
		System.out.println(map);
		System.out.println(map.keySet()+"--"+map.get("湖南省").get(2));		
	}
}
