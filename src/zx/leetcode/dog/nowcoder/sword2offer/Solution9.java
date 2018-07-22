package zx.leetcode.dog.nowcoder.sword2offer;

public class Solution9 {

	public void reOrderArray(int[] array) {
		int i = 0;
		int j = array.length - 1;
		while(i<j){
			if((array[i]&0x01)==1){
				i++;
			}
			if((array[j]&0x01)==0){
				j--;
			}
			int temp = array[i];
			array[i] = array[j];
			array[j] = temp;
			i++;
			j--;
			
			for(int k=0;k<array.length;k++){
				System.out.print(array[k]);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		new Solution9().reOrderArray(new int[]{1,2,3,4,5,6,7});
	}
}
