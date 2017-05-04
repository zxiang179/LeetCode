package zx.leetcode.may;
/**
 * 551. Student Attendance Record I
 * @author Carl_Hugo
 * @date 2017年5月4日
 */
public class Test8 {
	
	/**
	 * A student could be rewarded 
	 * if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).
	 * @param s
	 * @return
	 */
    public boolean checkRecord(String s) {
        char[] charArray = s.toCharArray();
        int[] ALP = new int[3];
        boolean flag = true;
        for(int i=0;i<charArray.length;i++){
        	if(charArray[i]=='L'){
        		ALP[1]++;	
        	}else if(charArray[i]=='A'){
        		ALP[0]++;
        		ALP[1]=0;
        	}else if(charArray[i]=='P'){
        		ALP[2]++;
        		ALP[1]=0;
        	}
        	if(ALP[0]>=2||ALP[1]>=3){
        		flag = false;
        		break;
        	}
        }
        return flag;
    }
    
    public static void main(String[] args) {
		System.out.println(new Test8().checkRecord("LLPLLPLPPLLPLPLPPPLPLPLPPPLPPP"));
	}

}
