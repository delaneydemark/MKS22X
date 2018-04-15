import java.util.*;
import java.io.*;

public class Sorts{
    public static void radixsort(MyLinkedListImproved<Integer> data){
	@SuppressWarnings("unchecked") MyLinkedListImproved<Integer>[] buckets = new MyLinkedListImproved[10];
	for(int i = 0; i<buckets.length; i++){
	    buckets[i] = new MyLinkedListImproved<Integer>();
	}

	MyLinkedListImproved<Integer> negativeNums = new MyLinkedListImproved<>();

	for(Integer i : data){
	    if(i<0){
		negativeNums.add(i);
		data.remove(i);
	    }
	}
	
	int maxI = data.max();
	Integer max = data.get(maxI);
	int digits = Sorts.digits(max);
	for(int d = 1; d<=digits; d++){
	    for(Integer i : data){
		int bucket = Sorts.getDigit(i, d);
		buckets[bucket].add(i);
	    }

	    data.clear();

	    for(int i = 0; i<buckets.length; i++){
		data.extend(buckets[i]);
		buckets[i].clear();
	    }
	}
	negativeNums = Sorts.sortNegatives(negativeNums);
	negativeNums.extend(data);
	data.extend(negativeNums);
    }

    public static MyLinkedListImproved sortNegatives(MyLinkedListImproved<Integer> data){
	@SuppressWarnings("unchecked") MyLinkedListImproved<Integer>[] buckets = new MyLinkedListImproved[10];
	for(int i = 0; i<buckets.length; i++){
	    buckets[i] = new MyLinkedListImproved<Integer>();
	}
	
	int minI = data.min();
	Integer min = data.get(minI);
	int digits = Sorts.digits(min);
	for(int d = 1; d<=digits; d++){
	    for(Integer i : data){
		int bucket = Sorts.getDigit(i, d) + 9;
		buckets[bucket].add(i);
	    }

	    data.clear();

	    for(int i = 0; i<buckets.length; i++){
		data.extend(buckets[i]);
		buckets[i].clear();
	    }
	}
	return data;
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
	//System.out.println(Sorts.digits(test.get(test.max())));
	//System.out.println(Sorts.getDigit(test.get(2), 2));
	//Sorts.radixsort(test);
	//System.out.println(test.toString());
	
	test.add(-1);
	test.add(-30);
	test.add(-6);
	test.add(-17);
	test.add(-300);
	Sorts.radixsort(test);
	System.out.println(test.toString());
    }

    
}
