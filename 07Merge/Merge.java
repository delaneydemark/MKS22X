public class Merge{

    public static void merge(int[] data, int[] temp, int lo, int mid, int hi){
	int firstI = lo;
	int secondI = mid+1;
	for(int i = lo; i<=hi; i++){
	    if(firstI>mid){
		data[i]=temp[secondI];
		secondI+=1;
	    }else if(secondI>hi){
		data[i] = temp[firstI];
		firstI+=1;
	    }else if(temp[firstI]<temp[secondI]){
		data[i] = temp[firstI];
		firstI+=1;
	    }else if(temp[secondI]<=temp[firstI]){
		data[i] = temp[secondI];
		secondI+=1;
	    }
	} 
    }

    public static void mergesort(int[] data){
	int[] temp = new int[data.length];
	msort(data, temp, 0, data.length-1);
    }

    private static void msort(int[] data, int[] temp, int lo, int hi){
	if(hi-lo <= 10){
	    insertionSort(data, lo, hi);
	    return ;
	}
	for(int i = lo; i<=hi; i++){
	    temp[i]=data[i];
	}
	int mid = (lo+hi)/2;
	msort(temp, data, lo, mid);
	msort(temp, data, mid + 1, hi);
	merge(data, temp, lo, mid, hi);
	
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
    

    public static void main(String[] args){
	int[] data = {999,999,999,4,1,0,3,2,999,999,999};
	Merge.mergesort(data);
	String s = "";
	for(int i = 0; i<data.length; i++){
	    s+= data[i] + " ";
	}
	System.out.println(s);
    }
}

