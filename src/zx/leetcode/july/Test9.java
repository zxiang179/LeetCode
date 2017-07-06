package zx.leetcode.july;
/**
 * 413. Arithmetic Slices
 * @author Carl_Hugo
 * @date 2017年7月6日
 */
public class Test9 {
	
    public int numberOfArithmeticSlices(int[] A) {
        int step = 0;
        int count = 0;
        int gap=0;
        int element = 3;
        step = A[1] - A[0];
        if(A.length<3)return 0;
        for(int i=2;i<A.length;i++){
        	if(A[i]-A[i-1]!=step)return 0;
        }
        
        while(element<=A.length){
        	count+=A.length-element+1;
        	gap=1;
        	while(((gap+1)*(element-1)+1)<=A.length){
            	count +=(A.length-((gap+1)*(element-1)+1)+1);
            	gap++;
            }
        }
        
        return count;
    }

}
