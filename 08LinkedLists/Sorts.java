import java.util.*;
import java.io.*;

public class Sorts{
    public static void radixsort(MyLinkedListImproved<Integer> data){
	@SuppressWarnings("unchecked") MyLinkedListImproved<Integer>[] buckets = new MyLinkedListImproved[10];
	for(int i = 0; i<buckets.length; i++){
	    buckets[i] = new MyLinkedListImproved<Integer>();
	}

	int maxI = data.max();
	Integer max = data.get(maxI);
	int digits = Sorts.digits(max);
	int level = 1;
	for(int d = 1; d<=digits; d++){
	    for(Integer i : data){
		int bucket = (i/level) % 10;
		buckets[bucket].add(i);
	    }
	}
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

    public static int getDigit(Integer n, int digit){
	Integer d = 0;
	int i = 1;
	int level = 1;
	while(i <= digit){
	    d = (n/level) % 10;
	    level *= 10;
	    i++;
	}
	return d;
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
	System.out.println(Sorts.getDigit(test.get(2), 2));
    }

    
}
