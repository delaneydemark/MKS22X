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
	
    }

    public String remove(){
	
    }

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
	
}
