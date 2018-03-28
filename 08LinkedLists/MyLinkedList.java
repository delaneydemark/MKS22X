public class MyLinkedList{
    Node first;
    Node last;
    int length;

    public MyLinkedList(){
    }

    public boolean add(int value){
    }

    public int size(){
	return length;
    }

    public String toString(){
	String s = "{";
	Node i = first;
	while(i!=null){
	    if(i.next==null){
		s+=i.getValue() + "}";
	    }else{
		s+=i.getValue() + ", ";
	    }
	    i = node.next;
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
	    j++:
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
	}
	return val;
    }

    public int indexOf(int value){
    }

    public void add(int index, int value){
    }

    public int remove(int index){
    }

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
}
