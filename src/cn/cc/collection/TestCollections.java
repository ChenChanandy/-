package cn.cc.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Collections辅助类的使用
 * Collection是接口
 * @author chenc
 *
 */
public class TestCollections {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		for(int i=0;i<10;i++) {
			list.add("chen"+i);
		}
		System.out.println(list);
		
		Collections.reverse(list);	//逆序排序
		System.out.println(list);
		
		Collections.shuffle(list);	//随机排列list中的元素
		System.out.println(list);
		
		Collections.sort(list); 	//递增排序
		System.out.println(list);
		
		System.out.println(Collections.binarySearch(list,"chen5"));//二分法查找
	}
}
