public class MyLinkedList{
    Node first;
    Node last;
    int length;

    public MyLinkedList(){
	first = new Node();
	last = new Node();
	length = 0;
    }

    public boolean add(int value){
	
	if(length==0){
	    first.setValue(value);
	    last.setValue(value);
	}else{
	    Node i = new Node();
	    i.setValue(value);
	    last.setNext(i);
	    i.setPrev(last);
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

    public int get(int index){
	Node i = first;
	int j = 0;
	int val = 0;
	while(i!=null && j<length){
	    if(j==index){
		val = i.getValue();
	    }
	    j++;
	    i = i.getNext();
	}
	return val;
    }

    public int set(int index, int newValue){
	Node i = first;
	int j = 0;
	int val = 0;
	while(i!=null & j<length){
	    if(j==index){
		i.setValue(newValue);
	    }
	    j++;
	    i = i.getNext();
	}
	return val;
    }

    /*public int indexOf(int value){
    }

    public void add(int index, int value){
    }

    public int remove(int index){
    }*/

    private class Node{
	Node next, prev;
	int data;

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
	    next = n;
	}

	public void setPrev(Node p){
	    prev = p;
	}

	public void setValue(int i){
	    data = i;
	}

	public String toString(){
	    return prev + " " + data + " " + next;
	}
    }

    public static void main(String[] args){
	MyLinkedList test = new MyLinkedList();
	test.add(7);
	System.out.println(test.toString());
    }
}
