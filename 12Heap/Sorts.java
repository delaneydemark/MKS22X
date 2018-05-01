import java.io.*;
import java.util.*;

public class Sorts{
    public static void heapsort(Integer[] arr){
	MyHeap<Integer> nums = MyHeap.heapify(arr);
	//System.out.println(Arrays.toString(arr));
	for(int i = 0; i<nums.size(); i++){
	    Integer val = nums.remove();
	    arr[nums.size()] = val;
	}
    }

    public static void main(String[] args){
	Integer[] test = new Integer[5];
	test[0] = 4;
	test[1] = 7;
	test[2] = 10;
	test[3] = 5;
	test[4] = 3;
	heapsort(test);
	System.out.println(Arrays.toString(test));
    }
}
