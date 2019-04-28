package cn.cc.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试Map常用的方法
 * @author chenc
 *
 */
public class TestMap2 {
	public static void main(String[] args) {
		Employee e1 = new Employee(1001, "老大", 8000);
		Employee e2 = new Employee(1002, "老二", 5000);
		Employee e3 = new Employee(1003, "老三", 6000);
		Employee e4 = new Employee(1001, "老四", 3000);
		
		Map<Integer, Employee> map = new HashMap<>();
		
		map.put(e1.getId(), e1);
		map.put(1002, e2);
		map.put(1003, e3);
		map.put(e4.getId(),e4);
		
		Employee emp = map.get(1001);
		System.out.println(emp.getName());
		System.out.println(map);
	}
}

//雇员信息
class Employee{
	private int id;
	private String name;
	private double salary;
	
	@Override
	public String toString() {
		return "id:"+id+",name:"+name+",salary:"+salary;
	}
	
	public Employee(int id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
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
		
}