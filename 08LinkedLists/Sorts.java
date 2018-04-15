import java.util.*;
import java.io.*;

public class Sorts{
    public static void radixsort(MyLinkedListImproved<Integer> data){
	@SuppressWarnings("unchecked") MyLinkedListImproved<Integer>[] buckets = new MyLinkedListImproved[10];

	int maxI = data.max();
	Integer max = data.get(maxI);
	
    }

    public static int digits(Integer n){
	int sum = 0;
	if(n<0){
	    n *= -1;
	}
	while(n>=1){
	    sum++;
	    n/=10;
	}
	return sum;
    }

    public static void main(String[] args){
	MyLinkedListImproved<Integer> test = new MyLinkedListImproved<Integer>();
	test.add(3);
	test.add(2);
	test.add(57);
	test.add(9);
	test.add(666);
	System.out.println(test.toString());
	System.out.println(Sorts.digits(test.get(test.max())));
    }

    
}
