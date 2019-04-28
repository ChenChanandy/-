package cn.cc.myCollection;

import java.util.LinkedList;

/**
 * 增加泛型
 * @author chenc
 *
 */
public class MyLinkedList5 <E> {
	private Node first;
	private Node last;
	
	private int size;   
	
	public void add(int index,E element) {
		Node newNode = new Node(element);
		Node temp = getNode(index);
		
		if(temp!=null) {
			Node up = temp.previous;
			
			up.next = newNode;
			newNode.previous = up;
			
			newNode.next = temp;
			temp.previous = newNode;
		}
		
	}
	
	public void remove(int index) {
		Node temp = getNode(index);
		
		if(temp!=null) {
			Node up = temp.previous;
			Node down = temp.next;
			
			if(up!=null) {
				up.next = down;
			}
			if(down!=null) {
				down.previous = up;
			}
			if(index==0) {
				first = down;
			}
			if(index==size-1) {
				last = up;
			}
			size--;
		}
	}
	
	public E get(int index) {

		Node temp = getNode(index);
		
		return temp!=null?(E)temp.element:null;
	}
	
	public Node getNode(int index) {
		if(index<0||index>size-1) {
			throw new RuntimeException("索引数字不合法："+index);
		}
		Node temp = null;
		if(index<=size>>1) {
			temp = first;
			for(int i=0;i<index;i++) {
				temp = temp.next;
			}
		}else {
			temp = last;
			for(int i=size-1;i>index;i--) {
				temp = temp.previous;
			}
		}
		return temp;
	}
	
	//[a,b,c]
	public void add(E element) {
		Node node = new Node(element);
		if(first==null) {
			first = node;
			last = node;
		}else {
			node.previous = last;
			node.next = null;
			
			last.next = node;
			last = node;
		}	
		size++;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		Node temp = first;
		while(temp!=null) {
			sb.append(temp.element+",");
			temp =temp.next;
		}
		sb.setCharAt(sb.length()-1, ']');
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		MyLinkedList5<String> list = new MyLinkedList5<>();
		
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		list.add("f");
		
		System.out.println(list);
		
		list.add(2, "老陈");
		System.out.println(list.get(2));
		//list.remove(0);
		System.out.println(list);

	}
	
}
