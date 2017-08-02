package zx.leetcode.Aug.pingduoduo;

public class Main4 {
	
	    public static void main(String[] args) {
	        
	        int[] a = {1, -2, 3, 10, -4, 7, 2, -5};
	        int max = MaxSum(a);
	        System.out.println(max);
	    }
	    
	   
	    public static int MaxSum(int[] a){
	        int sum = 0;
	        int max = 0;
	        for(int i=0;i<a.length;i++){
	            sum = sum + a[a.length-i-1];
	            if(a[a.length-i-1] >= 0){
	               if(max < sum){
	                  max = sum ;
	                }
	            }
	            if(sum < 0){
	                 sum = 0;
	             }
	        }
	        return max;
	    }
	
}
