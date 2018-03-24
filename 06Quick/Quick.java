import java.util.Random;

public class Quick{
    
    public static int firstpartition(int[] data, int start, int end){
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

    public static int[] partition(int[] data, int start, int end){
	Random rand = new Random();
	int pivot = rand.nextInt(end-start + 1) + start;

	int pVal = data[pivot];
	data[pivot] = data[start];
	data[start] = pVal;
	int lt = start;
	int gt = end;
	int i = lt+1;
	
	while(i<=gt){
	    if(data[i]==pVal){
		i++;
	    }else if(data[i]>pVal){
		int swap = data[i];
		data[i] = data[gt];
		data[gt] = swap;
		gt--;
	    }
	    else{
		int s = data[i];
		data[i] = data[lt];
		data[lt] = s;
		i++;
		lt++;
	    }
	}
	int indices[] = new int[2];
	indices[0] = lt;
	indices[1] = gt;
	return indices;
    }

    

    public static int firstquickselect(int[] data, int k){
	int start = 0;
	int end = data.length-1;
	int index = firstpartition(data, start, end);
	for(int i = 0; i<data.length; i++){
	    if(index==k){
		return data[k];
	    }else if(k<=index){
		end = index-1;
	    }else if(k>index){
		start = index+1;
	    }
	    index = firstpartition(data, start, end);
	}
	return data[k];
    }

    public static int quickselect(int[] data, int k){
	int start = 0;
	int end = data.length-1;
	int[] indices = partition(data, start, end);
	for(int i = 0; i<data.length; i++){
	    
	    if(indices[0]<=k && indices[1]>=k){
		return data[k];
	    }else if(k<=indices[0]){
		end = indices[0]-1;
	    }else if(k>indices[1]){
		start = indices[1]+1;
	    }
	    indices = partition(data, start, end);
	}
	return data[k];
    }


    
    public static void quicksort(int[] data){
	quickH(data, 0, data.length -1);
    }

    public static void quickH(int[] data, int start, int end){
	if(end-start<=10 && end-start>0){
	    int indices[] = partition(data, start, end);
	    Quick.insertionSort(data, start, indices[0]);
	    Quick.insertionSort(data, indices[1]+1, end);
	}else if(end-start>0){
	    int indices[] = partition(data, start, end);
	    quickH(data, start, indices[0]);
	    quickH(data, indices[1]+1, end);
	}
    }

    private static void swap(int[]ary,int a, int b){
        int c =ary[a];
        ary[a] = ary[b];
        ary[b] = c;
    }

    public static void insertionSort(int[] ary, int start, int end){
        for (int i = start+1; i<=end; i++){
                int current = i;
                for (int j = i-1; j>=start; j--){
                        if(ary[j]>ary[current]){
                                swap(ary,j,current);
                                current = j;
                        }
                }
        }
    }
    /*public static void main(String[] args){
		int[] arr = {999,999,999,4,1,0,3,2,999,999,999};
		int[] index = Quick.partition(arr, 0, arr.length-1);
		System.out.println(index[0]);
		System.out.println(index[1]);
		String s = "";
		for(int i = 0; i<arr.length; i++){
			s+=" " + arr[i];
		}
		System.out.println(s);
		int k = Quick.quickselect(arr, 3);
		System.out.println(k);
		String s = "";
		for(int i = 0; i<arr.length; i++){
			s+=" " + arr[i];
		}
		System.out.println(s);
		Quick.quicksort(arr);
		String s = "";
		for(int i = 0; i<arr.length; i++){
			s+=" " + arr[i];
		}
		System.out.println(s);
		

		
		}*/
    public static void main(String[] args){
	int[] arr = {999,999,999,4,1,0,3,2,999,999,999};
	Quick.insertionSort(arr, 3, 10);
	String s = "";
	for(int i = 0; i<arr.length; i++){
	    s+= arr[i] + " ";
	}
	System.out.println(s);
    }
}
