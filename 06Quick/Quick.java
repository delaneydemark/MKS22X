import java.util.Random;

public class Quick{
    
    public static int partition(int[] data, int start, int end){
	Random rand = new Random();
	int pivot = rand.nextInt(end-start + 1) + start;

	int pVal = data[pivot];
	data[pivot] = data[start];
	data[start] = pVal;
	int small = start + 1;
	int large = end;
	while(small<=large ){
	    if(data[small]>=pVal){
		int swap = data[large];
		data[large] = data[small];
		data[small] = swap;
		large--;
	    }else if(data[small]<pVal){
		small++;
	    }
	}
	int sw = data[large];
	data[large] = pVal;
	data[start] = sw;
	return large;
    }

    public static int quickselect(int[] data, int k){
	int start = 0;
	int end = data.length-1;
	int index = partition(data, start, end);
	for(int i = 0; i<data.length; i++){
	    if(index==k){
		return data[k];
	    }else if(k<=index){
		end = index-1;
	    }else if(k>index){
		start = index+1;
	    }
	    index = partition(data, start, end);
	}
	return data[k];
    }

    public static void quicksort(int[] data){
	quickH(data, 0, data.length -1);
    }

    public static void quickH(int[] data, int start, int end){
	
    }
    public static void main(String[] args){
		int[] arr = {999,999,999,4,1,0,3,2,999,999,999};
		/*int index = Quick.partition(arr, 0, 7);
		System.out.println(index);
		String s = "";
		for(int i = 0; i<arr.length; i++){
			s+=" " + arr[i];
		}
		System.out.println(s);*/
		int k = Quick.quickselect(arr, 2);
		System.out.println(k);
		String s = "";
		for(int i = 0; i<arr.length; i++){
			s+=" " + arr[i];
		}
		System.out.println(s);
		

		
    }
}