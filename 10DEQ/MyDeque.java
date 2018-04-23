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
	if(size==0){
	    data[start] = element;
	}else{
	    if(size >= data.length){
		this.resize();
	    }
	    if(size != data.length){
		start--;
		if(start<0){
		    start+= data.length;
		}
		data[start] = element;
	    }
	}
	//System.out.println(start);
	//System.out.println(end);
	size++;
    }
    
    public void addLast(E element){
	if(element==null){
	    throw new NullPointerException();
	}
	if(size >= data.length){
	    this.resize();
	}
	if(size != data.length){
	    end = (end+1) % data.length;
	    data[end] = element;
	}
	//System.out.println(end);
	size++;
    }
    
    public E removeFirst(){
	if(size==0){
	    throw new NoSuchElementException();
	}
	E val = data[start];
	data[start] = null;
	start = (start+1) % data.length;
	size--;
	return val;
    }
    /*
    public E removeLast(){
	if(size==0){
	    throw new NoSuchElementException();
	}
	E val = data[end];
	end = (end-1) % this.size();
	size--;
	return val;
    }
    */
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
    
    public void resize(){
	E[] d = (E[])new Object[data.length*2];
	for(int i = start; i<start+this.size(); i++){
	    d[i-start] = data[i % data.length];
	}
	start = 0;
	end = this.size()-1;
	data = d;
	
    }

    public static void main(String[] args){
	MyDeque test = new MyDeque(5);
	MyDeque a = new MyDeque(20);
	test.addFirst(4);
	//System.out.println(test.getFirst());
	test.addFirst(1);
	test.addFirst(20);
	test.addFirst(300);
	test.addFirst(5);
	//test.getFirst();
	test.addFirst(6);
	//System.out.println(test.getFirst());
	//System.out.println(test.getLast());
	//System.out.println(test.toString());
	//test.resize();
	System.out.println(test.toString());
	System.out.println(test.removeFirst());
	System.out.println(test.toString());
	System.out.println(test.removeFirst());
	System.out.println(test.toString());
    }

}

