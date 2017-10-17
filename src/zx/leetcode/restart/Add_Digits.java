package zx.leetcode.restart;

public class Add_Digits {
	
	public int addDigits(int num){
		//当num为个位数时，直接返回
		if(num/10<=0)return num;
		int temp = num;
		while(temp/10>0){
			//digit不只一个
			int sum = 0;
			while(temp>0){
				sum+=temp%10;
				temp=temp/10;
			}
			temp = sum;
		}
		return temp;
	}

}
