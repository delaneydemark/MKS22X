@SuppressWarnings("unchecked")

public class MyDeque<E>{
    private int start;
    private int end;
    private int length;
    private E[] data;
    
    @SuppressWarnings("unchecked")
    public MyDeque(){
	length = 10;
	data= (E[])new Object[10];
	start = 0;
	end = 0;
    }

    @SuppressWarnings("unchecked")
    public MyDeque(int initialCapacity){
	if(initialCapacity<0){
	    throw new IllegalArgumentException();
	}
	length = initialCapacity;
	data= (E[])new Object[length];
	start = 0;
	end = 0;
    }

    public int size(){
	return length;
    }

    public void addFirst(E element){
	if(element==null){
	    throw new NullPointerException();
	}if((start+end+1)%this.size() != 0){
	    start = (start-1) % this.size();
	    data[start] = element;
	    length++;
	}
    }

    public void addLast(E element){
	if(element==null){
	    throw new NullPointerException();
	}
	if((start+end+1)%this.size() != 0){
	    end = (end+1) % this.size();
	    data[end] = element;
	    length++;
	}
    }

    public E removeFirst(){
	if(length==0){
	    throw new NoSuchElementException();
	}
	E val = data[start];
	start = (start-1) % this.size();
	return val;
    }

    public E removeLast(){
	if(length==0){
	    throw new NoSuchElementException();
	}
	E val = data[end];
	end = (end-1) % this.size();
	return val;
    }

    public E getFirst(){
	if(length==0){
	    throw new NoSuchElementException();
	}
    }

    public static void main(String[] args){
	MyDeque test = new MyDeque();
	MyDeque a = new MyDeque(20);
    }

}

