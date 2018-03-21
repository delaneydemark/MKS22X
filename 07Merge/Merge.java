public class Merge{

    public static void merge(int[] data, int[] temp, int lo, int mid, int hi){
	int firstI = lo;
	int secondI = mid+1;
	for(int i = lo; i<=hi; i++){
	    if(firstI>mid){
		data[i]=temp[secondI];
		secondI+=1;
	    }else if(secondI>hi){
		data[i] = data[firstI];
		firstI+=1;
	    }else if(data[firstI]<data[secondI]){
		merged[i] = data[firstI];
		firstI+=1;
	    }else if(data[secondI]<=data[firstI]){
		merged[i] = data[secondI];
		secondI+=1;
	    }
	}
	return merged; 
    }

    public static void mergesort(int[] data){
	int[] temp = new int[data.length];
	msort(data, temp, 0, data.length-1);
    }

    private static void msort(int[] data, int[] temp, int lo, int hi){
	if(lo<=hi){
	    for(int i = lo; i<=hi; i++){
		temp[i]=data[i];
	    }
	    int mid = (lo+hi)/2;
	    msort(temp, data, lo, mid);
	    msort(temp, data, mid + 1, hi);
	    merge(data, temp, lo, mid, hi);
	}
    }
    

    public static void main(String[] args){
	int[] data = {2,6,8,10,1,3,9,200};
	int[] mergedData = merge(data, 0, 3, 4, 7);
	String s = "";
	for(int i = 0; i<mergedData.length; i++){
	    s+= mergedData[i] + " ";
	}
	System.out.println(s);
    }
}

