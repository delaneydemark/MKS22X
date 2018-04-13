import java.util.Iterator;
import java.util.*;

public class MyLinkedListImproved<T extends Comparable<T>> implements Iterable<T>{
    Node first;
    Node last;
    int length;

    public MyLinkedListImproved(){
	first = new Node();
	last = new Node();
	length = 0;
    }

    public Iterator<T> iterator(){
	return new MyLinkedListIterator(first);
    }

    public int compareTo(T b){
	return this.compareTo(b);
    }

    public boolean add(T value){
	Node i = new Node(value);
	if(length==0){
	    first = i;
	    last = i;
	}else{
	    i.setPrev(last);
	    last.setNext(i);
	    last = i;
	}
	length++;
	return true;
    }

    public int size(){
	return length;
    }

    public void clear(){
	length = 0;
    }

    public String toString(){
	if(length==0){
	    return "[]";
	}
	String s = "[";
	Node i = first;
	while(i!=null){
	    if(i.getNext()==null){
		s+=i.getValue() + "]";
	    }else{
		s+=i.getValue() + ", ";
	    }
	    i = i.getNext();
	}
	return s;
    }

    public T get(int index){
	if(index<0 || index>=length){
	    throw new IndexOutOfBoundsException();
	}
	Node i = first;
	int j = 0;
	T val = i.getValue();
	while(i!=null && j<length){
	    if(j==index){
		val = i.getValue();
	    }
	    j++;
	    i = i.getNext();
	}
	return val;
    }

    public Node getNode(int index){
	if(index<0 || index>=length){
	    throw new IndexOutOfBoundsException();
	}
	Node i = first;
	int j = 0;
	while(i!=null && j<length){
	    if(j==index){
		return i;
	    }
	    j++;
	    i = i.getNext();
	}
	return i;
    }

    public T set(int index, T newValue){
	if(index<0 || index>=length){
	    throw new IndexOutOfBoundsException();
	}
	Node i = first;
	int j = 0;
	T val = i.getValue();
	while(i!=null && j<length){
	    if(j==index){
		val = i.getValue();
		i.setValue(newValue);
	    }
	    j++;
	    i = i.getNext();
	}
	return val;
    }

    public int indexOf(T value){
	int j = 0;
	while(j<length){
	    if(this.get(j).equals(value)){
		return j;
	    }
	    j++;
	}
	return -1;
    }

    
    public void add(int index, T value){
	if(index<0 || index>length){
	    throw new IndexOutOfBoundsException();
	}
	if(index == 0){
	    Node i = new Node(value);
	    i.setNext(first);
	    first.setPrev(i);
	    first = i;
	    length++;
	}else if(index == length){
	    this.add(value);
	}else{
	    Node old = getNode(index);
	    Node i = new Node(value);
	    old.getPrev().setNext(i);
	    i.setPrev(old.getPrev());
	    i.setNext(old);
	    old.setPrev(i);
	    length++;
	}
    }

    
    public T remove(int index){
	if(index<0 || index>=length){
	    throw new IndexOutOfBoundsException();
	}
	T val = first.getValue();
	if(index==0){
	    val = first.getValue();
	    first.getNext().setPrev(null);
	    first = first.getNext();
	}else if(index == length-1){
	    val = last.getValue();
	    last = last.getPrev();
	    last.setNext(null);
	}else{
	    Node i = getNode(index);
	    val = i.getValue();
	    i.getPrev().setNext(i.getNext());
	    i.getNext().setPrev(i.getPrev());
	}
	length-=1;
	return val;
    }

    
    public boolean remove(T value){
	int index = indexOf(value);
	if(index==0){
	    first.getNext().setPrev(null);
	    first = first.getNext();
	}else if(index == length-1){
	    last = last.getPrev();
	    last.setNext(null);
	}else if(index != length-1){
	    System.out.println(length-1);
	    Node i = getNode(index);
	    i.getPrev().setNext(i.getNext());
	    i.getNext().setPrev(i.getPrev());
	}
	length-=1;
	return true;
    }

    public int min(){
	if(length==0){
	    return -1;
	}
	Node current = first;
	T smallest = first.getValue();
	int smallI = 0;
	int index = 0;
	while(current!=null){
	    if(current.getValue().compareTo(smallest)<0){
		smallest = current.getValue();
		smallI = index;
	    }
	    index++;
	    current = current.getNext();
	}
	return smallI;
    }

    public int max(){
	if(length==0){
	    return -1;
	}
	Node current = first;
	T largest = first.getValue();
	int largeI = 0;
	int index = 0;
	while(current!=null){
	    if(current.getValue().compareTo(largest)>0){
		largest = current.getValue();
		largeI = index;
		
	    }
	    index++;
	    current = current.getNext();
	}
	return largeI;
    }

    public void extend(MyLinkedListImproved<T> other){
	other.first.setPrev(this.last);
	this.last.setNext(other.first);
	this.length+=other.length;
	other.clear();
    }
	
    
    

    private class Node{
	Node next, prev;
	T data;

	public Node(T n){
	    data = n;
	    next = null;
	    prev = null;
	}

	public Node(){
	    
	}

	public Node getNext(){
	    return next;
	}

	public Node getPrev(){
	    return prev;
	}

	public T getValue(){
	    return data;
	}

	public void setNext(Node n){
	    if(n==null){
		next = null;
	    }else{
		next = n;
	    }
	}

	public void setPrev(Node p){
	    if(p==null){
		prev = null;
	    }else{
		prev = p;
	    }
	}

	public void setValue(T i){
	    data = i;
	}

	public String toString(){
	    return prev + " " + data + " " + next;
	}
    }

    public class MyLinkedListIterator implements Iterator<T>{
	private Node current;

	public MyLinkedListIterator(Node n){
	    current = n;
	}

	public boolean hasNext(){
	    return current!=null;
	}

	public T next(){
	    if(this.hasNext()){
		current = current.getNext();
	    }else{
		throw new NoSuchElementException();
	    }
	    return current.getPrev().getValue();
	}

	public void remove(){
	    throw new UnsupportedOperationException();
	}
    }

    public static void main(String[] args){
	MyLinkedListImproved<Integer> test = new MyLinkedListImproved<Integer>();
	test.add(7);
	test.add(3);
	test.add(6);
	test.add(9);
	test.add(0, 0);
	test.add(5, 5);
	test.add(1,1);
	System.out.println(test.toString());
	// 0
	//System.out.println(test.min());
	// 5
	//System.out.println(test.max());

	MyLinkedListImproved<Integer> a = new MyLinkedListImproved<Integer>();
	a.add(0);
	a.add(1);
	a.add(2);
	a.add(3);
	a.add(4);
	System.out.println(a.toString());
	test.extend(a);
	System.out.println(test.toString());

	/*MyLinkedListImproved<String> s = new MyLinkedListImproved<String>();
	s.add("hi");
	s.add("this");
	s.add("is");
	s.add("a");
	s.add("test");
	System.out.println(s.toString());
	// 3
	System.out.println(s.min());
	// 1 
	System.out.println(s.max());*/
	    
    }
}

