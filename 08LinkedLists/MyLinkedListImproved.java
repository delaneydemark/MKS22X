public class MyLinkedListImproved<T>{
    Node first;
    Node last;
    int length;

    public MyLinkedListImproved<T>(){
	first = new Node();
	last = new Node();
	length = 0;
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

    public String toString(){
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

	public int getValue(){
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

    public static void main(String[] args){
	MyLinkedListImproved<Integer> test = new MyLinkedListImproved<Integer>();
	test.add(7);
	
	//System.out.println(test.size());
	//System.out.println(test.get(0));
	test.add(3);
	test.add(6);
	test.add(9);
	//test.set(0,3);
	//System.out.println(test.toString());
	//Node i = test.getNode(2);
	//System.out.println(i.getValue());
	//System.out.println(test.indexOf(6));
	//System.out.println(test.indexOf(2));
	test.add(0, 0);
	//System.out.println(test.toString());
	test.add(5, 5);
	//System.out.println(test.toString());
	test.add(1,1);
	System.out.println(test.toString());
	System.out.println(test.remove(5));
	System.out.println(test.toString());
	//System.out.println(test.indexOf(5));
    }
}

