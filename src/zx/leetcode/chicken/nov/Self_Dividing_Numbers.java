package zx.leetcode.chicken.nov;

import java.util.ArrayList;
import java.util.List;

public class Self_Dividing_Numbers {
	
	public List<Integer> selfDividingNumbers(int left, int right) {
		//digit can not contain zero
		List<Integer> ans = new ArrayList<Integer>();
		for(int i=left;i<=right;i++){
			if(isSelfDividingNumbers(i)){
				ans.add(i);
			}
		}
        return ans;
    }
	
	public boolean isSelfDividingNumbers(int num){
		int temp = num;
		while(num>0){
			int r = num%10;
			if(r==0)return false;
			if(temp%r!=0)return false;
			num/=10;
		}
		return true;
	}

}
