package zx.leetcode.chicken.Aug.toutiao;

public class Main2 {
	
	public static void main(String[] args){
//	    int[] arr = {6,1,3,2,3,12,2,4,5,5,5,5,5,5,6,7,7,8,8,2,9,9,9};
		int[] arr = {2,1,6};
	    System.out.println(max(arr,0,arr.length-1));
	}
	static public int max(int[] arr, int start, int end){
	    if(start == end) return arr[start];
	    if(start > end) return 0;
	    int minNum = Integer.MAX_VALUE;
	    int minNumIndex = 0;
	    int sum = 0;
	    int result = 0;
	    for(int i = start; i <= end; i++){
	        if(arr[i] < minNum){
	            minNum = arr[i];
	            minNumIndex = i;
	        }
	        sum += arr[i];
	    }
	    result = minNum* sum;
	    int resultLeft = max(arr, start, minNumIndex-1);
	    int resultRight = max(arr, minNumIndex+1, end);
	    return Math.max(result, Math.max(resultLeft, resultRight));
	}

}
