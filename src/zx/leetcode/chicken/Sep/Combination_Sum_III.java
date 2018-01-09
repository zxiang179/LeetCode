package zx.leetcode.chicken.Sep;

import java.util.ArrayList;
import java.util.List;

/**
 * 216. Combination Sum III
 * @author Carl_Hugo
 * 2017年9月14日 上午9:26:28
 */
public class Combination_Sum_III {
	
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> ans = new ArrayList<>();
		combination(ans,new ArrayList<Integer>(),k,1,n);
		return ans;
    }
	
	private void combination(List<List<Integer>> ans,
			List<Integer> comb,int k,int start,int n){
		if(comb.size()==k&&n==0){
			List<Integer> li = new ArrayList<Integer>(comb);
			ans.add(li);
			return;
		}
		for(int i=start;i<=9;i++){
			comb.add(i);
			combination(ans,comb,k,i+1,n-i);
			comb.remove(comb.size()-1);
		}
		
	}

}
