import java.util.*;

public class Sorts{
    public static void radixsort(MyLinkedListImproved<Integer> data){
	@SupressWarnings("unchecked") MyLinkedListImproved<Integer>[] buckets = new MyLinkedListImproved[10];

	int maxI = data.max();
	Integer max = data.get(maxI);
	
    }

    public static int digits(Integer n){
	int sum = 0;
	if(n<0){
	    num *= -1;
	}
	while(n>=1){
	    sum++;
	    n/=10;
	}
	return sum;
    }

    
}
