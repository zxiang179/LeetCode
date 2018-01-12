package zx.leetcode.dog.jan;

public class bit1_and_bit2_Characters {
	
	/**
	 * 1-bit 0
	 * 2-bits 10 or 11
	 * [1,0,0]
	 * [1,1,1,0]
	 * @param bits
	 * @return
	 */
	public boolean isOneBitCharacter(int[] bits) {
		boolean flag = true;
		for(int i=0;i<bits.length;){
			if(bits[i]==1){
				if(i==bits.length-2){
					flag = false;
					break;
				}else{
					i+=2;
				}
			}else{
				if(i==bits.length-2){
					flag = true;
					break;
				}else{
					i+=1;
				}
			}
		}
        return flag;
    }

}
