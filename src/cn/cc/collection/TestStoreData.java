package cn.cc.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 测试表格数据的存储
 * 体会ORM思想
 * 每一行使用javabean对象存储，多行使用放到map或list中
 * @author chenc
 *
 */
public class TestStoreData {
	public static void main(String[] args) {
		User u1 = new User(1001, "zhangsan", 20000, "2018.5.5");
		User u2 = new User(1002, "lisi", 30000, "2008.4.4");
		User u3 = new User(1003, "wangwu", 20000, "2019.3.3");
		
		List<User> list = new ArrayList<>();
		list.add(u1);
		list.add(u2);
		list.add(u3);
		
		for(User u:list) {
			System.out.println(u);
		}
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
		
		Map<Integer,User> map = new HashMap<>();
		map.put(1001, u1);
		map.put(1002, u2);
		map.put(1003, u3);
		
		Set<Integer> keySet = map.keySet();
		for(Integer key:keySet) {
			System.out.println(key+"--"+map.get(key));
		}
	}
	
}

class User{
	private int id;
	private String name;
	private double salary;
	private String hiredate;
	
	@Override
	public String toString() {
		return "id:"+id+",name:"+name+",salary:"+salary+",hiredate:"+hiredate;
	}
	
	public User() {
	}

	public User(int id, String name, double salary, String hiredate) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.hiredate = hiredate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
		
}
