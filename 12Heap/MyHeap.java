import java.io.*;
import java.util.*;

@SuppressWarnings("unchecked")
public class MyHeap<T extends Comparable<T>>{

    private T[] data;
    private int size;
    private boolean max;
    
    
    @SuppressWarnings("unchecked")
    public MyHeap(){
	data = (T[]) new Comparable[10];
	size = 0;
	max = true;
    }

    @SuppressWarnings("unchecked")
    public MyHeap(boolean b){
	data = (T[]) new Comparable[10];
	size = 0;
	max = b;
    }

    public void add(T s){
	if(this.size()==data.length){
	    this.resize();
	}
	data[size] = s;
	int child = size;
	int parent = (size-1)/2;
	while(parent>=0 && compareTo(data[parent], data[child])<0){
	    T a = data[child];
	    data[child] = data[parent];
	    data[parent] = a;
	    child = parent;
	    parent = (child-1)/2;
	}
	size++;
	
    }

    public void resize(){
	T[] d = (T[]) new Comparable[data.length*2];
	for(int i = 0; i<data.length; i++){
	    d[i] = data[i];
	}
	data = d;
    }

    public T remove(){
	T a = data[0];
	data[0] = data[size-1];
	data[size-1] = null;
	size--;
	pushDown(0);
	return a;
    }

    private void pushDown(int index){
	int parent = index;
	int child = parent*2 + 1;
	while(child<size && compareTo(data[parent], data[child])<0 || child+1<size && compareTo(data[parent], data[child+1])<0){
	    if(child+1>=size){
		T a = data[parent];
		data[parent] = data[child];
		data[child] = a;
		parent = child;
		return;
	    }else if(compareTo(data[parent], data[child])<0){
		T a = data[parent];
		data[parent] = data[child];
		data[child] = a;
		parent = child;
	    }else{
		T a = data[parent];
		data[parent] = data[child+1];
		data[child+1] = a;
		parent = child+1;
	    }
	    child = parent*2 + 1;
	}
    }

    public T peek(){
	if(this.size()<=0){
	    return null;
	}
	return data[0];
    }

    public int size(){
	return size;
    }

    private int compareTo(T a, T b){
	if(!max){
	    return a.compareTo(b) * -1;
	}
	return a.compareTo(b);
    }

    public String toString(){
	return Arrays.toString(data);
    }

    public static void main(String[] args){
	MyHeap<String> test = new MyHeap<String>();
	test.add("s");
	System.out.println(test.peek());
	test.add("zzzzzzzzzzzzz");
	System.out.println(test.peek());
	test.add("wooo");
	System.out.println(test.peek());
	test.remove();
	System.out.println(test.peek());
	System.out.println(test.toString());

	MyHeap<Integer> nums = new MyHeap<Integer>(false);
	nums.add(4);
	System.out.println("should be 4: " + nums.peek());
	nums.add(10);
	System.out.println("should be 4: " + nums.peek());
	nums.add(1);
	System.out.println("should be 1: " + nums.peek());
	nums.add(9);
	System.out.println("should be 1: " + nums.peek());
	nums.add(25);
	System.out.println("should be 1: " + nums.peek());
	nums.add(3);
	System.out.println("should be 1: " + nums.peek());
	nums.add(8);
	System.out.println("should be 1: " + nums.peek());
	System.out.println(nums.toString());
    }
	
}
