public class MyLinkedList{
    Node first;
    Node last;
    int length;

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
