package zx.leetcode.dog.nowcoder.sword2offer;

public class Solution2 {
	
	public String LeftRotateString(String str,int n) {
		if(str==null||str.length()==0)return "";
        char[] charArr = str.toCharArray();
        reverse(charArr,0,n-1);
        reverse(charArr,n,charArr.length-1);
        reverse(charArr,0,charArr.length-1);
        int count = 0;
        for(int i=0;i<charArr.length;i++) {
        	if((charArr[i]>='a'&&charArr[i]<='z')||(charArr[i]>='A'&&charArr[i]<='Z')) {
        		charArr[count++] = charArr[i];
        	}
        }
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<count;i++) {
        	sb.append(charArr[i]);
        }
        return sb.toString();
    }
    
    public void reverse(char[] array,int i,int j){
        for(;i<j;i++,j--){
            char c = array[i];
            array[i] = array[j];
            array[j] = c;
        }
    }
    
    public static void main(String[] args) {
		new Solution2().LeftRotateString("abcdefg,2", 2);
	}

}
