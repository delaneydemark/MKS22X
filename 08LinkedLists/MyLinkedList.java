public class MyLinkedList{
    Node first;
    Node last;
    int length;

    public MyLinkedList(){
	first = new Node();
	last = new Node();
	length = 0;
    }

    public boolean add(Integer value){
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

    public Integer get(int index){
	if(index<0 || index>=length){
	    throw new IndexOutOfBoundsException();
	}
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

    public Integer set(int index, int newValue){
	if(index<0 || index>=length){
	    throw new IndexOutOfBoundsException();
	}
	Node i = first;
	int j = 0;
	int val = 0;
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

    public int indexOf(int value){
	int j = 0;
	while(j<length){
	    if(this.get(j)==value){
		return j;
	    }
	    j++;
	}
	return -1;
    }

    
    public void add(int index, int value){
	if(index<0 || index>length){
	    throw new IndexOutOfBoundsException();
	}
	if(index == 0){
	   
	}else if(index == length){
	    this.add(value);
	}else{
	    
	}
    }

    /*
    public int remove(int index){
    }*/

    private class Node{
	Node next, prev;
	int data;

	public Node(Integer n){
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
	
	System.out.println(test.size());
	System.out.println(test.get(0));
	test.add(3);
	test.add(6);
	test.add(9);
	//test.set(0,3);
	System.out.println(test.toString());
	//Node i = test.getNode(2);
	//System.out.println(i.getValue());
	//System.out.println(test.indexOf(6));
	//System.out.println(test.indexOf(2));
    }
}
