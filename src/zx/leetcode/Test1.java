package zx.leetcode;

import org.junit.Test;

/**
 * 461. Hamming Distance 
 * @author Carl_Hugo
 * 在信息论中，两个等长字符串之间的汉明距离是两个字符串对应位置的不同字符的个数。
 */
public class Test1 {
	
	public int hammingDistance(int x, int y) {
        int xor = x^y;
        int count=0;
        for(int i=0;i<32;i++){
        	count+=(xor>>i)&1;
        }
        return count;
    }
	
	@Test
	public void test(){
		Test1 test1 = new Test1();
		System.out.println(test1.hammingDistance(1, 4));
	}

}
