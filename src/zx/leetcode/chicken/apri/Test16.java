package zx.leetcode.chicken.apri;

/**
 * 167. Two Sum II - Input array is sorted
 * @author Carl_Hugo
 */
public class Test16 {
	
    public int[] twoSum(int[] numbers, int target) {
        int end = numbers.length-1;
        int[] res = new int[2];
        for(int i=0,j=end;i<j;){
        	if(numbers[i]+numbers[j]>target){
        		j--;
        	}else if(numbers[i]+numbers[j]<target){
        		i++;
        	}else{
        		res[0]=i+1;
        		res[1]=j+1;
        		break;
        	}
        }
        return res;
    }
    
    public static void main(String[] args) {
		Test16 test16 = new Test16();
		int[] res = new int[2];
		res = test16.twoSum(new int[]{2, 7, 8,11, 15}, 15);
		for(int i:res){
			System.out.print(i+" ");
		}
    	
	}

}
