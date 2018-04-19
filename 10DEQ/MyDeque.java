import java.util.*;

@SuppressWarnings("unchecked")

public class MyDeque<E>{
    private int start;
    private int end;
    private int size;
    private E[] data;
    
    @SuppressWarnings("unchecked")
    public MyDeque(){
	size = 0;
	data= (E[])new Object[10];
	start = 0;
	end = 0;
    }

    @SuppressWarnings("unchecked")
    public MyDeque(int initialCapacity){
	if(initialCapacity<0){
	    throw new IllegalArgumentException();
	}
	size = 0;
	data= (E[])new Object[initialCapacity];
	start = 0;
	end = 0;
    }

    public int size(){
	return size;
    }

    public void addFirst(E element){
	if(element==null){
	    throw new NullPointerException();
	}
	start--;
	if(size != data.length){
	    if(start<0){
		start+= data.length;
	    }
	    data[start] = element;
	}
	size++;
    }
    
    public void addLast(E element){
	if(element==null){
	    throw new NullPointerException();
	}
	if(size != data.length){
	    end = (end+1) % data.length;
	    data[end] = element;
	}
	size++;
    }
    /*
    public E removeFirst(){
	if(size==0){
	    throw new NoSuchElementException();
	}
	E val = data[start];
	start = (start+1) % this.size();
	size--;
	return val;
    }

    public E removeLast(){
	if(size==0){
	    throw new NoSuchElementException();
	}
	E val = data[end];
	end = (end-1) % this.size();
	size--;
	return val;
    }

    public E getFirst(){
	if(size==0){
	    throw new NoSuchElementException();
	}
	return data[start];
	}

    public E getLast(){
	if(size==0){
	    throw new NoSuchElementException();
	}
	return data[end];
    }
    */
    public String toString(){
	String s = "[";
	for(int i = 0; i< data.length; i++){
	    if(i== data.length-1){
		s+= data[i] + "]";
	    }else{
		s+= data[i] + ", ";
	    }
	}
	return s;
    }
    /*
    public void resize(){
	E[] d = (E[])new Object[data.length*2];
	for(int i = start; i<this.size(); i++){
	    d[i-start] = data[i % this.size()];
	}
	data = d;
	}*/

    public static void main(String[] args){
	MyDeque test = new MyDeque();
	MyDeque a = new MyDeque(20);
	test.addFirst(4);
	//System.out.println(test.getFirst());
	test.addFirst(1);
	test.addLast(20);
	//System.out.println(test.getFirst());
	//System.out.println(test.getLast());
	System.out.println(test.toString());
    }

}

