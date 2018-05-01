public class RunningMedians{
    private MyHeap<Integer> max;
    private MyHeap<Integer> min;

    public RunningMedians(){
	max = new MyHeap<Integer>();
	min = new MyHeap<Integer>(false);
    }

    
}
