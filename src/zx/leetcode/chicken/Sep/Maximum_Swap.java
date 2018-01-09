package zx.leetcode.chicken.Sep;
/**
 * 670. Maximum Swap	
 * @param num
 * @return
 */
public class Maximum_Swap {

	public int maximumSwap(int num) {
		Integer numInt = Integer.valueOf(num);
		String numStr = numInt.toString();
		char[] numsArr = numStr.toCharArray();
		boolean flag = true;
		for(int i=0;i<numsArr.length&&flag==true;i++){
			char c = numsArr[i];
			Integer cInt = Integer.valueOf(c-'0');
			int indexJ = 0;
			int maxJ = cInt;
			for(int j=i+1;j<numsArr.length;j++){
				char cj = numsArr[j];
				Integer cjInt = Integer.valueOf(cj-'0');
				if(cjInt>=maxJ){
					maxJ = cjInt;
					indexJ = j;
				}
			}
			if(maxJ>cInt){
				char temp = numsArr[i];
				numsArr[i]=numsArr[indexJ];
				numsArr[indexJ]=temp;
				flag = false;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(char c:numsArr){
			sb.append(c);
		}
		return Integer.valueOf(sb.toString());
				
    }
	
	public static void main(String[] args) {
//		System.out.println(new Maximum_Swap().maximumSwap(98368));
		System.out.println(new Maximum_Swap().maximumSwap(1993));
	}

}
