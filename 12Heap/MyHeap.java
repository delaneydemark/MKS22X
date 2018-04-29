import java.io.*;
import java.util.*;

public class MyHeap{

    private String[] data;
    private int size;
    private boolean max;
    
    

    public MyHeap(){
	data = new String[10];
	size = 0;
	max = true;
    }

    public MyHeap(boolean b){
	data = new String[10];
	size = 0;
	max = b;
    }

    public void add(String s){
	if(this.size()==data.length){
	    this.resize();
	}
	data[size] = s;
	int child = size;
	int parent = (size-1)/2;
	while(parent>=0 && compareTo(data[parent], data[child])<0){
	    String a = data[child];
	    data[child] = data[parent];
	    data[parent] = a;
	    child = parent;
	    parent = (child-1)/2;
	}
	size++;
	
    }

    public void resize(){
	String[] d = new String[data.length*2];
	for(int i = 0; i<data.length; i++){
	    d[i] = data[i];
	}
	data = d;
    }

    /*public String remove(){
	String a = data[0];
	
	}*/

    public String peek(){
	if(this.size()<=0){
	    return "";
	}
	return data[0];
    }

    public int size(){
	return size;
    }

    private int compareTo(String a, String b){
	if(!max){
	    return a.compareTo(b) * -1;
	}
	return a.compareTo(b);
    }

    public static void main(String[] args){
	MyHeap test = new MyHeap();
	test.add("s");
	System.out.println(test.peek());
	test.add("zzzzzzzzzzzzz");
	System.out.println(test.peek());
	test.add("wooo");
	System.out.println(test.peek());

    }
	
}
