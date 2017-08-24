package zx.leetcode.Aug;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 406. Queue Reconstruction by Height
 * @author Carl_Hugo
 * @date 2017年8月24日
 */
public class Test19 {
	
    public int[][] reconstructQueue(int[][] people) {
    	if(people==null||people.length==0||people[0].length==0){
    		return new int[0][0];
    	}
    	
    	//比较一个二维数组，第一个元素按降序排列,当第一个元素相同时，第二个元素按照升序排列
    	Arrays.sort(people,new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				if(a[0]==b[0])return a[1]-b[1];
	    		return b[0]-a[0];	
			}
		});
    	
    	int n = people.length;
    	ArrayList<int[]> tmp = new ArrayList<>();
    	for(int i=0;i<n;i++){
    		tmp.add(people[i][1], new int[]{people[i][0],people[i][1]});
    	}
    	
    	int[][] res = new int[people.length][2];
    	int i=0;
    	for(int[] k:tmp){
    		res[i][0]=k[0];
    		res[i++][1]=k[1];
    	}
    	return res;
    }
    
    public static void main(String[] args) {
    	int[][] people={{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
		new Test19().reconstructQueue(people);
	}

}
