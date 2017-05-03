package zx.leetcode.may;
/**
 * 434. Number of Segments in a String
 * @author Carl_Hugo
 * @date 2017年5月3日
 */
public class Test5 {
	
	/**
	 * Count the number of segments in a string, 
	 * where a segment is defined to be a contiguous sequence of non-space characters.
	 * @param s
	 * @return
	 */
    public int countSegments(String s) {
    	s=s.trim();
    	if(s==""||s==null||"".equals(s))return 0;
    	String[] split = s.split("\\s+");
    	return split.length;
    }
    
    public static void main(String[] args) {
		System.out.println(new Test5().countSegments(" sad asdf "));
	}

}
