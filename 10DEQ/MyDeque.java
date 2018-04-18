@SuppressWarnings("unchecked")

public class MyDeque<T>{
    private int start;
    private int end;
    private int length;
    private T[] data;
    

    public MyDeque(){
	length = 10;
	@SuppressWarnings("unchecked") data = new T[10];
	start = 0;
	end = 0;
    }

    public MyDeque(int initialCapacity){
	if(initialCapacity<0){
	    throw new IllegalArgumentException();
	}
	length = initialCapacity;
	@SuppressWarnings("unchecked") data = new T[length];
	start = 0;
	end = 0;
    }

    public int size(){
	return length;
    }

    public void addFirst(T element){
	if(element==null){
	    throw new NullPointerException();
	}if((start+end+1)%this.size() != 0){
	    start = (start-1) % this.size();
	    data[start] = element;
	    length++;
	}
    }

    public void addLast(T element){
	if(element==null){
	    throw new NullPointerException();
	}
	if((start+end+1)%this.size() != 0){
	    end = (end+1) % this.size();
	    data[end] = element;
	    length++;
	}
    }

    public static void main(String[] args){
	MyDeque test = new MyDeque();
	MyDeque a = new MyDeque(20);
    }

}

