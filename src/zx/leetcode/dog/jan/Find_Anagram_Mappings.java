/**
 * @author Carl_Hugo
 * 2018年1月9日 下午8:27:39
 */
package zx.leetcode.dog.jan;

class Find_Anagram_Mappings{
	
	public int[] anagramMappings(int[] A, int[] B) {
		int[] resArr = new int[A.length];
		int temp;
		for(int i=0;i<A.length;i++){
			temp = A[i];
			for(int j=0;j<B.length;j++){
				if(temp==B[j]){
					resArr[i] = j;
				}
			}
		}
	    return resArr;
	}
	
}