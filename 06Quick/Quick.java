import java.util.Random;

public class Sorts{
    
    public static int partition(int[] data, int start, int end){
		Random rand = new Random();
		int pivot = rand.nextInt(data.length);
		int pVal = data[pivot];
		data[pivot] = data[start];
		data[start] = pVal;
		int small = start + 1;
		while(small<=end ){
			if(data[small]>pVal){
	    		int swap = data[end];
	    		data[end] = data[small];
	    		data[small] = swap;
	    		end--;
	    	}else if(data[small]<=pVal){
	    		small++;
	    	}
		}
		int sw = data[end];
		data[end] = pVal;
		data[start] = sw;
		return end;
    }

    public static int quickselect(int[] data, int k){
	int index = 0;
	int start = 0;
	int end = data.length-1;
	for(int i = 0; i<data.length; i++){
	    index = partition(data, start, end);
	    if(index==k){
		return data[k];
	    }else if(k<=index){
		end = index-1;
	    }else if(k>index){
		start = index+1;
	    }
	}
	return data[k];
    }
    public static void main(String[] args){
		int[] arr = {999,999,999,4,1,0,3,2,999,999,999};
		/*int index = Sorts.partition(arr, 0, arr.length-1);
		System.out.println(index);
		String s = "";
		for(int i = 0; i<arr.length; i++){
			s+=" " + arr[i];
		}
		System.out.println(s);*/
		

		
    }
}
