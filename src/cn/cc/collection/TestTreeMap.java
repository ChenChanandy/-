package cn.cc.collection;

import java.util.Map;
import java.util.TreeMap;

/**
 * 测试TreeMap的使用
 * @author chenc
 *
 */
public class TestTreeMap {

	public static void main(String[] args) {
		Map<Integer,String> tm = new TreeMap<>();
		tm.put(20, "aa");
		tm.put(5, "bb");
		tm.put(30, "cc");
		
		Map<Emp,String> tm2 = new TreeMap<>();
		tm2.put(new Emp(150, "张三", 50000), "张三是个好小伙");
		tm2.put(new Emp(250, "李四", 5000), "李四工作不积极");
		tm2.put(new Emp(100, "王五", 6000), "王五是个开心果");
		tm2.put(new Emp(50, "赵六", 6000), "赵六还不错");
		
		System.out.println(tm2.toString());
	}
		
}

class Emp implements Comparable<Emp>{
	
	int id;
	String name;
	double salary;
	
	public Emp(int id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "id:"+id+",name:"+name+",salary:"+salary;
	}
	
	@Override
	public int compareTo(Emp o) {	//负数：小于；0：等于；正数：大于。
		if(this.salary>o.salary) {
			return 1;
		}else if(this.salary<o.salary) {
			return -1;
		}else {
			if(this.id>o.id) {
				return 1;
			}else if(this.id<o.id) {
				return -1;
			}else {
				return 0;
			}
		}
	}
	
	
}