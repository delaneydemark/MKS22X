import java.util.*;

public class RunningMedians{
    private MyHeap<Double> max;
    private MyHeap<Double> min;
    private double median;

    public RunningMedians(){
	max = new MyHeap<Double>();
	min = new MyHeap<Double>(false);
	median = 0;
    }

    public void add(Double d){
	if(max.size()==0 && min.size()==0){
	    max.add(d);
	    median = d;
	}else{
	    if(d<=median){
		max.add(d);
	    }else if(d>median){
		min.add(d);
	    }
	}

	if(max.size()-min.size()>1){
	    Double i = max.remove();
	    min.add(i);
	}else if(min.size()-max.size()>1){
	    Double i = min.remove();
	    max.add(i);
	}
    }

    public int size(){
	return max.size() + min.size();
    }

    public double getMedian(){
	if(size()==0){
	    throw new NoSuchElementException();
	}
	if(max.size() - min.size() == 1){
	    median = max.peek();
	}else if(min.size() - max.size() ==1){
	    median = min.peek();
	}else{
	    median = (min.peek() + max.peek()) / 2;
	}
	return median;
    }

    public static void main(String[] args){
	RunningMedians test = new RunningMedians();
	test.add(3.0);
	test.add(5.0);
	test.add(7.0);
	System.out.println(test.getMedian());
    }
}
