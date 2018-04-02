package zx.leetcode.dog.microsoft;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Main2 {

	long calculatePower(int numOfKids, int cardDrawn, int[][] studentPair,
			int[] strength) {
		int max = 0;
		int[] sameGroup = new int[cardDrawn];
		for(int i=0;i<sameGroup.length;i++){
			//1 2 3
			sameGroup[i] = i+1;
		}
		
		for(int i=0;i<studentPair.length;i++){
			Set set = new HashSet();
			set.add(studentPair[i][0]);
			set.add(studentPair[i][1]);
			for(int j=i+1;j<studentPair.length;j++){
				if(set.contains(studentPair[j][0])||set.contains(studentPair[j][1])){
					sameGroup[j] = sameGroup[i]; 
				}
			}
		}
		
		int[] countdisAppear = new int[numOfKids+1];
		HashSet allSet = new HashSet();
		Arrays.fill(countdisAppear, -1);
		for(int i=0;i<studentPair.length;i++){
			for(int j=0;j<studentPair[0].length;j++){
				allSet.add(studentPair[i][j]);
			}
		}
		for(int i=1;i<=numOfKids;i++){
			if(allSet.contains(i)){
				countdisAppear[i] = 1;
			}
		}
		
		for(int i=1;i<countdisAppear.length;i++){
			if(max<=strength[i-1]&&countdisAppear[i]==-1){
				max = strength[i-1];
			}
		}
		
		
		
		for(int i=1;i<=sameGroup.length;i++){
			HashSet tempSet = new HashSet();
			for(int j=0;j<studentPair.length;j++){
				if(sameGroup[j]==i){
					tempSet.add(studentPair[j][0]);
					tempSet.add(studentPair[j][1]);
				}
			}
			Iterator iterator = tempSet.iterator();
			int sum = 0;
			while(iterator.hasNext()){
				sum+=strength[(int)iterator.next()-1];
			}
			if(sum>=max){
				max = sum;
			}
		}
		
		return max+0L;
	}
	
	public static void main(String[] args) {
		new Main2().calculatePower(6, 3, new int[][]{{1,2},{2,3},{4,5}}, new int[]{11,2,3,15,8,22});
	}

}
